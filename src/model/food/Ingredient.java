package model.food;

import model.food.RawItem;

/**
 * The item/ingredient used as a component of a food item.
 */
public class Ingredient {

    public static final String TABLE_NAME = "Ingredient";
    public static final String COLUMN_CONSUMABLE_ID = "Consumable_ID";
    public static final String COLUMN_RAWITEM_ID = "RawItem_ID";
    public static final String COLUMN_QUANTITY = "Quantity";

    private RawItem rawItem;
    private int quantity; // The number of rawItems used as ingredient.

    public Ingredient(RawItem rawItem, int quantity) {
        this.rawItem = rawItem;
        this.quantity = quantity;
    }

    public RawItem getRawItem() {
        return rawItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}