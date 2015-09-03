package ca.stefanm.sayhi;

import android.app.Activity;
import android.os.Bundle;

import ca.stefanm.sayhi.model.NearbyExtendedItem;
import ca.stefanm.sayhi.ui.ExtendedNearbyItemViewFragment;
import ca.stefanm.sayhi.ui.NearbyListFragment;

/**
 * Created by stefan on 8/11/15.
 */
public class ExtendedViewActivity extends Activity {


    ExtendedNearbyItemViewFragment extendedNearbyItemViewFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extendeditemview);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        //if (findViewById(R.id.fragment_container) != null) {

        // However, if we're being restored from a previous state,
        // then we don't need to do anything and should return or else
        // we could end up with overlapping fragments.
        if (savedInstanceState != null) {
            return;
        }


        Bundle args = new Bundle();
        args.putString("EXTENDED_VIEW_UUID", getIntent().getExtras().getString("EXTENDED_VIEW_UUID"));
        extendedNearbyItemViewFragment = new ExtendedNearbyItemViewFragment();
        extendedNearbyItemViewFragment.setArguments(args);

        getFragmentManager().beginTransaction()
                .replace(R.id.container_eifr, extendedNearbyItemViewFragment)
                .commit();

        //}

    }



    //Populate layout
    //On resume, delete all fragments, instantiate new fragment with info, then add to view.
    @Override
    protected void onResume() {
        super.onResume();
        //We have an Intent with our arguments in it. Now we take the UUID in the Intent and make it
        //a Bundle so the fragment can deal with it.



        //extendedNearbyItemViewFragment = new NearbyListFragment();
        //getFragmentManager().beginTransaction().replace()





    }

    //OnPause, need to remove the fragment from the fragment manager so we can set up the arguments
    //again onResume.

    //(Can only setArgs on a Fragment not bound

}
