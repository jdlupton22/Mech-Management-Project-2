Mech-Management Project 

The Mechanized Vehicle Management System allows for users to manage an inventory of Mechs.
Users are able to login in to gain full access.  
Admins can add mechs to the database, update a mechs info, or delete them.
Pilots can view detailed information about a mech and check them out of the inventory for missions.
If a user isn't logged in they are still able to view some mechs info, but Admins are able to set a mech as confidential,
    which prevents anonymous users from viewing it.
Polit Users can also leave reviews on mechs.

Technologies Used:
REST, SQL, JavaScript, Java, Python, Flask, Javalin, Selenium, Postman, HTML, CSS, Cucumber, Trello, Unittesting, Pytest, Junit, and Built in loggers. 


<!-- Before running Set up your Database-->
<! -- Warning for security in Python DB is set as a env variable-->
<! -- Warning for security in JAVAn DB has gitignore attached to resources for conenctions-->


<!-- To run the App in Python (recommended IDE PyCharm)Install:
  1. pip install psycopg2
  2. pip install flask
  3. pip install flask_cors
  4. pip install unittest
  5. pip install behave
  6. pip install selenium
 -->

<!-- To run the App in Java Install:
  1. Install Java IDE (recommended IDE Intellij)
  2. Run as a Maven Project
  Next install the following dependencies(may vary based on OS and Browser Utilized):
      <dependencies>

        <dependency>
            <groupId>io.javalin</groupId>
            <artifactId>javalin</artifactId>
            <version>4.6.0</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.36</version>
        </dependency>

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.9.0</version>
        </dependency>

        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.3.6</version>
        </dependency>

        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>4.5.1</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.1.4</version>
        </dependency>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-chrome-driver</artifactId>
            <version>4.1.4</version>
        </dependency>

        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>1.2.6</version>
        </dependency>

        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>1.2.6</version>
        </dependency>

        <dependency>
            <groupId>info.cukes</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>1.2.6</version>
            <scope>test</scope>
        </dependency>

    </dependencies>