package com.example.whatsapphesam.entity;

public class Contact {

    private int imgProfileContact;
    private String tvnameContact;
    private String tvBio;

    public Contact(int imgProfileContact, String tvnameContact, String tvBio) {
        this.imgProfileContact = imgProfileContact;
        this.tvnameContact = tvnameContact;
        this.tvBio = tvBio;
    }

    public int getImgProfileContact() {
        return imgProfileContact;
    }

    public void setImgProfileContact(int imgProfileContact) {
        this.imgProfileContact = imgProfileContact;
    }

    public String getTvnameContact() {
        return tvnameContact;
    }

    public void setTvnameContact(String tvnameContact) {
        this.tvnameContact = tvnameContact;
    }

    public String getTvBio() {
        return tvBio;
    }

    public void setTvBio(String tvBio) {
        this.tvBio = tvBio;
    }
}
