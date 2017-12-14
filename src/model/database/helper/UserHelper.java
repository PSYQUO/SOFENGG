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
    
    public final String TABLE_NAME = "User";
    public final String COLUMN_ID = "User_ID";
    public final String COLUMN_USERNAME = "User_Username";
    public final String COLUMN_NAME = "User_Name";
    public final String COLUMN_PASSWORD = "User_Password";
    public final String COLUMN_ROLE_ID = "Role_ID";

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