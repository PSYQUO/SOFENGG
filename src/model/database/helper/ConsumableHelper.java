package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.Consumable;
import model.food.Meal;
import model.food.Ingredient;
import model.food.Category;

/**
 * Used to access the Consumable database table through specific data operations.
 */
public class ConsumableHelper extends DatabaseHelper implements DataAccessObject<Consumable> {

    @Override
    public boolean addItem(Consumable item) {
        String query = "INSERT INTO " + Consumable.TABLE_NAME 
                     + " (" + Consumable.COLUMN_NAME + ", "
                            + Consumable.COLUMN_CODENAME + ", "
                            + Consumable.COLUMN_PRICE + ", "
                            + Consumable.COLUMN_MEAL + ", "
                            + Consumable.COLUMN_CATEGORY + ") "
                            + "VALUES (?, ?, ?, ?, ?);";

        System.out.println(query);
        
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
        String query = "SELECT " + Consumable.COLUMN_ID + ", "
                                 + Consumable.COLUMN_NAME + ", "
                                 + Consumable.COLUMN_CODENAME + ", "
                                 + Consumable.COLUMN_PRICE + ", "
                                 + Consumable.COLUMN_MEAL + ", "
                                 + Consumable.COLUMN_CATEGORY
                                 + " FROM " + Consumable.TABLE_NAME 
                                 + " WHERE " + Consumable.COLUMN_ID + " = ?;";

		ResultSet rs = database.executeQuery(query, new Object[] {id});
		Consumable consumable = null;

		try {
			if (rs.next ()) {
                int consumableId = rs.getInt(Consumable.COLUMN_ID);
                String name = rs.getString(Consumable.COLUMN_NAME);
                String codeName = rs.getString(Consumable.COLUMN_CODENAME);
                double price = rs.getDouble(Consumable.COLUMN_PRICE);
                Category category = new Category(rs.getInt(Consumable.COLUMN_CATEGORY), null);
                Meal meal = new Meal(rs.getInt(Consumable.COLUMN_MEAL), null);

                consumable = new Consumable(consumableId, name, codeName, category, price, null, meal);
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return consumable;
    }
    
    @Override
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

    @Override
    public int editItem(int id, Consumable item) {

        String query = "UPDATE " + Consumable.TABLE_NAME + " "
                     + "SET " + Consumable.COLUMN_NAME + " = ?, "
                              + Consumable.COLUMN_CODENAME + " = ?, "
                              + Consumable.COLUMN_PRICE + " = ?, "
                              + Consumable.COLUMN_MEAL + " = ?, "
                              + Consumable.COLUMN_CATEGORY + " = ? "
                              + "WHERE " + Consumable.COLUMN_ID + " = ?;";
                            
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
        String query = "DELETE FROM " + Consumable.TABLE_NAME + " "
                     + "WHERE " + Consumable.COLUMN_ID + " = ?;";
        
        int result = database.executeUpdate(query, new Object[] {id});
        
        return result;
    }

}