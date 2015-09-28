package ca.stefanm.sayhi.services.Retrofit;

import com.squareup.okhttp.OkHttpClient;

import retrofit.client.OkClient;

/**
 * Created by stefan on 9/10/15.
 */
public class RestAdapter {

    public static final String API_ENDPOINT = "http://lagoon.stefanm.ca";


    private static RestAdapter restAdapter = new RestAdapter();


    //https://github.com/bkiers/retrofit-oauth
    //https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit

    public static RestAdapter getInstance() {
        if (restAdapter == null){

            retrofit.RestAdapter restAdapter = new retrofit.RestAdapter.Builder()
                    .setEndpoint(API_ENDPOINT)
                    .setClient(new OkClient(new OkHttpClient()))
                    .build();

        }

        return restAdapter;
    }

    private RestAdapter() {
    }
}

//