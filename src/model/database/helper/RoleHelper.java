package model.database.helper;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Role;
import model.database.DatabaseHelper;
import model.database.DataAccessObject;

/**
 * Used to access the Incoming database table through specific data operations.
 */
public class RoleHelper extends DatabaseHelper implements DataAccessObject<Role> {
    
    public final String TABLE_NAME = "Role";
    public final String COLUMN_ID = "Role_ID";
    public final String COLUMN_NAME = "Role_Name";

    @Override
    public boolean addItem(Role item) {
        return false;
    }

    @Override
    public Role getItem(int id) {
        return null;
    }

    @Override
    public List<Role> getAllItems() {
        return null;
    }

    @Override
    public int editItem(int id, Role item) {
        return 0;
    }

    @Override
    public int deleteItem(int id) {
        return 0;
    }

}