package org.jrichardsz.tools.stressify.common;

public class DataTypeHelper {

  public static int getIntFromLong(Object longg, int defaultValue) {
    if (longg == null || !(longg instanceof Long)) {
      return defaultValue;
    } else {
      Long temp = (Long) longg;
      return temp.intValue();
    }
  }

}
