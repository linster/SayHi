package ca.stefanm.sayhi.model.restpojo;


import com.google.gson.annotations.Expose;


public class LocationRequestBody {

    @Expose
    private Double lat;
    @Expose
    private Double lon;
    @Expose
    private Double accuracy;

    public LocationRequestBody(Double lat, Double lon, Double accuracy) {
        this.lat = lat;
        this.lon = lon;
        this.accuracy = accuracy;
    }

    /**
     *
     * @return
     * The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     * The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     *
     * @return
     * The accuracy
     */
    public Double getAccuracy() {
        return accuracy;
    }

    /**
     *
     * @param accuracy
     * The accuracy
     */
    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

}