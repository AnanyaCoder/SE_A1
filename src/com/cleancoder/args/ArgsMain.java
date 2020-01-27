package com.cleancoder.args;

public class ArgsMain {

     static boolean logging;  
     static int port;      
     static String directory;  
     static double version;   
     static String[] features;

  public ArgsMain(){}

  public static void handleException(ArgsException e){
      System.out.printf("Argument error: %s\n", e.errorMessage());
      System.out.println("Schema : (l,p#,d*,v##,s[*])");
      System.out.println("Coresponding command line: -l 1 -d IIIT_HYD -p 8080 -v 5.6 -s students -s management -s faculty");
  }

  public static void defineSchema(Args arg) throws ArgsException{
      logging       = arg.getBoolean('l');
      port          = arg.getInt('p');
      directory     = arg.getString('d');  
      version       = arg.getDouble('v');
      features      = arg.getStringArray('s');
}

  public static void main(String[] args) {
    try {
      Args arg = new Args("l,p#,d*,v##,s[*]", args);
      defineSchema(arg);
      executeApplication(logging, port, directory,version,features);
    } catch (ArgsException e) {
        handleException(e);
    }
    finally {
      System.out.println("This is a Java Program to validate the arguments passed from the command line. Good Day!");
    }
  }


  private static void executeApplication(boolean logging, int port, String directory,double version,String[] features) {
    System.out.printf("logging is %s, port:%d, directory:%s, version:%f\n",logging, port, directory,version);
    if(features.length != 0) 
       printStringArrayElements(features);
    else
       System.out.println("No features are mentioned");
  }

 private static void printStringArrayElements(String[] features){
    System.out.println("Features:");
    for (String element: features) {
        System.out.println(element);
    }
}
}
