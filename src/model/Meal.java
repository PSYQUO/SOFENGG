package model;

import java.util.*;

public class Meal {
    private ArrayList<ConsumableQuantityPair> addOns;
    
    public Meal(ArrayList<ConsumableQuantityPair> addOns) {
        this.addOns = addOns;
    }

    public ArrayList<ConsumableQuantityPair> getAddOns() {
        return addOns;
    }

    public void setAddOns(ArrayList<ConsumableQuantityPair> addOns) {
        this.addOns = addOns;
    }
}