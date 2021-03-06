package com.cleancoder.args;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;


public class MapArgumentMarshaler implements ArgumentMarshaler {
  private Map<String, String> map = new HashMap<>();
  
  public MapArgumentMarshaler() {}

  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      String[] mapEntries = currentArgument.next().split(",");
      for (String entry : mapEntries) {
        String[] entryComponents = entry.split(":");
        if (entryComponents.length != 2)
          throw new ArgsException(ArgsException.ErrorCode.MALFORMED_MAP);
        System.out.println("checking map entry passed");
        map.put(entryComponents[0], entryComponents[1]);
      }
    } catch (NoSuchElementException e) {
      throw new ArgsException(ArgsException.ErrorCode.MISSING_MAP);
    }
  }

  public static Map<String, String> getValue(ArgumentMarshaler am) {
    if (am != null)
      return ((MapArgumentMarshaler) am).map;
    else
      return new HashMap<>();
  }
}
