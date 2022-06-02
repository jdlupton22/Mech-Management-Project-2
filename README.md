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

ScreenShots of User Interface
![browser-not-logged-in](https://user-images.githubusercontent.com/102607791/171521253-c4b9cee4-bb0f-4dd8-9da0-e74541954807.png)
![checkout-form](https://user-images.githubusercontent.com/102607791/171521273-939891f4-3709-45d3-b589-d91289c2f82a.png)
![homepage-logged-in](https://user-images.githubusercontent.com/102607791/171521279-7bbec6df-c651-41d1-9a22-464b5e6577fb.png)
![index-page](https://user-images.githubusercontent.com/102607791/171521297-801c490b-6599-40bf-a88a-21d1ef239989.png)
![login-page](https://user-images.githubusercontent.com/102607791/171521370-558929de-9336-4846-b1d7-79679c4d8a5c.png)
![mech-unavailable-alert](https://user-images.githubusercontent.com/102607791/171521381-9d13f8a4-bbea-4f21-a87b-e7690e8a435e.png)
![successful-checkout](https://user-images.githubusercontent.com/102607791/171521396-5f19471a-9b0b-43d9-89be-72d6f6757983.png)

