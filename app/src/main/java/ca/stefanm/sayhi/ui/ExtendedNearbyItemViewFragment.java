package ca.stefanm.sayhi.ui;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;

import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.model.NearbyExtendedItem;

/**
 * Created by stefan on 8/10/15.
 */
public class ExtendedNearbyItemViewFragment extends Fragment {

    NearbyExtendedItem nearbyExtendedItem;

    public ExtendedNearbyItemViewFragment(NearbyExtendedItem nearbyExtendedItem) {
        this.nearbyExtendedItem = nearbyExtendedItem;
    }

    public NearbyExtendedItem getNearbyExtendedItem() {
        return nearbyExtendedItem;
    }

    public void setNearbyExtendedItem(NearbyExtendedItem nearbyExtendedItem) {
        this.nearbyExtendedItem = nearbyExtendedItem;
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

        TextView nickname = (TextView)view.findViewById(R.id.eifrNickname);
        TextView friendlydistance = (TextView)view.findViewById(R.id.eifrFriendlyDist);
        TagCloudLinkView talktopics = (TagCloudLinkView)view.findViewById(R.id.eifr_talkabout_taglist);
        ImageView userImage = (ImageView)view.findViewById(R.id.eifrUserImageView);
        ImageView mapImage  = (ImageView)view.findViewById(R.id.eifrMapFragmentImageView);

        //Now we need to populate the ListItemView
        nickname.setText(nearbyExtendedItem.getNickname());
        //TODO: make this configurable based on global units settings.
        friendlydistance.setText(nearbyExtendedItem.getFriendlydistance(null));

        //Talk topics. Need to loop over the list of strings and then follow this:
        //https://github.com/namito/TagCloudLinkView

        int i = 1; //Used as ID for the tag thing.
        for (String topic : nearbyExtendedItem.getConversationtopics()){
            talktopics.add(new Tag(i, topic));
            i++;
        }

        //Check if our item has images set. If not, plug in some generic ones.
        if (nearbyExtendedItem.getUserPicture() == null){
            Drawable img = getActivity().getDrawable(R.drawable.ic_generic_person);
            userImage.setImageDrawable(img);
        } else {
            //TODO: Update this to actually show a picture.
            //userImage.setImageBitmap(nearbyItems.get(position).getUserPicture());
        }

        if (nearbyExtendedItem.getMapFragment() == null) {
            Drawable img = getActivity().getDrawable(R.drawable.ic_generic_map);
            mapImage.setImageDrawable(img);
        } else {
            //TODO: Update this to show the map picture.
        }

    }
}
