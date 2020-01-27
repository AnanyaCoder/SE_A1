package com.cleancoder.args;
import java.util.*;

public class BooleanArgumentMarshaler implements ArgumentMarshaler 
{
  private boolean booleanValue = false;
  private String boolArg = " ";
  public BooleanArgumentMarshaler(){}

  public void validateBooleanArgument(Iterator<String> currentArgument)throws ArgsException{
   boolArg = currentArgument.next();
      switch(boolArg)
      {
       case "1":
       	booleanValue = true;
       	break;
       case "0":
       	booleanValue = false; 
       	break;
       default :
        throw new ArgsException(ArgsException.ErrorCode.INVALID_BOOL,boolArg);      
      }
}

  public void set(Iterator<String> currentArgument) throws ArgsException 
  {
    try{
      validateBooleanArgument(currentArgument);
   }catch (NoSuchElementException e) {
      throw new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER);
    }
   }
  
  public static boolean getValue(ArgumentMarshaler am) {
    if (am != null)
      return ((BooleanArgumentMarshaler) am).booleanValue;
    else
      return false;
  }
}
