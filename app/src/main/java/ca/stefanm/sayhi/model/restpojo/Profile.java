package ca.stefanm.sayhi.model.restpojo;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefan on 9/6/15.
 */
public class Profile {
    @Expose
    private long profileid;
    @Expose
    private long BusinessCardId;
    @Expose
    private Integer Chattiness;
    @Expose
    private List<String> ConversationTopics = new ArrayList<String>();
    @Expose
    private String Nickname;
    @Expose
    private String Pictureurl;

    public Profile(long profileid, long businessCardId, Integer chattiness, List<String> conversationTopics, String nickname, String pictureurl) {
        this.profileid = profileid;
        BusinessCardId = businessCardId;
        Chattiness = chattiness;
        ConversationTopics = conversationTopics;
        Nickname = nickname;
        Pictureurl = pictureurl;
    }

    public Profile() {
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

    public String getPictureurl() {
        return Pictureurl;
    }

    public void setPictureurl(String pictureurl){
        Pictureurl = pictureurl;
    }
}
