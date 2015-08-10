package ca.stefanm.sayhi.model;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by stefan on 8/8/15.
 */
public class NearbyItem {


    public NearbyItem(Integer userid, Integer sortQuotient, String nickname, ArrayList<String> conversationtopics, float distance, Distanceunit distanceunit, Image userPicture, Image mapFragment) {
        this.userid = userid;
        this.sortQuotient = sortQuotient;
        this.nickname = nickname;
        this.conversationtopics = conversationtopics;
        this.distance = distance;
        this.distanceunit = distanceunit;
        UserPicture = userPicture;
        MapFragment = mapFragment;
    }

    public NearbyItem(Integer userid, String nickname, ArrayList<String> conversationtopics, float distance, Distanceunit distanceunit, Image userPicture, Image mapFragment) {
        this.userid = userid;
        this.nickname = nickname;
        this.conversationtopics = conversationtopics;
        this.distance = distance;
        this.distanceunit = distanceunit;
        UserPicture = userPicture;
        MapFragment = mapFragment;
    }

    Integer userid;

    /**Used for sorting by magic. This is set on constructor. Server-side does the sorting & algorithm stuff */
    Integer sortQuotient;

    private String nickname;

    private ArrayList<String> conversationtopics;

    private float distance;

    public enum Distanceunit {METERS, FEET, KILOMETERS, MILES};

    private Distanceunit distanceunit;

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


    public Image getUserPicture() {
        return UserPicture;
    }

    public void setUserPicture(Image userPicture) {
        UserPicture = userPicture;
    }

    public Image getMapFragment() {
        return MapFragment;
    }

    public void setMapFragment(Image mapFragment) {
        MapFragment = mapFragment;
    }
}
