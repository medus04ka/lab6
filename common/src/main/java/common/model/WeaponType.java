package common.model;

import java.io.Serializable;

/**
 * The enum Weapon type.
 */
public enum WeaponType implements Serializable {
    /**
     * Axe weapon type.
     */
    AXE,
    /**
     * Shotgun weapon type.
     */
    SHOTGUN,
    /**
     * Rifle weapon type.
     */
    RIFLE,
    /**
     * Knife weapon type.
     */
    KNIFE,
    /**
     * Machine gun weapon type.
     */
    MACHINE_GUN;

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
