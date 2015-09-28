package ca.stefanm.sayhi.model.restpojo;


import com.google.gson.annotations.Expose;


public class AverageRating {

    @Expose
    private String CategoryName;
    @Expose
    private double AverageRating;

    /**
     *
     * @return
     * The CategoryName
     */
    public String getCategoryName() {
        return CategoryName;
    }

    /**
     *
     * @param CategoryName
     * The CategoryName
     */
    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    /**
     *
     * @return
     * The AverageRating
     */
    public double getAverageRating() {
        return AverageRating;
    }

    public int getAverageRatingInt() {
        return (int) Math.floor(AverageRating);
    }

    /**
     *
     * @param AverageRating
     * The AverageRating
     */
    public void setAverageRating(double AverageRating) {
        this.AverageRating = AverageRating;
    }

}