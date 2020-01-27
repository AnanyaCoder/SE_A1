package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
  private List<String> strings = new ArrayList<String>();

  public StringArrayArgumentMarshaler(){}
  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      strings.add(currentArgument.next());
    } catch (NoSuchElementException e) {
      throw new ArgsException(ArgsException.ErrorCode.MISSING_STRING);
    }
  }

  public static String[] getValue(ArgumentMarshaler am) {
    if (am != null)
      return ((StringArrayArgumentMarshaler) am).strings.toArray(new String[0]);
    else
      return new String[0];
  }
}
