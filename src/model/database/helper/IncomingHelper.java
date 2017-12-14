package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Incoming;
import model.database.DatabaseHelper;
import model.database.DataAccessObject;

/**
 * Used to access the Incoming database table through specific data operations.
 */
public class IncomingHelper extends DatabaseHelper implements DataAccessObject<Incoming> {
    
    public final String TABLE_NAME = "Incoming";
    public final String COLUMN_ID = "In_ID";
    public final String COLUMN_RAWITEM_ID = "RawItem_ID";
    public final String COLUMN_REMARKS = "In_Remarks";
    public final String COLUMN_QUANTITY = "In_Quantity";
    public final String COLUMN_DATETIME = "In_DateTime";

    @Override
    public boolean addItem(Incoming item) {
        return false;
    }

    @Override
    public Incoming getItem(int id) {
        return null;
    }

    @Override
    public List<Incoming> getAllItems() {
        return null;
    }

    @Override
    public int editItem(int id, Incoming item) {
        return 0;
    }

    @Override
    public int deleteItem(int id) {
        return 0;
    }

}