import java.sql.*;

public class DBConnector
{
    private Connection connection;
    private Statement statment;
    private PreparedStatement pstatement;
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
            result = statment.executeQuery("select c.consumable_name from consumable c, category cc where c.Category_ID=cc.Category_ID and cc.Cateogry_Name='"+category+"'");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    public ResultSet getCart(String id)
    {
        result = null;

        try
        {
            result = statment.executeQuery("select c.consumable_name, l.quantity, c.consumable_price*l.quantity from consumable c, lineitem l where c.consumable_id=l.consumable_id and l.transaction_id='"+id+"'");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    public ResultSet getRawItem(String id)
    {
        result = null;

        try
        {
            result = statment.executeQuery("select rawitem_name, rawitem_quantity from rawitem");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    public ResultSet getXReadToday()
    {
        result = null;

        try
        {
            result = statment.executeQuery("select u.user_name, sum(t.total) from user u, transaction t where u.User_ID=t.User_ID and t.Trans_DateTime=curdate() group by u.User_ID");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    public ResultSet getXReadDate(Date date)
    {
        result = null;

        try
        {
            result = statment.executeQuery("select u.user_name, sum(t.total) from user u, transaction t where u.User_ID=t.User_ID and t.Trans_DateTime=='"+date+"' group by u.User_ID");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    public ResultSet getXReadRangeDate(Date date1, Date date2)
    {
        result = null;

        try
        {
            result = statment.executeQuery("select u.user_name, sum(t.total) from user u, transaction t where u.User_ID=t.User_ID and t.Trans_DateTime>='"+date1+"' and t.Trans_DateTime<='"+date2+"' group by u.User_ID;");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    public boolean changePassword(String userID, String newPassword)
    {
        try
        {
            pstatement = connection.prepareStatement("UPDATE user SET User_Password= ? WHERE User_ID= ?");
            pstatement.setString(1, newPassword);
            pstatement.setInt(2, Integer.parseInt(userID));

            pstatement.executeUpdate();
            pstatement.close();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean changeRole(String userID, String newRole)
    {
        try
        {
            pstatement = connection.prepareStatement("UPDATE user SET User_Role= ? WHERE User_ID= ?");
            pstatement.setString(1, newRole);
            pstatement.setInt(2, Integer.parseInt(userID));

            pstatement.executeUpdate();
            pstatement.close();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteConsumable(String consID)
    {
        try
        {
            pstatement = connection.prepareStatement("DELETE FROM consumable WHERE Consumable_ID= ?");
            pstatement.setInt(1, Integer.parseInt(consID));

            pstatement.executeUpdate();
            pstatement.close();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteTransaction(String transID)
    {
        try
        {
            pstatement = connection.prepareStatement("DELETE transaction WHERE Trans_ID= ?");
            pstatement.setInt(1, Integer.parseInt(transID));

            pstatement.executeUpdate();
            pstatement.close();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean addRawItem(String rawName, String rawPrice, String rawQuantity)
    {
        try
        {
            pstatement = connection.prepareStatement("INSERT INTO rawitem (RawItem_Name, RawItem_Price, RawItem_Quantity) VALUES (?, ?, ?)");
            pstatement.setString(1, rawName);
            pstatement.setString(2, rawPrice);
            pstatement.setString(3, rawQuantity);

            pstatement.executeUpdate();
            pstatement.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateRawItem(String rawID, String addQuantity, String remarks, Date date) //not sure
    {
        try
        {
            pstatement = connection.prepareStatement("UPDATE rawitem SET RawItem_Quantity=RawItem_Quantity+? WHERE RawItem_ID= ?");
            pstatement.setString(1, rawID);
            pstatement.setString(2, addQuantity);

            pstatement.executeUpdate();
            pstatement.close();
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }

        try
        {
            pstatement = connection.prepareStatement("INSERT INTO incoming (In_DateTime, In_Quantity, In_Remarks, RawItem_ID) VALUES (?, ?, ?, ?)");
            
            pstatement.setString(1, date);
            pstatement.setString(2, addQuantity);
            pstatement.setString(3, remarks);
            pstatement.setString(4, rawID);

            pstatement.executeUpdate();
            pstatement.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
