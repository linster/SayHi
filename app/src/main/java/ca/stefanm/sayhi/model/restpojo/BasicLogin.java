package ca.stefanm.sayhi.model.restpojo;

import com.google.gson.annotations.Expose;
/**
 * Created by stefan on 9/27/15.
 */
public class BasicLogin {

    @Expose
    private String username;
    @Expose
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BasicLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
