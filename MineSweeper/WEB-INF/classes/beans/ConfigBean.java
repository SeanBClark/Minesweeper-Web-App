package beans;

import javax.sql.*;
import java.sql.*;

import javax.management.RuntimeErrorException;
import javax.naming.*;

public class ConfigBean 
{

    private static final DataSource dataSource = makeDataSource();

    private static DataSource makeDataSource()
    {

        try
        {

            InitialContext initialContext = new InitialContext();
            return (DataSource) initialContext.lookup("java:/comp/env/jdbc/MyConnection");
            

        }
        catch (NamingException e)
        {

            throw new RuntimeException(e);

        }

    }

    public static Connection getConnection() throws SQLException
    {

        return dataSource.getConnection();        

    }

}