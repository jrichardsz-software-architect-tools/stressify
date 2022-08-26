package org.jrichardsz.tools.stressify.steps;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import org.jrichardsz.common.csv.CSVUtil;
import org.jrichardsz.tools.stressify.core.ExecutableStep;
import  java.io.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;

public class ReportStep implements ExecutableStep {

  @SuppressWarnings("unchecked")
  public Object execute(HashMap<String, Object> parameters) throws Exception {

    List<HashMap<String, Object>> dataStress =
        (List<HashMap<String, Object>>) parameters.get("dataStress");
    List<String> headers = (List<String>) parameters.get("reportColumnValues");
    String reportFolderPath = (String) parameters.get("reportFolderPath");
    String fileBaseName = (String)parameters.get("fileBaseName");
    createCsv(reportFolderPath, fileBaseName, headers, dataStress);
    createExcel(reportFolderPath, fileBaseName, headers, dataStress);

    return "success";
  }

  public void createExcel(String reportFolderPath, String fileBaseName, List<String> headers, List<HashMap<String, Object>> dataStress)
  throws Exception
  {
    String filename = reportFolderPath + File.separator + fileBaseName+"-report.xls";

    FileOutputStream fileOut = null;
    HSSFWorkbook workbook = null;
    try{
      //creating an instance of HSSFWorkbook class
      workbook = new HSSFWorkbook();
      //invoking creatSheet() method and passing the name of the sheet to be created
      HSSFSheet sheet = workbook.createSheet("stressify_report");

      HSSFRow rowhead = sheet.createRow((short)0);

      rowhead.createCell(0).setCellValue("id");
      rowhead.createCell(1).setCellValue("startDate");
      rowhead.createCell(2).setCellValue("endDate");
      rowhead.createCell(3).setCellValue("responseStatus");
      rowhead.createCell(4).setCellValue("asserts");
      rowhead.createCell(5).setCellValue("totalExecutionMillisTime");
      rowhead.createCell(6).setCellValue("log");

      for (int i = 0; i < dataStress.size(); i++) {
        HashMap<String, Object> rowMap = dataStress.get(i);
        if (rowMap != null && !rowMap.isEmpty()) {
          HSSFRow row = sheet.createRow((short)i+1);
          row.createCell(0).setCellValue((String)rowMap.get("id"));
          row.createCell(1).setCellValue((String)rowMap.get("startDate"));
          row.createCell(2).setCellValue((String)rowMap.get("endDate"));
          row.createCell(3).setCellValue((Integer)rowMap.get("responseStatus"));
          row.createCell(4).setCellValue(((Boolean) rowMap.get("asserts")).booleanValue());
          row.createCell(5).setCellValue((Long)rowMap.get("totalExecutionMillisTime"));
          row.createCell(6).setCellValue((String)rowMap.get("log"));
        }
      }
      fileOut = new FileOutputStream(filename);
      workbook.write(fileOut);
    }catch(Exception e){
      throw new Exception("Failed to create the excel report.", e);
    }finally{
      if(fileOut!=null) fileOut.close();
      if(workbook!=null) workbook.close();
    }
  }

  public void createCsv(String reportFolderPath, String fileBaseName, List<String> headers, List<HashMap<String, Object>> dataStress)
  throws Exception {
    String reportFilePath = reportFolderPath + File.separator + fileBaseName+"-report.csv";

    FileWriter writer = new FileWriter(reportFilePath);

    CSVUtil csvUtil = new CSVUtil();

    String headerString = csvUtil.convertListToString(headers, ",");

    String reportData = csvUtil.convertListMapToCsvString(dataStress, "\n", ",", headers);
    String headerAndReport = String.format("%s\n%s", headerString, reportData);

    writer.write(headerAndReport);
    writer.close();
  }

}
