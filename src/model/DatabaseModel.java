package model;

import java.util.*;
import java.sql.*;

public class DatabaseModel{
    private DBConnection dbc;

    public DatabaseModel(){
    }

    public ArrayList<Category> getCategories(){
        dbc = DBConnection.getConnection ();
        ArrayList<Category> data = new ArrayList<Category>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select * from category");
            while(rs.next()){
                Category c = new Category (Integer.valueOf(rs.getString(1)), rs.getString(2));
                data.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            dbc.closeConnection();
        }
        return data;
    }

    public ArrayList<RawItem> getRawItems(){
        dbc = DBConnection.getConnection ();
        ArrayList<RawItem> data = new ArrayList<RawItem>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select * from rawitem");
            while(rs.next()){
                RawItem r = new RawItem (Integer.valueOf(rs.getString(1)), rs.getString(2), Integer.valueOf(rs.getString(4)), rs.getDouble(3));
                data.add(r);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            dbc.closeConnection();
        }
        return data;
    }

    /**
     * TODO: NULLS
     */
    public ArrayList<User> getUsers(){
        dbc = DBConnection.getConnection ();
        ArrayList<User> data = new ArrayList<User>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select * from user");
            while(rs.next()){
                User u = new User (Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), null);
                data.add(u);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            dbc.closeConnection();
        }
        return data;
    }

    /**
     * TODO: NULLS
     */
    public ArrayList<Consumable> getConsumables(){
        dbc = DBConnection.getConnection ();
        ArrayList<Consumable> data = new ArrayList<Consumable>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select * from consumable c, category cc where c.Category_ID=cc.Category_ID");
            while(rs.next()){
                Consumable c = new Consumable (Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), new Category(rs.getInt(6), rs.getString(8)),rs.getDouble(4), null, null);
                data.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            dbc.closeConnection();
        }
        return data;
    }

    /**
     * TODO: NULLS
     */
    public ArrayList<Consumable> getConsumableByCategory(String category){
        dbc = DBConnection.getConnection ();
        ArrayList<Consumable> data = new ArrayList<Consumable>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select * from consumable c, category cc where c.Category_ID=cc.Category_ID and cc.Category_Name='"+category+"'");
            while(rs.next()){
                Consumable c = new Consumable (Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), new Category(rs.getInt(6), rs.getString(8)),rs.getDouble(4), null, null);
                data.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            dbc.closeConnection();
        }
        return data;
    }

    /**
     * TODO: line 115 - new Consumable()
     */
    public ArrayList<LineItem> getCartByTransID(int id){
        dbc = DBConnection.getConnection ();
        ArrayList<LineItem> data = new ArrayList<LineItem>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select distinct * from lineitem l, consumable cc, category c where l.transaction_id="+id+" and l.Consumable_ID=cc.Consumable_ID and cc.Category_ID=c.Category_ID;");
            while(rs.next()){
                LineItem l = new LineItem (Integer.valueOf(rs.getString(1)), new Consumable(), Integer.valueOf(rs.getString(3)));
                data.add(l);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            dbc.closeConnection();
        }
        return data;
    }

    public ArrayList<RawItem> getRawItems(){
        dbc = DBConnection.getConnection ();
        ArrayList<RawItem> data = new ArrayList<RawItem>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select * from rawitem");
            while(rs.next()){
                RawItem r = new RawItem (Integer.valueOf(rs.getString(1)), rs.getString(2), Integer.valueOf(rs.getString(4)), rs.getDouble(3));
                data.add(r);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            dbc.closeConnection();
        }
        return data;
    }
}