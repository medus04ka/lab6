package common.build.response;

import common.util.Commands;

/**
 * The type Update res.
 */
public class UpdateRes extends Response {
    /**
     * Instantiates a new Update res.
     *
     * @param error the error
     */
    public UpdateRes(String error) {
        super(Commands.UPDATE, error);
    }
}