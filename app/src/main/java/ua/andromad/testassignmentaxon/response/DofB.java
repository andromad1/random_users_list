package ua.andromad.testassignmentaxon.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DofB implements Parcelable {
    @SerializedName("date")
    private String date;

    @SerializedName("age")
    private int age;

    protected DofB(Parcel in) {
        date = in.readString();
        age = in.readInt();
    }

    public static final Creator<DofB> CREATOR = new Creator<DofB>() {
        @Override
        public DofB createFromParcel(Parcel in) {
            return new DofB(in);
        }

        @Override
        public DofB[] newArray(int size) {
            return new DofB[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DofB{" +
                "date='" + date + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeInt(age);
    }
}
