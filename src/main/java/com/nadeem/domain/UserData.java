package com.nadeem.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.*;

// notifies spring that this class persists in the db
@Entity
// specifying the collection used
@Document(collection = "user")
public class UserData implements Serializable {

    // include all the variables that will be added to the db. These will be gathered from the users in the front end
    // Mongodb have their own unique id, which hashes all the values in the document as one string
    // We'll use the hashed email to identify returning users and correlate data
    @Id
    private String hashEmail;

    private String model;
    private String os;
    private String browser;
    private Payload payload;

    public UserData(String hashEmail, String model, String os, String browser, Payload payload) {
        this.hashEmail = hashEmail;
        this.model = model;
        this.os = os;
        this.browser = browser;
        this.payload = payload;
    }

    public UserData() {
    }

    // getters

    public String getHashEmail() {
        return hashEmail;
    }

    public String getModel() {
        return model;
    }

    public String getOs() {
        return os;
    }

    public String getBrowser() {
        return browser;
    }

    public Payload getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(hashEmail, userData.hashEmail) &&
                Objects.equals(model, userData.model) &&
                Objects.equals(os, userData.os) &&
                Objects.equals(browser, userData.browser) &&
                Objects.equals(payload, userData.payload);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hashEmail, model, os, browser, payload);
    }
}
