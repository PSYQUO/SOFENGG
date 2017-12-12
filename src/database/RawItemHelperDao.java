package database.helper;

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
    boolean addItem(RawItem item) {

    }

    /**
     * Retrieves a RawItem record from the database with a specific id.
     * 
     * @param id    Refers to a specific record in a database table.
     * @return      The representation of an item/ingredient in stock in the inventory.
     */
    RawItem getItem(int id) {

    }
    
    /**
     * Updates a RawItem record in the database with a specific id.
     * 
     * @param RawItem   The representation of an item/ingredient in stock in the inventory.
     * @return          The number of rows affected by the operation.
     */
    int editItem(int id, RawItem item) {

    }
    
    /**
     * Deletes a RawItem record from the database.
     * 
     * @param RawItem   The representation of an item/ingredient in stock in the inventory.
     * @return          The number of rows affected by the operation.
     */
    int deleteItem(int id) {

    }

}