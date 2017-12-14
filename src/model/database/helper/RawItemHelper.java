package model.database.helper;

import model.database.DataAccessObject;
import model.database.DatabaseHelper;
import model.food.RawItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* Used to access the RawItem database table through specific data operations.
*/
public class RawItemHelper extends DatabaseHelper implements DataAccessObject<RawItem> {
    
    public static final String TABLE_NAME = "RawItem";
    public static final String COLUMN_ID = "RawItem_ID";
    public static final String COLUMN_NAME = "RawItem_Name";
    public static final String COLUMN_PRICE = "RawItem_Price";
    public static final String COLUMN_QUANTITY = "RawItem_Quantity";

    @Override
    public boolean addItem(RawItem item) {
        String query = "INSERT INTO " + TABLE_NAME 
                     + " (" + COLUMN_NAME + ", "
                            + COLUMN_PRICE + ", "
                            + COLUMN_QUANTITY + ") "
                            + "VALUES (?, ?, ?);";

        System.out.println(query);
        
        String name = item.getName();
        int quantity = item.getQuantity();
        double price = item.getPrice();
                            
        int result = database.executeUpdate(query, new Object[] { name, quantity, price});
        
        return result != -1;
    }

    @Override
    public RawItem getItem(int id) {
        String query = "SELECT " + COLUMN_NAME + ", "
                                 + COLUMN_PRICE + ", "
                                 + COLUMN_QUANTITY
                                 + " FROM " + TABLE_NAME 
                                 + " WHERE " + COLUMN_ID + " = ?;";

		ResultSet rs = database.executeQuery(query, new Object[] {id});
		RawItem rawItem = null;

		try {
			if (rs.next ()) {
                String name = rs.getString(COLUMN_NAME);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                double price = rs.getDouble(COLUMN_PRICE);

                rawItem = new RawItem(id, name, quantity, price);
			}
		} catch (SQLException e) {
			e.printStackTrace ();
        }
        
        return rawItem;
    }
    
    @Override
    public List<RawItem> getAllItems() {
        String query = "SELECT " + COLUMN_ID + ", "
                                 + COLUMN_NAME + ", "
                                 + COLUMN_PRICE + ", "
                                 + COLUMN_QUANTITY
                                 + " FROM " + TABLE_NAME + ";";

		ResultSet rs = database.executeQuery (query, null);
		List<RawItem> rawItems = null;

		try {
			while (rs.next()) {
                int id = rs.getInt(COLUMN_ID);
                String name = rs.getString(COLUMN_NAME);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                double price = rs.getDouble(COLUMN_PRICE);

                RawItem rawitem = new RawItem(id, name, quantity, price);
                
                if (rawItems == null) {
                    rawItems = new ArrayList<>();
                }
                else {
                    rawItems.add(rawitem);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace ();
        }
        
        return rawItems;
    }

<<<<<<< HEAD
    /**
    * Updates a RawItem record in the database with a specific id.
    * 
    * @param RawItem   The representation of an item/ingredient in stock in the inventory.
    * @return          The number of rows affected by the operation.
    */
=======
    @Override
>>>>>>> c77ea6a8a7bced1928a6f25ee58befd538b5a723
    public int editItem(int id, RawItem item) {
        String query = "UPDATE " + TABLE_NAME + " "
                     + "SET " + COLUMN_NAME + " = ?, "
                              + COLUMN_PRICE + " = ?, "
                              + COLUMN_QUANTITY + " = ?, "
                              + "WHERE " + COLUMN_ID + " = ?;";
                            
        String name = item.getName();
        int quantity = item.getQuantity();
        double price = item.getPrice();
                            
		int result = database.executeUpdate(query, new Object[] { name, price, quantity, id });

		return result;
    }
    
    @Override
    public int deleteItem(int id) {
        String query = "DELETE FROM " + TABLE_NAME + " "
                      + "WHERE " + COLUMN_ID + " = ?;";
        
        int result = database.executeUpdate(query, new Object[] {id});
        
        return result;
    }
}