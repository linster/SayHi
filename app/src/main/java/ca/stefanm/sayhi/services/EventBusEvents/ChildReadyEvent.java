package ca.stefanm.sayhi.services.EventBusEvents;

/**
 * Created by stefan on 9/27/15.
 */
public class ChildReadyEvent {

   final String childIdentifer;

    public ChildReadyEvent(String childIdentifer) {
        this.childIdentifer = childIdentifer;
    }

    public String getChildIdentifer() {
        return childIdentifer;
    }

}
