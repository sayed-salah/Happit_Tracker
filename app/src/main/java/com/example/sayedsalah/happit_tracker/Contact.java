package com.example.sayedsalah.happit_tracker;

import java.io.Serializable;

public class Contact implements Serializable {
    private String contactName;
    private int phoneNumber;

    public Contact() {
    }

    public Contact(String contactName, int phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
