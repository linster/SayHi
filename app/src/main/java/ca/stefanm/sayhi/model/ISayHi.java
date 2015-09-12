package ca.stefanm.sayhi.model;

import java.util.List;

import ca.stefanm.sayhi.model.restpojo.AverageRating;
import ca.stefanm.sayhi.model.restpojo.Bizcard;
import ca.stefanm.sayhi.model.restpojo.NearbyResponse;
import ca.stefanm.sayhi.model.restpojo.LocationRequestBody;
import ca.stefanm.sayhi.model.restpojo.Profile;
import ca.stefanm.sayhi.model.restpojo.User;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by stefan on 9/6/15.
 */

/* Interface for REST API */
public interface ISayHi {



    //Have /auth endpoints.

    //mmake a singleton to hold User data
    //write callbacks to store that data into singleton

    @GET("/auth/me/User/")
    void getAuthUserRecord(Callback<User> cb);

    @GET("/auth/me/Profile")
    void getAuthProfileRecord(Callback<Profile> cb);



    @GET("/api/AverageRatings/{userid}/{RatingWho}")
    void getAverageRatings(@Path("userid") long userid, @Path("RatingWho") long RatingWho, Callback<List<AverageRating>> cb);

    @GET("/api/Bizcard/{profileid}")
    void getBizCard(@Path("profileid") long profileid, Callback<Bizcard> cb);

    @POST("/api/Location")
    void logLocation(@Body LocationRequestBody lrb, Callback<List<NearbyResponse>> cb);


}
