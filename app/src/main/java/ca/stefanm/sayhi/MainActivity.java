package ca.stefanm.sayhi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import ca.stefanm.sayhi.adapters.NearbyItemsListAdapter;
import ca.stefanm.sayhi.services.MockNearbyItemsService;
import ca.stefanm.sayhi.services.NearbyItemsService;
import ca.stefanm.sayhi.ui.NearbyListFragment;

public class MainActivity extends AppCompatActivity {


    NearbyItemsListAdapter nearbyItemsListAdapter = null;
    NearbyListFragment nearbyListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        setContentView(R.layout.activity_main);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        //if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            nearbyListFragment = new NearbyListFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, nearbyListFragment)
                    .commit();


        //}

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
