package common.model;

import common.util.Element;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Human being.
 */
public class HumanBeing extends Element {
    @Serial
    private static final long serialVersionUID = 1L;

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private Long impactSpeed; //Максимальное значение поля: 659
    private WeaponType weaponType; //Поле может быть null
    private Mood mood; //Поле не может быть null
    private Car car; //Поле не может быть null

    /**
     * Instantiates a new Human being.
     *
     * @param id           the id
     * @param name         the name
     * @param coordinates  the coordinates
     * @param creationDate the creation date
     * @param realHero     the real hero
     * @param hasToothpick the has toothpick
     * @param impactSpeed  the impact speed
     * @param weaponType   the weapon type
     * @param mood         the mood
     * @param car          the car
     */
    public HumanBeing(int id, String name, Coordinates coordinates, LocalDate creationDate, Boolean realHero, boolean hasToothpick, Long impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;

    }
    /**
     * Валидирует правильность полей.
     * @return true, если все поля корректны, иначе false.
     */
//    @Override
//    public int compareTo(HumanBeing o) {
//        return Double.compare(this.impactSpeed, o.getImpactSpeed());
//    }

    @Override
    public boolean validate() {
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (creationDate == null) return false;
        if (realHero == null) return false;
        if (impactSpeed > 659) return false;
        if (mood == null) return false;
        if (car != null) return false;
        return true;
    }

    /**
     * Update.
     *
     * @param humanBeing the human being
     */
    public void update(HumanBeing humanBeing) {
        this.name = humanBeing.name;
        this.coordinates = humanBeing.coordinates;
        this.realHero = humanBeing.realHero;
        this.hasToothpick = humanBeing.hasToothpick;
        this.impactSpeed = humanBeing.impactSpeed;
        this.weaponType = humanBeing.weaponType;
        this.mood = humanBeing.mood;
        this.car = humanBeing.car;
    }

    // Getters
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Is real hero boolean.
     *
     * @return the boolean
     */
    public Boolean isRealHero() {
        return realHero;
    }

    /**
     * Has toothpick boolean.
     *
     * @return the boolean
     */
    public boolean hasToothpick() {
        return hasToothpick;
    }

    /**
     * Gets impact speed.
     *
     * @return the impact speed
     */
    public Long getImpactSpeed() {
        return impactSpeed;
    }

    /**
     * Gets weapon type.
     *
     * @return the weapon type
     */
    public WeaponType getWeaponType() {
        return weaponType;
    }

    /**
     * Gets mood.
     *
     * @return the mood
     */
    public Mood getMood() {
        return mood;
    }

    /**
     * Gets car.
     *
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanBeing that = (HumanBeing) o;
        return id == that.id && hasToothpick == that.hasToothpick &&
                Long.compare(that.impactSpeed, impactSpeed) == 0 &&
                Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) &&
                Objects.equals(creationDate, that.creationDate) && Objects.equals(realHero, that.realHero) &&
                weaponType == that.weaponType && mood == that.mood && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, weaponType, mood, car);
    }

    @Override
    public String toString() {
        return "HumanBeing #" + id +
                " (created on " + creationDate + ")" +
                "\n Имя убийцы: " + name +
                "\n Местоположение: " + coordinates +
                "\n А он точно убийца??: " + realHero +
                "\n Он Фредди Крюггер?: " + hasToothpick +
                "\n Скорость удара: " + impactSpeed +
                "\n Оружие: " + (weaponType != null ? weaponType : "None") +
                "\n Mood: " + mood +
                "\n МашинА???: " + car;
    }

    @Override
    public int compareTo(Element element) {
        return this.id - element.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

}