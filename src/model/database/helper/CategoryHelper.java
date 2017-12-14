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
public class CategoryHelper extends DatabaseHelper implements DataAccessObject<Category> {
    
    public final String TABLE_NAME = "Category";
    public final String COLUMN_ID = "Category_ID";
    public final String COLUMN_NAME = "Category_Name";

    @Override
    public boolean addItem(Category item) {
        return false;
    }

    @Override
    public Category getItem(int id) {
        return null;
    }

    @Override
    public List<Category> getAllItems() {
        return null;
    }

    @Override
    public int editItem(int id, Category item) {
        return 0;
    }

    @Override
    public int deleteItem(int id) {
        return 0;
    }
}