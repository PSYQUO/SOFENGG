package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseModel
{
    private DBConnection dbc;

    public ArrayList<Category> getCategories()
    {
        dbc = DBConnection.getInstance();
        ArrayList<Category> data = new ArrayList<Category>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from category");
            while(rs.next())
            {
                Category c = new Category(rs.getInt(1), rs.getString(2));
                data.add(c);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public Category searchCategory(int id)
    {
        dbc = DBConnection.getInstance();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from category where category_id=" + id);
            while(rs.next())
            {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return null;
    }

    public ArrayList<Role> getRoles()
    {
        dbc = DBConnection.getInstance();
        ArrayList<Role> data = new ArrayList<Role>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from role");
            while(rs.next())
            {
                Role r = new Role(rs.getInt(1), rs.getString(2));
                data.add(r);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public Role searchRole(int id)
    {
        dbc = DBConnection.getInstance();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from role where role_id=" + id);
            while(rs.next())
            {
                return new Role(rs.getInt(1), rs.getString(2));
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return null;
    }

    public ArrayList<RawItem> getRawItems()
    {
        dbc = DBConnection.getInstance();
        ArrayList<RawItem> data = new ArrayList<RawItem>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from rawitem");
            while(rs.next())
            {
                RawItem r = new RawItem(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(3));
                data.add(r);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public RawItem searchRawItem(int id)
    {
        dbc = DBConnection.getInstance();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from rawitem where rawitem_id=" + id);
            while(rs.next())
            {
                return new RawItem(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getDouble(3));
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return null;
    }

    public ArrayList<User> getUsers()
    {
        dbc = DBConnection.getInstance();
        ArrayList<User> data = new ArrayList<User>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from user");
            while(rs.next())
            {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), searchRole(rs.getInt(5)));
                data.add(u);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public User searchUser(int id)
    {
        dbc = DBConnection.getInstance();
        ArrayList<User> data = new ArrayList<User>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from user where user_id=" + id);
            while(rs.next())
            {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), searchRole(rs.getInt(5)));
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return null;
    }

    /**
     * TODO: NULLS
     */
    public ArrayList<Consumable> getConsumables()
    {
        dbc = DBConnection.getInstance();
        ArrayList<Consumable> data = new ArrayList<Consumable>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from consumable c, category cc where c.Category_ID=cc.Category_ID");
            while(rs.next())
            {
                Consumable c = new Consumable(rs.getInt(1), rs.getString(2), rs.getString(3), searchCategory(rs.getInt(6)), rs.getDouble(4), null, null);
                data.add(c);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    /**
     * TODO: NULLS
     */
    public Consumable searchConsumable(int id)
    {
        dbc = DBConnection.getInstance();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from consumable c, category cc where c.Category_ID=cc.Category_ID and c.consumable_id=" + id);
            while(rs.next())
            {
                return new Consumable(rs.getInt(1), rs.getString(2), rs.getString(3), searchCategory(rs.getInt(6)), rs.getDouble(4), null, null);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return null;
    }

    /**
     * TODO: NULLS
     */
    public ArrayList<Consumable> searchConsumableByCategory(String category)
    {
        dbc = DBConnection.getInstance();
        ArrayList<Consumable> data = new ArrayList<Consumable>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from consumable c, category cc where c.Category_ID=cc.Category_ID and cc.Category_Name='" + category + "'");
            while(rs.next())
            {
                Consumable c = new Consumable(rs.getInt(1), rs.getString(2), rs.getString(3), searchCategory(rs.getInt(6)), rs.getDouble(4), null, null);
                data.add(c);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    /**
     * TODO: NULLS
     */
    public ArrayList<Consumable> searchConsumableByCategory(int id)
    {
        dbc = DBConnection.getInstance();
        ArrayList<Consumable> data = new ArrayList<Consumable>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from consumable c, category cc where c.Category_ID=cc.Category_ID and cc.category_id=" + id);
            while(rs.next())
            {
                Consumable c = new Consumable(rs.getInt(1), rs.getString(2), rs.getString(3), searchCategory(rs.getInt(6)), rs.getDouble(4), null, null);
                data.add(c);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public ArrayList<LineItem> getLineItems()
    {
        dbc = DBConnection.getInstance();
        ArrayList<LineItem> data = new ArrayList<LineItem>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from lineitem l, consumable cc, category c where l.Consumable_ID=cc.Consumable_ID and cc.Category_ID=c.Category_ID;");
            while(rs.next())
            {
                LineItem l = new LineItem(rs.getInt(1), searchConsumable(rs.getInt(2)), rs.getInt(3));
                data.add(l);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public ArrayList<LineItem> searchLineItems(int id)
    {
        dbc = DBConnection.getInstance();
        ArrayList<LineItem> data = new ArrayList<LineItem>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from lineitem l, consumable cc, category c where l.transaction_id=" + id + " and l.Consumable_ID=cc.Consumable_ID and cc.Category_ID=c.Category_ID;");
            while(rs.next())
            {
                LineItem l = new LineItem(rs.getInt(1), searchConsumable(rs.getInt(2)), rs.getInt(3));
                data.add(l);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public ArrayList<XReading> getXReadToday()
    {
        dbc = DBConnection.getInstance();
        ArrayList<XReading> data = new ArrayList<XReading>();
        try
        {
            ResultSet rs = dbc.executeQuery("select u.*, sum(t.total) from user u, transaction t where u.User_ID=t.User_ID and t.Trans_DateTime=curdate() group by u.User_ID");
            while(rs.next())
            {
                XReading x = new XReading(searchUser(rs.getInt(1)), rs.getDouble(8));
                data.add(x);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public ArrayList<XReading> getXReadDate(LocalDate date)
    {
        dbc = DBConnection.getInstance();
        ArrayList<XReading> data = new ArrayList<XReading>();
        try
        {
            ResultSet rs = dbc.executeQuery("select u.user_name, sum(t.total) from user u, transaction t where u.User_ID=t.User_ID and t.Trans_DateTime=='" + date + "' group by u.User_ID");
            while(rs.next())
            {
                XReading x = new XReading(searchUser(rs.getInt(1)), rs.getDouble(8));
                data.add(x);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public ArrayList<XReading> getXReadRangeDate(LocalDate dateStart, LocalDate dateEnd)
    {
        dbc = DBConnection.getInstance();
        ArrayList<XReading> data = new ArrayList<XReading>();
        try
        {
            ResultSet rs = dbc.executeQuery("select u.user_name, sum(t.total) from user u, transaction t where u.User_ID=t.User_ID and t.Trans_DateTime>='" + dateStart + "' and t.Trans_DateTime<='" + dateEnd + "' group by u.User_ID;");
            while(rs.next())
            {
                XReading x = new XReading(searchUser(rs.getInt(1)), rs.getDouble(8));
                data.add(x);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    /**
     * TODO: rs.getString(1) to Date data type
     */
    public ArrayList<ZReading> getZReading()
    {
        dbc = DBConnection.getInstance();
        ArrayList<ZReading> data = new ArrayList<ZReading>();
        try
        {
            ResultSet rs = dbc.executeQuery("select trans_datetime ,sum(total) from transaction group by date(trans_datetime)");
            while(rs.next())
            {
                ZReading z = new ZReading(rs.getString(1), rs.getDouble(2));
                data.add(z);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    /**
     * TODO: NULLS
     */
    public ArrayList<Transaction> getTransactions()
    {
        dbc = DBConnection.getInstance();
        ArrayList<Transaction> data = new ArrayList<Transaction>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from transaction");
            while(rs.next())
            {
                Transaction t = new Transaction(rs.getInt(1), null, searchUser(rs.getInt(3)), null, rs.getDouble(6), rs.getDouble(7), rs.getDouble(9), rs.getDouble(10), searchLineItems(rs.getInt(1)), rs.getInt(4));
                data.add(t);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    /**
     * TODO: NULLS
     */
    public Transaction searchTransaction(int id)
    {
        dbc = DBConnection.getInstance();
        ArrayList<Transaction> data = new ArrayList<Transaction>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from transaction where transaction_id=" + id);
            while(rs.next())
            {
                return new Transaction(rs.getInt(1), null, searchUser(rs.getInt(3)), null, rs.getDouble(6), rs.getDouble(7), rs.getDouble(9), rs.getDouble(10), searchLineItems(rs.getInt(1)), rs.getInt(4));
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return null;
    }

    public ArrayList<Ingredient> getIngredients()
    {
        dbc = DBConnection.getInstance();
        ArrayList<Ingredient> data = new ArrayList<Ingredient>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from ingredient");
            while(rs.next())
            {
                Ingredient i = new Ingredient(searchRawItem(rs.getInt(1)), rs.getInt(2));
                data.add(i);
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return data;
    }

    public ArrayList<Ingredient> searchIngredientByConsumable(int id)
    {
        dbc = DBConnection.getInstance();
        ArrayList<Ingredient> data = new ArrayList<Ingredient>();
        try
        {
            ResultSet rs = dbc.executeQuery("select * from ingredient where consumable_id=" + id);
            while(rs.next())
            {
                Ingredient i = new Ingredient(searchRawItem(rs.getInt(1)), rs.getInt(2));
                data.add(i);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return data;
    }

    public ArrayList<Col2> getMostandLeastSold()
    {
        dbc = DBConnection.getInstance();
        ArrayList<Col2> data = new ArrayList<Col2>();
        try
        {
            ResultSet rs = dbc.executeQuery("select c.consumable_name, sum(l.quantity) from lineitem l, consumable c where l.consumable_id=c.consumable_id group by l.quantity desc");
            while(rs.next())
            {
                Col2 c = new Col2(rs.getString(1), rs.getString(2));
                data.add(c);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return data;
    }

    public boolean changePassword(User user, String newPassword)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("UPDATE user SET User_Password= ? WHERE User_ID= ?");
            dbc.setString(1, newPassword);
            dbc.setInt(2, user.getUserID());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean changeRole(User user, Role newRole)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("UPDATE user SET role_id= ? WHERE User_ID= ?");
            dbc.setInt(1, newRole.getRoleID());
            dbc.setInt(2, user.getUserID());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean addRawItem(RawItem newRawItem)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("INSERT INTO rawitem (RawItem_Name, RawItem_Price, RawItem_Quantity) VALUES (?, ?, ?)");
            dbc.setString(1, newRawItem.getName());
            dbc.setDouble(2, newRawItem.getPrice());
            dbc.setInt(3, newRawItem.getQuantity());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteRawItem(RawItem rawItem)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("DELETE FROM rawitem WHERE rawitem_ID=?");
            dbc.setInt(1, rawItem.getRawItemID());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean addCategory(Category newCategory)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("INSERT INTO category (Category_Name) VALUES (?)");
            dbc.setString(1, newCategory.getCategoryName());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteCategory(Category category)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("DELETE FROM category WHERE category_ID=?");
            dbc.setInt(1, category.getCategoryID());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean addUser(User newUser)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("INSERT INTO user (User_Username, User_Name, User_Password, Role) VALUES (?, ?, ?, ?)");
            dbc.setString(1, newUser.getusername());
            dbc.setString(2, newUser.getUserLoginName());
            dbc.setString(3, newUser.getPassword());
            dbc.setInt(4, newUser.getRole().getRoleID());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteUser(User user)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("DELETE FROM user WHERE User_ID=?");
            dbc.setInt(1, user.getUserID());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteConsumable(Consumable consumable)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("DELETE FROM consumable WHERE consumable_ID=?");
            dbc.setInt(1, consumable.getConsumableID());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }

            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteIngredients(Consumable consumable)
    {
        try
        {
            dbc = DBConnection.getInstance();
            dbc.prepareStatement("DELETE FROM ingredient WHERE consumable_ID=?");
            dbc.setInt(1, consumable.getConsumableID());

            if(dbc.executeUpdate() == 1)
            {
                return true;
            }
            dbc.closePreparedStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

}