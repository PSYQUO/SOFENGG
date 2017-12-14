package model.database.helper;

import model.database.DataAccessObject;
import model.database.DatabaseHelper;
import model.food.Consumable;
import model.food.LineItem;
import model.transaction.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String query = "INSERT INTO " + TABLE_NAME
                     + " (" + COLUMN_TRANSACTION_ID + ", "
                            + COLUMN_CONSUMABLE_ID + ", "
                            + COLUMN_QUANTITY + " "
                            + "VALUES (? ? ?);";

        int transactionId = item.getTransID();

        Integer consumableId = null;
        if (item.getConsumable() != null) {
            consumableId = item.getConsumable().getConsumableID();
        }
        else {
            System.err.println("WARNING: Consumable must not be NULL!");
            return false;
        }

        int quantity = item.getQuantity();

        int result = database.executeUpdate(query, new Object[] { transactionId, consumableId, quantity });

        return result != -1;
    }

    @Override
    public LineItem getItem(int id) {
        // Do not use
        return null;
    }

    public LineItem getItem(Transaction transaction, Consumable consumable) {
        String query = "SELECT " + COLUMN_QUANTITY + " "
                     + " FROM " + TABLE_NAME
                     + " WHERE " + COLUMN_TRANSACTION_ID + " = ? AND " + COLUMN_CONSUMABLE_ID + " = ?;";

        Integer transactionId = null;
        if (transaction != null) {
            transactionId = transaction.getTransactionID();
        }

        Integer consumableId = null;
        if (consumable != null) {
            consumableId = consumable.getConsumableID();
        }

        ResultSet rs = database.executeQuery(query, new Object[] { transactionId, consumableId });
        LineItem lineItem = null;

        try {
            if (rs.next ()) {
                int quantity = rs.getInt(COLUMN_QUANTITY);
                lineItem = new LineItem(transactionId, consumable, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return lineItem;
    }

    @Override
    public List<LineItem> getAllItems() {
        String query = "SELECT " + COLUMN_QUANTITY + ", "
                                 + COLUMN_TRANSACTION_ID + ", "
                                 + COLUMN_CONSUMABLE_ID + ", "
                                 + " FROM " + TABLE_NAME + ";";

        ResultSet rs = database.executeQuery(query, null);
        List<LineItem> lineItems = null;

        try {
            while (rs.next ()) {
                int quantity = rs.getInt(COLUMN_QUANTITY);
                int transactionId = rs.getInt(COLUMN_TRANSACTION_ID);
                int consumableId = rs.getInt(COLUMN_CONSUMABLE_ID);

                Consumable consumable = new Consumable(consumableId, null, null, null, -1, null);
                LineItem lineItem = new LineItem(transactionId, consumable, quantity);

                if (lineItems == null) {
                    lineItems = new ArrayList<>();
                }
                else {
                    lineItems.add(lineItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return lineItems;
    }

    @Override
    public int editItem(int id, LineItem item) {
        String query = "INSERT INTO " + TABLE_NAME
                     + " SET " + COLUMN_QUANTITY + " = ?"
                     + " WHERE " + COLUMN_TRANSACTION_ID + " = ? AND " + COLUMN_CONSUMABLE_ID + " = ?;";

        int transactionId = item.getTransID();

        Integer consumableId = null;
        if (item.getConsumable() != null) {
            consumableId = item.getConsumable().getConsumableID();
        }
        else {
            System.err.println("WARNING: Consumable must not be NULL!");
            return -1;
        }

        int quantity = item.getQuantity();

        int result = database.executeUpdate(query, new Object[] { quantity, transactionId, consumableId });

        return result;
    }

    @Override
    public int deleteItem(int id) {
        // Do not use
        return -1;
    }
    
    public int deleteItem(Transaction transaction, Consumable consumable) {
        String query = "DELETE FROM " + TABLE_NAME + " "
                + " WHERE " + COLUMN_TRANSACTION_ID + " = ? AND " + COLUMN_CONSUMABLE_ID + " = ?;";

        Integer transactionId = null;
        if (transaction != null) {
            transactionId = transaction.getTransactionID();
        }
        else {
            System.err.println("WARNING: Transaction must not be NULL!");
            return -1;
        }
        
        Integer consumableId = null;
        if (consumable != null) {
            consumableId = consumable.getConsumableID();
        }
        else {
            System.err.println("WARNING: Consumable must not be NULL!");
            return -1;
        }

        int result = database.executeUpdate(query, new Object[] { transactionId, consumableId });

        return result;
    }

}