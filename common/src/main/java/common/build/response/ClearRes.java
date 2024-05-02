package common.build.response;

import common.util.Commands;

/**
 * The type Clear res.
 */
public class ClearRes extends Response {
    /**
     * Instantiates a new Clear res.
     *
     * @param error the error
     */
    public ClearRes(String error) {
        super(Commands.CLEAR, error);
    }
}