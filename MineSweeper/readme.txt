Database used === MySql

=============================================================================================

A login is created when the database is created in the c3269995_Database_Script.sql

User Name = admin
Password = admin

=============================================================================================

TO MAKE MARKING EASIER 

Comment out font-size within btn.ms within minesweeper.css. This will allow you you see the bombs which will make marking easier. 

!!! I have left font-size commented out for easy of marking !!!

=============================================================================================

ISSUES!

-  When marking a bomb with a right click, you may have to click in the box around the text, not on the actual text to mark a bomb. 

-  Currently only supports one user at a time. When loading a new game it overrides the last save game. Would have been able to fix however, as this is only worth 15% 
     I have had to move onto other assignments for my other Classes

-   CSS ain't that great. Sorry!

=============================================================================================

Complile Java Classes command

javac -cp ".;mysql-connector-java-8.0.19.jar;C:\Users\seanc\Documents\Git Hub\SENG2250-Web-Engineering\apache-tomcat-9.0.34\apache-tomcat-9.0.34\lib\servlet-api.jar" *.java

=============================================================================================

Server Set up

Create MySql login as User Name: root, Password: c3269995

If different on your computer!!!!!  change username and password on context.xml file to the login and password on your computers MySql database

=============================================================================================

EXPLANATION!

App is MVC. 

    -   Java classes (Sevlets) are kept within the WEB-INF with java bean kept within WEB-INF/beans to break up classes

    -   View (jsp) files are kept within a views sub file within c3269995_assignment2

    -   css files are kept within a css sub file within c3269995_assignment2

    -   Javascript (Jquery) files are kept within the Javascript sub file within c3269995_assignment2

Basic Overfiew

    -   All jsp and js files never touch the database. All database functions are ran through servlets then saved into sessions data to then sent back to the front end.
        This is done to preserve the MVC stucture

Objects

    -   Beans

        -   Config bean.java

            -   Used to set up the database connection

        -   GameBean.java

            - Used to store and seralize infomation about the game

        -   User Beans.java

            - Used to store and seralize infomation about the current user

        -   UserGameBean.java

            - Used to store and seralize infomation about the game structure itself

    -   Classes

        -   DatabaseQuery.java

            -   This is a class used to query the database for any information that is needed throughout the App.
                This was made to stop repeated code as otherwise this function would have had to be written out each time the DB needed to be queried

        -   GameServlet.java

            - Controller to keep data about each users game

        -   LoadGameServlet.java

            -   Controller to load a users game if it is saved to the database

        -   LoginServlet.java

            -   Controller to let user log into the sesssion. Current only users created in the database can log in

            -   USERNAME = admin; PASSWORD = admin;

        -   MinesweeperServlet.java

            - Controller for the game itself. 

        -   SaveGameServlet.java

            - Controller to save users current game to return to at a later date


=============================================================================================

SESSIONS TRACKING

    -   Sessions is just kept through the servelets build in sessions functions

GAME SAVING

    -   When user hits save it will to a post request that saves the games data to the database

URL MARKER

    -   http://localhost:8080/c3269995_assignment2/views/login.jsp


DATABASE

Server Set up

Create MySql login as User Name: root, Password: c3269995

If different on your computer!!!!!  change username and password on context.xml file to the login and password on your computers MySql server login