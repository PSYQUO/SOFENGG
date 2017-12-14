package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.DatabaseHelper;
import model.database.DataAccessObject;

import model.transaction.Transaction;

/**
 * Used to access the Incoming database table through specific data operations.
 */
public class TransactionHelper extends DatabaseHelper implements DataAccessObject<Transaction> {
    
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
    public boolean addItem(Transaction item) {
        String query = "INSERT INTO " + TABLE_NAME 
                     + " (" + COLUMN_DATETIME + ", "
                            + COLUMN_USER_ID + ", "
                            + COLUMN_CUSTNO + ", "
                            + COLUMN_TYPE + ", "
                            + COLUMN_CASH + ", "
                            + COLUMN_CHANGE + ", "
                            + COLUMN_SUBTOTAL + ", "
                            + COLUMN_DISCOUNT + ", "
                            + COLUMN_TOTAL + ") "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        // date not sure 
        Date date = item.getDate();                    
        int custNo = item.getCustomerNo();                 
        String type = item.getMode().toString();
        double cash = item.getCashReceived();
        double change = item.getChange();
        double subtotal = item.getSubTotal();
        double discount = item.getDiscount();
        double total = item.getTotal();

        Integer userId = null;
        if (item.getCashier() != null) {
            userId = item.getCashier().getUserID();
        }
        else {
            System.err.println("WARNING: User must not be NULL! Foreign key constraint will fail!");
        }
                            
		int result = database.executeUpdate(query, new Object[] { date, userId, custNo, type, cash, change, subtotal, discount, total });

		return result != -1;
    }

    @Override
    public Transaction getItem(int id) {
        String query = "SELECT " + COLUMN_ID + ", "
                                 + COLUMN_DATETIME + ", "
                                 + COLUMN_USER_ID + ", "
                                 + COLUMN_CUSTNO + ", "
                                 + COLUMN_TYPE + ", "
                                 + COLUMN_CASH + ", "
                                 + COLUMN_CHANGE + ", "
                                 + COLUMN_SUBTOTAL + ", "
                                 + COLUMN_DISCOUNT + ", "
                                 + COLUMN_TOTAL
                                 + " FROM " + TABLE_NAME 
                                 + " WHERE " + COLUMN_ID + " = ?;";

		ResultSet rs = database.executeQuery(query, new Object[] {id});
		Transaction transaction = null;

		try {
			if (rs.next ()) {
                int transId = rs.getInt(COLUMN_ID);
                Date date = rs.getDate(COLUMN_DATETIME);  
                int userId = rs.getInt(COLUMN_USER_ID);          
                int custNo = rs.getInt(COLUMN_CUSTNO);          
                String type = rs.getString(COLUMN_TYPE);
                double cash = rs.getDouble(COLUMN_CASH);
                double change = rs.getDouble(COLUMN_CHANGE);
                double subtotal = rs.getDouble(COLUMN_SUBTOTAL);
                double discount = rs.getDouble(COLUMN_DISCOUNT);
                double total = rs.getDouble(COLUMN_TOTAL);
                
                // not sure
                transaction = new Transaction(transId, date, userId, custNo, type, cash, change, subtotal, discount, total);
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return transaction;
    }

    @Override
    public List<Transaction> getAllItems() {
        String query = "SELECT " + COLUMN_ID + ", "
                                 + COLUMN_DATETIME + ", "
                                 + COLUMN_USER_ID + ", "
                                 + COLUMN_CUSTNO + ", "
                                 + COLUMN_TYPE + ", "
                                 + COLUMN_CASH + ", "
                                 + COLUMN_CHANGE + ", "
                                 + COLUMN_SUBTOTAL + ", "
                                 + COLUMN_DISCOUNT + ", "
                                 + COLUMN_TOTAL
                                 + " FROM " + TABLE_NAME + ";";

		ResultSet rs = database.executeQuery (query, null);
		List<Transaction> transactions = null;

		try {
			while (rs.next()) {
                int transId = rs.getInt(COLUMN_ID);
                Date date = rs.getDate(COLUMN_DATETIME);  
                int userId = rs.getInt(COLUMN_USER_ID);          
                int custNo = rs.getInt(COLUMN_CUSTNO);          
                String type = rs.getString(COLUMN_TYPE);
                double cash = rs.getDouble(COLUMN_CASH);
                double change = rs.getDouble(COLUMN_CHANGE);
                double subtotal = rs.getDouble(COLUMN_SUBTOTAL);
                double discount = rs.getDouble(COLUMN_DISCOUNT);
                double total = rs.getDouble(COLUMN_TOTAL);

                // not sure
                transaction = new Transaction(transId, date, userId, custNo, type, cash, change, subtotal, discount, total);
                
                if (transaction == null) {
                    transaction = new ArrayList<Transaction>();
                }
                else {
                    transactions.add(transaction);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return transactions;
    }

    @Override
    public int editItem(int id, Transaction item) {
        String query = "UPDATE " + TABLE_NAME + " "
                     + "SET " + COLUMN_DATETIME + " = ?, "
                              + COLUMN_USER_ID + " = ?, "
                              + COLUMN_CUSTNO + " = ?, "
                              + COLUMN_TYPE + " = ?, "
                              + COLUMN_CASH + " = ? "
                              + COLUMN_CHANGE + " = ?, "
                              + COLUMN_SUBTOTAL + " = ?, "
                              + COLUMN_DISCOUNT + " = ?, "
                              + COLUMN_TOTAL + " = ? "
                              + "WHERE " + COLUMN_ID + " = ?;";
                            
         // date not sure 
         Date date = item.getDate();                    
         int custNo = item.getCustomerNo();                 
         String type = item.getMode().toString();
         double cash = item.getCashReceived();
         double change = item.getChange();
         double subtotal = item.getSubTotal();
         double discount = item.getDiscount();
         double total = item.getTotal();

        Integer userId = null;
        if (item.getCashier() != null) {
            userId = item.getCashier().getUserID();
        }
        else {
            System.err.println("WARNING: User must not be NULL! Foreign key constraint will fail!");
        }
        
        // not sure
		int result = database.executeUpdate(query, new Object[] { date, userId, custNo, type, cash, change, subtotal, discount, total, id });

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