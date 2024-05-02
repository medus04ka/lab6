package common.build.response;

/**
 * The type No such command res.
 */
public class NoSuchCommandRes extends Response {
    /**
     * Instantiates a new No such command res.
     *
     * @param name the name
     */
    public NoSuchCommandRes(String name) {
        super(name, "No such command");
    }
}