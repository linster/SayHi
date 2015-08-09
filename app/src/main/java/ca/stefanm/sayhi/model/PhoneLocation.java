package ca.stefanm.sayhi.model;

import android.location.Location;

import java.io.Serializable;

/**
 * Created by stefan on 8/9/15.
 */
public class PhoneLocation implements Serializable{

    //Wraps the stock Google Location object. The point is so we can send a bunch of telemetry
    //to the server and not be tied to a particular type of Location Object.

    //(Future revisions can also send along other data, like phones nearby)

    Location location;

    public PhoneLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
