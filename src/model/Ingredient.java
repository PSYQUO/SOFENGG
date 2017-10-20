package model;

public class Ingredient {
    private RawItem rawItem;
    private Consumable consumable;
    private int quantity;

    public Ingredient(RawItem rawItem, Consumable consumable, int quantity) {
        this.rawItem = rawItem;
        this.consumable = consumable;
        this.quantity = quantity;
    }

    public RawItem getRawItem() {
        return rawItem;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}