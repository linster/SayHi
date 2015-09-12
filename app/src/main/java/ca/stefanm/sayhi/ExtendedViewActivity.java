package ca.stefanm.sayhi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;
import com.squareup.picasso.Picasso;

import java.util.UUID;

import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.services.MockNearbyItemsService;
import ca.stefanm.sayhi.ui.ExtendedNearbyItemViewFragment;
import ca.stefanm.sayhi.ui.NearbyListFragment;
import ca.stefanm.sayhi.R;
/**
 * Created by stefan on 8/11/15.
 */
public class ExtendedViewActivity extends AppCompatActivity {


    ExtendedNearbyItemViewFragment extendedNearbyItemViewFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extendeditemview);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        //if (findViewById(R.id.fragment_container) != null) {

        // However, if we're being restored from a previous state,
        // then we don't need to do anything and should return or else
        // we could end up with overlapping fragments.
        if (savedInstanceState != null) {
            return;
        }




        //}

    }



    //Populate layout
    //On resume, delete all fragments, instantiate new fragment with info, then add to view.
    @Override
    protected void onResume() {
        super.onResume();

        UpdateView();



    }

    public void UpdateView(){
        //Updates the View.
        PopulateItem();
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


    }

    private void PopulateItem() {
        //Bundle arguments = getArguments();
        //String ItemId = arguments.getString("EXTENDED_VIEW_UUID");
        /*
        UUID ItemUUID;
        if (ItemId != null) {
            // we have a Question, grab it from dataManager
            ItemUUID = UUID.fromString(ItemId);
        } else {
            // no Question, toss er back to the main screen
            Toast.makeText(getActivity(), "Could not open specified item", Toast.LENGTH_LONG).show();
        }*/

        //TODO: Actually Make this work.
        MockNearbyItemsService mockNearbyItemsService = new MockNearbyItemsService();
        setNearbyExtendedItem(mockNearbyItemsService.GetExtendedItem(UUID.randomUUID()));
    }

    public NearbyExtendedItem getNearbyExtendedItem() {
        return nearbyExtendedItem;
    }

    public void setNearbyExtendedItem(NearbyExtendedItem nearbyExtendedItem) {
        this.nearbyExtendedItem = nearbyExtendedItem;
    }

    NearbyExtendedItem nearbyExtendedItem;


}
