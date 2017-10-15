package model;

import java.util.List;

public class Consumable {
    public int consumableId;
    private String name;
    private String codeName;
    private Category category;
    private double price;
    private List<RawItem> rawItem;
    private Meal meal;
}