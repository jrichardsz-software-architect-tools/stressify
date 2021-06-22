package edu.utec.tools.stressify.steps;

import java.awt.Color;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import edu.utec.tools.stressify.common.DataTypeHelper;
import edu.utec.tools.stressify.core.ExecutableStep;

public class ChartStep implements ExecutableStep {

  private int average = 0;

  @Override
  public Object execute(HashMap<String, Object> parameters) throws Exception {
    List<HashMap<String, Object>> dataList =
        (List<HashMap<String, Object>>) parameters.get("dataStress");
    String mode = (String) parameters.get("mode");
    String threads = (String) parameters.get("threads");
    String fileBaseName = (String) parameters.get("fileBaseName");
    String reportFolderPath = (String) parameters.get("reportFolderPath");
    String chartTitle = String.format("%s %s users", threads, mode);
    JFreeChart chart = createChart(dataList, chartTitle);

    String chartImageFileName = String.format("%s-chart-time.png", fileBaseName);

    ChartUtils.saveChartAsPNG(new File(reportFolderPath + File.separator + chartImageFileName),
        chart, 1000, 500);

    HashMap<String, Object> response = new HashMap<String, Object>();
    response.put("average", average);
    return response;
  }

  private JFreeChart createChart(List<HashMap<String, Object>> dataList, String chartTitle) {
    XYSeries realSerie = new XYSeries("Real");
    int sum = 0;
    for (int i = 0; i < dataList.size(); i++) {
      HashMap<String, Object> row = dataList.get(i);
      int y = DataTypeHelper.getIntFromLong(row.get("totalExecutionMillisTime"), -1);
      if (y >= 0) {
        realSerie.add(i + 1, y);
        sum += y;
      }
    }

    XYSeries averageSerie = null;
    // item count is zero on low http level errors in which there isn't response
    if (realSerie.getItemCount() > 0) {
      average = sum / realSerie.getItemCount();
      averageSerie = new XYSeries("Average: " + average + " millis");
      for (int i = 0; i < dataList.size(); i++) {
        HashMap<String, Object> row = dataList.get(i);
        int y = DataTypeHelper.getIntFromLong(row.get("totalExecutionMillisTime"), -1);
        if (y >= 0) {
          averageSerie.add(i + 1, average);
        }
      }
    } else {
      averageSerie = new XYSeries("Average");
    }

    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(realSerie);
    dataset.addSeries(averageSerie);

    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, "Number of users",
        "Response Time (millis)", dataset, PlotOrientation.VERTICAL, true, true, false);

    XYPlot plot = chart.getXYPlot();

    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesPaint(0, Color.RED);
    renderer.setSeriesPaint(1, Color.BLUE);
    plot.setRenderer(renderer);

    return chart;
  }
}
