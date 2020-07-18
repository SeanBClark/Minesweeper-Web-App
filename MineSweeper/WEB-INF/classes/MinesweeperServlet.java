// Sean Clark - C326995
// Main objective of this java file is to create new games for users as well as updating
// saved games if the user would like to start a new game

// TO DO: If time rewrite database queries to use DatabaseQuery.getResultSet() to get rid of repeated code.

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import beans.*;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/MinesweeperServlet", urlPatterns = { "/MinesweeperServlet" })

public class MinesweeperServlet extends HttpServlet {

    public MinesweeperServlet() {

    super();

    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

        //  Var constructors
        String gameMode;
        Connection connection = null;
        ResultSet resultSet = null;

        int result = 0;
        int gridSize;
        int userID = 0;

        
        // Open database connection
        try {

            connection = ConfigBean.getConnection();
            System.out.println("Connected to DBMS");

        }
        catch (Exception e) { 
            
            System.out.println("Could not connect to DBMS"); 

        }

        // Sets up game mode and grid size
        gameMode = request.getParameter("gameModeBtn");
        gridSize = Integer.parseInt(gameMode);
        gameMode = getGameMode(gridSize);

        HttpSession session = request.getSession(true);

        // Gets current user from session
        //  NOT WORKING!!@
        // String name = ((UserBean) (session.getAttribute("user"))).getUserName();
        String name = (String) session.getAttribute("userName");

        System.out.println("Sessions name " + name);

        String userIDQuery = "Select userID from user_info where userName = '" + name + "';";

        try {

            ResultSet userInfoResultSet = DatabaseQuery.getResultSet(userIDQuery, connection);
            System.out.println("Select UserID Query Success");

            while(userInfoResultSet.next()) {
                userID = userInfoResultSet.getInt("userID");
            }
            
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + userID);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //  Gets all userIDs from database to check if user had already got a game saved
        String checkIfExists = "SELECT userID FROM minesweeper_info;";
        resultSet = DatabaseQuery.getResultSet(checkIfExists, connection);

        // 1st if checks if data exists, if not goes ahead and inserts it.
        // else goes through result set data if it does exists and finds if user has already got a game in the database, if not goes ahead and inserts it
        // If user does it  have a game already in the database, the current data will be updated instead
        Boolean exists = false;
        try {

            // if (!resultSet.isBeforeFirst()) {

            //     System.out.print("Database contains NO users. Please add one");

            // }
            // else {

            while(resultSet.next()) {

                if (resultSet.getInt("userID") == userID) {

                    exists = true;

                }
            }            
        } catch (Exception e) {            
            e.printStackTrace();
        }

        // If users has not got a game saved, it will create one with an insert statement for this user
        if (exists == false) {

            String msInfoInsert = "INSERT INTO minesweeper_info(userID, gameMode, gridSize) VALUES ('" + userID + "','" + gameMode + "','" + gridSize + "');";
        
            try {
    
                Statement statement = connection.createStatement();
                statement.execute(msInfoInsert);
                System.out.println("Insert Success");
    
            } catch (Exception e) {System.out.println("Insert Failed");}


            //Creates game state

            int rowNum = 0;
            int cellNum;
            int mineID = getMineID(userID, connection);
            System.out.println(mineID);

            for (int i = 0; i < gridSize * gridSize; i++) {

                cellNum = i + 1;

                if (i%gridSize == 0) {

                    rowNum++;

                }

                String msGameInsert = "INSERT INTO game_info(mineID, rowNum, cellNum, cellType) VALUES ('" + mineID + "','" + rowNum + "','" + cellNum + "','" + getRandomType() + "');";

                try {
    
                    Statement statement = connection.createStatement();
                    statement.execute(msGameInsert);
                    // System.out.println("Insert Game Success");
        
                } catch (Exception e) {
                    System.out.println("Insert Game Failed");
                    e.printStackTrace();
                }
    
                
            }


        }
        //  If a game is already saved to the users account, will update the saved game to a fresh state 
        //  Could also work for restart game button instead of redirecting to gameload.jsp
        else if (exists == true) {

            String msInfoUpdate = "UPDATE minesweeper_info SET gameMode = '" + gameMode + "', gridSize = " + gridSize + " WHERE userID ='" + userID + "';";

            try {
    
                Statement statement = connection.createStatement();
                statement.execute(msInfoUpdate);
                // System.out.println("Update Success");
    
            } catch (Exception e) {
                System.out.println("Update Failed");
                e.printStackTrace();
            }

            //Creates a new game if user already had a saved game
            int cellNum;
            int rowNum = 0;
            int gameID = 1;
            int fullGrid = gridSize * gridSize;
            int mineID = getMineID(userID, connection);
            System.out.println(mineID);

            // Loops through and creates grid, cells and their types
            for (int i = 0; i < fullGrid; i++) {

                cellNum = i + 1;

                // Creates row number
                if (i%gridSize == 0) {

                    rowNum++;

                }

                // Inserts any new data and updates old data
                // 
                //  TO DO: Currently deletes everyone elses game from the database
                // 
                String msGameUpdate = "INSERT into game_info(gameID, mineID, rowNum, cellNum, cellType) values ('" + gameID + "', '" + mineID + "', '" + rowNum + "', '" + cellNum + "', '" + getRandomType() + "') on duplicate key update cellType = '" + getRandomType() + "';";
                // Deletes extra game data
                //  For example if users has advanced game saved then starts beginner. 
                String msGameDelete = "delete from game_info where gameID > '" + fullGrid + "';";

                gameID++;

                // Statement Execution
                try {
    
                    Statement statement = connection.createStatement();
                    statement.execute(msGameUpdate);
                    if (i == fullGrid - 1) {

                        statement.execute(msGameDelete);

                    }
                    // System.out.println("Update Game Success");
        
                } catch (Exception e) {e.printStackTrace();}
    
                
            }


        }
        // Catch all for unknown use cases
        else {

            System.out.println("!!!Insert and Update have failed!!!");
            response.sendRedirect("../c3269995_assignment2/views/errorpage.jsp");

        }

        // Closes db connection
        try {
            
            connection.close();
            System.out.println("DB connection closed");

        } catch (Exception e) {
        
            e.getStackTrace();

        }

        // response.sendRedirect("../c3269995_assignment2/views/minesweeper.jsp");
        response.sendRedirect("/c3269995_assignment2/GameServlet");

    }

