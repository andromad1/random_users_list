package ua.andromad.testassignmentaxon.response;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("gender")
    private String gender;

    @SerializedName("name")
    private UserName userName;

    @SerializedName("email")
    private String email;

    @SerializedName("dob")
    private DofB dob;

    @SerializedName("phone")
    private String phone;

    @SerializedName("picture")
    private Picture picture;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserName getUserName() {
        return userName;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DofB getDob() {
        return dob;
    }

    public void setDob(DofB dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "User{" +
                "gender='" + gender + '\'' +
                ", userName=" + userName +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", picture=" + picture +
                '}';
    }
}
