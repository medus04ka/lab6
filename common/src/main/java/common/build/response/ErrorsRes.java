package common.build.response;

/**
 * The type Errors res.
 */
public class ErrorsRes extends Response {
    /**
     * Instantiates a new Errors res.
     *
     * @param error the error
     */
    public ErrorsRes(String error) {
        super("error", error);
    }
}