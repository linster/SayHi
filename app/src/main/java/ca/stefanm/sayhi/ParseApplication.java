package ca.stefanm.sayhi;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

import ca.stefanm.sayhi.services.MagicAPIKeys;

/**
 * Created by Nathan on 2015-11-07.
 */
public class ParseApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, MagicAPIKeys.ParseApplicationID, MagicAPIKeys.ClientKey);
        ParseInstallation.getCurrentInstallation().saveInBackground();

    }
}

