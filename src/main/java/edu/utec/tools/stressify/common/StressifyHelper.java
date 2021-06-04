package edu.utec.tools.stressify.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StressifyHelper {

  public static String createFileBaseName(String uuid, boolean addMetadataToReport, String url,
      String method, String mode, String threads, String reportName) throws Exception {
    String fileBaseName = null;
    if (addMetadataToReport) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
      String date = sdf.format(new Date());
      String realEndpoint = StringHelper.getEndpoint(url);
      String endpoint = StringHelper.sanitizeEndpoint(realEndpoint);
      fileBaseName = String.format("%s-%s-%s-%s-%s-%s-date-%s", reportName, uuid, endpoint, method,
          mode, threads, date);
    } else {
      fileBaseName = String.format("%s-%s", reportName, uuid);
    }

    return fileBaseName;
  }

  public static Map<String, Object> getStats(List<HashMap<String, Object>> dataStress)
      throws Exception {

    int total = dataStress.size();
    int response200Count = 0;
    int assertsTrueCount = 0;

    for (HashMap<String, Object> invocationData : dataStress) {
      Integer response200 = (Integer) invocationData.get("responseStatus");
      Boolean assertsTrue = (Boolean) invocationData.get("asserts");
      if (response200.intValue() == 200) {
        response200Count++;
      }
      if (assertsTrue.booleanValue()) {
        assertsTrueCount++;
      }
    }
    HashMap<String, Object> stats = new HashMap<String, Object>();
    stats.put("total", total);
    stats.put("response200", response200Count);
    stats.put("responseNon200", total - response200Count);
    stats.put("assertsTrue", assertsTrueCount);
    stats.put("assertsFalse", total - assertsTrueCount);
    return stats;
  }

}
