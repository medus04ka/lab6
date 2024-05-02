package common.model;

import common.util.Validator;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс кар.
 *
 */
public class Car implements Validator, Serializable {
    private final String name; // Длина строки должна быть не меньше 6, Поле может быть null

    /**
     * Instantiates a new Car.
     *
     * @param zipCode the zip code
     */
    public Car(String zipCode) {
        this.name = zipCode;
    }

    /**
     * Валидирует правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        return name == null;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        common.model.Car address = (common.model.Car) o;
        return Objects.equals(name, address.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Машина " + (name == null ? "" : ", " + name);
    }
}