package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model;

/**
 * Used to access the Incoming database table through specific data operations.
 */
public class ConsumableHelper extends DatabaseHelper implements DataAccessObject<Incoming> {
    
    public final String TABLE_NAME = "Transaction";
    public final String COLUMN_ID = "Transaction_ID";
    public final String COLUMN_DATETIME = "Transaction_DateTime";
    public final String COLUMN_USER_ID = "User_ID";
    public final String COLUMN_CUSTNO = "Customer_Number";
    public final String COLUMN_TYPE = "Transaction_Type";
    public final String COLUMN_CASH = "Cash";
    public final String COLUMN_CHANGE = "Change";
    public final String COLUMN_SUBTOTAL = "Subtotal";
    public final String COLUMN_DISCOUNT = "Senior_Discount";
    public final String COLUMN_TOTAL = "Total";

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