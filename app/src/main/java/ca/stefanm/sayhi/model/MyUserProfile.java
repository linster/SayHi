package ca.stefanm.sayhi.model;

import ca.stefanm.sayhi.model.restpojo.Bizcard;

/**
 * Created by stefan on 8/8/15.
 */

//TODO: Make this a singleton
public class MyUserProfile {

    //TODO Intitialize this on initial app load.
    public MyUserProfile(NearbyItem myNearbyItem, Bizcard myBusinessCard) {
        this.profile = myNearbyItem;
        this.bizcard = myBusinessCard;
    }


    private NearbyItem profile;
    private Bizcard bizcard;





}