package ca.stefanm.sayhi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import ca.stefanm.sayhi.model.ISayHi;
import ca.stefanm.sayhi.model.restpojo.BasicLogin;
import ca.stefanm.sayhi.model.restpojo.Profile;
import ca.stefanm.sayhi.model.restpojo.User;
import ca.stefanm.sayhi.services.CredentialService;
import ca.stefanm.sayhi.services.Retrofit.ServiceGenerator;
import ca.stefanm.sayhi.ui.BasicAuthLoginDialog;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* Setup pacifico font on splash activity */
        TextView tvSayHiLogo = (TextView)findViewById(R.id.SayHiLogo);
        Typeface fntPacifico;
        fntPacifico = Typeface.createFromAsset(getApplicationContext().getResources().getAssets(), "pacifico.ttf");
        tvSayHiLogo.setTypeface(fntPacifico);


        /* Setup image view to have hipster-approved background */
        ImageView ivBackground = (ImageView)findViewById(R.id.splash_bkg);
        Drawable background = null;
        try {
            background = Drawable.createFromStream(getApplicationContext().getResources().getAssets().open("bkgfuzzy.jpg"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ivBackground.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ivBackground.setImageDrawable(background);
        tvSayHiLogo.bringToFront();

        /* Initialize the Credential Service */
        CredentialService cs = CredentialService.getInstance();

        cs.initializeFromSharedPreferences(getSharedPreferences(CredentialService.CRED_FILE, 0));



        /* Set up onClickListeners for the login buttons */
        Button basicLogin = (Button)findViewById(R.id.splash_login_basic);
        basicLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show the basic auth window.
                BasicAuthLoginDialog bald = new BasicAuthLoginDialog();
                bald.show(getFragmentManager(), "BasicAuthLogin");
            }
        });

        Button googleLogin = (Button)findViewById(R.id.splash_login_google);
        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do nothing so far.
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        if (CredentialService.getInstance().getAuthenticated() == true){
            //We are authenticated and we can skip this activity
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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

    @Override
    public void onPause(){
        super.onPause();

        /* Save changes to preferences file */
        CredentialService.getInstance().
                serializeToSharedPreferences(
                        getSharedPreferences(CredentialService.CRED_FILE, 0));
    }

    public void BasicAuthLoginCallback(String username, String password){
        //Called from Basic Auth Login DialogFragment.
        //This is some CMPUT301-level garbage here.

        //Now we can put this in the Credentials Service.
        final CredentialService cs = CredentialService.getInstance();
        cs.setAuthType(CredentialService.AuthTypes.BASIC);
        cs.setCredentials(username, password);

        /* Now do a test on the server to see if credentials were correct */

        ISayHi ish = ServiceGenerator.getService();

        ish.getAuthProfileRecord(new Callback<Profile>() {
            @Override
            public void success(Profile profile, Response response) {
                cs.setMyProfile(profile);
                cs.setAuthenticated(true);
                cs.serializeToSharedPreferences(getSharedPreferences(CredentialService.CRED_FILE, 0));
                Intent i = new Intent(getApplication(), MainActivity.class);
                startActivity(i);

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Retrofit Login Error", error.toString());
                Log.d("Retrofit Login Body", error.getBody().toString());
                Log.d("Retrofit Login", error.getMessage());
                Log.d("Retrofit Login", error.getResponse().toString());
                cs.setAuthenticated(false);
                Toast.makeText(getApplication().getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_SHORT).show();
            }
        });



    }
}