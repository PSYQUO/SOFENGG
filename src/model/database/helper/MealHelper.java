package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.Category;
import model.food.Consumable;
import model.food.ConsumableQuantityPair;
import model.food.Meal;

/**
 * Used to access the Incoming database table through specific data operations.
 */
public class MealHelper extends DatabaseHelper implements DataAccessObject<Meal> {
    
    public final String TABLE_NAME = "Meal";
    public final String COLUMN_MEAL_ID = "Meal_ID";
    public final String COLUMN_ADDONS = "AddOns";
    public final String COLUMN_QUANTITY = "In_Quantity";

    @Override
    public boolean addItem(Meal item) {
        // Do not use
        return false;
    }

    public boolean addItem(Meal item, ConsumableQuantityPair consumableQuantityPair) {
        String query = "INSERT INTO " + TABLE_NAME
                     + " (" + COLUMN_MEAL_ID + ", "
                            + COLUMN_ADDONS + ", "
                            + COLUMN_QUANTITY + ") "
                            + "VALUES (? ? ?);";

        int mealId = item.getMealID();

        Integer addon = null;
        Integer quantity = null;

        if (consumableQuantityPair != null) {
            if (consumableQuantityPair.getConsumable() != null) {
                addon = consumableQuantityPair.getConsumable().getConsumableID();
            }
            else {
                System.err.println("WARNING: Consumable of meal to be added is null!");
            }

            quantity = consumableQuantityPair.getQuantity();
        }
        else {
            System.err.println("WARNING: ConsumableQuantityPair of input to be added is null!");
        }

        int result = database.executeUpdate(query, new Object[] { mealId, addon, quantity });

        return result != -1;
    }

//    public final String TABLE_NAME = "Meal";
//    public final String COLUMN_MEAL_ID = "Meal_ID";
//    public final String COLUMN_ADDONS = "AddOns";
//    public final String COLUMN_QUANTITY = "In_Quantity";
    @Override
    public Meal getItem(int id) {
        // Do not use
        return null;
    }

    public List<ConsumableQuantityPair> getConsumablesByMeal(int id) {
        String query = "SELECT " + COLUMN_ADDONS + ", "
                                 + COLUMN_QUANTITY
                                 + " FROM " + TABLE_NAME
                                 + " WHERE " + COLUMN_MEAL_ID + " = ?;";

        ResultSet rs = database.executeQuery(query, new Object[] {id});
        List<ConsumableQuantityPair> consumableQuantityPairList = null;

        try {
            while (rs.next()) {
                int consumableId = rs.getInt(COLUMN_ADDONS);
                int quantity = rs.getInt(COLUMN_QUANTITY);

                Consumable consumable = new Consumable(consumableId, null, null, null, -1, null);
                ConsumableQuantityPair consumableQuantityPair = new ConsumableQuantityPair(consumable, quantity);

                if (consumableQuantityPairList == null) {
                    consumableQuantityPairList = new ArrayList<>();
                }
                else {
                    consumableQuantityPairList.add(consumableQuantityPair);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return consumableQuantityPairList;
    }

    @Override
    public List<Meal> getAllItems() {
        String query = "SELECT " + COLUMN_MEAL_ID + ", "
                                 + COLUMN_ADDONS + ", "
                                 + COLUMN_QUANTITY
                                 + " FROM " + TABLE_NAME + ";";

        ResultSet rs = database.executeQuery(query, null);
        List<Meal> meals = null;

        try {
            while (rs.next()) {
                int mealId = rs.getInt(COLUMN_MEAL_ID);
                int consumableId = rs.getInt(COLUMN_ADDONS);
                int quantity = rs.getInt(COLUMN_QUANTITY);

                Meal meal = new Meal(mealId, null);

                if (meals == null) {
                    meals = new ArrayList<>();
                }
                else {
                    meals.add(meal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return meals;
    }

    @Override
    public int editItem(int id, Meal item) {
//        String query = "UPDATE " + TABLE_NAME + " "
//                     + "SET " + COLUMN_QUANTITY + " = ? "
//                     + "WHERE " + COLUMN_MEAL_ID + " = ?, " + COLUMN_ADDONS + " = ?;";
//
//        Integer mealId = null;
//        Integer addon = null;
//        if (item != null) {
//            mealId = item.getMealID();
//            addon = item.getAddOns();
//        }
//        else {
//            System.err.println("WARNING: Meal must not be NULL!");
//            return false;
//        }
//
//        int result = database.executeUpdate(query, new Object[] { name, id });
//
//        return result;
        return -1;
    }

    @Override
    public int deleteItem(int id) {
        String query = "DELETE FROM " + TABLE_NAME + " "
                     + "WHERE " + COLUMN_MEAL_ID + " = ?;";

        int result = database.executeUpdate(query, new Object[] {id});

        return result;
    }

}