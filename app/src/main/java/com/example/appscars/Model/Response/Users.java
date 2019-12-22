package com.example.appscars.Model.Response;

import com.google.gson.annotations.SerializedName;

public class Users {
    @SerializedName("userPhoto")
    private String userPhoto;

    @SerializedName("Address")
    private String address;

    @SerializedName("FBID")
    private String fBID;

    @SerializedName("userPhone")
    private String userPhone;

    @SerializedName("UserPassword")
    private String userPassword;

    @SerializedName("userName")
    private String userName;

    @SerializedName("UserEmail")
    private String userEmail;

    public void setUserPhoto(String userPhoto){
        this.userPhoto = userPhoto;
    }

    public String getUserPhoto(){
        return userPhoto;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setFBID(String fBID){
        this.fBID = fBID;
    }

    public String getFBID(){
        return fBID;
    }

    public void setUserPhone(String userPhone){
        this.userPhone = userPhone;
    }

    public String getUserPhone(){
        return userPhone;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    public String getUserPassword(){
        return userPassword;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    public String getUserEmail(){
        return userEmail;
    }

    @Override
    public String toString(){
        return
                "CAR{" +
                        "userPhoto = '" + userPhoto + '\'' +
                        ",address = '" + address + '\'' +
                        ",fBID = '" + fBID + '\'' +
                        ",userPhone = '" + userPhone + '\'' +
                        ",userPassword = '" + userPassword + '\'' +
                        ",userName = '" + userName + '\'' +
                        ",userEmail = '" + userEmail + '\'' +
                        "}";
    }
}
