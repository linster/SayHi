package ca.stefanm.sayhi.services.Retrofit;

import android.util.Base64;

import com.squareup.okhttp.OkHttpClient;

import ca.stefanm.sayhi.model.ISayHi;
import retrofit.RequestInterceptor;
import retrofit.client.OkClient;
import retrofit.RestAdapter;

/**
 * Created by stefan on 9/10/15.
 */
public class ServiceGenerator {
    private static RestAdapter.Builder builder = new RestAdapter.Builder().setClient(new OkClient(new OkHttpClient()));

    // No need to instantiate this class.
    private ServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl, String username, String password) {
        // set endpoint url
        builder.setEndpoint(baseUrl);

        if (username != null && password != null) {
            // concatenate username and password with colon for authentication
            final String credentials = username + ":" + password;

            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    // create Base64 encodet string
                    String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Accept", "application/json");
                    request.addHeader("Authorization", string);
                }
            });
        }

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }


    public static <S> S createService(Class<S> serviceClass, String baseUrl, final AccessToken accessToken) {
        // set endpoint url
        builder.setEndpoint(baseUrl);

        if (accessToken != null) {
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept", "application/json");
                    request.addHeader("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken());
                }
            });
        }

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }

    private static ISayHi api = null;
    public static ISayHi getService(){
        if (api == null) {
            api = createService(ISayHi.class, "http://lagoon.stefanm.ca/", "io", "bacon"); //Hardcoded user/pass. Change to use Auth Singleton.
        }
        return api;
    }

}
