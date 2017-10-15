package model;

public class Category {
    public int categoryId;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryId = -1;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}