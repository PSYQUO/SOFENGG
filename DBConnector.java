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
            result = statment.executeQuery("select category_name from category");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    public ResultSet getUsers()
    {
        result = null;

        try
        {
            result = statment.executeQuery("select user_name from user");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    public ResultSet getConsumable(String category)
    {
        result = null;

        try
        {
            result = statment.executeQuery("select f.consumable_name from consumable f, category c where c.category_name=="+category);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }
}
