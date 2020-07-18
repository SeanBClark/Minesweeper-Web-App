import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import beans.*;

@WebServlet(urlPatterns = { "/LoginServlet" })

public class LoginServlet extends HttpServlet {

    public LoginServlet() {

        super();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        String userNameInput = request.getParameter("inputUserName");
        String userPasswordInput = request.getParameter("inputPassword");        
        Connection connection = null;
        ResultSet resultSet = null;

        // Gets database connection
        try {

            connection = ConfigBean.getConnection();
            System.out.println("Connected");

        }
        catch (Exception e)
        {

            System.out.println("Could not connect to DBMS");

        }

        String userInfoQuery = "select userName, password from user_info";
        resultSet = DatabaseQuery.getResultSet(userInfoQuery, connection);

        // Loop through resault to see if user name exists. If it does saves it to sessions and progresses. 
        // If not sends back to login page
        //
        // TO DO: Add status letting user know they have failed to login

        try {

            while(resultSet.next()) {

                if (userNameInput.equals(resultSet.getString("userName")) && userPasswordInput.equals(resultSet.getObject("password"))) {

                    HttpSession session = request.getSession();

                    // Removes password before  going to next page
                    userPasswordInput = null;

                    UserBean userBean = new UserBean();
                    userBean.setUserName(resultSet.getString("userName"));
                    session.setAttribute("userBean", userBean);
                    session.setAttribute("userName", resultSet.getString("userName"));

                }

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("../c3269995_assignment2/views/gameload.jsp");

    }
}