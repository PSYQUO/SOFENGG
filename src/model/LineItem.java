package model;

/**
 * The representation of a food item involved in a transaction. 
 * Directly references the food item that it represents.
 */
public class LineItem {
    private int transID; // The ID of the transaction in which the line item was ordered.
    private Consumable consumable;
    private int quantity; // The number of consumables ordered.
    
    public LineItem(int transID, Consumable consumable, int quantity) {
        this.transID = transID;
        this.consumable = consumable;
        this.quantity = quantity;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTransID() {
        return transID;
    }

    public void increaseQuantity(int value) {
        if (value > 0)
            quantity += value;
    }

    public void decreaseQuantity(int value) {
        if (value > 0 && quantity - value > 0)
            quantity -= value;
    }

    /**
     * Returns the line item in a string format that can be used in 
     * printing a receipt given to the kitchen staff.
     *
     * @return a string that can be used in 
     * printing a receipt given to the kitchen staff.
     */
    public String getKitchenItem() {
        return String.format("%-15s%21s\n", consumable.getName(), quantity);
    }

    /**
     * Returns the line item in a string format that can be used in 
     * printing a receipt given to the customer. 
     *
     * @return a string that can be used in 
     * printing a receipt given to the customer.
     */
    public String getCustomerItem() {
        return String.format("%-15s%5s%16s\n", consumable.getName(), quantity + "", consumable.getPrice());
    }
}