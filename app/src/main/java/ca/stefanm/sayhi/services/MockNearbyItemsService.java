package ca.stefanm.sayhi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.model.NearbyItem;
import ca.stefanm.sayhi.model.PhoneLocation;
import ca.stefanm.sayhi.model.restpojo.LocationRequestBody;
import ca.stefanm.sayhi.model.restpojo.Profile;


/**
 * Created by stefan on 8/9/15.
 */
public class MockNearbyItemsService implements INearbyItemsService {
    //This class is a mock. We just use it to test whether the UI is working.

    private ArrayList<NearbyItem> nearbyItems;

    public MockNearbyItemsService() {

        nearbyItems = new ArrayList<NearbyItem>();
        List<String> conversationtopics = new ArrayList<String>();
        conversationtopics.add("Computers");
        conversationtopics.add("Stuff");
        conversationtopics.add("Whatever");



        //Insert some dummy data
        //profileid, bizcardid, chattiness, topics, nickname
        nearbyItems.add(
                new NearbyItem(new Profile(1, 1, 4, conversationtopics , "Boris", null))
        );

        nearbyItems.add(
                new NearbyItem(new Profile(1, 1, 4, conversationtopics , "Scott", null))
        );

        nearbyItems.add(
                new NearbyItem(new Profile(1, 1, 4, conversationtopics , "Sam", null))
        );

        nearbyItems.add(
                new NearbyItem(new Profile(1, 1, 4, conversationtopics , "Rocky", null))
        );
        nearbyItems.add(
                new NearbyItem(new Profile(1, 1, 4, conversationtopics , "Bullwinkle", null))
        );


    }

    @Override
    public ArrayList<NearbyItem> GetNearbyItems(LocationRequestBody location) {
        return this.nearbyItems;
    }

    @Override
    public NearbyExtendedItem GetExtendedItem(NearbyItem nearbyitem) {

        ArrayList<String> conversationtopics = new ArrayList<String>();
        conversationtopics.add("Computers");
        conversationtopics.add("Stuff");

        //Create a dummy NearbyItem
        NearbyExtendedItem nei;
        nei = new NearbyExtendedItem(new Profile(1, 1, 4, conversationtopics , "Bullwinkle", "https://lh6.googleusercontent.com/-H4mAAWPb2m4/AAAAAAAAAAI/AAAAAAAAHDg/0YHNim5UAoQ/photo.jpg?sz=128"), null);


        return nei;

    }

    @Override
    public NearbyExtendedItem GetExtendedItem(UUID uuid) {
        return GetExtendedItem(new NearbyExtendedItem());
    }
}
