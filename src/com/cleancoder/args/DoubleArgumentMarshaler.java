package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;
import java.util.*;

public class DoubleArgumentMarshaler implements ArgumentMarshaler {
  private double doubleValue = 0;
  public DoubleArgumentMarshaler(){}
  public void set(Iterator<String> currentArgument) throws ArgsException {
    String parameter = null;
    try {
      parameter = currentArgument.next();
      doubleValue = Double.parseDouble(parameter);
    } catch (NoSuchElementException e) {
      throw new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE);
    } catch (NumberFormatException e) {
      throw new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE, parameter);
    }
  }

  public static double getValue(ArgumentMarshaler am) {
    if (am != null)
      return ((DoubleArgumentMarshaler) am).doubleValue;
    else
      return 0.0;
  }
}
