package ca.stefanm.sayhi.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by stefan on 9/7/15.
 */
public interface INearbyItem {

    /* Nearby items can be people (with profiles) or paidfor things */
    long getItemId();
    String getNickname();
    String getFriendlyDistance();
    List<String> getConversationTopics();
    String getUserImage();
    String getMapImage();
}
