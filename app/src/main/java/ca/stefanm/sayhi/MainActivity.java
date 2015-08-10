package ca.stefanm.sayhi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import ca.stefanm.sayhi.adapters.NearbyItemsListAdapter;
import ca.stefanm.sayhi.services.MockNearbyItemsService;
import ca.stefanm.sayhi.services.NearbyItemsService;

public class MainActivity extends Activity {


    NearbyItemsListAdapter nearbyItemsListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up the List Adapter for the ListView on this activity.
        //As a test, use only the MockNearbyItemsService.

        NearbyItemsService nearbyItemsService = new MockNearbyItemsService();

        NearbyItemsListAdapter nila = new NearbyItemsListAdapter(getApplicationContext(),
                R.layout.nearbyitem_listitem,
                nearbyItemsService.GetNearbyItems(null)); //Null Phone location to start with.

        ListView nearbyItemsListView = (ListView)findViewById(R.id.listView);
        nearbyItemsListView.setAdapter(nila);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
