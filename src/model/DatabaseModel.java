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
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return data;
    }
}