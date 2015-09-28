package ca.stefanm.sayhi.services.EventBusEvents;

import ca.stefanm.sayhi.model.NearbyItem;

/**
 * Created by stefan on 9/27/15.
 */
public class GetExtendedNearbyItemEvent {

    //If you receive this event, call NearbyItemsService.getExtendedItem(this.NearbyItem)

    private final NearbyItem nearbyItem;

    public NearbyItem getNearbyItem() {
        return nearbyItem;
    }

    public GetExtendedNearbyItemEvent(NearbyItem nearbyItem) {
        this.nearbyItem = nearbyItem;
    }
}
