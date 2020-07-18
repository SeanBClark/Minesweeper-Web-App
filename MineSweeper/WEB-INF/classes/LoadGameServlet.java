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

@WebServlet(name = "/LoadGameServlet", urlPatterns = { "/LoadGameServlet" })

public class LoadGameServlet extends HttpServlet {

    public LoadGameServlet() {

    super();

    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

        Connection connection = null;
        // ResultSet minesweeperRSet = null;
        // ResultSet gameResultSet = null;
        // int userID = 0;
        // List <UserGameBean> userGameList = new ArrayList<>();
        // List <GameBean> gameList = new ArrayList<>();
        HttpSession session = request.getSession(true);
        String name = (String) session.getAttribute("userName");

        // Open database connection
        try {

            connection = ConfigBean.getConnection();
            System.out.println("Connected to DBMS");

        }
        catch (Exception e) { 
            
            System.out.println("Could not connect to DBMS"); 

        }

        int userID = getUserID(name, connection);

        String getGameQuery = "SELECT * FROM game_info where mineID = '" + userID + "';";

        try {

            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Closes db connection
        try {
            
            connection.close();
            System.out.println("DB connection closed");

        } catch (Exception e) {
        
            e.getStackTrace();

        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {}

    public int getUserID(String param, Connection connection) {

        String query = "SELECT userID FROM user_info WHERE userName = '" + param + "';";
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
}