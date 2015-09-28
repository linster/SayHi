package ca.stefanm.sayhi;

import android.app.Activity;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;
import com.squareup.picasso.Picasso;

import java.util.UUID;

import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.model.NearbyItem;
import ca.stefanm.sayhi.services.EventBusEvents.ChildReadyEvent;
import ca.stefanm.sayhi.services.EventBusEvents.GetExtendedNearbyItemEvent;
import ca.stefanm.sayhi.services.MockNearbyItemsService;
import ca.stefanm.sayhi.services.NearbyItemsService;
import ca.stefanm.sayhi.ui.ExtendedNearbyItemViewFragment;
import ca.stefanm.sayhi.ui.NearbyListFragment;
import ca.stefanm.sayhi.R;
import de.greenrobot.event.EventBus;

/**
 * Created by stefan on 8/11/15.
 */
public class ExtendedViewActivity extends AppCompatActivity {




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extendeditemview);

        if (savedInstanceState != null) {
            return;
        }

        //Register ourselves to the EventBus
        Log.d("EVA", "Subscribe to eventbus");
        EventBus.getDefault().registerSticky(this);
        //EventBus.getDefault().post(new ChildReadyEvent("ExtendedViewActivity"));
    }

    @Override
    public void onStart(){
        super.onStart();

        //EventBus.getDefault().register(this);

    }

    @Override
    public void onStop(){
        //EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void onEvent(GetExtendedNearbyItemEvent e){
        //Log.d("onEvent Extv", "Got eventbus event!");

        NearbyItemsService nearbyItemsService = new NearbyItemsService();

        NearbyItem ni = e.getNearbyItem();
        NearbyExtendedItem nei = nearbyItemsService.GetExtendedItem(ni);
        setNearbyExtendedItem(nei);
        //Log.d("Verify", nei.getNickname());
        UpdateView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void UpdateView(){
        //Updates the View.

        TextView nickname = (TextView)findViewById(R.id.eifrNickname);
        TextView friendlydistance = (TextView)findViewById(R.id.eifrFriendlyDist);
        TagCloudLinkView talktopics = (TagCloudLinkView)findViewById(R.id.eifr_talkabout_taglist);
        ImageView userImage = (ImageView)findViewById(R.id.eifrUserImageView);
        ImageView mapImage  = (ImageView)findViewById(R.id.eifrMapFragmentImageView);

        //Now we need to populate the ListItemView
        nickname.setText(nearbyExtendedItem.getNickname());
        //TODO: make this configurable based on global units settings.
        friendlydistance.setText(nearbyExtendedItem.getFriendlyDistance());

        //Talk topics. Need to loop over the list of strings and then follow this:
        //https://github.com/namito/TagCloudLinkView

        int i = 1; //Used as ID for the tag thing.
        for (String topic : nearbyExtendedItem.getConversationTopics()){
            talktopics.add(new Tag(i, topic));
            i++;
        }




        //userImage.setImageDrawable(nearbyExtendedItem.getUserImage(getApplicationContext(), userImage));
        //mapImage.setImageDrawable(nearbyExtendedItem.getMapImage(getApplicationContext(), mapImage));

        Picasso.with(this).load(nearbyExtendedItem.getUserImage())
                .placeholder(R.drawable.ic_generic_person)
                .error(R.drawable.ic_generic_person)
                .into(userImage);

        Picasso.with(this).load(nearbyExtendedItem.getMapImage())
                .placeholder(R.drawable.ic_generic_map)
                .error(R.drawable.ic_generic_map)
                .into(mapImage);


        Log.d("EVA MapURL ", nearbyExtendedItem.getMapImage());

        /*
                Doesn't work because we call an async method, then get a result.
                At running, this code gets null in the getRatings, and doesn't populate anything
                The solution is to refactor the NearbyItemsService to also have
                an intentService on NearbyExtendedItemService. Or something? That's retarded for
                how simple this app is. Maybe just plonk in the API call here? I might be Kusters-ing
                the crap out of this.
         */
        // Set up the star ratings
        RatingBar rb_attentiveness = (RatingBar)findViewById(R.id.avgRating1);
        RatingBar rb_activelist = (RatingBar)findViewById(R.id.avgRating2);
        RatingBar rb_ontopic = (RatingBar)findViewById(R.id.avgRating3);
//
//        rb_attentiveness.setStepSize((double)Double.valueOf("0.5"));
//        rb_activelist.setStepSize(Double.valueOf("0.5"));
//        rb_ontopic.setStepSize(Double.valueOf("0.5"));

        float AttentivenessRating = (float) nearbyExtendedItem.getRating("Attentiveness").getAverageRating();
        float ActiveListeningRating = (float) nearbyExtendedItem.getRating("Active Listening").getAverageRating();
        float OnTopicRating = (float) nearbyExtendedItem.getRating("On-Topic").getAverageRating();

        Log.d("AttRat", String.valueOf(AttentivenessRating));
        Log.d("ACTLRat", String.valueOf(ActiveListeningRating));
        Log.d("Ontop", String.valueOf(OnTopicRating));

        rb_attentiveness.setRating(AttentivenessRating);
        rb_activelist.setRating(ActiveListeningRating);
        rb_ontopic.setRating(OnTopicRating);


    }



    public NearbyExtendedItem getNearbyExtendedItem() {
        return nearbyExtendedItem;
    }

    public void setNearbyExtendedItem(NearbyExtendedItem nearbyExtendedItem) {
        this.nearbyExtendedItem = nearbyExtendedItem;
    }

    NearbyExtendedItem nearbyExtendedItem;


}
