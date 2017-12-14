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
    public boolean addItem(Outgoing item, RawItem rawItem) {
        String query = "INSERT INTO " + TABLE_NAME
                     + " (" + COLUMN_DATETIME + ", "
                            + COLUMN_QUANTITY + ", "
                            + COLUMN_REMARKS + ", "
                            + COLUMN_RAWITEM_ID + ") "
                            + "VALUES (?, ?, ?, ?)";

        LocalDateTime date = item.getInDate();
        Timestamp timestamp = Timestamp.valueOf(date); // TODO Check if this works.

        int quantity = item.getQuantity();

        String remarks = item.getRemarks();

        Integer rawItemId = null;
        if (rawItem != null) {
            rawItemId = rawItem.getRawItemID();
        }
        else {
            System.err.println("WARNING: RawItem is NULL!");
            return false;
        }

        int result = database.executeUpdate(query, new Object[] { timestamp, quantity, remarks, rawItemId });

        return result != -1;
    }

    @Override
    public Outgoing getItem(int id) {
        String query = "SELECT " + COLUMN_REMARKS + ", "
                                 + COLUMN_QUANTITY + ", "
                                 + COLUMN_DATETIME
                                 + " FROM " + TABLE_NAME
                                 + " WHERE " + COLUMN_ID + " = ?;";
//        COLUMN_ID + ", "
//                + COLUMN_RAWITEM_ID + ", "

        ResultSet rs = database.executeQuery(query, new Object[] {id});
        Outgoing outgoing = null;

        try {
            if (rs.next ()) {
//                int columnId = rs.getInt(COLUMN_ID);
//                int rawItemId = rs.getInt(COLUMN_RAWITEM_ID);
                String remarks = rs.getString(COLUMN_REMARKS);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                LocalDateTime outDate = rs.getTimestamp(COLUMN_DATETIME).toLocalDateTime();

                outgoing = new Outgoing(outDate, quantity, remarks);
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return outgoing;
    }

    @Override
    public List<Outgoing> getAllItems() {
        String query = "SELECT " + COLUMN_REMARKS + ", "
                                 + COLUMN_QUANTITY + ", "
                                 + COLUMN_DATETIME
                                 + " FROM " + TABLE_NAME + ";";
//        COLUMN_ID + ", "
//                + COLUMN_RAWITEM_ID + ", "

        ResultSet rs = database.executeQuery(query, null);
        List<Outgoing> outgoings = new ArrayList<>();

        try {
            while (rs.next ()) {
//                int columnId = rs.getInt(COLUMN_ID);
//                int rawItemId = rs.getInt(COLUMN_RAWITEM_ID);
                String remarks = rs.getString(COLUMN_REMARKS);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                LocalDateTime outDate = rs.getTimestamp(COLUMN_DATETIME).toLocalDateTime();

                Outgoing outgoing = new Outgoing(outDate, quantity, remarks);

                if (outgoings == null) {
                    outgoings = new ArrayList<>();
                }
                else {
                    outgoings.add(outgoing);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return outgoings;
    }

    @Override
    public int editItem(int id, Outgoing item) {
        // do not use
        return -1;
    }

    public int editItem(Outgoing item, RawItem rawItem) {
        String query = "UPDATE " + TABLE_NAME + " "
                     + "SET " + COLUMN_DATETIME + " = ?, "
                              + COLUMN_QUANTITY + " = ?, "
                              + COLUMN_REMARKS + " = ? "
                              + "WHERE " + COLUMN_ID + " = ?;";

        LocalDateTime date = item.getInDate();
        Timestamp timestamp = Timestamp.valueOf(date); // TODO Check if this works.

        int quantity = item.getQuantity();

        String remarks = item.getRemarks();

        Integer rawItemId = null;
        if (rawItem != null) {
            rawItemId = rawItem.getRawItemID();
        }
        else {
            System.err.println("WARNING: RawItem is NULL!");
            return -1;
        }

        int result = database.executeUpdate(query, new Object[] { timestamp, quantity, remarks, rawItemId });

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