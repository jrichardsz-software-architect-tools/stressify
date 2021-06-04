package edu.utec.tools.stressify.steps;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import edu.utec.common.csv.CSVUtil;
import edu.utec.tools.stressify.core.ExecutableStep;

public class ReportStep implements ExecutableStep {

  @SuppressWarnings("unchecked")
  public Object execute(HashMap<String, Object> parameters) throws Exception {

    List<HashMap<String, Object>> dataStress =
        (List<HashMap<String, Object>>) parameters.get("dataStress");
    List<String> headers = (List<String>) parameters.get("reportColumnValues");
    String reportFolderPath = (String) parameters.get("reportFolderPath");
    String fileBaseName = (String)parameters.get("fileBaseName");
    String reportFilePath = reportFolderPath + File.separator + fileBaseName+"-report.csv";

    FileWriter writer = new FileWriter(reportFilePath);

    CSVUtil csvUtil = new CSVUtil();

    String headerString = csvUtil.convertListToString(headers, ",");

    String reportData = csvUtil.convertListMapToCsvString(dataStress, "\n", ",", headers);
    String headerAndReport = String.format("%s\n%s", headerString, reportData);

    writer.write(headerAndReport);
    writer.close();

    return "success";
  }

}