    // Function to get mineID from game info table
    public int getMineID(int param, Connection connection) {

        String query = "SELECT mineID FROM minesweeper_info where userID = '" + param + "'; ";
        ResultSet resultSet = null;
        int result = 0;

        try {

            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("Query Success");

        } catch (Exception e) {
            System.out.println("Query Failed");
        }

        try {

            while(resultSet.next()) {

                result = resultSet.getInt(1);
    
            }
            
        } catch (Exception e) {e.printStackTrace();}

        return result;


    }

    public String getRandomType() {

        String[] arrayStrings = {"Bomb", "Bomb", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", };

        int result = new Random().nextInt(arrayStrings.length);

        return arrayStrings[result];

    }

    //  Simple function to get what game mode the player has chosen
    //  Doesn't serve a purpose just for data keeping
    public String getGameMode(int param) {

        String result = null;

        if (param == 10)
            result = "Beginner";
        else if (param == 15)
            result = "Intermediate";
        else if (param == 20)
            result = "Advanced";

        return result;

    }

    // Method to get user ID from DB
    public int getUserID(String param) {   

        Connection connection = null;
        ResultSet resultSet = null;
        int result = 0;

        try {
            connection = ConfigBean.getConnection();
            System.out.println("Connected to DBMS");
        }
        catch (Exception e) { System.out.println("Could not connect to DBMS"); }

        String userInfoQuery = "select userID from user_info where userName = '" + param + "'";

        // Query try catch
        try {

            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(userInfoQuery);
            System.out.println("Query Success");

        } catch (Exception e) {
            System.out.println("Query Failed");
            result = 0;
        }

        try {
            
            while (resultSet.next()) {

                result = resultSet.getInt(1);
                
            }
        }
        catch (Exception e) {
            System.out.println("While failed");
        }

        try {

            connection.close();
            System.out.println("DBMS Connection Closed");

        }
        catch (Exception e) { System.out.println("Connection close failed"); }

        return result;

    }

}