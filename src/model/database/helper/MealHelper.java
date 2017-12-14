package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

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
        return false;
    }

    @Override
    public Meal getItem(int id) {
        return null;
    }

    @Override
    public List<Meal> getAllItems() {
        return null;
    }

    @Override
    public int editItem(int id, Meal item) {
        return 0;
    }

    @Override
    public int deleteItem(int id) {
        return 0;
    }

}