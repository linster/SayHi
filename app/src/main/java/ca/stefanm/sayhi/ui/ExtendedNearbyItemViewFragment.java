package ca.stefanm.sayhi.ui;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;
import com.squareup.picasso.Picasso;

import java.util.UUID;

import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.services.MockNearbyItemsService;

/**
 * Created by stefan on 8/10/15.
 */
public class ExtendedNearbyItemViewFragment extends Fragment {

    NearbyExtendedItem nearbyExtendedItem;


    //Todo: Replace this constructor with a default one that reads a bundle.
    //The bundle has this tag in it: EXTENDED_VIEW_UUID
    //From that we can call .getNearbyExtendedItem(UUID....) and populate

    public ExtendedNearbyItemViewFragment() {

    }

    public NearbyExtendedItem getNearbyExtendedItem() {
        return nearbyExtendedItem;
    }

    public void setNearbyExtendedItem(NearbyExtendedItem nearbyExtendedItem) {
        this.nearbyExtendedItem = nearbyExtendedItem;
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
        setNearbyExtendedItem(mockNearbyItemsService.GetExtendedItem(12));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_extendeditem_view, container, false);

        UpdateView(fragmentView);
        return fragmentView;

    }

    public void UpdateView(View view){
        //Updates the View.
        PopulateItem();
        TextView nickname = (TextView)view.findViewById(R.id.eifrNickname);
        TextView friendlydistance = (TextView)view.findViewById(R.id.eifrFriendlyDist);
        TagCloudLinkView talktopics = (TagCloudLinkView)view.findViewById(R.id.eifr_talkabout_taglist);
        ImageView userImage = (ImageView)view.findViewById(R.id.eifrUserImageView);
        ImageView mapImage  = (ImageView)view.findViewById(R.id.eifrMapFragmentImageView);

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

        //userImage.setImageDrawable(nearbyExtendedItem.getUserImage(getActivity(), userImage));
        //mapImage.setImageDrawable(nearbyExtendedItem.getMapImage(getActivity(), mapImage));

        Picasso.with(getActivity()).load(nearbyExtendedItem.getUserImage())
                .placeholder(R.drawable.ic_generic_person)
                .error(R.drawable.ic_generic_person)
                .into(userImage);

        Picasso.with(getActivity()).load(nearbyExtendedItem.getMapImage())
                .placeholder(R.drawable.ic_generic_map)
                .error(R.drawable.ic_generic_map)
                .into(mapImage);

        //Now to change this to a MapView.
        



    }
}
