package ua.andromad.testassignmentaxon.response;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Users {
    @SerializedName("results")
    private User[] arrUsers;

    public User[] getArrUsers() {
        return arrUsers;
    }

    public void setArrUsers(User[] arrUsers) {
        this.arrUsers = arrUsers;
    }

    @Override
    public String toString() {
        return "Users{" +
                "arrUsers=" + Arrays.toString(arrUsers) +
                '}';
    }
}
