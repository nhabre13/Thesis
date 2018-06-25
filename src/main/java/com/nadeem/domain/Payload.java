package com.nadeem.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Payload implements Serializable {



    @Id
    private String id;

    public Payload(String id) {
        this.id = id;
    }

    public Payload() {}

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payload payload = (Payload) o;
        return Objects.equals(id, payload.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
