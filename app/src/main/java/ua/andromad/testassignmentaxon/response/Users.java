package ua.andromad.testassignmentaxon.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Users {
    @SerializedName("results")
    private List<User> lstUsers = new ArrayList<>();

    public List<User> getLstUsers() {
        return lstUsers;
    }

    public void setLstUsers(List<User> lstUsers) {
        this.lstUsers = lstUsers;
    }

    @Override
    public String toString() {
        return "Users{" +
                "lstUsers=" + lstUsers +
                '}';
    }
}
