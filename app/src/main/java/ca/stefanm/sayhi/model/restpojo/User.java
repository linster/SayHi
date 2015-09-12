package ca.stefanm.sayhi.model.restpojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @Expose
    private String Id;

    //TODO: Make this not Object
    @Expose
    private Object oauthid;
    @Expose
    private String Created;
    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private Object socialtype;
    @Expose
    private String profileid;
    @SerializedName("email_address")
    @Expose
    private Object emailAddress;

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The oauthid
     */
    public Object getOauthid() {
        return oauthid;
    }

    /**
     *
     * @param oauthid
     * The oauthid
     */
    public void setOauthid(Object oauthid) {
        this.oauthid = oauthid;
    }

    /**
     *
     * @return
     * The Created
     */
    public String getCreated() {
        return Created;
    }

    /**
     *
     * @param Created
     * The Created
     */
    public void setCreated(String Created) {
        this.Created = Created;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     * The socialtype
     */
    public Object getSocialtype() {
        return socialtype;
    }

    /**
     *
     * @param socialtype
     * The socialtype
     */
    public void setSocialtype(Object socialtype) {
        this.socialtype = socialtype;
    }

    /**
     *
     * @return
     * The profileid
     */
    public String getProfileid() {
        return profileid;
    }

    /**
     *
     * @param profileid
     * The profileid
     */
    public void setProfileid(String profileid) {
        this.profileid = profileid;
    }

    /**
     *
     * @return
     * The emailAddress
     */
    public Object getEmailAddress() {
        return emailAddress;
    }

    /**
     *
     * @param emailAddress
     * The email_address
     */
    public void setEmailAddress(Object emailAddress) {
        this.emailAddress = emailAddress;
    }

}
