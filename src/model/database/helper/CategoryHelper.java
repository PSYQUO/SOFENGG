package model.database.helper;

import model.database.DataAccessObject;
import model.database.DatabaseHelper;
import model.food.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to access the Category database table through specific data operations.
 */
public class CategoryHelper extends DatabaseHelper implements DataAccessObject<Category> {

    public final String TABLE_NAME = "Category";
    public final String COLUMN_ID = "Category_ID";
    public final String COLUMN_NAME = "Category_Name";

    @Override
    public boolean addItem(Category item) {
        String query = "INSERT INTO " + TABLE_NAME
                + " (" + COLUMN_NAME + " "
                + "VALUES (?);";

        String name = item.getCategoryName();

        int result = database.executeUpdate(query, new Object[] { name });

        return result != -1;
    }

    @Override
    public Category getItem(int id) {
        String query = "SELECT " + COLUMN_ID + ", "
                + COLUMN_NAME + " "
                + " FROM " + TABLE_NAME
                + " WHERE " + COLUMN_ID + " = ?;";

        ResultSet rs = database.executeQuery(query, new Object[] {id});
        Category category = null;

        try {
            if (rs.next ()) {
                int consumableId = rs.getInt(COLUMN_ID);
                String name = rs.getString(COLUMN_NAME);
                category = new Category(consumableId, name);
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return category;
    }

    @Override
    public List<Category> getAllItems() {
        String query = "SELECT " + COLUMN_ID + ", "
                + COLUMN_NAME + " "
                + "FROM " + TABLE_NAME + ";";

        ResultSet rs = database.executeQuery(query, null);
        List<Category> categories = null;

        try {
            while (rs.next ()) {
                int consumableId = rs.getInt(COLUMN_ID);
                String name = rs.getString(COLUMN_NAME);
                Category category = new Category(consumableId, name);

                if (categories == null) {
                    categories = new ArrayList<>();
                }
                else {
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return categories;
    }

    @Override
    public int editItem(int id, Category item) {
        String query = "UPDATE " + TABLE_NAME + " "
                + "SET " + COLUMN_NAME + " = ? "
                + "WHERE " + COLUMN_ID + " = ?;";

        String name = item.getCategoryName();

        int result = database.executeUpdate(query, new Object[] { name, id });

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