package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    public boolean addItem(Consumable item) {

        return false;
    }

    /**
     * Retrieves a Consumable record from the database with a specific id.
     * 
     * @param id    Refers to a specific record in a database table.
     * @return      The representation of an item/ingredient in stock in the inventory.
     */
    public Consumable getItem(int id) {
        String query = "SELECT " + Consumable.COLUMN_ID + ","
                                 + Consumable.COLUMN_NAME + ","
                                 + Consumable.COLUMN_CODENAME + ","
                                 + Consumable.COLUMN_PRICE + ","
                                 + Consumable.COLUMN_MEAL + ","
                                 + Consumable.COLUMN_CATEGORY
                                 + " FROM " + Consumable.TABLE_NAME 
                                 + " WHERE " + Consumable.COLUMN_ID + " = ?;";

		ResultSet rs = database.executeQuery (query, new Object[] {id});
		Consumable consumable = null;

		try {
			if (rs.next ()) {
                int consumableId = rs.getInt(Consumable.COLUMN_ID);
                String name = rs.getString(Consumable.COLUMN_NAME);
                String codeName = rs.getString(Consumable.COLUMN_CODENAME);
                double price = rs.getDouble(Consumable.COLUMN_PRICE);

                consumable = new Consumable(consumableId, name, codeName, null, price, null);
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return consumable;
    }
    
    /**
     * Retrieves all Consumable records from the database.
     * 
     * @return      A list of all Consumable records in the database.
     */
    public List<Consumable> getAllItems() {
        String query = "SELECT " + Consumable.COLUMN_ID + ", "
                                 + Consumable.COLUMN_NAME + ", "
                                 + Consumable.COLUMN_CODENAME + ", "
                                 + Consumable.COLUMN_PRICE + ", "
                                 + Consumable.COLUMN_MEAL + ", "
                                 + Consumable.COLUMN_CATEGORY
                                 + " FROM " + Consumable.TABLE_NAME + ";";

		ResultSet rs = database.executeQuery (query, null);
		List<Consumable> consumables = null;

		try {
			while (rs.next()) {
                int id = rs.getInt(Consumable.COLUMN_ID);
                String name = rs.getString(Consumable.COLUMN_NAME);
                String codeName = rs.getString(Consumable.COLUMN_CODENAME);
                double price = rs.getDouble(Consumable.COLUMN_PRICE);

                Consumable consumable = new Consumable(id, name, codeName, null, price, null);
                
                if (consumables == null) {
                    consumables = new ArrayList<Consumable>();
                }
                else {
                    consumables.add(consumable);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return consumables;
    }

    /**
     * Updates a Consumable record in the database with a specific id.
     * 
     * @param Consumable    The representation of a food item.
     * @return              The number of rows affected by the operation.
     */
    public int editItem(int id, Consumable item) {

        return -1;
    }
    
    /**
     * Deletes a Consumable record from the database.
     * 
     * @param Consumable    The representation of a food item. 
     * @return              The number of rows affected by the operation.
     */
    public int deleteItem(int id) {

        return -1;
    }

}