package model;

public class RawItem {
    public int rawItemId;
    private String name;
    private int quantity;
    private double price;

    public RawItem(String name, int quantity, double price) {
        this.rawItemId = -1;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public RawItem(int rawItemId, String name, int quantity, double price) {
        this.rawItemId = rawItemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }
}