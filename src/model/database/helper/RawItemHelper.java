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

     /**
      * Inserts a RawItem record to the database.
      * 
      * @param RawItem   The representation of an item/ingredient in stock in the inventory.
      * @return          A boolean that is true if the operation is successful.
      */
     public boolean addItem(RawItem item) {
         String query = "INSERT INTO " + RawItem.TABLE_NAME 
                     + " (" + RawItem.COLUMN_NAME + ", "
                            + RawItem.COLUMN_PRICE + ", "
                            + RawItem.COLUMN_QUANTITY + ") "
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
         String query = "SELECT " + RawItem.COLUMN_NAME + ", "
                                 + RawItem.COLUMN_PRICE + ", "
                                 + RawItem.COLUMN_QUANTITY
                                 + " FROM " + RawItem.TABLE_NAME 
                                 + " WHERE " + RawItem.COLUMN_ID + " = ?;";

		ResultSet rs = database.executeQuery(query, new Object[] {id});
		RawItem rawItem = null;

		try {
			if (rs.next ()) {
                String name = rs.getString(RawItem.COLUMN_NAME);
                int quantity = rs.getString(RawItem.COLUMN_QUANTITY);
                double price = rs.getDouble(RawItem.COLUMN_PRICE);

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
         String query = "SELECT " + RawItem.COLUMN_ID + ", "
                                 + RawItem.COLUMN_NAME + ", "
                                 + RawItem.COLUMN_PRICE + ", "
                                 + RawItem.COLUMN_QUANTITY
                                 + " FROM " + RawItem.TABLE_NAME + ";";

		ResultSet rs = database.executeQuery (query, null);
		List<RawItem> rawItems = null;

		try {
			while (rs.next()) {
                int id = rs.getInt(RawItem.COLUMN_ID);
                String name = rs.getString(RawItem.COLUMN_NAME);
                int quantity = rs.getString(RawItem.COLUMN_QUANTITY);
                double price = rs.getDouble(RawItem.COLUMN_PRICE);

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
         String query = "UPDATE " + RawItem.TABLE_NAME + " "
                      + "SET " + RawItem.COLUMN_NAME + " = ?, "
                              + RawItem.COLUMN_PRICE + " = ?, "
                              + RawItem.COLUMN_QUANTITY + " = ?, "
                              + "WHERE " + RawItem.COLUMN_ID + " = ?;";
                            
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
         String query = "DELETE FROM " + RawItem.TABLE_NAME + " "
                      + "WHERE " + RawItem.COLUMN_ID + " = ?;";
        
        int result = database.executeUpdate(query, new Object[] {id});
        
        return result;
     }

 }