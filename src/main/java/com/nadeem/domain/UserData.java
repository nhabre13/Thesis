package com.nadeem.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.*;

@Entity
public class UserData implements Serializable {

    @Id
    private String hashEmail;

    private String model;
    private String os;
    private String browser;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Payload> payload = new HashSet<>();

    public UserData(String hashEmail, String model, String os, String browser, Payload payload) {
        this.hashEmail = hashEmail;
        this.model = model;
        this.os = os;
        this.browser = browser;
        this.payload.add(payload);
    }

    public UserData() {
    }

    public Set<Payload> addPayload(final Set<Payload> payload){
        this.payload.addAll(payload);

        return this.payload;
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

    public Set<Payload> getPayload() {
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
