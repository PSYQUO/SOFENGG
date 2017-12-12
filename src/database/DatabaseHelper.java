package database;

/**
 * Provides access to a database to give way for data operations.
 */
public abstract class DatabaseHelper {

    /**
     * Creates a common parent for database access.
     */
    protected static DatabaseManager database;

    /**
     * Sets the current database to be used.
     * 
     * @param database  Creates a common parent for database access.
     */
    public static void setDatabaseManager(DatabaseManager database) {
        this.database = database;
    }

}