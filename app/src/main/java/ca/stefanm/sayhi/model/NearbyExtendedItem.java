package ca.stefanm.sayhi.model;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by stefan on 8/8/15.
 */
public class NearbyExtendedItem extends NearbyItem {

    public NearbyExtendedItem(Integer userid, String nickname, ArrayList<String> conversationtopics, float distance, Distanceunit distanceunit) {
        super(userid, nickname, conversationtopics, distance, distanceunit);
    }

    public NearbyExtendedItem(Integer userid, String nickname, ArrayList<String> conversationtopics, float distance, Distanceunit distanceunit, Image userPicture, Image mapFragment) {
        super(userid, nickname, conversationtopics, distance, distanceunit, userPicture, mapFragment);
    }

    String conversationnotes;

    private class ConversationRating {
        //This is the model item for the grid in the mockup.

        String place;
        Integer rating; //Out of 10. Each 1 represents half a star.
        String notes;
    }

    ArrayList<ConversationRating> ConversationRatings;

    public ArrayList<ConversationRating> getConversationRatings() {
        return ConversationRatings;
    }

    public void setConversationRatings(ArrayList<ConversationRating> conversationRatings) {
        ConversationRatings = conversationRatings;
    }


}
