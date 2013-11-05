About
=====

A GAE/J project template for JSF based applications. This template uses Gradle for building.

This template:

+ uses Bootstrap for its templating
+ is based on JSF 2.2, JPA 2, CDI , PrimeFaces
+ uses Gradle for building & running


Getting Started
---------------

    1. Clone the repository locally
    2. $> gradle setupEnv
          This will download and setup the AppEngine environment in your local machine

       $> gradle run
          This will build and run the project. You can access the application @ http://localhost:8888/

    3. Have a look at the build.gradle file. This contains all the key attributes of the project like the name and version details.
       It also contains details on what version of the appengine should be used, etc.

    4. Under the infra/ folder you will find the scripts that provide the actual integration with GAE/J


I had created this template as a base for reproducing issues that I filed against JavaServerFaces.

Since I found this quite useful, I though I should share it with the rest.

<i>
NOTE:

 + There are still a few pieces that I haven't integrated, like the upload commands.
 + I use an advanced version of the same template for a multi-module project that I am working on. I shall update this starter template once I get some time.

</i>
