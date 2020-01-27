package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;
import java.util.EnumMap;

public class ArgsException extends RuntimeException {
  private char errorArgumentId = '\0';
  private String errorParameter = null;
  private ErrorCode errorCode = ErrorCode.OK;
  public ArgsException() {}

  public ArgsException(String message) {super(message);}

  public ArgsException(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public ArgsException(ErrorCode errorCode, String errorParameter) {
   
    this.errorCode = errorCode; 
    this.errorParameter = errorParameter;
    
  }

  public ArgsException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
    this.errorCode = errorCode;
    this.errorParameter = errorParameter;
    this.errorArgumentId = errorArgumentId;
  }

  public char getErrorArgumentId() {
    return errorArgumentId;
  }

  public void setErrorArgumentId(char errorArgumentId) {
    this.errorArgumentId = errorArgumentId;
  }

  public String getErrorParameter() {
    return errorParameter;
  }

  public void setErrorParameter(String errorParameter) {
    this.errorParameter = errorParameter;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public String errorMessage() {
    if(errorParameter != null && errorArgumentId != '\0')
       return String.format(errors.get(errorCode),errorArgumentId, errorParameter);
    else
    {
    if(errorParameter != null)
     return String.format(errors.get(errorCode),errorParameter); 
    else
    return String.format(errors.get(errorCode),errorArgumentId);
}
  }
    
   EnumMap<ErrorCode, String> errors = new EnumMap<ErrorCode, String> (ErrorCode.class);
    //errors = new HashMap<>();
    
    {errors.put(ErrorCode.OK,"TILT: Should not get here.");}
    {errors.put(ErrorCode.INVALID_ARGUMENT_FORMAT,"'%s' is not a valid argument format.");}
    {errors.put(ErrorCode.UNEXPECTED_ARGUMENT,"Argument -%c unexpected.");}
    {errors.put(ErrorCode.INVALID_ARGUMENT_NAME,"'%c' is not a valid argument name.");}
    {errors.put(ErrorCode.MISSING_STRING,"Could not find string parameter for -%c.");}
    {errors.put(ErrorCode.INVALID_BOOL,"Argument -%c expects a bool value 1 or 0 but was '%s'.");}
    {errors.put(ErrorCode.MISSING_INTEGER,"Could not find integer parameter for -%c.");}
    {errors.put(ErrorCode.INVALID_INTEGER,"Argument -%c expects an integer but was '%s'.");}
    {errors.put(ErrorCode.MISSING_DOUBLE,"Could not find double parameter for -%c.");}
    {errors.put(ErrorCode.MALFORMED_MAP,"Map string for -%c is not of form k1:v1,k2:v2...");}
    {errors.put(ErrorCode.MISSING_MAP,"Could not find map string for -%c.");}
    {errors.put(ErrorCode.INVALID_DOUBLE,"Argument -%c expects a double but was '%s'.");}
    {errors.put(ErrorCode.INVALID_DIRECTORY_FORMAT,"Directory name should contain only [- a-z A-Z 0-9 _]");}
    {errors.put(ErrorCode.INVALID_SCHEMA_FORMAT,"Unexpected argument %s. Kindly check the command line format to pass the arguments.");}  
 

  public enum ErrorCode {
    OK, INVALID_ARGUMENT_FORMAT, UNEXPECTED_ARGUMENT, INVALID_ARGUMENT_NAME, INVALID_SCHEMA_FORMAT,
    MISSING_STRING,INVALID_BOOL,
    MISSING_INTEGER, INVALID_INTEGER,
    MISSING_DOUBLE, MALFORMED_MAP, MISSING_MAP, INVALID_DOUBLE,INVALID_DIRECTORY_FORMAT}
}
