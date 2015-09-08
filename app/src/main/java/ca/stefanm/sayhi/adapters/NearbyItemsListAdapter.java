package ca.stefanm.sayhi.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.ns.developer.tagview.entity.Tag;
import com.ns.developer.tagview.widget.TagCloudLinkView;

import java.util.List;

import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.model.NearbyItem;
import ca.stefanm.sayhi.services.NearbyItemsService;

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
        ImageView mapImage  = (ImageView)convertView.findViewById(R.id.MapFragmentimageView);

        //Now we need to populate the ListItemView
        nickname.setText(item.getNickname());
        //TODO: make this configurable based on global units settings.
        friendlydistance.setText(item.getFriendlyDistance(null));

        //Talk topics. Need to loop over the list of strings and then follow this:
        //https://github.com/namito/TagCloudLinkView

        int i = 1; //Used as ID for the tag thing.
        for (String topic : item.getConversationTopics()){
            talktopics.add(new Tag(i, topic));
            i++;
        }

        userImage.setImageDrawable(item.getUserImage(getContext()));
        mapImage.setImageDrawable(item.getMapImage(getContext()));
        

        return convertView;

    }
}
