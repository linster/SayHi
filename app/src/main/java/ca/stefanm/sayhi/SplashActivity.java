package ca.stefanm.sayhi;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

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
}
