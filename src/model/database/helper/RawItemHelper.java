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
        
    }

    /**
     * Retrieves a RawItem record from the database with a specific id.
     * 
     * @param id    Refers to a specific record in a database table.
     * @return      The representation of an item/ingredient in stock in the inventory.
     */
    public RawItem getItem(int id) {

    }
    
    /**
     * Retrieves all RawItem records from the database.
     * 
     * @return      A list of all RawItem records in the database.
     */
    public List<RawItem> getAllItems() {

    }

    /**
     * Updates a RawItem record in the database with a specific id.
     * 
     * @param RawItem   The representation of an item/ingredient in stock in the inventory.
     * @return          The number of rows affected by the operation.
     */
    public int editItem(int id, RawItem item) {

    }
    
    /**
     * Deletes a RawItem record from the database.
     * 
     * @param RawItem   The representation of an item/ingredient in stock in the inventory.
     * @return          The number of rows affected by the operation.
     */
    public int deleteItem(int id) {

    }

}