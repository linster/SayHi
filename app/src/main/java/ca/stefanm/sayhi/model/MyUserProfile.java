package ca.stefanm.sayhi.model;

/**
 * Created by stefan on 8/8/15.
 */
public class MyUserProfile {

    //TODO Intitialize this on initial app load.
    public MyUserProfile(NearbyItem myNearbyItem, BusinessCardItem myBusinessCard) {
        this.myNearbyItem = myNearbyItem;
        this.myBusinessCard = myBusinessCard;
        this.talkativity = 5;
    }

    //Contains Nearby Item and Nearby Business Card Item


    //Set distance to zero and have a phony map fragment. This gets us most of the fields we need.
    private NearbyItem myNearbyItem;
    private BusinessCardItem myBusinessCard;

    Integer talkativity;    //0 for Untalkative, 10 for Very Chatty.



    public Integer getTalkativity() {
        return talkativity;
    }


    /** @param talkativity 0 for untalkative, 10 for very chatty */
    public void setTalkativity(Integer talkativity) {
        if (talkativity > 10 || talkativity < 0) {
            throw new IllegalArgumentException("Talkativity must be between 0 and 10");
        }
        this.talkativity = talkativity;
    }



}