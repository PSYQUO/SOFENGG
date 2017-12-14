package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.Category;

/**
 * Used to access the Category database table through specific data operations.
 */
public class ConsumableHelper extends DatabaseHelper implements DataAccessObject<Category> {
    
    public final String TABLE_NAME = "Category";
    public final String COLUMN_ID = "Category_ID";
    public final String COLUMN_NAME = "Category_Name";

    @Override
    public boolean addItem(Consumable item) {
    }

    @Override
    public Consumable getItem(int id) {
    }
    
    @Override
    public List<Consumable> getAllItems() {
    }

    @Override
    public int editItem(int id, Consumable item) {
    }
    
    @Override
    public int deleteItem(int id) {

    }

}