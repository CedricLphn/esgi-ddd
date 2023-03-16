package org.example.domain.model;

import java.util.Objects;
import java.util.UUID;

public class AlimentId {

    private final UUID id;

    public AlimentId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlimentId that = (AlimentId) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
