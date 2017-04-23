package es.iessaladillo.pedrojoya.fct.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    // TODO
    private String firstname;
    private String sirname;
    private String phonenumber;
    private String address;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // TODO
    public Student(String firstname, String sirname) {
        this.firstname = firstname;
        this.sirname = sirname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstname);
        dest.writeString(this.sirname);
        dest.writeString(this.phonenumber);
        dest.writeString(this.address);
    }

    protected Student(Parcel in) {
        this.firstname = in.readString();
        this.sirname = in.readString();
        this.phonenumber = in.readString();
        this.address = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

}
