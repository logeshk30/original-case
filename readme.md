Travel API Client
=================

Code repository of Travel API client assignment software. 

I have added the workflow actions (build and test stage) to the project. Whenever there is a push or pull request to 
master branch then this workflow actions will be triggered automatically. 

I had to do this assignment from my Boeing imaged laptop which has quite a few restrictions on setting up new software 
applications. I had difficulties in setting up gradle in my dev environment to build and test this application. So I 
went ahead with maven for resolving the project dependencies. However I have also added the necessary dependency details
in build.gradle file. So it should work fine thru gradle as well. But I could validate only using maven in my machine.

To start the application using maven

`mvn spring-boot:run`

To start the application using gradle (on windows systems use the gradlew.bat file)

`./gradlew bootRun`

To view the application (after starting the application) go to:

[http://localhost:9000/index.html](http://localhost:9000/index.html)

To build the jar artifact

`mvn package`

To run the test cases

`mvn test`
