package com.example.supermarket;

public class Rating {

    private int superMarketID;
    private String superMarketName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private float liquorRating;
    private float produceRating;
    private float meatRating;
    private float cheeseRating;
    private float checkoutRating;


    public Rating() {
        superMarketID = -1;
        liquorRating = (float) 0;
        produceRating = (float) 0;
        meatRating = (float) 0;
        cheeseRating = (float) 0;
        checkoutRating = (float) 0;

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

    public float getLiquorRating() {
        return liquorRating;
    }

    public void setLiquorRating(float liquorRating) {
        this.liquorRating = liquorRating;
    }

    public float getProduceRating() {
        return produceRating;
    }

    public void setProduceRating(float produceRating) {
        this.produceRating = produceRating;
    }

    public float getMeatRating() {
        return meatRating;
    }

    public void setMeatRating(float meatRating) {
        this.meatRating = meatRating;
    }

    public float getCheeseRating() {
        return cheeseRating;
    }

    public void setCheeseRating(float cheeseRating) {
        this.cheeseRating = cheeseRating;
    }

    public float getCheckoutRating() {
        return checkoutRating;
    }

    public void setCheckoutRating(float checkoutRating) {
        this.checkoutRating = checkoutRating;
    }
}


