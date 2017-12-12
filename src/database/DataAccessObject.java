package database;

/**
 * Used to access the database through specific data operations.
 */
public interface DataAccessObject<T> {

    /**
     * Inserts an item to the database.
     * 
     * @param T     A generic entity in the database.
     * @return      A boolean that is true if adding is successful.
     */
    boolean addItem(T item);

    /**
     * Retrieves an item from the database.
     * 
     * @param id    Refers to a specific record in a database table.
     * @return      A generic entity in the database.
     */
    T getItem(int id);
    
    /**
     * Updates an item in the database.
     * 
     * @param T     A generic entity in the database.
     * @return      The number of rows affected by the operation.
     */
    int editItem(int id, T item);
    
    /**
     * Deletes an item from the database.
     * 
     * @param T     A generic entity in the database.
     * @return      The number of rows affected by the operation.
     */
    int deleteItem(int id);

}