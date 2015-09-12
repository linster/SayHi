package ca.stefanm.sayhi.model;

        import android.content.Context;
        import android.graphics.drawable.Drawable;
        import android.os.Parcel;
        import android.os.Parcelable;
        import android.widget.ImageView;
        import android.widget.Toast;

        import com.squareup.picasso.Picasso;

        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;

        import ca.stefanm.sayhi.R;
        import ca.stefanm.sayhi.model.restpojo.NearbyResponse;
        import ca.stefanm.sayhi.model.restpojo.Profile;
        import ca.stefanm.sayhi.services.Retrofit.ServiceGenerator;
        import retrofit.Callback;
        import retrofit.RetrofitError;
        import retrofit.client.Response;

public class NearbyItem implements INearbyItem, Parcelable {
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

    @Override
    public String getMapImage() {
        return null;
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