package com.IntegrativeNutrition.IIN_Learning_Center.DrupalServices;

import org.json.simple.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 6/16/14
 * Time: 2:00 PM
 * Contains drupal user addresses
 */
public class UserAddress {

    private String Country;
    private String Province;
    private String City;
    private String Address1;
    private String Address2;
    private String PostalCode;
    private String AddressType;

    public String getCountry() {
        return Country;
    }

    public String getProvince() {
        return Province;
    }

    public String getCity() {
        return City;
    }

    public String getAddress1() {
        return Address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public String getAddressType() {
        return AddressType;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public void setAddressType(String addressType) {
        AddressType = addressType;
    }

    public String convertAddressToJSONString() {
        JSONObject addressObject = new JSONObject();
        JSONObject addressTitleObject = new JSONObject();

        addressObject.put("country", this.getCountry());
        addressObject.put("administrative_area", this.getProvince());
        addressObject.put("locality", this.getCity());
        addressObject.put("postal_code", this.getPostalCode());
        addressObject.put("thoroughfare", this.getAddress1());
        addressObject.put("premise", this.getAddress2());

        if (this.getAddressType().equals("home")) {
            addressTitleObject.put("home_address", addressObject);
        } else if (this.getAddressType().equals("shipping")) {
            addressTitleObject.put("shipping_address", addressObject);
        } else if (this.getAddressType().equals("work")) {
            addressTitleObject.put("work_address", addressObject);
        }

        return addressTitleObject.toString();
    }
}
