
System requirements -> Jdk 21 LTS. Vscode/intellij. Spring boot and java extension plugins. Jacoco min requirements, junit minimum requirements.

Upon installation of the application, A few setup steps need to be followed.

1. Create a database called "medical_assistance" and within it, create a user, with user id as "user" and password as "password123".
2. Grant this user all PRIVILEGES within this database, and then FLUSH PRIVILEGES in order to maintain clarity.
3. Now, You may navigate to the main class (application.java) under the applications package. 
4. Run the application main class, Once this is done, wait for the terminal to print "started".
This is our indication that our application has started.

Now, Open your favourite browser, And navigate to localhost:8080.
Once this is open, you will be in the home page of the application. From here, depending on your use, you may navigate to Patient form or Patient list.

To run the tests, ne sure that the corresponding maven, jacoco and junit packages are installed. (check pom.xml for versions, as the tests are very sensitive to 
different versions of the jdk and other dependencies.)

to run black box tests, open the terminal in the pom.xml file and enter the ./mvnw test command.
the result will be printed out in the error console.

To run the white box tests, open the terminal in the same directory and run "mvn clean install"
and then "mvn clean test".

The result of this will be printed to the error console and the sure-fire reports of the target directory. be sure to refer to the txt files only as the xml files 
are cluttering.

