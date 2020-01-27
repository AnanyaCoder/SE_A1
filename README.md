# SE_A1
Software Engineering Course Assignment 1

Name    : Ananya Mukherjee
Roll No : 2018801009

# Instructions to run. 


My Schema : (logging,portno,directory name, version, features)
(l,p#,d*,v##,s[*])
Coresponding command line: -l 1 -d IIIT_HYD -p 8080 -v 5.6 -s students -s management -s faculty

# Reduced the Library Structure 
/home/ananya/Desktop/SE/A1/src/args

# Changes made to the existing code
1. Code Redundancy
2. Introduced a new method to decrease the no. of lines of code in one long method.
3. Methods contain only one level of Abstraction
4. Removed unnecesary throws ArgsException
5. Removed instanceof operator 5 programs as it is useful only during compile time and not during run time.

# Newly added implementations 
1. Added Try, Catch, Finally 
2. Added new error codes to handle various exceptions like String Format, Schema Format, etc 
3. Added Switch cases in place of nested if where more than 5 if conditions were present
4. Added a enumMap for mapping the enum error code to the respective error messages by removing the Switch Case
5. Implemented code to handle the double & string array arguments (as version & features)
6. Implemented new check conditions for the input arguments validation by introducing regex for directory name and validate conditions for Schema ( -l -p -s -d -v) 


# Unit Tests 

