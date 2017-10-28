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
            ResultSet rs = dbc.executeQuery ("select * from category");
            while(rs.next()){
                Category c = new Category (Integer.valueOf(rs.getString(1)), rs.getString(2));
                data.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            try
            {
                dbc.closeConnection();
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
            ResultSet rs = dbc.executeQuery ("select * from consumable c, category cc where c.Category_ID=cc.Category_ID and cc.Cateogry_Name='"+category+"'");
            while(rs.next()){
                Consumable c = new Consumable (Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), ,rs.getDouble(4), , );
                data.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        } finally{
            try
            {
                dbc.closeConnection();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return data;
    }
}