package org.jrichardsz.tools.stressify.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StressifyHelper {

  public static String createFileBaseName(String uuid, boolean addMetadataToReport, String url,
      String method, String mode, String threads, String reportName) throws Exception {
    String fileBaseName = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    String date = sdf.format(new Date());
    if (addMetadataToReport) {
      String realEndpoint = StringHelper.getEndpoint(url);
      String endpoint = StringHelper.sanitizeEndpoint(realEndpoint);
      fileBaseName = String.format("%s-%s-%s-%s-%s-date-%s-uuid-%s", reportName, endpoint, method,
          mode, threads, date, uuid);
    } else {
      fileBaseName = String.format("%s-%s", reportName, date);
    }

    return fileBaseName;
  }

  public static Map<String, Object> getStats(List<HashMap<String, Object>> dataStress, int average)
      throws Exception {

    int total = dataStress.size();
    int response200Count = 0;
    int assertsTrueCount = 0;

    for (HashMap<String, Object> invocationData : dataStress) {
      Integer response200 = (Integer) invocationData.get("responseStatus");
      Boolean assertsTrue = (Boolean) invocationData.get("asserts");

      if (response200 != null && response200.intValue() == 200) {
        response200Count++;
      }
      if (assertsTrue != null && assertsTrue.booleanValue()) {
        assertsTrueCount++;
      }
    }
    LinkedHashMap<String, Object> stats = new LinkedHashMap<String, Object>();
    stats.put("totalInvocations", total);
    stats.put("response200Count", response200Count);
    stats.put("responseNon200Count", total - response200Count);
    stats.put("assertsTrueCount", assertsTrueCount);
    stats.put("assertsFalseCount", total - assertsTrueCount);
    stats.put("averageResponseTimeMillis", average);
    return stats;
  }

}
