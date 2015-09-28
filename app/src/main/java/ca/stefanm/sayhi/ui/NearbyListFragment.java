package ca.stefanm.sayhi.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.transform.Result;

import ca.stefanm.sayhi.ExtendedViewActivity;
import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.adapters.NearbyItemsListAdapter;
import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.model.NearbyItem;
import ca.stefanm.sayhi.services.EventBusEvents.ChildReadyEvent;
import ca.stefanm.sayhi.services.EventBusEvents.GetExtendedNearbyItemEvent;
import ca.stefanm.sayhi.services.MockNearbyItemsService;
import ca.stefanm.sayhi.services.INearbyItemsService;
import ca.stefanm.sayhi.services.NearbyItemsService;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

/**
 * Created by stefan on 8/8/15.
 */
public class NearbyListFragment extends Fragment {


    private NearbyItemsListAdapter nearbyItemsListAdapter = null;

    private SwipeRefreshLayout swipeContainer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Set up the List Adapter for the ListView on this activity.
        //As a test, use only the MockNearbyItemsService.
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

        View fragmentView = inflater.inflate(R.layout.fragment_nearbyitemslist, container, false);




        final INearbyItemsService nearbyItemsService = new NearbyItemsService();

        final NearbyItemsListAdapter nila = new NearbyItemsListAdapter(getActivity(),
                R.layout.nearbyitem_listitem,
                new ArrayList<NearbyItem>()); //Null Phone location to start with.
        //Load list
        Intent i = new Intent(getActivity(), NearbyItemsService.class);
        ResultReceiver rr = new NearbyListResultReceiver(new Handler());
        i.putExtra("NearbyListResultReceiver", rr);
        getActivity().startService(i);

        Toast.makeText(getActivity(), "Loaded!", Toast.LENGTH_SHORT).show();

        this.nearbyItemsListAdapter = nila; //Get the pointer out to the class.

        ListView nearbyItemsListView = (ListView)fragmentView.findViewById(R.id.listView_nearbyItems);
        nearbyItemsListView.setAdapter(nila);
        nearbyItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final NearbyItem nearbyItem = nila.getItem(position);



                Intent intent = new Intent(getActivity(), ExtendedViewActivity.class);
                startActivity(intent);
                EventBus.getDefault().postSticky(new GetExtendedNearbyItemEvent(nearbyItem));

            }
        });

        swipeContainer = (SwipeRefreshLayout)fragmentView.findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                refreshList();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        return fragmentView;
    }

    //100% WTF. Don't ever do this again.
    //Had to do this because the OnCreate wasn't firing in time to post events.
    public boolean IsExtendedViewActivityReady = false;

    public void onEvent(ChildReadyEvent cre){
        if (cre.getChildIdentifer().equals("ExtendedViewActivity")){
            this.IsExtendedViewActivityReady = true;
        }
    }


    public void refreshList(){
        //The pull-swipe calls this. We need to build a phone location intent and send it to the
        //NearbyItemsService.

        //https://guides.codepath.com/android/Implementing-Pull-to-Refresh-Guide
        // https://developer.android.com/training/run-background-service/send-request.html

        //Send an Intent to the NearbyItemsService with our current location.
        Intent i = new Intent(getActivity(), NearbyItemsService.class);
        ResultReceiver rr = new NearbyListResultReceiver(new Handler());
        i.putExtra("NearbyListResultReceiver", rr);
                getActivity().startService(i);

        Toast.makeText(getActivity(), "Refreshed!", Toast.LENGTH_SHORT).show();
        swipeContainer.setRefreshing(false);

    }

    //http://javatechig.com/android/creating-a-background-service-in-android#7-report-status-from-intentservice-to-activity
    //http://ramdroid.github.io/androiddev/ResultReceiverDemo.html
    public class NearbyListResultReceiver extends ResultReceiver {
        public NearbyListResultReceiver(Handler handler) {
            super(handler);
        }

        protected void onReceiveResult(int resultCode, Bundle resultData) {

            // Can't cast from Object[] to Thing[]
            // NearbyItem[] nia = (NearbyItem[]) resultData.getSerializable("ResultArray");
            Object[] rawresults = resultData.getParcelableArray("ResultArray");
            NearbyItem[] nia = Arrays.copyOf(rawresults, rawresults.length, NearbyItem[].class );

            ArrayList<NearbyItem> nil = new ArrayList<NearbyItem>();

            for (NearbyItem item: nia){
                nil.add(item);
            }

            nearbyItemsListAdapter.clear();
            nearbyItemsListAdapter.addAll(nil);
        }
    }

}
