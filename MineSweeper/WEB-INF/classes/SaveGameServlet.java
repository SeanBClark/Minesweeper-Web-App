import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import beans.*;

@WebServlet(name = "SaveGameServlet", urlPatterns = { "/SaveGameServlet" })

public class SaveGameServlet extends HttpServlet {

    public SaveGameServlet() {

        super();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

            Connection connection = null;
            String gridSizeString = request.getParameter("gridSize");
            int gridSize = Integer.parseInt(gridSizeString);
            System.out.println("Grid Size = " + gridSize);

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

            try {

                for (int i = 1; i <= gridSize * gridSize; i++){

                    String value = request.getParameter("getValue" + i);
                    System.out.println(value);
    
                    String updateString = "UPDATE game_info SET cellType = '" + value + "' where mineID = '" + userID + "';";

                    Statement statement = connection.createStatement();
                    statement.execute(updateString);
    
                }
                
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

        // Function to get mineID from game info table
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