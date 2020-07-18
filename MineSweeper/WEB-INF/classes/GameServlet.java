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

@WebServlet(urlPatterns = { "/GameServlet" })

public class GameServlet extends HttpServlet {

    public GameServlet() {

        super();

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

        Connection connection = null;
        ResultSet minesweeperRSet = null;
        ResultSet gameResultSet = null;
        int userID = 0;
        List <UserGameBean> userGameList = new ArrayList<>();
        List <GameBean> gameList = new ArrayList<>();

        // Open database connection
        try {

            connection = ConfigBean.getConnection();
            System.out.println("Connected to DBMS");

        }
        catch (Exception e) { 
            
            System.out.println("Could not connect to DBMS"); 

        }

        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("userName");
        String mineID = null;

        userID = getUserID(name, connection);
        String query = "Select * from minesweeper_info where userID = '" + userID + "';";
        minesweeperRSet = DatabaseQuery.getResultSet(query, connection);

        // Gets user info about current saved game
        try {

            while(minesweeperRSet.next()){

                session = request.getSession();

                UserGameBean userGameBean = new UserGameBean();

                userGameBean.setMineID(Integer.parseInt(minesweeperRSet.getString("mineID")));
                userGameBean.setUserID(Integer.parseInt(minesweeperRSet.getString("userID")));
                userGameBean.setGameMode(minesweeperRSet.getString("gameMode"));
                userGameBean.setGridSize(Integer.parseInt(minesweeperRSet.getString("gridSize")));
                userGameList.add(userGameBean);
                mineID = minesweeperRSet.getString("mineID");
    
            }

            session.setAttribute("userGameList", userGameList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("MINE ID ====================== " + mineID);
        // GETS the game data
        String gameQuery = "SELECT * FROM game_info WHERE mineID = '" + mineID + "';";

        gameResultSet = DatabaseQuery.getResultSet(gameQuery, connection);
        
        try {

            while (gameResultSet.next()) {

                session = request.getSession();
    
                GameBean gameBean = new GameBean();

                gameBean.setGameID(Integer.parseInt(gameResultSet.getString("gameID")));
                gameBean.setMineID(Integer.parseInt(gameResultSet.getString("mineID")));
                gameBean.setRowNum(Integer.parseInt(gameResultSet.getString("rowNum")));
                gameBean.setCellNum(Integer.parseInt(gameResultSet.getString("cellNum")));
                gameBean.setCellType(gameResultSet.getString("cellType"));
                gameList.add(gameBean);

            }
    
            session.setAttribute("gameList", gameList);

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

        response.sendRedirect("../c3269995_assignment2/views/minesweeper.jsp");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {}

    public int getUserID(String param, Connection connection) {

        String query = "Select userID from user_info where userName = '" + param + "';";
        ResultSet resultSet = null;
        int result = 0;

        try {
            
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("Query Success");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {

            while(resultSet.next()) {

                result = resultSet.getInt("userID");
    
            }
            
        } catch (Exception e) {e.printStackTrace();}

        return result;

    }
}

