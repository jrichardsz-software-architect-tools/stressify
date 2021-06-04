package edu.utec.tools.stressify.common;

import java.io.File;
import java.util.Map;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class FileHelper {

  public static void mapToJsonFile(Map<?, ?> obj, String fileAbsolutePath) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
    try {
      writer.writeValue(new File(fileAbsolutePath), obj);
    } catch (Exception e) {
      throw new Exception("Failed to generate json from map", e);
    }
  }
  
  
}
