package model;

import java.util.*;
import java.sql.*;

public class DatabaseModel{
    private DBConnection dbc;
    private Statement stmt;

    public DatabaseModel(){
        
    }

    public ArrayList<Category> getCategories(){
        dbc = DBConnection.getConnection ();
        ArrayList<Category> data = new ArrayList<Category>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select category_name from category");
            while(rs.next()){
                Category c = new Category (Integer.valueOf(rs.getString(1)), rs.getString(2));
                data.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            try
            {
                dbc.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return data;
    }

    public ArrayList<Consumable> getConsumableByCategory(String category){
        dbc = DBConnection.getConnection ();
        ArrayList<Consumable> data = new ArrayList<Consumable>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select c.consumable_name from consumable c, category cc where c.Category_ID=cc.Category_ID and cc.Cateogry_Name='"+category+"'");
            while(rs.next()){
                Consumable c = new Consumable (rs.getString(1));
                data.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            try
            {
                dbc.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return data;
    }
}