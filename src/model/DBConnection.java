package model;

import java.sql.*;

public class DBConnection
{

    private static final DBConnection dbc = new DBConnection();

    private Connection con;
    private Statement stmt;

    private DBConnection()
    {
    }

    public static DBConnection getConnection()
    {
        return dbc;
    }

    public void setConnection(String db, String user, String pass)
    {
        setConnection("localhost", "3306", db, user, pass);
    }

    public void setConnection(String host, String port, String db, String user, String pass)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false", user, pass);
            stmt = con.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String query) throws SQLException
    {
        return stmt.executeUpdate(query);
    }

    public ResultSet executeQuery(String query) throws SQLException
    {
        return stmt.executeQuery(query);
    }

    public void closeConnection()
    {
        if(con == null)
            return;
        try
        {
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}