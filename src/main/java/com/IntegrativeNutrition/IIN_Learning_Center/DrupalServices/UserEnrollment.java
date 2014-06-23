package com.IntegrativeNutrition.IIN_Learning_Center.DrupalServices;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 6/16/14
 * Time: 5:00 PM
 * Contains drupal user enrollments
 */
public class UserEnrollment {

    private String uri;
    private String id;
    private String uUID;
    private String enrollmentState;
    private int unsignAgreementCount;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuUID() {
        return uUID;
    }

    public void setuUID(String uUID) {
        this.uUID = uUID;
    }

    public String getEnrollmentState() {
        return enrollmentState;
    }

    public void setEnrollmentState(String enrollmentState) {
        this.enrollmentState = enrollmentState;
    }

    public int getUnsignAgreementCount() {
        return unsignAgreementCount;
    }

    public void setUnsignAgreementCount(int unsignAgreementCount) {
        this.unsignAgreementCount = unsignAgreementCount;
    }

    public UserEnrollment parseJSONObject(Object enrollmentsObject) {
        JSONObject enrollment;

        try {
                enrollment = (JSONObject)enrollmentsObject;

                if (enrollment.containsKey("id") && enrollment.get("id") != null) {
                    this.setId(enrollment.get("id").toString());
                }
                if (enrollment.containsKey("uri") && enrollment.get("uri") != null) {
                    this.setUri(enrollment.get("uri").toString());
                }
                if (enrollment.containsKey("uuid") && enrollment.get("uuid") != null) {
                    this.setuUID(enrollment.get("uuid").toString());
                }
                if (enrollment.containsKey("enrollment_state") && enrollment.get("enrollment_state") != null) {
                    this.setEnrollmentState(enrollment.get("enrollment_state").toString());
                }
                if (enrollment.containsKey("unsigned_agreement_count") && enrollment.get("unsigned_agreement_count") != null) {
                    this.setUnsignAgreementCount(Integer.parseInt(enrollment.get("unsigned_agreement_count").toString()));
                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            return this;
        }
    }

}
