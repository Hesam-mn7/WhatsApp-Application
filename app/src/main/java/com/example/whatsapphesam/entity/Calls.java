package com.example.whatsapphesam.entity;

public class Calls {

    private int imgProfileCall;
    private String tvnameCall;
    private String tvtimeCall;
    private String stateCall;
    private String stateVideoOrCall;

    public Calls(int imgProfileCall, String tvnameCall, String tvtimeCall, String stateCall, String stateVideoOrCall) {
        this.imgProfileCall = imgProfileCall;
        this.tvnameCall = tvnameCall;
        this.tvtimeCall = tvtimeCall;
        this.stateCall = stateCall;
        this.stateVideoOrCall = stateVideoOrCall;
    }

    public int getImgProfileCall() {
        return imgProfileCall;
    }

    public void setImgProfileCall(int imgProfileCall) {
        this.imgProfileCall = imgProfileCall;
    }

    public String getTvnameCall() {
        return tvnameCall;
    }

    public void setTvnameCall(String tvnameCall) {
        this.tvnameCall = tvnameCall;
    }

    public String getTvtimeCall() {
        return tvtimeCall;
    }

    public void setTvtimeCall(String tvtimeCall) {
        this.tvtimeCall = tvtimeCall;
    }

    public String getStateCall() {
        return stateCall;
    }

    public void setStateCall(String stateCall) {
        this.stateCall = stateCall;
    }

    public String getStateVideoOrCall() {
        return stateVideoOrCall;
    }

    public void setStateVideoOrCall(String stateVideoOrCall) {
        this.stateVideoOrCall = stateVideoOrCall;
    }
}
