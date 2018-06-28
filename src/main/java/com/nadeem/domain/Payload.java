package com.nadeem.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (o == null || getClass() != o.getClass()) return false;
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
