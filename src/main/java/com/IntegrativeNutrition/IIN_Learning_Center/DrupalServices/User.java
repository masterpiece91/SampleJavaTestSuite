package com.IntegrativeNutrition.IIN_Learning_Center.DrupalServices;

import org.json.simple.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 6/16/14
 * Time: 1:00 PM
 * Contains drupal user created upon authenticating
 */
public class User {

    public User(String JSONObject) {
        parseJSONObject(JSONObject);
    }

    public User(){}

    private String uID;
    private String sessionID;
    private String sessionName;
    private String CSRFToken;
    private String firstName;
    private String lastName;
    private String middleName;
    private String contactPhone;
    private String name;
    private String password;
    private String email;
    private List<UserEnrollment> enrollments;
    private UserAddress userHomeAddress = new UserAddress();
    private UserAddress userWorkAddress = new UserAddress();
    private UserAddress userShippingAddress = new UserAddress();
    private String displayName;
    private String financialStanding;
    private boolean isMigrated;
    private boolean initialSetupCompleted;

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getCSRFToken() {
        return CSRFToken;
    }

    public void setCSRFToken(String CSRFToken) {
        this.CSRFToken = CSRFToken;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }



    public List<UserEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<UserEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public UserAddress getUserHomeAddress() {
        return userHomeAddress;
    }

    public void setUserHomeAddress(UserAddress userHomeAddress) {
        this.userHomeAddress = userHomeAddress;
    }

    public UserAddress getUserWorkAddress() {
        return userWorkAddress;
    }

    public void setUserWorkAddress(UserAddress userWorkAddress) {
        this.userWorkAddress = userWorkAddress;
    }

    public UserAddress getUserShippingAddress() {
        return userShippingAddress;
    }

    public void setUserShippingAddress(UserAddress userShippingAddress) {
        this.userShippingAddress = userShippingAddress;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFinancialStanding() {
        return financialStanding;
    }

    public void setFinancialStanding(String financialStanding) {
        this.financialStanding = financialStanding;
    }

    public boolean isMigrated() {
        return isMigrated;
    }

    public void setMigrated(boolean isMigrated) {
        this.isMigrated = isMigrated;
    }

    public boolean isInitialSetupCompleted() {
        return initialSetupCompleted;
    }

    public void setInitialSetupCompleted(boolean initialSetupCompleted) {
        this.initialSetupCompleted = initialSetupCompleted;
    }

    public User parseJSONObject(String JSONObject) {
        JSONObject responseObject = (org.json.simple.JSONObject) JSONValue.parse(JSONObject);
        JSONObject user = (org.json.simple.JSONObject) responseObject.get("user");

        //When creating a user the response only include user info and therefore session will not be included,
        //therefore do not attempt to capture session info and set user JSONObject to response JSONObject.
        if (user == null) {
            user = responseObject;
        } else {
            if (responseObject.containsKey("sessid") && responseObject.get("sessid") != null) {
                sessionID = responseObject.get("sessid").toString();
            }
            if (responseObject.containsKey("session_name") && responseObject.get("session_name") != null) {
                sessionName = responseObject.get("session_name").toString();
            }
            if (responseObject.containsKey("token") && responseObject.get("token") != null) {
                CSRFToken = responseObject.get("token").toString();
            }
        }

        if (user.containsKey("uid") && user.get("uid") != null) {
            uID = user.get("uid").toString();
        }
        if (user.containsKey("name") && user.get("name") != null) {
            name = user.get("name").toString();
        }
        if (user.containsKey("mail") && user.get("mail") != null) {
            email = user.get("mail").toString();
        }
        if (user.containsKey("name_first") && user.get("name_first") != null) {
            firstName = user.get("name_first").toString();
        }
        if (user.containsKey("name_middle") && user.get("name_middle") != null) {
            middleName = user.get("name_middle").toString();
        }
        if (user.containsKey("name_last") && user.get("name_last") != null) {
            lastName = user.get("name_last").toString();
        }
        if (user.containsKey("contact_phone") && user.get("contact_phone") != null) {
            contactPhone = user.get("contact_phone").toString();
        }
        if (user.containsKey("enrollments") && user.get("enrollments") != null) {
            enrollments = parseEnrollments(user.get("enrollments"));
        }
        if (user.containsKey("home_address") && user.get("home_address") != null) {
            userHomeAddress = parseAddress(user.get("home_address"), "home");
        }
        if (user.containsKey("work_address") && user.get("work_address") != null) {
            userShippingAddress = parseAddress(user.get("work_address"), "shipping");
        }
        if (user.containsKey("shipping_address") && user.get("shipping_address") != null) {
            userWorkAddress = parseAddress(user.get("shipping_address"), "work");
        }
        if (user.containsKey("display_name") && user.get("display_name") != null) {
            displayName = user.get("display_name").toString();
        }
        if (user.containsKey("financial_standing") && user.get("financial_standing") != null) {
            financialStanding = user.get("financial_standing").toString();
        }
        if (user.containsKey("migrated") && user.get("migrated") != null) {
            if (user.get("migrated").toString().contentEquals("true")) {
                isMigrated = true;
            } else {
                isMigrated = false;
            }
        }
        if (user.containsKey("initial_setup") && user.get("initial_setup") != null) {
            if (user.get("initial_setup").toString().contentEquals("1")) {
                initialSetupCompleted = true;
            } else {
                initialSetupCompleted = false;
            }
        }

        return this;
    }

    private UserAddress parseAddress(Object address, String addressType) {
        JSONObject addressObject = (JSONObject) address;
        UserAddress userAddress = new UserAddress();

        if (addressObject.containsKey("thoroughfare") && addressObject.get("thoroughfare") != null) {
            userAddress.setAddress1(addressObject.get("thoroughfare").toString());
        }
        if (addressObject.containsKey("premise") && addressObject.get("premise") != null) {
            userAddress.setAddress2(addressObject.get("premise").toString());
        }
        if (addressObject.containsKey("locality") && addressObject.get("locality") != null) {
            userAddress.setCity(addressObject.get("locality").toString());
        }
        if (addressObject.containsKey("administrative_area") && addressObject.get("administrative_area") != null) {
            userAddress.setProvince(addressObject.get("administrative_area").toString());
        }
        if (addressObject.containsKey("country") && addressObject.get("country") != null) {
            userAddress.setCountry(addressObject.get("country").toString());
        }
        if (addressObject.containsKey("postal_code") && addressObject.get("postal_code") != null) {
            userAddress.setPostalCode(addressObject.get("postal_code").toString());
        }

        userAddress.setAddressType(addressType);

        return userAddress;
    }

    private List<UserEnrollment> parseEnrollments(Object enrollmentsObject) {

        List<UserEnrollment> userEnrollments = new ArrayList<UserEnrollment>();

        try {
            JSONArray enrollments = (JSONArray) enrollmentsObject;

            for (Object enrollment : enrollments) {
                UserEnrollment currentEnrollment = new UserEnrollment();
                currentEnrollment.parseJSONObject(enrollment);

                if (currentEnrollment != null) {
                    userEnrollments.add(currentEnrollment);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            return userEnrollments;
        }
    }


}

