package ca.stefanm.sayhi.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import ca.stefanm.sayhi.model.restpojo.Profile;
import ca.stefanm.sayhi.services.Retrofit.AccessToken;

/**
 * Created by stefan on 9/26/15.
 */
public class CredentialService {
    private static CredentialService ourInstance = new CredentialService();

    public static CredentialService getInstance() {
        return ourInstance;
    }

    private CredentialService() {
    }

    /* Credentials */
    private String username;
    private String password;
    /* Tokens for Google API */
    private AccessToken gaccessToken = new AccessToken("", "");
    private AccessToken grefreshToken = new AccessToken("", "");;

    /* Tokens for SayHI Api */

    /* Storage Files */
    public static final String CRED_FILE = "credentials";


    private Boolean authenticated = false;

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean auth) {
        this.authenticated = auth;
    }


    //Get my profile information
    Profile myProfile;

    public Profile getMyProfile() {
        return myProfile;
    }

    public void setMyProfile(Profile myProfile) {
        this.myProfile = myProfile;
    }

    //Get my user information



    //Perform Authentication with OAuth.

    //Provide hook for launch-screen button.


    public void initializeFromSharedPreferences(SharedPreferences sp){

        //0 is Basic, 1..more
        Integer iauthType = sp.getInt("AuthType", 0);
        AuthTypes authType;
        switch (iauthType){
            case 0:
                authType = AuthTypes.BASIC;
                break;
            case 1:
                authType = AuthTypes.GOOGLE;
                break;
        }

        this.username = sp.getString("username", null);
        this.password = sp.getString("password", null);

        /* Pull out the access tokens stored */
        String gaccesstoken = sp.getString("gacctok", null);
        String gaccesstokentype = sp.getString("gacctoktype", null);

        AccessToken spAccessToken = new AccessToken(gaccesstoken, gaccesstokentype);
        this.gaccessToken = spAccessToken;

        String grefreshtoken = sp.getString("greftok", null);
        String grefreshtokentype = sp.getString("greftoktype", null);

        AccessToken spRefreshToken = new AccessToken(grefreshtoken, grefreshtokentype);
        this.grefreshToken = spRefreshToken;

        this.authenticated = sp.getBoolean("authenticated", false);

        Gson gson = new Gson();

        this.myProfile = gson.fromJson(sp.getString("ProfileJSON", "{}"), Profile.class);

    }

    public void serializeToSharedPreferences(SharedPreferences sp){

        SharedPreferences.Editor ed = sp.edit();

        Integer iauthtype;
        switch (getAuthType()){
            case BASIC:
                ed.putInt("AuthType", 0);
                ed.putString("username", this.username);
                ed.putString("password", this.password);
                break;
            case GOOGLE:
                ed.putInt("AuthType", 1);
                /* Save tokens */
                String gaccesstoken = this.gaccessToken.getAccessToken();
                String gacccesstokentype = this.gaccessToken.getTokenType();

                String grefreshtoken = this.grefreshToken.getAccessToken();
                String grefreshtokentype = this.grefreshToken.getTokenType();

                ed.putString("gacctok", gaccesstoken);
                ed.putString("gacctoktype", gacccesstokentype);

                ed.putString("greftok", grefreshtoken);
                ed.putString("greftoktype", grefreshtokentype);
                break;
            default:
                break;
        }

        Gson gson = new Gson();

        ed.putString("ProfileJSON", gson.toJson(myProfile));

        ed.putBoolean("authenticated", this.authenticated);

        ed.commit();
    }


    public enum AuthTypes {BASIC, GOOGLE};
    private AuthTypes AuthType = AuthTypes.BASIC;

    public AuthTypes getAuthType() {
        return AuthType;
        //Put logic in here for getting AuthType out of shared prefs.
    }

    /* The SplashActivity will do all the fun stuff of calling this, then initializing the singleton */
    public void setAuthType(AuthTypes authType) {
        AuthType = authType;

        switch (authType){
            case BASIC:
                this.AuthType = authType;
                break;
            case GOOGLE:
                this.AuthType = authType;
                break;
        }

        //Put logic in here for storing AuthType into shared prefs.

    }




    //Get credentials for REST interceptor
    public Map<String, String> getCredentials() {
        //Have logic for pulling this out of shared prefs.
        HashMap<String, String> basiccred = new HashMap<String, String>();
        basiccred.put("username", this.username);
        basiccred.put("password", this.password);
        return basiccred;
    }

    public void setCredentials(String username, String password){
        //Add logic for putting this into shared prefs.
        this.username = username;
        this.password = password;
    }

    public AccessToken getAccessToken(){
        return this.gaccessToken;

        //Have logic here
        /*
        if accesstoken == null || sharedprefs.token.....
        //do round trip and get it
        //else
        //return the token
         */
    }

    public void setAccessToken(AccessToken accessToken){
        this.gaccessToken = accessToken;
    }

    public void setRefreshToken(AccessToken refreshToken){
        this.grefreshToken = refreshToken;
    }


    public void Logout(SharedPreferences sp){
        /* Clear the state of this singleton and logout from API */
        this.authenticated = false;
        this.gaccessToken = new AccessToken("", "");
        this.grefreshToken = new AccessToken("", "");
        this.username = "";
        this.password = "";
        this.myProfile = null;
        serializeToSharedPreferences(sp);
    }
}
