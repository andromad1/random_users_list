package ua.andromad.testassignmentaxon.response;

import com.google.gson.annotations.SerializedName;

public class DofB {
    @SerializedName("date")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DofB{" +
                "date='" + date + '\'' +
                '}';
    }
}
