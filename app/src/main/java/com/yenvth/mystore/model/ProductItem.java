package com.yenvth.mystore.model.home;

public class ProductItem {
    package com.yenvth.mystore.home;

    public class ProductItemHome{
        int starNum;
        int person;
        String brandName;
        String productName;
        String old_price;
        String new_price;

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

        public ProductItemHome(int starNum, int person, String brandName, String productName, String old_price, String new_price) {
            this.starNum = starNum;
            this.person = person;
            this.brandName = brandName;
            this.productName = productName;
            this.old_price = old_price;
            this.new_price = new_price;


        }
    }

}
