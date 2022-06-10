package com.yenvth.mystore.model;

public class Category {
    private String categoryName;
    private int categoryImage;

    public Category(String categoryName, int categoryImage) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryImage=" + categoryImage +
                '}';
    }
}
