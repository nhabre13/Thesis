package com.nadeem.domain;

import com.google.common.hash.Hashing;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

// notifies spring that this class persists in the db
@Entity
// specifying the collection used
@Document(collection = "user")
public class UserData implements Serializable {

    // include all the variables that will be added to the db. These will be gathered from the users in the front end
    // Mongodb have their own unique id, which hashes all the values in the document as one string
    // We'll use the hashed email to identify returning users and correlate data
    private String hashEmail;

    private String model;
    private String os;
    private String environment;
    private String browser;
    private String userAgent;
    private Payload payload;

    public UserData(final String hashEmail,
                    final String model,
                    final String os,
                    final String environment,
                    final String browser,
                    final String userAgent,
                    final Payload payload) {
        this.hashEmail = hashEmail;
        this.model = model;
        this.os = os;
        this.environment = environment;
        this.browser = browser;
        this.userAgent = userAgent;
        this.payload = payload;
    }

    public UserData() {
    }

    public UserData hashData() {
        this.hashEmail =  Hashing.sha256()
                .hashString(hashEmail, StandardCharsets.UTF_8)
                .toString();

        return this;
    }

    // getters

    public String getEnvironment() {
        return environment;
    }

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

    public String getUserAgent() {
        return userAgent;
    }

    public Payload getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserData)) return false;
        UserData userData = (UserData) o;
        return Objects.equals(hashEmail, userData.hashEmail) &&
                Objects.equals(model, userData.model) &&
                Objects.equals(os, userData.os) &&
                Objects.equals(environment, userData.environment) &&
                Objects.equals(browser, userData.browser) &&
                Objects.equals(userAgent, userData.userAgent) &&
                Objects.equals(payload, userData.payload);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hashEmail, model, os, environment, browser, userAgent, payload);
    }
}
