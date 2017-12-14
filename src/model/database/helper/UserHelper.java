package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import model.database.DatabaseHelper;
import model.database.DataAccessObject;

/**
 * Used to access the Incoming database table through specific data operations.
 */
public class UserHelper extends DatabaseHelper implements DataAccessObject<User> {
    
    public final String TABLE_NAME = "User";
    public final String COLUMN_ID = "User_ID";
    public final String COLUMN_USERNAME = "User_Username";
    public final String COLUMN_NAME = "User_Name";
    public final String COLUMN_PASSWORD = "User_Password";
    public final String COLUMN_ROLE_ID = "Role_ID";

    @Override
    public boolean addItem(User item) {
        String query = "INSERT INTO " + TABLE_NAME 
                     + " (" + COLUMN_USERNAME + ", "
                            + COLUMN_NAME + ", "
                            + COLUMN_PASSWORD + ", "
                            + COLUMN_ROLE_ID + ") "
                            + "VALUES (?, ?, ?, ?);";
        
        String uname = item.getUsername();
        String name = item.getUserLoginName();
        String password = item.getPassword();

        Integer roleId = null;
        if (item.getRole() != null) {
            roleId = item.getRole().getRoleID();
        }
        else {
            System.err.println("WARNING: Role must not be NULL! Foreign key constraint will fail!");
        }
                            
		int result = database.executeUpdate(query, new Object[] { uname, name, password, roleId });

		return result != -1;
    }

    @Override
    public User getItem(int id) {
        String query = "SELECT " + COLUMN_USERNAME + ", "
                                 + COLUMN_NAME + ", "
                                 + COLUMN_PASSWORD + ", "
                                 + COLUMN_ROLE_ID
                                 + " FROM " + TABLE_NAME 
                                 + " WHERE " + COLUMN_ID + " = ?;";

		ResultSet rs = database.executeQuery(query, new Object[] {id});
		Consumable consumable = null;

		try {
			if (rs.next ()) {
                String uname = item.getUsername();
                String name = item.getUserLoginName();
                String password = item.getPassword();
                Role role = new Role(rs.getInt(COLUMN_ROLE_ID), null);

                consumable = new Consumable(id, uname, name, password, role);
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return consumable;
    }

    @Override
    public List<User> getAllItems() {
        String query = "SELECT " + COLUMN_ID + ", "
                                 + COLUMN_USERNAME + ", "
                                 + COLUMN_NAME + ", "
                                 + COLUMN_PASSWORD + ", "
                                 + COLUMN_ROLE_ID
                                 + " FROM " + TABLE_NAME + ";";

		ResultSet rs = database.executeQuery (query, null);
		List<User> users = null;

		try {
			while (rs.next()) {
                int id = rs.getInt(COLUMN_ID);
                String uname = rs.getString(COLUMN_USERNAME);
                String name = rs.getString(COLUMN_NAME);
                String password = rs.getDouble(COLUMN_PASSWORD);

                User user = new User(id, uname, name, password, null);
                
                if (users == null) {
                    users = new ArrayList<User>();
                }
                else {
                    users.add(user);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace ();
		}

		return users;
    }

    @Override
    public int editItem(int id, User item) {
        String query = "UPDATE " + TABLE_NAME + " "
                     + "SET " + COLUMN_USERNAME + " = ?, "
                              + COLUMN_NAME + " = ?, "
                              + COLUMN_PASSWORD + " = ?, "
                              + COLUMN_ROLE_ID + " = ? "
                              + "WHERE " + COLUMN_ID + " = ?;";
                            
        String uname = item.getUsername();
        String name = item.getUserLoginName();
        String password = item.getPassword();

        Integer roleId = null;
        if (item.getRole() != null) {
            roleId = item.getRole().getRoleID();
        }
        else {
            System.err.println("WARNING: Role must not be NULL! Foreign key constraint will fail!");
        }
                            
		int result = database.executeUpdate(query, new Object[] { uname, name, password, roleId, id });

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