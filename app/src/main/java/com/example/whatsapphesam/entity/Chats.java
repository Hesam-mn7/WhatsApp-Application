package com.example.whatsapphesam.entity;

public class Chats {

    private int imgProfile;
    private String tvname;
    private String tvtext;
    private String tvTime;

    public Chats(int imgProfile, String tvname, String tvtext, String tvTime) {
        this.imgProfile = imgProfile;
        this.tvname = tvname;
        this.tvtext = tvtext;
        this.tvTime = tvTime;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getTvname() {
        return tvname;
    }

    public void setTvname(String tvname) {
        this.tvname = tvname;
    }

    public String getTvtext() {
        return tvtext;
    }

    public void setTvtext(String tvtext) {
        this.tvtext = tvtext;
    }

    public String getTvTime() {
        return tvTime;
    }

    public void setTvTime(String tvTime) {
        this.tvTime = tvTime;
    }
}
