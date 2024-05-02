package client.util;

import java.util.Scanner;

/**
 * Отвечает за режим ввода пользовательских данных
 *
 */
public class Interrogator {
    private static Scanner userScanner;
    private static boolean fileMode = false;

    /**
     * Gets user scanner.
     *
     * @return the user scanner
     */
    public static Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Sets user scanner.
     *
     * @param userScanner the user scanner
     */
    public static void setUserScanner(Scanner userScanner) {
        Interrogator.userScanner = userScanner;
    }

    /**
     * File mode boolean.
     *
     * @return the boolean
     */
    public static boolean fileMode() {
        return fileMode;
    }

    /**
     * Sets user mode.
     */
    public static void setUserMode() {
        Interrogator.fileMode = false;
    }

    /**
     * Sets file mode.
     */
    public static void setFileMode() {
        Interrogator.fileMode = true;
    }
}