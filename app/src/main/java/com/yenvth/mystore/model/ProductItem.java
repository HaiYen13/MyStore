package com.yenvth.mystore.model;

public class ProductItem {
        private String productImg;
        private int starNum;
        private int person;
        private String brandName;
        private String productName;
        private String old_price;
        private String new_price;
        private int favorite_btn;

    public ProductItem(String productImg, int starNum, int person, String brandName, String productName, String old_price, String new_price, int favorite_btn) {
        this.productImg = productImg;
        this.starNum = starNum;
        this.person = person;
        this.brandName = brandName;
        this.productName = productName;
        this.old_price = old_price;
        this.new_price = new_price;
        this.favorite_btn = favorite_btn;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOld_price() {
        return old_price;
    }

    public void setOld_price(String old_price) {
        this.old_price = old_price;
    }

    public String getNew_price() {
        return new_price;
    }

    public void setNew_price(String new_price) {
        this.new_price = new_price;
    }

    public int getFavorite_btn() {
        return favorite_btn;
    }

    public void setFavorite_btn(int favorite_btn) {
        this.favorite_btn = favorite_btn;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "productImg='" + productImg + '\'' +
                ", starNum=" + starNum +
                ", person=" + person +
                ", brandName='" + brandName + '\'' +
                ", productName='" + productName + '\'' +
                ", old_price='" + old_price + '\'' +
                ", new_price='" + new_price + '\'' +
                ", favorite_btn=" + favorite_btn +
                '}';
    }
}
