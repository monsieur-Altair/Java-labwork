import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBconnection {
    private Connection connection;

    public DBconnection(){

    }

    public void init() throws InstantiationException, IllegalAccessException {
        try
        {
            //Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connection succesfull!");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/db6", "root", "583M6259vn328");
        }
        catch (SQLException e)
        {
            System.out.println("oooops");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public Connection getMyConnection()
    {
        return connection;
    }

    public void close(ResultSet rs)
    {
        if(rs !=null)
        {
            try
            {
                rs.close();
            }
            catch(Exception e){}
        }
    }

    public void close(java.sql.Statement stmt)
    {
        if(stmt !=null)
        {
            try
            {
                stmt.close();
            }
            catch(Exception e){}
        }
    }

    public void destroy()
    {
        if(connection !=null)
        {
            try
            {
                connection.close();
            }
            catch(Exception e){}
        }
    }

}
