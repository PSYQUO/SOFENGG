package model;

import java.util.List;

public class Meal {
    private List<Consumable> addOns;

    public Meal(List<Consumable> addOns) {
        this.addOns = addOns;
    }

    public List<Consumable> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<Consumable> addOns) {
        this.addOns = addOns;
    }
}