package com.example.supermarket;

public class Rating {

    private int superMarketID;
    private String superMarketName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String liquorRating;
    private String produceRating;
    private String meatRating;
    private String cheeseRating;
    private String checkoutRating;


    public Rating() {
        superMarketID = -1;
    }

    public int getSuperMarketID() {
        return superMarketID;
    }

    public void setSuperMarketID(int superMarketID) {
        this.superMarketID = superMarketID;
    }

    public String getSuperMarketName() {
        return superMarketName;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLiquorRating() {
        return liquorRating;
    }

    public void setLiquorRating(String liquorRating) {
        this.liquorRating = liquorRating;
    }

    public String getProduceRating() {
        return produceRating;
    }

    public void setProduceRating(String produceRating) {
        this.produceRating = produceRating;
    }

    public String getMeatRating() {
        return meatRating;
    }

    public void setMeatRating(String meatRating) {
        this.meatRating = meatRating;
    }

    public String getCheeseRating() {
        return cheeseRating;
    }

    public void setCheeseRating(String cheeseRating) {
        this.cheeseRating = cheeseRating;
    }

    public String getCheckoutRating() {
        return checkoutRating;
    }

    public void setCheckoutRating(String checkoutRating) {
        this.checkoutRating = checkoutRating;
    }
}
