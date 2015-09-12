package ca.stefanm.sayhi.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.nearby.Nearby;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ca.stefanm.sayhi.model.ISayHi;
import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.model.NearbyItem;
import ca.stefanm.sayhi.model.PhoneLocation;
import ca.stefanm.sayhi.model.restpojo.LocationRequestBody;
import ca.stefanm.sayhi.model.restpojo.NearbyResponse;
import ca.stefanm.sayhi.services.Retrofit.ServiceGenerator;
import ca.stefanm.sayhi.ui.NearbyListFragment;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by stefan on 9/6/15.
 */
public class NearbyItemsService extends IntentService implements INearbyItemsService  {

    private static final int RESULT_GOOD = 1;
    private ISayHi api = ServiceGenerator.getService();
    private ResultReceiver rr = null;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public NearbyItemsService(String name) {
        super(name);
    }

    public NearbyItemsService(){
        super("NearbyItemService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //Unpack the result receiver from the extras so we can populate our result list in there.
        this.rr = intent.getParcelableExtra("NearbyListResultReceiver");

        //Get a Location Changed intent going in here and do magic.
        GetNearbyItems(null);
    }


    @Override
    public ArrayList<NearbyItem> GetNearbyItems(LocationRequestBody location) {
        location = new LocationRequestBody(53.521705, -113.594349, 12.0); //TODO get rid of this once gps works.
        api.logLocation(location, new Callback<List<NearbyResponse>>() {
            @Override
            public void success(List<NearbyResponse> nearbyResponses, Response response) {
                //Go through the fragment, get the list adapter instance, update the list.
                Toast.makeText(getApplicationContext(), "Number of items returned: " + nearbyResponses.size(), Toast.LENGTH_SHORT).show();
                // http://stackoverflow.com/questions/10334901/how-to-get-results-from-an-intentservice-back-into-an-activity
                //In the fragment have a result receiver.
                /* NearbyListFragment.getListAdapter().clear();

                //Build the nearbyResponse into a NearbyItem. They could be different in the future.
                for (NearbyResponse nr : nearbyResponses){
                    NearbyItem nbi = NearbyItem.buildNearbyItem(nr);
                    NearbyListFragment.getListAdapter().add(nbi);
                }*/
                List<NearbyItem> nearbyItems = new ArrayList<NearbyItem>();
                for (NearbyResponse nr: nearbyResponses){
                    NearbyItem nbi = NearbyItem.buildNearbyItem(nr);
                    nearbyItems.add(nbi);
                }

                NearbyItem[] arrNearbyItems = new NearbyItem[nearbyItems.size()];
                arrNearbyItems = nearbyItems.toArray(arrNearbyItems);


                Bundle resultdata = new Bundle();
                resultdata.putParcelableArray("ResultArray", arrNearbyItems);
                rr.send(RESULT_GOOD, resultdata);



            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "API Request Error: GetNearbyItems", Toast.LENGTH_SHORT).show();
                Log.e("GetNearbyItems", "In api.loglocation failure callback");
            }
        });
        return null;
    }

    @Override
    public NearbyExtendedItem GetExtendedItem(NearbyItem nearbyitem) {
        return null;
    }

    @Override
    public NearbyExtendedItem GetExtendedItem(UUID uuid) {
        return null;
    }



    ////https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
    ////Write all the API consumption code here.


}
