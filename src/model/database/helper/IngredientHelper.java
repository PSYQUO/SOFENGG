package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.*;

/**
 * Used to access the Ingredient database table through specific data operations.
 */
public class IngredientHelper extends DatabaseHelper implements DataAccessObject<Ingredient> {

    public final String TABLE_NAME = "Ingredient";
    public final String COLUMN_CONSUMABLE_ID = "Consumable_ID";
    public final String COLUMN_RAWITEM_ID = "RawItem_ID";
    public final String COLUMN_QUANTITY = "Quantity";

    @Override
    public boolean addItem(Ingredient item) {
        // Do not use
        return false;
    }

    /**
     * Use in place of the overridden addItem method.
     *
     * @param consumable            The representation of a food item.
     * @param rawItemQuantityPair   Determines the number of raw items used as ingredient to a consumable.
     * @return                      A boolean that is true if adding is successful.
     */
    public boolean addItem(Consumable consumable, RawItemQuantityPair rawItemQuantityPair) {
        String query = "INSERT INTO " + TABLE_NAME
                     + " (" + COLUMN_CONSUMABLE_ID + ", "
                            + COLUMN_RAWITEM_ID + ", "
                            + COLUMN_QUANTITY + ") "
                            + "VALUES (?, ?, ?);";

        Integer consumableId = null;
        if (consumable != null) {
            consumableId = consumable.getConsumableID();
        }
        else {
            System.err.println("WARNING: Consumable of ingredient to be added is null!");
        }

        Integer rawItemId = null;
        if (rawItemQuantityPair.getRawItem() != null) {
            rawItemId = rawItemQuantityPair.getRawItem().getRawItemID();
        }
        else {
            System.err.println("WARNING: Raw item of ingredient to be added is null!");
        }

        int quantity = rawItemQuantityPair.getQuantity();

        int result = database.executeUpdate(query, new Object[] { consumableId, rawItemId, quantity });

        return result != -1;
    }

    @Override
    public Ingredient getItem(int id) {
        // Do not use, Ingredient has no primary key.
        return null;
    }

    /**
     * Retrieves the ingredients of the specified consumable.
     *
     * @param id    The database ID of a consumable in the database.
     * @return      The ingredients of the specified consumable.
     */
    public List<Ingredient> getIngredientsByConsumable(int id) {
        String query = "SELECT " + COLUMN_CONSUMABLE_ID + ", "
                                 + COLUMN_RAWITEM_ID + ", "
                                 + COLUMN_QUANTITY
                                 + " FROM " + TABLE_NAME
                                 + " WHERE " + COLUMN_CONSUMABLE_ID + " = ?;";

        ResultSet rs = database.executeQuery (query, new Object[] {id});
        List<Ingredient> ingredients = null;

        try {
            while (rs.next()) {
                int Cid = rs.getInt(COLUMN_CONSUMABLE_ID);
                int Rid = rs.getInt(COLUMN_RAWITEM_ID);
                int q = rs.getInt(COLUMN_QUANTITY);

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
    public List<Ingredient> getAllItems() {
        String query = "SELECT " + COLUMN_CONSUMABLE_ID + ", "
                                 + COLUMN_RAWITEM_ID + ", "
                                 + COLUMN_QUANTITY
                                 + " FROM " + TABLE_NAME + ";";

		ResultSet rs = database.executeQuery (query, null);
		List<Ingredient> ingredients = null;

		try {
			while (rs.next()) {
                int Cid = rs.getInt(COLUMN_CONSUMABLE_ID);
                int Rid = rs.getInt(COLUMN_RAWITEM_ID);
                int q = rs.getInt(COLUMN_QUANTITY);

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
        // Do not use
        return -1;
    }

    @Override
    public int deleteItem(int id) {
        String query = "DELETE FROM " + TABLE_NAME
                    + " WHERE " + COLUMN_CONSUMABLE_ID + " = ? AND " + COLUMN_RAWITEM_ID + " = ?;";

        int result = database.executeUpdate(query, new Object[] {id});

        return result;
    }

    public int deleteItem(Consumable consumable, RawItem rawItem) {
        String query = "DELETE FROM " + TABLE_NAME
                + " WHERE " + COLUMN_CONSUMABLE_ID + " = ? AND " + COLUMN_RAWITEM_ID + " = ?;";

        Integer consumableId = null;
        if (consumable != null) {
            consumableId = consumable.getConsumableID();
        }
        else {
            System.err.println("WARNING: Consumable of ingredient to be deleted is null!");
        }

        Integer rawItemId = null;
        if (rawItem != null) {
            rawItemId = rawItem.getRawItemID();
        }
        else {
            System.err.println("WARNING: Raw item of ingredient to be deleted is null!");
        }

        int result = database.executeUpdate(query, new Object[] { consumableId, rawItemId });

        return result;
    }
}