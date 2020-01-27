package com.cleancoder.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

public class StringArgumentMarshaler implements ArgumentMarshaler {
  private String stringValue = "";
  
  public StringArgumentMarshaler(){}

  public void validateStringArgument(String stringValue) throws ArgsException{
      if(!stringValue.matches("^[a-zA-Z0-9_]+")) 
	  throw new ArgsException(ArgsException.ErrorCode.INVALID_DIRECTORY_FORMAT);
}
  
  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      stringValue = currentArgument.next();
      validateStringArgument(stringValue);  } 
   
    catch (NoSuchElementException e) {
      throw new ArgsException(ArgsException.ErrorCode.MISSING_STRING); }
    
  }

  public static String getValue(ArgumentMarshaler am) {
    if (am != null)
      return ((StringArgumentMarshaler) am).stringValue;
    else
      return "";
  }
}
