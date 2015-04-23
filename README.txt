CS442 Design Patterns
Spring 2015
ASSIGNMENT #4 README FILE

Due Date: <Wednesday, April 22, 2015>
Submission Date: <Wednesday, April 22, 2015>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <CALEB DONOVICK> <ALEXANDER TERELA>
e-mail(s): <CDONOVI1@BINGHAMTON.EDU> <ATERELA1@BINGHAMTON.EDU>


PURPOSE:

This assignment models the visitor pattern

PERCENT COMPLETE:

We believe that we have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

N/A

BUGS:

None

FILES:

  Included with this project are 15 files:

  Driver - tests the wordCount program
  Tree - contains the tree data structure
  FileProcessor - contains methods to read a line and write to a file
  MyLogger - simulates the java logger class
  PopulateTreeVisitor - visitor class that reads words from a file and populates a tree data structure
  Visitor - interface which contains visit methods for each element
  WordCountVisitor - visitor that determines the total number of words and characters in the tree and stores them in output file
  README.txt, the text file you are presently reading

	In the README.txt, there are 4 levels that the MyLogger class can be set to:
		- 0: No output is printed other than error messages.
		- 1: Only output from the dashboard is printed
		- 2: Output is printed when constructors are called
		- 3: Output is printed when other methods are called
		- 4: No output is printed at all

SAMPLE OUTPUT:

Alexs-MacBook-Air-6:wordCount alex$ ant -buildfile src/build.xml -Darg0=input1M.txt -Darg1=output.txt -Darg2=5 -Darg3=4 run
Buildfile: /Users/alex/Documents/BU/Junior Spring 2015/CS 442/Assignment4/donovick_caleb_terela_alexander_assign4/wordCount/src/build.xml

jar:
      [jar] Building jar: /Users/alex/Documents/BU/Junior Spring 2015/CS 442/Assignment4/donovick_caleb_terela_alexander_assign4/wordCount/BUILD/jar/wordCount.jar

run:
     [java] Total iteration time: 557 millisecond.

BUILD SUCCESSFUL
Total time: 3 seconds

TO COMPILE:

Assuming you are in the directory containing this README:
extract the files
“make”
in command line: ant -buildfile src/build.xml all

TO RUN:

## To run, edit the build.xml to enter args (search for arg0, arg1, arg2, arg3)
Assuming you are in the directory containing this README:

ex. ant -buildfile src/build.xml -Darg0=‘inputFile.txt’ -Darg1=‘outputFile.txt’ -Darg2=‘0’, or ‘1’, or ‘2’, or ‘3’, or ‘4’ Darg3=‘0’, or ‘1’, or ‘2’, or ‘3’, or ‘4 run

ant -buildfile src/build.xml -Darg0=new_in1.txt -Darg1=output.txt -Darg2=0 -Darg3=4 run

EXTRA CREDIT:

We created an ant task to profile the program and used JVM flags for compiler optimization and efficiency.

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<CALEB DONOVICK> <ALEXANDER TERELA>

ACKNOWLEDGEMENT:

  During the coding process one or more of the following people may have been
  consulted. Their help is greatly appreciated.

	A. Thompson
