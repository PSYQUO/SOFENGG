package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.Consumable;
import model.food.Ingredient;
import model.food.ingredient;

/**
 * Used to access the Ingredient database table through specific data operations.
 */
public class IngredientHelper extends DatabaseHelper implements DataAccessObject<Ingredient> {

    /**
     * Inserts a Ingredient record into the database.
     * 
     * @param Ingredient    The representation of a Ingredient item. 
     * @return              A boolean that is true if the operation is successful.
     */
    @Override
    public boolean addItem(Ingredient item) {

        return false;
    }

    /**
     * Retrieves Ingredients record from the database with a specific id.
     * 
     * @param id    Refers to a specific record in a database table.
     * @return      The representation of an item/ingredient in stock in the inventory.
     */
    @Override
    public List<Ingredient> getItem(int id) {
        String query = "SELECT " + Ingredient.COLUMN_CONSUMABLE_ID + ", "
                                 + Ingredient.COLUMN_RAWITEM_ID + ", "
                                 + Ingredient.COLUMN_QUANTITY
                                 + " FROM " + Ingredient.TABLE_NAME
                                 + " WHERE " + Ingredient.COLUMN_CONSUMABLE_ID + " = ?;";

		ResultSet rs = database.executeQuery (query, null);
		List<Ingredient> ingredients = null;

		try {
			if (rs.next ()) {
                int Cid = rs.getInt(Ingredient.COLUMN_CONSUMABLE_ID);
                int Rid = rs.getInt(Ingredient.COLUMN_RAWITEM_ID);
                int q = rs.getInt(Ingredient.COLUMN_QUANTITY);

                Ingredient ingredient = new Ingredient(null, q);

                if (ingredients == null) {
                    ingredients = new ArrayList<Ingredient>();
                }
                else {
                    ingredients.add(ingredient);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return ingredients;
    }
    
    /**
     * Retrieves all Ingredient records from the database.
     * 
     * @return      A list of all Ingredient records in the database.
     */
    @Override
    public List<Ingredient> getAllItems() {
        String query = "SELECT " + Ingredient.COLUMN_CONSUMABLE_ID + ", "
                                 + Ingredient.COLUMN_RAWITEM_ID + ", "
                                 + Ingredient.COLUMN_QUANTITY
                                 + " FROM " + Ingredient.TABLE_NAME + ";";

		ResultSet rs = database.executeQuery (query, null);
		List<Ingredient> ingredients = null;

		try {
			while (rs.next()) {
                int Cid = rs.getInt(Ingredient.COLUMN_CONSUMABLE_ID);
                int Rid = rs.getInt(Ingredient.COLUMN_RAWITEM_ID);
                int q = rs.getInt(Ingredient.COLUMN_QUANTITY);

                Ingredient ingredient = new Ingredient(null, q);
                
                if (ingredients == null) {
                    ingredients = new ArrayList<Ingredient>();
                }
                else {
                    ingredients.add(ingredient);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return ingredients;
    }

    /**
     * Updates a Consumable record in the database with a specific id.
     * 
     * @param Consumable    The representation of a food item.
     * @return              The number of rows affected by the operation.
     */
    @Override
    public int editItem(int id, Consumable item) {

        return -1;
    }
    
    /**
     * Deletes a Consumable record from the database.
     * 
     * @param Consumable    The representation of a food item. 
     * @return              The number of rows affected by the operation.
     */
    @Override
    public int deleteItem(int id) {
        String query = "DELETE FROM " + Ingredient.TABLE_NAME + 
                            " WHERE " + Consumable.COLUMN_ID + " = ?;";
        
        if(database.executeUpdate(query, new Object[] {id}) == 1)
        {
            return 1;
        }
        
        return -1;
    }
}