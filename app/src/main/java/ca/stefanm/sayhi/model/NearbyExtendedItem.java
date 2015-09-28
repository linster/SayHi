package ca.stefanm.sayhi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.stefanm.sayhi.model.restpojo.AverageRating;
import ca.stefanm.sayhi.model.restpojo.AverageRatings;
import ca.stefanm.sayhi.model.restpojo.Profile;
import ca.stefanm.sayhi.services.MagicAPIKeys;

/**
 * Created by stefan on 8/8/15.
 */
public class NearbyExtendedItem extends NearbyItem implements Serializable {

    //http://stackoverflow.com/questions/18548077/parcelable-protocol-requires-a-parcelable-creator-object-called-creator-i-do-ha

    //public static final String CREATOR = "stefan";

    //Compose: AverageRatings for now. Later on, set up another db table with notes and things.

    private List<AverageRating> averageRatings = new ArrayList<AverageRating>();



    public NearbyExtendedItem() {
    }

    public NearbyExtendedItem(Profile profile, ArrayList<AverageRating> averageRatings) {
        super(profile);
        this.averageRatings = averageRatings;
    }

    public AverageRating getRating(String category){
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

    public void setAverageRatings(List<AverageRating> ar){
        this.averageRatings = ar;
    }

    public String getMapImage() {

        String urlhead = "https://maps.googleapis.com/maps/api/staticmap?";

        // Set up parameters after "?"
        //https://developers.google.com/maps/documentation/static-maps/intro

        if (this.JSONpoint == null || this.JSONpoint.equals("")){
            return null;
        }

        String center = "center="+ getLocation().latitude + "," + getLocation().longitude;
        String zoom = "zoom="+"14";

        // Magic to get markers of the point onto the map
        String marker = "markers=size:small%7Ccolor:black%7C" + getLocation().latitude + "," + getLocation().longitude;


        String size = "size="+"128x128";
        String apikey = "key="+ MagicAPIKeys.STATIC_MAPS_API_KEY;

        String url = urlhead + center + "&" + zoom + "&" + size + "&"  + marker + "&" + apikey;
        Log.d("MapImageURL", url);
        return url;
    }




}
