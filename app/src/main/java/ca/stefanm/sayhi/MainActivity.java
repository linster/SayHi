package ca.stefanm.sayhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseObject;

import ca.stefanm.sayhi.adapters.NearbyItemsListAdapter;
import ca.stefanm.sayhi.services.CredentialService;
import ca.stefanm.sayhi.ui.LocationDebugDialog;
import ca.stefanm.sayhi.ui.LoginDebugDialog;
import ca.stefanm.sayhi.ui.NearbyListFragment;


public class MainActivity extends AppCompatActivity {


    //https://guides.codepath.com/android/Implementing-Pull-to-Refresh-Guide

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

        /* Initialize the Credential Service */
        CredentialService cs = CredentialService.getInstance();

        cs.initializeFromSharedPreferences(getSharedPreferences(CredentialService.CRED_FILE, 0));


        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();



        if (cs.getAuthenticated() == false){
            Intent i = new Intent(this, SplashActivity.class);
            startActivity(i);
        }


            nearbyListFragment = new NearbyListFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, nearbyListFragment)
                    .commit();


        //}

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (CredentialService.getInstance().getAuthenticated() == false){
            Intent i = new Intent(this, SplashActivity.class);
            startActivity(i);
        }
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

        switch (id) {
            case R.id.action_logout:
                CredentialService cs = CredentialService.getInstance();
                cs.Logout(getSharedPreferences(CredentialService.CRED_FILE, 0));
                Intent i = new Intent(this, SplashActivity.class);
                startActivity(i);
                break;
            case R.id.menu_locationdebug:
                LocationDebugDialog ldd = new LocationDebugDialog();
                ldd.show(getFragmentManager(), "LDD");
                break;
            case R.id.menu_logindebug:
                LoginDebugDialog lodd = new LoginDebugDialog();
                lodd.show(getFragmentManager(), "LODD");
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
