package org.jrichardsz.tools.stressify.common;

import java.util.HashMap;
import java.util.List;

public class MathHelper {

  public static int getAverage(List<HashMap<String, Object>> dataList, String field) {
    int sum = 0;
    int count = 0;
    for (int i = 0; i < dataList.size(); i++) {
      HashMap<String, Object> row = dataList.get(i);
      int y = DataTypeHelper.getIntFromLong(row.get(field), -1);
      if (y >= 0) {
        sum += y;
        count++;
      }
    }
    return sum / count;
  }

}
