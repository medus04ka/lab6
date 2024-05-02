package client.util.console;

/**
 * Консоль для ввода команд и вывода результата
 *
 */
public interface Cons {
    /**
     * Print.
     *
     * @param obj the obj
     */
    void print(Object obj);

    /**
     * Println.
     *
     * @param obj the obj
     */
    void println(Object obj);

    /**
     * Print error.
     *
     * @param obj the obj
     */
    void printError(Object obj);

    /**
     * Print table.
     *
     * @param obj1 the obj 1
     * @param obj2 the obj 2
     */
    void printTable(Object obj1, Object obj2);

    /**
     * Ps 1.
     */
    void ps1();

    /**
     * Ps 2.
     */
    void ps2();

    /**
     * Gets ps 1.
     *
     * @return the ps 1
     */
    String getPS1();

    /**
     * Gets ps 2.
     *
     * @return the ps 2
     */
    String getPS2();
}