package ca.stefanm.sayhi.ui;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.adapters.NearbyItemsListAdapter;
import ca.stefanm.sayhi.services.MockNearbyItemsService;
import ca.stefanm.sayhi.services.NearbyItemsService;

/**
 * Created by stefan on 8/8/15.
 */
public class NearbyListFragment extends Fragment {


    NearbyItemsListAdapter nearbyItemsListAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Set up the List Adapter for the ListView on this activity.
        //As a test, use only the MockNearbyItemsService.

        View fragmentView = inflater.inflate(R.layout.fragment_nearbyitemslist, container, false);


        NearbyItemsService nearbyItemsService = new MockNearbyItemsService();

        NearbyItemsListAdapter nila = new NearbyItemsListAdapter(getActivity(),
                R.layout.nearbyitem_listitem,
                nearbyItemsService.GetNearbyItems(null)); //Null Phone location to start with.

        ListView nearbyItemsListView = (ListView)fragmentView.findViewById(R.id.listView_nearbyItems);
        nearbyItemsListView.setAdapter(nila);

        return fragmentView;
    }


}
