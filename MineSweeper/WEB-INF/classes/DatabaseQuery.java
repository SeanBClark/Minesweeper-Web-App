import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQuery {

    public static ResultSet getResultSet(String query, Connection connection) {

        ResultSet resultSet = null;

        try {
            
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("Query Success");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;

    }

}