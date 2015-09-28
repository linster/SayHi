package ca.stefanm.sayhi.model;

        import android.content.res.Resources;
        import android.os.Parcel;
        import android.os.Parcelable;
        import android.util.Log;

        import com.google.android.gms.maps.model.LatLng;

        import java.io.Serializable;
        import java.util.List;

        import ca.stefanm.sayhi.R;
        import ca.stefanm.sayhi.model.restpojo.NearbyResponse;
        import ca.stefanm.sayhi.model.restpojo.Profile;
        import ca.stefanm.sayhi.services.MagicAPIKeys;


public class NearbyItem implements INearbyItem, Parcelable, Serializable {

    //http://stackoverflow.com/questions/18548077/parcelable-protocol-requires-a-parcelable-creator-object-called-creator-i-do-ha
    public static final String CREATOR = "stefan";
    /* The Rest POJO that holds the goods */
    public Profile profile;

    public NearbyItem(Profile profile) {
        this.profile = profile;
    }

    public NearbyItem() {
    }

    @Override
    public long getItemId() {
        return profile.getProfileid();
    }

    @Override
    public String getNickname() {
        return profile.getNickname();
    }

    @Override
    public String getFriendlyDistance() {
        return "1.0 mi";
    }

    @Override
    public List<String> getConversationTopics() {
        return profile.getConversationTopics();
    }

    @Override
    public String getUserImage() {
       return profile.getPictureurl();
    }

    enum MapSize {SMALL, LARGE};

    @Override
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


        String size = "size="+"64x64";
        String apikey = "key="+ MagicAPIKeys.STATIC_MAPS_API_KEY;

        String url = urlhead + center + "&" + zoom + "&" + size + "&"  + marker + "&" + apikey;
        Log.d("MapImageURL", url);
        return url;
    }

    private long AccuracyRadius;

    public long getAccuracyRadius() {
        return AccuracyRadius;
    }

    public void setAccuracyRadius(long accuracyRadius) {
        AccuracyRadius = accuracyRadius;
    }



    public LatLng getLocation() {

        //Parse the GeoJSON point and get the latlong
        //Our input is this:
        //"{\"type\":\"Point\",\"coordinates\":[-113.593883,53.522043]}"

        String j = this.JSONpoint;


        //HACK GROSS WTF
        j = j.substring(j.indexOf("["),j.length()-2);

        String lonstr = j.substring(1, j.indexOf(","));
        String latstr = j.substring(j.indexOf(",")+1, j.length());

        LatLng r = new LatLng(Double.valueOf(latstr), Double.valueOf(lonstr));

        return r;
    }

    //major feature envy.
    protected String JSONpoint = new String(); //This is what comes back from NearbyResponse

    public String getJSONpoint() {
        return JSONpoint;
    }

    public void setJSONpoint(String JSONpoint) {
        this.JSONpoint = JSONpoint;
    }

    public static NearbyItem buildNearbyItem(NearbyResponse nr) {

        Profile p = new Profile();
        p.setProfileid(nr.getProfileid());
        p.setNickname(nr.getNickname());
        p.setBusinessCardId(nr.getBusinessCardId());
        p.setChattiness(nr.getChattiness());
        p.setConversationTopics(nr.getConversationTopics());
        p.setPictureurl(nr.getPictureurl());

        NearbyItem r = new NearbyItem(p);
        r.setJSONpoint(nr.getPoint());
        return r;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}