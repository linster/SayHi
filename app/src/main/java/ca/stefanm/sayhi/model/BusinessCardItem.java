package ca.stefanm.sayhi.model;

import android.media.Image;

/**
 * Created by stefan on 8/8/15.
 */
public class BusinessCardItem {

    public BusinessCardItem(Integer businesscardid, Integer userid, String firstName,
                            String lastName, String catchPhrase, String phoneNumber,
                            String cellNumber, String email, String website,
                            String linkedInURL, Image userPicture) {
        this.businesscardid = businesscardid;
        this.userid = userid;
        FirstName = firstName;
        LastName = lastName;
        CatchPhrase = catchPhrase;
        PhoneNumber = phoneNumber;
        CellNumber = cellNumber;
        this.email = email;
        this.website = website;
        LinkedInURL = linkedInURL;
        UserPicture = userPicture;
    }

    private Integer businesscardid; //Id of this business card on the server
    private Integer userid;         //Id of the user who belongs to this business card.

    private String FirstName;
    private String LastName;
    private String CatchPhrase;
    private String PhoneNumber;
    private String CellNumber;
    private String email;
    private String website;
    private String LinkedInURL;

    Image UserPicture;

    public Integer getBusinesscardid() {
        return businesscardid;
    }

    public void setBusinesscardid(Integer businesscardid) {
        this.businesscardid = businesscardid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCatchPhrase() {
        return CatchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        CatchPhrase = catchPhrase;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCellNumber() {
        return CellNumber;
    }

    public void setCellNumber(String cellNumber) {
        CellNumber = cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLinkedInURL() {
        return LinkedInURL;
    }

    public void setLinkedInURL(String linkedInURL) {
        LinkedInURL = linkedInURL;
    }

    public Image getUserPicture() {
        return UserPicture;
    }

    public void setUserPicture(Image userPicture) {
        UserPicture = userPicture;
    }
}
