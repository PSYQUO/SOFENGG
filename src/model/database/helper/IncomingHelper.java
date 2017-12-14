package model.database.helper;

import model.Incoming;
import model.database.DataAccessObject;
import model.database.DatabaseHelper;
import model.food.RawItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to access the Incoming database table through specific data operations.
 */
public class IncomingHelper extends DatabaseHelper {
    
    public final String TABLE_NAME = "Incoming";
    public final String COLUMN_ID = "In_ID";
    public final String COLUMN_RAWITEM_ID = "RawItem_ID";
    public final String COLUMN_REMARKS = "In_Remarks";
    public final String COLUMN_QUANTITY = "In_Quantity";
    public final String COLUMN_DATETIME = "In_DateTime";

    @Override
    public boolean addItem(Incoming item) {
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
        if (item.getRawItem() != null) {
            rawItemId = item.getRawItem().getRawItemID();
        }
        else {
            System.err.println("WARNING: RawItem is NULL!");
            return false;
        }

        int result = database.executeUpdate(query, new Object[] { timestamp, quantity, remarks, rawItemId });

        return result != -1;
    }

    @Override
    public Incoming getItem(int id) {
        String query = "SELECT " + COLUMN_REMARKS + ", "
                                 + COLUMN_QUANTITY + ", "
                                 + COLUMN_DATETIME
                                 + COLUMN_RAWITEM_ID + ", "
                                 + COLUMN_ID + " "
                                 + " FROM " + TABLE_NAME
                                 + " WHERE " + COLUMN_ID + " = ?;";

        ResultSet rs = database.executeQuery(query, new Object[] {id});
        Incoming incoming = null;

        try {
            if (rs.next ()) {
//                int columnId = rs.getInt(COLUMN_ID);
                int rawItemId = rs.getInt(COLUMN_RAWITEM_ID);
                String remarks = rs.getString(COLUMN_REMARKS);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                LocalDateTime inDate = rs.getTimestamp(COLUMN_DATETIME).toLocalDateTime();

                RawItem rawItem = new RawItem(rawItemId, null, -1, -1);

                incoming = new Incoming(inDate, quantity, remarks, rawItem);
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return incoming;
    }

    @Override
    public List<Incoming> getAllItems() {
        String query = "SELECT " + COLUMN_REMARKS + ", "
                                 + COLUMN_QUANTITY + ", "
                                 + COLUMN_DATETIME
                                 + " FROM " + TABLE_NAME + ";";
//        COLUMN_ID + ", "
//                + COLUMN_RAWITEM_ID + ", "

        ResultSet rs = database.executeQuery(query, null);
        List<Incoming> incomings = new ArrayList<>();

        try {
            while (rs.next ()) {
//                int columnId = rs.getInt(COLUMN_ID);
                int rawItemId = rs.getInt(COLUMN_RAWITEM_ID);
                String remarks = rs.getString(COLUMN_REMARKS);
                int quantity = rs.getInt(COLUMN_QUANTITY);
                LocalDateTime inDate = rs.getTimestamp(COLUMN_DATETIME).toLocalDateTime();

                RawItem rawItem = new RawItem(rawItemId, null, -1, -1);

                Incoming incoming = new Incoming(inDate, quantity, remarks, rawItem);

                if (incomings == null) {
                    incomings = new ArrayList<>();
                }
                else {
                    incomings.add(incoming);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return incomings;
    }

    @Override
    public int editItem(int id, Incoming item) {
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
        if (item.getRawItem() != null) {
            rawItemId = item.getRawItem().getRawItemID();
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