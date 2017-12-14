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
    
    public final String TABLE_NAME = "Incoming";
    public final String COLUMN_ID = "In_ID";
    public final String COLUMN_RAWITEM_ID = "RawItem_ID";
    public final String COLUMN_REMARKS = "In_Remarks";
    public final String COLUMN_QUANTITY = "In_Quantity";
    public final String COLUMN_DATETIME = "In_DateTime";

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