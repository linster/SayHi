package ca.stefanm.sayhi.model;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by stefan on 8/8/15.
 */
public class NearbyItem {

    public NearbyItem(Integer userid, String nickname, ArrayList<String> conversationtopics, float distance, Distanceunit distanceunit, Image userPicture, Image mapFragment) {
        this.userid = userid;
        this.nickname = nickname;
        this.conversationtopics = conversationtopics;
        this.distance = distance;
        UserPicture = userPicture;
        MapFragment = mapFragment;
    }

    public NearbyItem(Integer userid, String nickname, ArrayList<String> conversationtopics, float distance, Distanceunit distanceunit) {
        this.userid = userid;
        this.nickname = nickname;
        this.conversationtopics = conversationtopics;
        this.distance = distance;
    }

    Integer userid;

    private String nickname;

    private ArrayList<String> conversationtopics;

    private float distance;

    public static enum Distanceunit {METERS, FEET, KILOMETERS, MILES};
    private String friendlydistance;

    Image UserPicture;
    Image MapFragment;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ArrayList<String> getConversationtopics() {
        return conversationtopics;
    }

    public void setConversationtopics(ArrayList<String> conversationtopics) {
        this.conversationtopics = conversationtopics;
    }


    //Todo: Make Friendly distance unit-agnostic, and return nice things.
    //Meanwhile, just use metric units.

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance, Distanceunit u) {
        this.distance = distance;
    }

    public String getFriendlydistance(Distanceunit u) {
        return friendlydistance;
    }


}
