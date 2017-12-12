package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.Consumable;

/**
 * Used to access the Consumable database table through specific data operations.
 */
public class ConsumableHelper extends DatabaseHelper implements DataAccessObject<Consumable> {

    /**
     * Inserts a Consumable record to the database.
     * 
     * @param Consumable    The representation of a food item. 
     * @return              A boolean that is true if the operation is successful.
     */
    boolean addItem(Consumable item) {
        
    }

    /**
     * Retrieves a Consumable record from the database with a specific id.
     * 
     * @param id    Refers to a specific record in a database table.
     * @return      The representation of an item/ingredient in stock in the inventory.
     */
    Consumable getItem(int id) {

    }
    
    /**
     * Retrieves all Consumable records from the database.
     * 
     * @return      A list of all Consumable records in the database.
     */
    List<Consumable> getAllItems() {

    }

    /**
     * Updates a Consumable record in the database with a specific id.
     * 
     * @param Consumable    The representation of a food item.
     * @return              The number of rows affected by the operation.
     */
    int editItem(int id, Consumable item) {

    }
    
    /**
     * Deletes a Consumable record from the database.
     * 
     * @param Consumable    The representation of a food item. 
     * @return              The number of rows affected by the operation.
     */
    int deleteItem(int id) {

    }

}