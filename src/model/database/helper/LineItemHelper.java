package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.food.LineItem;

/**
 * Used to access the Incoming database table through specific data operations.
 */
public class LineItemHelper extends DatabaseHelper implements DataAccessObject<LineItem> {
    
    public final String TABLE_NAME = "LineItem";
    public final String COLUMN_TRANSACTION_ID = "Transaction_ID";
    public final String COLUMN_CONSUMABLE_ID = "Consumable_ID";
    public final String COLUMN_QUANTITY = "Quantity";

    @Override
    public boolean addItem(LineItem item) {
        return false;
    }

    @Override
    public LineItem getItem(int id) {
        return null;
    }

    @Override
    public List<LineItem> getAllItems() {
        return null;
    }

    @Override
    public int editItem(int id, LineItem item) {
        return 0;
    }

    @Override
    public int deleteItem(int id) {
        return 0;
    }

}