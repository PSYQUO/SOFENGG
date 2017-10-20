package model;

public class LineItem {
    private Consumable consumable;
    private int quantity;

    public LineItem(Consumable consumable, int quantity) {
        this.consumable = consumable;
        this.quantity = quantity;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public int getQuantity() {
        return quantity;
    }
}