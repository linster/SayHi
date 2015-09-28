package ca.stefanm.sayhi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;
import com.squareup.picasso.Picasso;

import java.util.List;

import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.model.NearbyItem;
import ca.stefanm.sayhi.model.restpojo.NearbyResponse;

/**
 * Created by stefan on 8/9/15.
 */
public class NearbyItemsListAdapter extends ArrayAdapter<NearbyItem> {


    // Because of how NearbyItems service is defined, the list adapter may be the one phoning
    // a GetLocationService to figure out where we are and populate the list that way.


    List<NearbyItem> nearbyItems;

    public NearbyItemsListAdapter(Context context, int resource, List<NearbyItem> objects) {
        super(context, resource, objects);
        nearbyItems = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.nearbyitem_listitem, parent, false);
        }


        NearbyItem item = nearbyItems.get(position);

        //Get references to all the things
        TextView nickname = (TextView)convertView.findViewById(R.id.textNickName);
        TextView friendlydistance = (TextView)convertView.findViewById(R.id.distancetextView);
        TagCloudLinkView talktopics = (TagCloudLinkView)convertView.findViewById(R.id.talkabout_taglist);
        ImageView userImage = (ImageView)convertView.findViewById(R.id.UserimageView);
        ImageView mapImage = (ImageView)convertView.findViewById(R.id.MapFragmentImageView);

        //Now we need to populate the ListItemView
        nickname.setText(item.getNickname());
        //TODO: make this configurable based on global units settings.
        friendlydistance.setText(item.getFriendlyDistance());

        //Talk topics. Need to loop over the list of strings and then follow this:
        //https://github.com/namito/TagCloudLinkView
        //talktopics.removeAllViews();

//        Integer size = talktopics.getTags().size();

        talktopics.getTags().clear();

        int i = 1; //Used as ID for the tag thing.
        for (String topic : item.getConversationTopics()){
            talktopics.add(new Tag(i, topic));
            i++;
        }
        talktopics.drawTags();

        //Toast.makeText(getContext(), item.getUserImage(), Toast.LENGTH_LONG).show();

        Picasso.with(getContext()).load(item.getUserImage())
                .placeholder(R.drawable.ic_generic_person)
                .error(R.drawable.ic_generic_person)
                .into(userImage);

        Picasso.with(getContext()).load(item.getMapImage())
                .placeholder(R.drawable.ic_generic_map)
                .error(R.drawable.ic_generic_person)
                .into(mapImage);






        return convertView;

    }

    @Override
    public void clear(){

        nearbyItems.clear();
        super.clear();
    }



}
