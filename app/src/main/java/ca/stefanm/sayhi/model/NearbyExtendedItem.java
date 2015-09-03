package ca.stefanm.sayhi.model;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by stefan on 8/8/15.
 */
public class NearbyExtendedItem extends NearbyItem {

    public NearbyExtendedItem() {
    }

    public NearbyExtendedItem(Integer userid, String nickname, ArrayList<String> conversationtopics, float distance, Distanceunit distanceunit, Image userPicture, Image mapFragment) {
        super(userid, nickname, conversationtopics, distance, distanceunit, userPicture, mapFragment);
    }



    String conversationnotes;

    public static class ConversationRating {
        //This is the model item for the grid in the mockup.

        public ConversationRating(String place, Integer rating, String notes) {
            this.place = place;
            this.rating = rating;
            this.notes = notes;
        }

        private String place;
        private Integer rating; //Out of 10. Each 1 represents half a star.
        private String notes;

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            if (rating > 10 || rating < 0) {
                throw new IllegalArgumentException("Rating must be between 0 and 10");
            }
            this.rating = rating;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }
    }

    ArrayList<ConversationRating> ConversationRatings = new ArrayList<ConversationRating>();

    public ArrayList<ConversationRating> getConversationRatings() {
        return ConversationRatings;
    }

    public void setConversationRatings(ArrayList<ConversationRating> conversationRatings) {
        ConversationRatings = conversationRatings;
    }

    public void addNewRating(ConversationRating rating){
        this.ConversationRatings.add(rating);
    }


}
