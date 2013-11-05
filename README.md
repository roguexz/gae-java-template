About
=====

A GAE/J project template for JSF based applications. I had created this template as a base for reproducing issues that
I filed against JavaServerFaces. Since I found this quite useful, I though I should share it with the rest.

Key points about this bare bones starter template:

+ Configured with JSF 2.2 &amp; JPA 2 &amp; CDI &amp; PrimeFaces.
+ Basic code for supporting serialization, session cleanup and stuff that I keep
  <a href="http://roguexz.blogspot.in/">blogging about</a>.
+ Uses Gradle as its build system (including downloading &amp; running the GAE/J server itself).
+ Uses bootstrap for page templating.


Getting Started
---------------

    1. Clone the repository locally
    2. $> gradle setupEnv
          This will download and setup the AppEngine environment in your local machine

       $> gradle run
          This will build and run the project. You can access the application @ http://localhost:8888/

    3. Have a look at the build.gradle file. This contains all the key attributes of the project like
       the name and version details. It also contains details on what version of the AppEngine should
       be used, etc.

    4. Under the infra/ folder you will find the scripts that provide the actual integration with GAE/J

    5. $> gradle uploadApp
          This will upload the application to AppEngine.
          Do not forget to update the app name before firing this command


Here is an actual instance <a href='http://gae-java-template.appspot.com/'>deployed on AppEngine</a>.
