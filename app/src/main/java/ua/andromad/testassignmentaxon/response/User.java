package ua.andromad.testassignmentaxon.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
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

    protected User(Parcel in) {
        gender = in.readString();
        userName = in.readParcelable(UserName.class.getClassLoader());
        email = in.readString();
        dob = in.readParcelable(DofB.class.getClassLoader());
        phone = in.readString();
        picture = in.readParcelable(Picture.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gender);
        dest.writeParcelable(userName, flags);
        dest.writeString(email);
        dest.writeParcelable(dob, flags);
        dest.writeString(phone);
        dest.writeParcelable(picture, flags);
    }
}
