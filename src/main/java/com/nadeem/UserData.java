package com.nadeem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserData implements Serializable {

    private String hashEmail;
    private String model;
    private String os;
    private String browser;
    private List<Object> payload = new ArrayList<>();

    public UserData(String hashEmail, String model, String os, String browser, Object payload) {
        this.hashEmail = hashEmail;
        this.model = model;
        this.os = os;
        this.browser = browser;
        this.payload.add(payload);
    }

    public UserData() {
    }

    public List<Object> addPayload(final Object payload){
        this.payload.add(payload);

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

    public List<Object> getPayload() {
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
