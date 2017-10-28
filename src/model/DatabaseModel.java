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

        ResultSet rs = dbc.executeQuery ();
        while(rs.next()){
            Category c = new Category (rs.getString(1), rs.getString(2));
            data.add(c);
        }
    }

}