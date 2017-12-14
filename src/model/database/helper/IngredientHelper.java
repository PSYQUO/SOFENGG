
package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.Consumable;
import model.food.Ingredient;

/**
 * Used to access the Ingredient database table through specific data operations.
 */
public class IngredientHelper extends DatabaseHelper implements DataAccessObject<Ingredient> {

    @Override
    public boolean addItem(Ingredient item) {

        return false;
    }

    @Override
    public Ingredient getItem(int id) {
        String query = "SELECT " + Ingredient.COLUMN_CONSUMABLE_ID + ", "
                                 + Ingredient.COLUMN_RAWITEM_ID + ", "
                                 + Ingredient.COLUMN_QUANTITY
                                 + " FROM " + Ingredient.TABLE_NAME
                                 + " WHERE " + Ingredient.COLUMN_CONSUMABLE_ID + " = ?;";

		ResultSet rs = database.executeQuery (query, null);
        Ingredient ingredient = null;

		try {
			if (rs.next ()) {
                int Cid = rs.getInt(Ingredient.COLUMN_CONSUMABLE_ID);
                int Rid = rs.getInt(Ingredient.COLUMN_RAWITEM_ID);
                int q = rs.getInt(Ingredient.COLUMN_QUANTITY);

                 ingredient = new Ingredient(null, q);
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return ingredient;
    }

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

    @Override
    public int editItem(int id, Ingredient item) {

        return -1;
    }

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