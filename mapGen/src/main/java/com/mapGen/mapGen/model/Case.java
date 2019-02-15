package com.mapGen.mapGen.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter @Setter
@ToString @EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Case {

    private CaseType type;

    public Case(CaseType type) {
        this.type = type;
    }

    public CaseType getType() {
        return type;
    }

    public String getTexture(){
        switch (type) {
            default:
                return "grass.jpg";

            case FOREST:
                return "forest.jpg";

            case WALL:
                return "wall.jpg";

            case CITY:
                return "city.jpg";

            case WATER:
                return "water.jpg";

            case GRASS:
                return "grass.jpg";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return type == aCase.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
