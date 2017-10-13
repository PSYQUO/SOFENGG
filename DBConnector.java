import java.sql.*;

public class DBConnector
{
    private Connection connection;
    private Statement statment;
    private ResultSet result;

    private static String username = "root";
    private static String password = "1234";
    private static String db = "tjbbqdb";
    
    private static String path = "jdbc:mysql://localhost:3306/"+db+"?useSSL=false";

    public DBConnector()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(path, username, password);
            statment = connection.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public ResultSet getCategories()
    {
        result = null;

        try
        {
            result = statment.executeQuery("select name from category");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }
}
