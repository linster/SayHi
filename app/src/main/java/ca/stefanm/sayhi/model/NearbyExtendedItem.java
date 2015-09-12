package ca.stefanm.sayhi.model;

import java.util.ArrayList;
import java.util.List;

import ca.stefanm.sayhi.model.restpojo.AverageRating;
import ca.stefanm.sayhi.model.restpojo.AverageRatings;
import ca.stefanm.sayhi.model.restpojo.Profile;

/**
 * Created by stefan on 8/8/15.
 */
public class NearbyExtendedItem extends NearbyItem {


    //Compose: AverageRatings for now. Later on, set up another db table with notes and things.

    private ArrayList<AverageRating> averageRatings;



    public NearbyExtendedItem() {
    }

    public NearbyExtendedItem(Profile profile, ArrayList<AverageRating> averageRatings) {
        super(profile);
        this.averageRatings = averageRatings;
    }

    AverageRating getRating(String category){
        for (AverageRating a : this.averageRatings){
            if (a.getCategoryName().equals(category)){
                return a;
            }
        }
        return null;
    }

    List<AverageRating> getAllRatings(){
        return averageRatings;
    }

    void setAverageRatings(ArrayList<AverageRating> ar){
        this.averageRatings = ar;
    }



}
