package ca.stefanm.sayhi.model.restpojo;


import com.google.gson.annotations.Expose;


public class Bizcard {

    @Expose
    private String Id;
    @Expose
    private String ProfileId;
    @Expose
    private String FirstName;
    @Expose
    private String LastName;
    @Expose
    private String email;
    @Expose
    private String Website;
    @Expose
    private String Company;
    @Expose
    private String Title;

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
     * The ProfileId
     */
    public String getProfileId() {
        return ProfileId;
    }

    /**
     *
     * @param ProfileId
     * The ProfileId
     */
    public void setProfileId(String ProfileId) {
        this.ProfileId = ProfileId;
    }

    /**
     *
     * @return
     * The FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     *
     * @param FirstName
     * The FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     *
     * @return
     * The LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     *
     * @param LastName
     * The LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The Website
     */
    public String getWebsite() {
        return Website;
    }

    /**
     *
     * @param Website
     * The Website
     */
    public void setWebsite(String Website) {
        this.Website = Website;
    }

    /**
     *
     * @return
     * The Company
     */
    public String getCompany() {
        return Company;
    }

    /**
     *
     * @param Company
     * The Company
     */
    public void setCompany(String Company) {
        this.Company = Company;
    }

    /**
     *
     * @return
     * The Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     *
     * @param Title
     * The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

}
