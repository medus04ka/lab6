package common.model;

import common.util.Validator;

import java.io.Serializable;
import java.util.Objects;

/**
 * Классс координат.
 *
 */
public class Coordinates implements Validator, Serializable {
    private final Integer x; // Поле не может быть null
    private final Long y; // Поле не может быть null

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinates (Integer x, Long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Валидирует правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if (x == null) return false;
        return y != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}