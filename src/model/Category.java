package model;

public class Category {
    public int categoryID;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryID = -1;
        this.categoryName = categoryName;
    }

    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }
}