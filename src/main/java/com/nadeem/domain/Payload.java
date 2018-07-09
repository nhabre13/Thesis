package com.nadeem.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

// Payload is an object that contains the three variables that can be collected by the accelerometer: x-axis, y-axis, z-axis
// TODO: May change the variables depending on the inner workings of the motion API.
@Entity
public class Payload implements Serializable {

    private int x;
    private int y;
    private int z;

    public Payload(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Payload() {
    }

    // getters

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payload)) return false;
        Payload payload = (Payload) o;
        return x == payload.x &&
                y == payload.y &&
                z == payload.z;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, z);
    }
}
