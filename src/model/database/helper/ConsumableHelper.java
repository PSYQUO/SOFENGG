package model.database.helper;

import model.database.DataAccessObject;
import model.database.DatabaseHelper;
import model.food.Category;
import model.food.Consumable;
import model.food.Meal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to access the Consumable database table through specific data operations.
 */
public class ConsumableHelper extends DatabaseHelper implements DataAccessObject<Consumable> {
    
    public final String TABLE_NAME = "Consumable";
    public final String COLUMN_ID = "Consumable_ID";
    public final String COLUMN_NAME = "Consumable_Name";
    public final String COLUMN_CODENAME = "Consumable_CodeName";
    public final String COLUMN_CATEGORY = "Category_ID";
    public final String COLUMN_PRICE = "Consumable_Price";
    public final String COLUMN_MEAL = "Meal_ID";

    @Override
    public boolean addItem(Consumable item) {
        String query = "INSERT INTO " + TABLE_NAME 
                     + " (" + COLUMN_NAME + ", "
                            + COLUMN_CODENAME + ", "
                            + COLUMN_PRICE + ", "
                            + COLUMN_MEAL + ", "
                            + COLUMN_CATEGORY + ") "
                            + "VALUES (?, ?, ?, ?, ?);";
        
        String name = item.getName();
        String codeName = item.getCodeName();
        double price = item.getPrice();

        Integer mealId = null;
        if (item.getMeal() != null) {
            mealId = item.getMeal().getMealID();
        }

        Integer categoryId = null;
        if (item.getCategory() != null) {
            categoryId = item.getCategory().getCategoryID();
        }
        else {
            System.err.println("WARNING: Category must not be NULL! Foreign key constraint will fail!");
        }
                            
		int result = database.executeUpdate(query, new Object[] { name, codeName, price, mealId, categoryId });

		return result != -1;
    }

    @Override
    public Consumable getItem(int id) {
        String query = "SELECT " + COLUMN_ID + ", "
                                 + COLUMN_NAME + ", "
                                 + COLUMN_CODENAME + ", "
                                 + COLUMN_PRICE + ", "
                                 + COLUMN_MEAL + ", "
                                 + COLUMN_CATEGORY
                                 + " FROM " + TABLE_NAME 
                                 + " WHERE " + COLUMN_ID + " = ?;";

		ResultSet rs = database.executeQuery(query, new Object[] {id});
		Consumable consumable = null;

		try {
			if (rs.next ()) {
                int consumableId = rs.getInt(COLUMN_ID);
                String name = rs.getString(COLUMN_NAME);
                String codeName = rs.getString(COLUMN_CODENAME);
                double price = rs.getDouble(COLUMN_PRICE);
                Category category = new Category(rs.getInt(COLUMN_CATEGORY), null);
                Meal meal = new Meal(rs.getInt(COLUMN_MEAL), null);

                consumable = new Consumable(consumableId, name, codeName, category, price, null, meal);
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return consumable;
    }
    
    @Override
    public List<Consumable> getAllItems() {
        String query = "SELECT " + COLUMN_ID + ", "
                                 + COLUMN_NAME + ", "
                                 + COLUMN_CODENAME + ", "
                                 + COLUMN_PRICE + ", "
                                 + COLUMN_MEAL + ", "
                                 + COLUMN_CATEGORY
                                 + " FROM " + TABLE_NAME + ";";

		ResultSet rs = database.executeQuery (query, null);
		List<Consumable> consumables = null;

		try {
			while (rs.next()) {
                int id = rs.getInt(COLUMN_ID);
                String name = rs.getString(COLUMN_NAME);
                String codeName = rs.getString(COLUMN_CODENAME);
                double price = rs.getDouble(COLUMN_PRICE);

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

    @Override
    public int editItem(int id, Consumable item) {
        String query = "UPDATE " + TABLE_NAME + " "
                     + "SET " + COLUMN_NAME + " = ?, "
                              + COLUMN_CODENAME + " = ?, "
                              + COLUMN_PRICE + " = ?, "
                              + COLUMN_MEAL + " = ?, "
                              + COLUMN_CATEGORY + " = ? "
                              + "WHERE " + COLUMN_ID + " = ?;";
                            
        String name = item.getName();
        String codeName = item.getCodeName();
        double price = item.getPrice();

        Integer mealId = null;
        if (item.getMeal() != null) {
            mealId = item.getMeal().getMealID();
        }

        Integer categoryId = null;
        if (item.getCategory() != null) {
            categoryId = item.getCategory().getCategoryID();
        }
        else {
            System.err.println("ERROR: Consumable category must not be NULL! Foreign key constraint will fail!");
            return -1;
        }
                            
		int result = database.executeUpdate(query, new Object[] { name, codeName, price, mealId, categoryId, id });

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