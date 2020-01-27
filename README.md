# SE_A1
Software Engineering Course Assignment 1

Name    : Ananya Mukherjee <br>
Roll No : 2018801009

# Schema

(logging,portno,directory name, version, features)  <br>
(boolean,integer,string,double,String[])     <br> 
(l,p#,d*,v##,s[*])       <br>

Coresponding command line: -l 1 -d IIIT_HYD -p 8080 -v 5.6 -s students -s management -s faculty

# Changes made to the existing code
1. Tried to eliminate redundant Code.
2. Introduced a new method to decrease the no. of lines of code in one long method 
<i> (for example added validateElementTail & validateArgumentStrings methods in <b> Args.java </b>, ) </i>
3. Methods contain only one level of Abstraction
4. Removed unnecesary throws ArgsException from the <b> ArgumentMarshaler.java </b>
5. Removed instanceof operator 6 programs as it is useful only during compile time and not during run time.

# Newly added implementations 
1. Added Try, Catch, Finally in <b> ArgsMain.java </b>
2. Implemented code to handle the double & string array arguments (as version & features) 
3. Introduced a new method to define the schema variables outside the main block in <b> ArgsMain.java </b>
4. Added new error codes to handle various exceptions like INVALID_DIRECTORY_FORMAT, INVALID_SCHEMA_FORMAT, INVALID_BOOL, MISSING_DOUBLE,INVALID_DOUBLE, etc in  <b> ArgsException.java </b>
5. Added Switch cases in place of nested if where more than 5 if conditions were present in  <b> Args.java </b>
6. Added a enumMap for mapping the enum error code to the respective error messages by removing the Switch Case in  <b> ArgsException.java </b>
7. Implemented new check conditions for the input arguments validation by introducing regex for directory name and validate conditions for Schema ( -l -p -s -d -v) 
8. Included regex ^[a-zA-Z0-9_]+   to validate the directory name in the argument in <b> StringArgumentMarshaler.java </b>
9. Introduced a new feature to enter 1 or 0 for logging where 1 stands for logging true and 0 stands for logging false. <br>
 <i > Introduced a validating method to check on the argument for boolean (has to be 1 for true and 0 for false, else throw invalid argument exception) </i>
10. Introduced a new Validation check in <b> Args.java </b> to check the extra arguments per Schema variable. 
-l 1 -d abc xyz (this throws an exception message)

** Comments are not added in the code as mentioned in class, we need to include them if and only if the situation is unavoidable, and to the best of my knowledge the current modified code & its flow is readable & understandable. 



