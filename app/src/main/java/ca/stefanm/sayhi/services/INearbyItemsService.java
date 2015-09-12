package ca.stefanm.sayhi.services;

import java.util.ArrayList;
import java.util.UUID;

import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.model.NearbyItem;
import ca.stefanm.sayhi.model.PhoneLocation;
import ca.stefanm.sayhi.model.restpojo.LocationRequestBody;

/**
 * Created by stefan on 8/9/15.
 */
public interface INearbyItemsService {

    //Here we need to do a few things. & Define the interface.

    //Be able to:

    //Send our location to the server, and get back a list of NearbyItems
    public ArrayList<NearbyItem> GetNearbyItems(LocationRequestBody location);


    //Given a NearbyItem, get back a NearbyExtendedItem from the server.
    public NearbyExtendedItem GetExtendedItem(NearbyItem nearbyitem);
    public NearbyExtendedItem GetExtendedItem(UUID uuid);

    //Add GetRating AttributeList... returns a list of things that you can rate by on
    //the extended item view.

    //Add SendRating <K,V> pair.... Sends rating to server.

    //Later

    //Authenticate with the server, say it's us
    //Sign up for a new account by using a REST api to transact.
    // --> Uses Passport.Js on the server-side to login with a bunch of things. THe mock version
    //of the service will just magically authenticate :)

    //Later:
    //Send to the server who is near by using the NearBy Google API

    //Nice to have:
    //Sync up an offline copy of nearby items within a larger radius than normal.
    //So, typically we are always-connected and we can see people nearby. However, we also want
    //so that we can get a list of "Really Close to me" nearby, and cache a "Slightly Further away"
    //list from me so we can still have relevant results if our connection blips off.







}
