package ca.stefanm.sayhi.ui;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.UUID;

import ca.stefanm.sayhi.ExtendedViewActivity;
import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.adapters.NearbyItemsListAdapter;
import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.model.NearbyItem;
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


        final NearbyItemsService nearbyItemsService = new MockNearbyItemsService();

        NearbyItemsListAdapter nila = new NearbyItemsListAdapter(getActivity(),
                R.layout.nearbyitem_listitem,
                nearbyItemsService.GetNearbyItems(null)); //Null Phone location to start with.

        ListView nearbyItemsListView = (ListView)fragmentView.findViewById(R.id.listView_nearbyItems);
        nearbyItemsListView.setAdapter(nila);
        nearbyItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final NearbyItem nearbyItem = nila.getItem(position);
                final NearbyExtendedItem nei = nearbyItemsService.GetExtendedItem(nearbyItem);
                UUID neiuud = nei.getUniqueitemid();

                Intent intent = new Intent(getActivity(), ExtendedViewActivity.class);
                intent.putExtra("EXTENDEDVIEW_UUID", neiuud);

                startActivity(intent);
            }
        });
        return fragmentView;
    }


}
