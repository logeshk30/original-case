Travel API Client
=================

Here is the link to the repository of Travel API client assignment software
[Github Repo link](https://github.com/logeshk30/original-case)

I had to do this assignment from my Boeing imaged laptop which has quite a few restrictions on setting up new software 
applications. I had difficulties in setting up gradle in my dev environment to build and test this application. So I 
went ahead with maven for resolving the project dependencies. However I have also added the necessary dependency details
in build.gradle file. So it should work fine thru gradle as well. But I could not validate it in my machine.

To start the application using maven

`mvn spring-boot:run`

To start the application using gradle (on windows systems use the gradlew.bat file)

`./gradlew bootRun`

To view the application (after starting the application) go to:

[http://localhost:9000/index.html](http://localhost:9000/index.html)


Fork or otherwise clone this repo into your own personal **private** GitHub repository, and please make sure to add read access for the following GitHub users:
- Pim-Huisman
- bv1p

Please reply to the assessment invitation that you got from us with the link to your
repository when you are done with the assignment below. The mock backend to communicate with can be
found [here on GitHub](https://github.com/Pim-Huisman/simple-travel-api-mock).

Create your own [GitHub actions](https://github.com/features/actions) to build and test your assignment software.

Start it (on windows systems use the gradlew.bat file):

`./gradlew bootRun`

to list all tasks:

`./gradlew tasks`

To view the actual assignment (after starting the application) go to:

[http://localhost:9000/index.html](http://localhost:9000/index.html)
