package org.example.domain.vo;

import java.util.Objects;
import java.util.UUID;

public class ProgrammeId {

        private final UUID id;

        public ProgrammeId() {
            this.id = UUID.randomUUID();
        }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammeId that = (ProgrammeId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
