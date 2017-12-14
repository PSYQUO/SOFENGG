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
        return false;
    }

    @Override
    public User getItem(int id) {
        return null;
    }

    @Override
    public List<User> getAllItems() {
        return null;
    }

    @Override
    public int editItem(int id, User item) {
        return 0;
    }

    @Override
    public int deleteItem(int id) {
        return 0;
    }

}