package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Outgoing;
import model.database.DatabaseHelper;
import model.database.DataAccessObject;


/**
 * Used to access the Incoming database table through specific data operations.
 */
public class OutgoingHelper extends DatabaseHelper implements DataAccessObject<Outgoing> {
    
    public final String TABLE_NAME = "Outgoing";
    public final String COLUMN_ID = "Out_ID";
    public final String COLUMN_RAWITEM_ID = "RawItem_ID";
    public final String COLUMN_REMARKS = "Out_Remarks";
    public final String COLUMN_QUANTITY = "Out_Quantity";
    public final String COLUMN_DATETIME = "Out_DateTime";

    @Override
    public boolean addItem(Outgoing item) {
        return false;
    }

    @Override
    public Outgoing getItem(int id) {
        return null;
    }

    @Override
    public List<Outgoing> getAllItems() {
        return null;
    }

    @Override
    public int editItem(int id, Outgoing item) {
        return 0;
    }

    @Override
    public int deleteItem(int id) {
        return 0;
    }

}