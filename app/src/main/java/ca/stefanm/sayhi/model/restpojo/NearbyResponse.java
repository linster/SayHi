package ca.stefanm.sayhi.model.restpojo;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class NearbyResponse {

    @Expose
    private String Nickname;
    @Expose
    private long LocationId;
    @Expose
    private long UserId;
    @Expose
    private long AccuracyRadius;
    @Expose
    private String point;
    @Expose
    private String DateLogged;
    @Expose
    private String locationcircle;
    @Expose
    private long profileid;
    @Expose
    private long BusinessCardId;
    @Expose
    private Integer Chattiness;
    @Expose
    private List<String> ConversationTopics = new ArrayList<String>();
    @Expose
    private String pictureurl;
    /**
     *
     * @return
     * The Nickname
     */
    public String getNickname() {
        return Nickname;
    }

    /**
     *
     * @param Nickname
     * The Nickname
     */
    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    /**
     *
     * @return
     * The LocationId
     */
    public long getLocationId() {
        return LocationId;
    }

    /**
     *
     * @param LocationId
     * The LocationId
     */
    public void setLocationId(long LocationId) {
        this.LocationId = LocationId;
    }

    /**
     *
     * @return
     * The UserId
     */
    public long getUserId() {
        return UserId;
    }

    /**
     *
     * @param UserId
     * The UserId
     */
    public void setUserId(long UserId) {
        this.UserId = UserId;
    }

    /**
     *
     * @return
     * The AccuracyRadius
     */
    public long getAccuracyRadius() {
        return AccuracyRadius;
    }

    /**
     *
     * @param AccuracyRadius
     * The AccuracyRadius
     */
    public void setAccuracyRadius(long AccuracyRadius) {
        this.AccuracyRadius = AccuracyRadius;
    }

    /**
     *
     * @return
     * The point
     */
    public String getPoint() {
        return point;
    }

    /**
     *
     * @param point
     * The point
     */
    public void setPoint(String point) {
        this.point = point;
    }

    /**
     *
     * @return
     * The DateLogged
     */
    public String getDateLogged() {
        return DateLogged;
    }

    /**
     *
     * @param DateLogged
     * The DateLogged
     */
    public void setDateLogged(String DateLogged) {
        this.DateLogged = DateLogged;
    }

    /**
     *
     * @return
     * The locationcircle
     */
    public String getLocationcircle() {
        return locationcircle;
    }

    /**
     *
     * @param locationcircle
     * The locationcircle
     */
    public void setLocationcircle(String locationcircle) {
        this.locationcircle = locationcircle;
    }


    /**
     *
     * @return
     * The profileid
     */
    public long getProfileid() {
        return profileid;
    }

    /**
     *
     * @param profileid
     * The profileid
     */
    public void setProfileid(long profileid) {
        this.profileid = profileid;
    }

    /**
     *
     * @return
     * The BusinessCardId
     */
    public long getBusinessCardId() {
        return BusinessCardId;
    }

    /**
     *
     * @param BusinessCardId
     * The BusinessCardId
     */
    public void setBusinessCardId(long BusinessCardId) {
        this.BusinessCardId = BusinessCardId;
    }

    /**
     *
     * @return
     * The Chattiness
     */
    public Integer getChattiness() {
        return Chattiness;
    }

    /**
     *
     * @param Chattiness
     * The Chattiness
     */
    public void setChattiness(Integer Chattiness) {
        this.Chattiness = Chattiness;
    }

    /**
     *
     * @return
     * The ConversationTopics
     */
    public List<String> getConversationTopics() {
        return ConversationTopics;
    }

    /**
     *
     * @param ConversationTopics
     * The ConversationTopics
     */
    public void setConversationTopics(List<String> ConversationTopics) {
        this.ConversationTopics = ConversationTopics;
    }

    public void setPictureurl(String pictureurl){
        this.pictureurl = pictureurl;
    }
    public String getPictureurl(){
        return this.pictureurl;
    }
}