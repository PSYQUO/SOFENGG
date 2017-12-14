package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.RawItem;

/**
* Used to access the RawItem database table through specific data operations.
*/
public class RawItemHelper extends DatabaseHelper implements DataAccessObject<RawItem> {
    
    public static final String TABLE_NAME = "RawItem";
    public static final String COLUMN_ID = "RawItem_ID";
    public static final String COLUMN_NAME = "RawItem_Name";
    public static final String COLUMN_PRICE = "RawItem_Price";
    public static final String COLUMN_QUANTITY = "RawItem_Quantity";

    /**
    * Inserts a RawItem record to the database.
    * 
    * @param RawItem   The representation of an item/ingredient in stock in the inventory.
    * @return          A boolean that is true if the operation is successful.
    */
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

    /**
    * Retrieves a RawItem record from the database with a specific id.
    * 
    * @param id    Refers to a specific record in a database table.
    * @return      The representation of an item/ingredient in stock in the inventory.
    */
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
                int quantity = rs.getString(COLUMN_QUANTITY);
                double price = rs.getDouble(COLUMN_PRICE);

                rawItem = new RawItem(id, name, quantity, price);
			}
		} catch (SQLException e) {
			e.printStackTrace ();
        }
        
        return rawItem;
    }
    
    /**
    * Retrieves all RawItem records from the database.
    * 
    * @return      A list of all RawItem records in the database.
    */
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
                int quantity = rs.getString(COLUMN_QUANTITY);
                double price = rs.getDouble(COLUMN_PRICE);

                RawItem rawitem = new RawItem(id, name, quantity, price);
                
                if (rawItems == null) {
                    rawItems = new ArrayList<RawItem>();
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

    /**
    * Updates a RawItem record in the database with a specific id.
    * 
    * @param RawItem   The representation of an item/ingredient in stock in the inventory.
    * @return          The number of rows affected by the operation.
    */
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
    
    /**
    * Deletes a RawItem record from the database.
    * 
    * @param RawItem   The representation of an item/ingredient in stock in the inventory.
    * @return          The number of rows affected by the operation.
    */
    public int deleteItem(int id) {
        String query = "DELETE FROM " + TABLE_NAME + " "
                      + "WHERE " + COLUMN_ID + " = ?;";
        
        int result = database.executeUpdate(query, new Object[] {id});
        
        return result;
    }
}