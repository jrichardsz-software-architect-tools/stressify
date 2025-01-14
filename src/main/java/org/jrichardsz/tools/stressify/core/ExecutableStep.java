package org.jrichardsz.tools.stressify.core;

import java.util.HashMap;

public interface ExecutableStep {

  public Object execute(HashMap<String, Object> args) throws Exception;
}
