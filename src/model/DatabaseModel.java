package model;

import java.util.*;
import java.sql.*;

public class DatabaseModel{
    private DBConnection dbc;
    private Statement stmt;

    public DatabaseModel(){
        dbc = DBConnection.getConnection ();
    }

    public ArrayList<Category> getCategories(){
        ArrayList<Category> data = new ArrayList<Category>(); 
        try{
            ResultSet rs = dbc.executeQuery ("select category_name from category");
            while(rs.next()){
                Category c = new Category (Integer.valueOf(rs.getString(1)), rs.getString(2));
                data.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
}