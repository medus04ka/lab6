package common.model;

import java.io.Serializable;

/**
 * The enum Mood.
 */
public enum Mood implements Serializable {
    /**
     * Sadness mood.
     */
    SADNESS,
    /**
     * Longing mood.
     */
    LONGING,
    /**
     * Gloom mood.
     */
    GLOOM,
    /**
     * Calm mood.
     */
    CALM,
    /**
     * Rage mood.
     */
    RAGE;

    /**
     * Names string.
     *
     * @return the string
     */
    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var weaponType : values()) {
            nameList.append(weaponType.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
