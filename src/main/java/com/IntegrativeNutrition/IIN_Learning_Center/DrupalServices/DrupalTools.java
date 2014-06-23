package com.IntegrativeNutrition.IIN_Learning_Center.DrupalServices;

import com.sun.jna.platform.win32.Sspi;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 6/16/14
 * Time: 11:00 AM
 * Contains all methods to interact with drupal site
 */

public class DrupalTools {

    public DrupalTools(String siteHost)
    {
        //Create our HttpClient & host
        host = new HttpHost(siteHost,80,"https");
        globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).build();
        cookieStore = new BasicCookieStore();
        context = HttpClientContext.create();
        context.setCookieStore(cookieStore);

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(new AuthScope(host),
                                           new UsernamePasswordCredentials("webdev", "webdev"));

        httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .setDefaultRequestConfig(globalConfig)
                .setDefaultCookieStore(cookieStore).build();
    }

    //The httpClient and host will be created during setup & used throughout our test
    private CloseableHttpClient httpClient;
    private HttpHost host;
    private CloseableHttpResponse response;
    private String CSRFToken = "";
    private User authenticatedUser;
    private User testUser;
    private CookieStore cookieStore;
    private HttpClientContext context;
    private RequestConfig globalConfig;

    public void setAuthenticatedUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setTestUser(User testUser) {
        this.testUser = testUser;
    }

    public User getTestUser() {
        return testUser;
    }

    private String postRequest(String route, String requestBody, boolean allowNon200Status) throws Exception {
        StringEntity rawRequestBody;
        HttpEntity entity;
        String responseContent = "";

        rawRequestBody = new StringEntity(requestBody,"UTF-8");
        rawRequestBody.setContentType("application/json");

        HttpPost request = new HttpPost(host.getSchemeName() + "://" + host.getHostName() + route);
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        request.addHeader(HttpHeaders.CACHE_CONTROL, "max-age=0");
        request.addHeader("X-CSRF-Token", CSRFToken);
        request.addHeader(HttpHeaders.ACCEPT, "application/json");

        request.setEntity(rawRequestBody);

        response = httpClient.execute(request, context);

        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();

        entity = response.getEntity();

        if(statusCode==200 || allowNon200Status)
        {
            responseContent = EntityUtils.toString(entity);

        }
        else
        {
            responseContent = "ERROR: " + Integer.toString(statusCode) + " - " + EntityUtils.toString(entity);
        }

        return responseContent;
    }

    private String getRequest(String route, boolean allowNon200Status) throws Exception {
        HttpEntity entity;
        String responseContent = "";

        HttpGet request = new HttpGet(host.getSchemeName() + "://" + host.getHostName() + route);
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        request.addHeader(HttpHeaders.CACHE_CONTROL, "max-age=0");
        request.addHeader("X-CSRF-Token", CSRFToken);

        response = httpClient.execute(request, context);
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();

        entity = response.getEntity();

        if(statusCode==200 || allowNon200Status)
        {
            responseContent = EntityUtils.toString(entity);

        }
        else
        {
            responseContent = "ERROR: " + Integer.toString(statusCode) + " - " + EntityUtils.toString(entity);
        }

        return responseContent;
    }

    protected boolean isAuthenticated() {
        try {

            if (postRequest("/services/system/connect.json", "", true).contains("[\"User not logged in.\"]")) {
                return false;
            }
            return true;

        }catch (Exception ex) {
            return false;
        }
    }

    public User LoginToSite(String username, String password, boolean rememberMe) throws Exception {

        if (isAuthenticated()) {
            return authenticatedUser;
        }

        String requestBody = "{\"username\":\""
                        + username + "\",\"password\":\""
                        + password + "\",\"remember\":\""
                        + rememberMe + "\"} ";

        String response = postRequest("/services/entity_user/login.json", requestBody, false);

        authenticatedUser = new User(response);
        authenticatedUser.setPassword(username);
        CSRFToken = authenticatedUser.getCSRFToken();

        return authenticatedUser;

    }

    public User createNewStudent(User newUser) throws Exception {

        // make sure to destroy previous user object.
        testUser = null;

        if (isAuthenticated()) {
            String requestBody = "{" +
                    "\"pass_raw\":\"password\"," +
                    "\"name_first\":\"" + ((newUser.getFirstName() == null) ? "" : newUser.getFirstName()) + "\"," +
                    "\"name_last\":\"" + ((newUser.getLastName() == null) ? "" : newUser.getLastName()) + "\"," +
                    "\"name_middle\":\"" + ((newUser.getMiddleName() == null) ? "" : newUser.getMiddleName()) + "\"," +
                    //"\"social_security_number\":\"(text:Field 'field_social_security_number'.)\"," +
                    "\"contact_phone\":\"" + ((newUser.getContactPhone() == null) ? "" : newUser.getContactPhone()) + "\"," +
                    //"\"bio\":\"(text:Field 'field_bio'.)\"," +
                    //"\"call_in\":\"(text:Field 'field_call_in'.)\"," +
                    "\"best_number_to_call\":\"work\"," +
                    "\"date_of_birth\":\"-2208988800\"," +
                    "\"education_level_name\":\"High school degree/GED\"," +
                    "\"gender\":\"male\"," +
                    "\"home_address\":{" +
                    "\"country\":\"" + ((newUser.getUserHomeAddress().getCountry() == null) ? "" : newUser.getUserHomeAddress().getCountry()) + "\"," +
                    "\"administrative_area\":\"" + ((newUser.getUserHomeAddress().getProvince() == null) ? "" : newUser.getUserHomeAddress().getProvince()) + "\"," +
                    "\"locality\":\"" + ((newUser.getUserHomeAddress().getCity() == null) ? "" : newUser.getUserHomeAddress().getCity()) + "\"," +
                    "\"postal_code\":\"" + ((newUser.getUserHomeAddress().getPostalCode() == null) ? "" : newUser.getUserHomeAddress().getPostalCode()) + "\"," +
                    "\"thoroughfare\":\"" + ((newUser.getUserHomeAddress().getAddress1() == null) ? "" : newUser.getUserHomeAddress().getAddress1()) + "\"," +
                    "\"premise\":\"" + ((newUser.getUserHomeAddress().getAddress2() == null) ? "" : newUser.getUserHomeAddress().getAddress2()) + "\"" +
                    "}," +
                    //"\"legacy_student_guid\":\"(text:Field 'field_legacy_student_guid'.)\"," +
                    "\"migrated\":\"" + newUser.isMigrated() + "\"," +
                    //"\"occupation\":\"(text:Field 'field_occupation'.)\"," +
                    //"\"occupation_detail\":\"(text:Field 'field_occupation_detail'.)\"," +
                    //"\"preferred_name\":\"(text:Field 'field_preferred_name'.)\"," +
                    //"\"secondary_email\":\"(text:Field 'field_secondary_email'.)\"," +
                    "\"shipping_address\":{" +
                    "\"country\":\"" + ((newUser.getUserShippingAddress().getCountry() == null) ? "" : newUser.getUserShippingAddress().getCountry()) + "\"," +
                    "\"administrative_area\":\"" + ((newUser.getUserShippingAddress().getProvince() == null) ? "" : newUser.getUserShippingAddress().getProvince()) + "\"," +
                    "\"locality\":\"" + ((newUser.getUserShippingAddress().getCity() == null) ? "" : newUser.getUserShippingAddress().getCity()) + "\"," +
                    "\"postal_code\":\"" + ((newUser.getUserShippingAddress().getPostalCode() == null) ? "" : newUser.getUserShippingAddress().getPostalCode()) + "\"," +
                    "\"thoroughfare\":\"" + ((newUser.getUserShippingAddress().getAddress1() == null) ? "" : newUser.getUserShippingAddress().getAddress1()) + "\"," +
                    "\"premise\":\"" + ((newUser.getUserShippingAddress().getAddress2() == null) ? "" : newUser.getUserShippingAddress().getAddress2()) + "\"" +
                    "}," +
                    "\"work_address\":{" +
                    "\"country\":\"" + ((newUser.getUserWorkAddress().getCountry() == null) ? "" : newUser.getUserWorkAddress().getCountry()) + "\"," +
                    "\"administrative_area\":\"" + ((newUser.getUserWorkAddress().getProvince() == null) ? "" : newUser.getUserWorkAddress().getProvince()) + "\"," +
                    "\"locality\":\"" + ((newUser.getUserWorkAddress().getCity() == null) ? "" : newUser.getUserWorkAddress().getCity()) + "\"," +
                    "\"postal_code\":\"" + ((newUser.getUserWorkAddress().getPostalCode() == null) ? "" : newUser.getUserWorkAddress().getPostalCode()) + "\"," +
                    "\"thoroughfare\":\"" + ((newUser.getUserWorkAddress().getAddress1() == null) ? "" : newUser.getUserWorkAddress().getAddress1()) + "\"," +
                    "\"premise\":\"" + ((newUser.getUserWorkAddress().getAddress2() == null) ? "" : newUser.getUserWorkAddress().getAddress2()) + "\"" +
                    "}," +
                    "\"initial_setup\":\"" + newUser.isInitialSetupCompleted() + "\"," +
                    "\"display_name\":\"" + ((newUser.getDisplayName() == null) ? "" : newUser.getDisplayName()) + "\"," +
                    "\"external_id\":\"\"," +
                    //"\"legacy_collection_status\":\"(text:Field 'field_legacy_collection_status'.)\"," +
                    //"\"legacy_credentials_id\":\"(text:Field 'field_legacy_credentials_id'.)\"," +
                    "\"financial_standing\":\"" + ((newUser.getFinancialStanding() == null) ? "" : newUser.getFinancialStanding()) + "\"," +
                    //"\"sectioner_matcher_hide_sections\":\"(boolean:Field 'sectioner_matcher_hide_sections'.)\"," +
                    "\"name\":\"" + ((newUser.getName() == null) ? "" : newUser.getName()) + "\"," +
                    "\"mail\":\"" + ((newUser.getEmail() == null) ? "" : newUser.getEmail()) + "\"," +
                    "\"roles\":[" +
                    "\"95\"" +
                    "]," +
                    //"\"status\":\"1\"," +
                    "\"theme\":\"iin_bartik\"," +
                    //"\"language\":\"(token:This account's default language for e-mails, and preferred language for site presentation.)\"," +
                    //"\"pass_raw\":\"(text:The raw password of a user. Cannot be read.)\"," +
                    "\"timezone\":\"America/New_York\"" +
                    //"\"picture\":{" +
                    //"\"+id\":\"(integer:The id of the profile picture of a user.)\"" +
                    //"}," +
                    //"\"message_preferences\":\"(struct:The messaging preferences for this user.)\"" +
                    "}";

            String response = postRequest("/services/entity_user/", requestBody, false);
            testUser = newUser.parseJSONObject(response);
            testUser.setPassword("password");   //The password for new students will always be password for now.
        }

        return testUser;
    }

    public User retrieveUser(String userID) throws Exception {
        //Do not advance if there is no authenticated user.
        if (isAuthenticated()) {
            String response = getRequest("/services/entity_user/" + userID, false);
            return testUser.parseJSONObject(response);
        }

        return null;
    }

    public User enrollStudent(User user) throws Exception {

        //Do not advance if there is no authenticated user.
        if (isAuthenticated()) {

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            String requestBody = "{" +
                    //"\"external_id\":\"\"," +
                    "\"course\":{\"id\":\"7371\"}," +   //September 2014 course. This could be made more dynamic later on.
                    "\"date_status_changed\":\"" + timestamp.getNanos() + "\"," +
                    "\"enrolled_by\":\"Appium\"," +
                    "\"field_name\":\"field_enrollments\"," +
                    "\"host_entity\":{\"id\":\"" + user.getuID() + "\",\"resource\":\"user\"}" +
                    "}";

            String response = postRequest("/services/enrollment/", requestBody, false);
            testUser = retrieveUser(user.getuID());

            return testUser;
        }

        return null;
    }
}
