package ca.stefanm.sayhi.model.restpojo;


import com.google.gson.annotations.Expose;


public class AverageRating {

    @Expose
    private String CategoryName;
    @Expose
    private String AverageRating;

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
    public String getAverageRating() {
        return AverageRating;
    }

    /**
     *
     * @param AverageRating
     * The AverageRating
     */
    public void setAverageRating(String AverageRating) {
        this.AverageRating = AverageRating;
    }

}