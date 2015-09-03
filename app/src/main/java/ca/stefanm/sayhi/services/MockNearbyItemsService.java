package ca.stefanm.sayhi.services;

import java.util.ArrayList;
import java.util.UUID;

import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.model.NearbyExtendedItem.ConversationRating;
import ca.stefanm.sayhi.model.NearbyItem;
import ca.stefanm.sayhi.model.PhoneLocation;


/**
 * Created by stefan on 8/9/15.
 */
public class MockNearbyItemsService implements NearbyItemsService {
    //This class is a mock. We just use it to test whether the UI is working.

    private ArrayList<NearbyItem> nearbyItems;

    public MockNearbyItemsService() {

        nearbyItems = new ArrayList<NearbyItem>();
        ArrayList<String> conversationtopics = new ArrayList<String>();
        conversationtopics.add("Computers");
        conversationtopics.add("Stuff");
        conversationtopics.add("Whatever");



        //Insert some dummy data

        nearbyItems.add(new NearbyItem(1, 1, "Boris", conversationtopics, 5, NearbyItem.Distanceunit.METERS, null, null ));
        nearbyItems.add(new NearbyItem(2, 2, "Scott", conversationtopics, 6, NearbyItem.Distanceunit.METERS, null, null ));
        nearbyItems.add(new NearbyItem(3, 3, "Sam", conversationtopics, 7, NearbyItem.Distanceunit.METERS, null, null ));
        nearbyItems.add(new NearbyItem(4, 4, "Rocky", conversationtopics, 8, NearbyItem.Distanceunit.METERS, null, null ));
        nearbyItems.add(new NearbyItem(5, 5, "Bullwinkle", conversationtopics, 3, NearbyItem.Distanceunit.METERS, null, null ));
    }

    @Override
    public ArrayList<NearbyItem> GetNearbyItems(PhoneLocation location) {
        return this.nearbyItems;
    }

    @Override
    public NearbyExtendedItem GetExtendedItem(NearbyItem nearbyitem) {

        ArrayList<String> conversationtopics = new ArrayList<String>();
        conversationtopics.add("Computers");
        conversationtopics.add("Stuff");

        //Create a dummy NearbyItem
        NearbyExtendedItem nei = new NearbyExtendedItem(4, "Rocky", conversationtopics, 8, NearbyItem.Distanceunit.METERS, null, null );
        NearbyExtendedItem.ConversationRating rating = new NearbyExtendedItem.ConversationRating("Vaclav's Pizza", 10, "Great talk");
        nei.addNewRating(rating);

        return nei;

    }

    @Override
    public NearbyExtendedItem GetExtendedItem(UUID uuid) {
        return GetExtendedItem(new NearbyExtendedItem());
    }
}
