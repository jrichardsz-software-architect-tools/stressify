package org.jrichardsz.tools.stressify.controllers.project.stress;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import org.apache.logging.log4j.LogManager;
import org.jrichardsz.common.http.DisableCertificateValidation;
import org.jrichardsz.tools.stressify.common.AssertsHelper;
import org.jrichardsz.tools.stressify.common.StressifyHelper;
import org.jrichardsz.tools.stressify.common.StressorConstants;
import org.jrichardsz.tools.stressify.controllers.project.settings.ProjectSettingsBasicActionsController;
import org.jrichardsz.tools.stressify.mode.SimpleGraphicStressor;
import org.jrichardsz.tools.stressify.ui.MainView;

public class ProjectStressorController implements ActionListener {

  private MainView mainView;
  private JTable jTableHeaders;
  private JTextArea jTextAreaAssertResponseScript;
  private JTextArea jTextAreaStressLog;
  private JTextArea jTextAreaPostBody;
  private JTextField jTextFieldReportFolderLocation;
  private JTextField jTextFieldReportName;
  private JTextField jTextFieldUrl;
  private JTextField jTextFieldDataCsvFilePath;
  private JTextField jTextFieldThreadsNumber;
  private JButton jButtonStress;
  private JComboBox<?> jComboBoxMethod;
  private JComboBox<?> jComboBoxStressMode;
  private JCheckBox jCheckBoxAddMetadataToReportName;
  private JCheckBox jCheckBoxGenerateChartImages;


  private SimpleGraphicStressor graphicStressor;

  public ProjectStressorController(MainView mainView) {
    super();
    this.mainView = mainView;
    initializeUiReferences();
    initializeActionListeners();
  }

  public void initializeUiReferences() {
    this.jTableHeaders = this.mainView.getPanelHttpTest().getjTableHeaders();
    this.jTextAreaAssertResponseScript =
        this.mainView.getPanelHttpTest().getjTextAreaAssertResponseScript();
    this.jTextAreaStressLog = this.mainView.getPanelHttpTest().getjTextAreaStressLog();
    this.jTextAreaPostBody = this.mainView.getPanelHttpTest().getjTextAreaPostBody();
    this.jTextFieldReportFolderLocation =
        this.mainView.getPanelHttpTest().getjTextFieldReportFolderLocation();
    this.jTextFieldReportName = this.mainView.getPanelHttpTest().getjTextFieldReportName();
    this.jTextFieldUrl = this.mainView.getPanelHttpTest().getjTextFieldUrl();
    this.jButtonStress = this.mainView.getPanelHttpTest().getjButtonStress();
    this.jComboBoxMethod = this.mainView.getPanelHttpTest().getjComboBoxMethod();
    this.jTextFieldDataCsvFilePath =
        this.mainView.getPanelHttpTest().getjTextFieldDataCsvFilePath();
    this.jComboBoxStressMode = this.mainView.getPanelHttpTest().getjComboBoxStressMode();
    this.jTextFieldThreadsNumber = this.mainView.getPanelHttpTest().getjTextFieldThreadsNumber();
    this.jCheckBoxAddMetadataToReportName =
        this.mainView.getPanelHttpTest().getjCheckBoxAddMetadataToReportName();
    this.jCheckBoxGenerateChartImages =
        this.mainView.getPanelHttpTest().getjCheckBoxGenerateChartImages();

  }

  public void initializeActionListeners() {
    jButtonStress.addActionListener(this);

    ProjectSettingsBasicActionsController projectSettingsBasicActionsController =
        new ProjectSettingsBasicActionsController(mainView);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == jButtonStress.getActionCommand()) {
      try {
        stress();
      } catch (Exception ex) {
        ex.printStackTrace();
        String message = ex.getMessage();
        JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public void stress() throws Exception {

    String uuid = UUID.randomUUID().toString();

    if (graphicStressor == null) {
      graphicStressor = new SimpleGraphicStressor(jTextAreaStressLog);
    }

    String csvDataPath = jTextFieldDataCsvFilePath.getText();

    String reportFolderPath = jTextFieldReportFolderLocation.getText();
    AssertsHelper.ensureNotNullEmptyString(reportFolderPath, "[report folder location]");
    String reportName = jTextFieldReportName.getText();
    AssertsHelper.ensureNotNullEmptyString(reportFolderPath, "[report name]");
    String reportColumns = StressorConstants.REPORT_COLUMN_NAMES;

    String url = jTextFieldUrl.getText();
    String method = jComboBoxMethod.getSelectedItem().toString();
    String body = jTextAreaPostBody.getText();

    TableModel model = this.jTableHeaders.getModel();
    HashMap<String, String> headers = new HashMap<String, String>();
    for (int row = 0; row < model.getRowCount(); row++) {
      String key = null;
      String value = null;
      for (int col = 0; col < model.getColumnCount(); col++) {
        if (col == 0) {
          key = (String) model.getValueAt(row, col);
        } else if (col == 1) {
          value = (String) model.getValueAt(row, col);
        }
      }
      if ((key != null && !key.isEmpty()) && (value != null && !value.isEmpty())) {
        headers.put(key, value);
      }
    }

    String assertScript = this.jTextAreaAssertResponseScript.getText();
    String mode = jComboBoxStressMode.getSelectedItem().toString();
    String threads = jTextFieldThreadsNumber.getText();
    boolean addMetadataToReport = jCheckBoxAddMetadataToReportName.isSelected();
    boolean generateImageCharts = jCheckBoxGenerateChartImages.isSelected();

    String fileBaseName = StressifyHelper.createFileBaseName(uuid, addMetadataToReport, url, method,
        mode, threads, reportName);

    System.setProperty("logFilename", String.format("%s%s%s-log.txt",
        jTextFieldReportFolderLocation.getText(), File.separator, fileBaseName));
    org.apache.logging.log4j.core.LoggerContext ctx =
        (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
    ctx.reconfigure();

    graphicStressor.perform(mainView, uuid, csvDataPath, reportFolderPath, reportName,
        addMetadataToReport, generateImageCharts, reportColumns, mode, threads, url, method, body,
        headers, assertScript, fileBaseName);
  }

  public MainView getMainView() {
    return mainView;
  }

  public void setMainView(MainView mainView) {
    this.mainView = mainView;
  }
}
