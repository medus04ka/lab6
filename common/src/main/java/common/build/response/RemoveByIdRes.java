package common.build.response;

import common.util.Commands;

/**
 * The type Remove by id res.
 */
public class RemoveByIdRes extends Response {
    /**
     * Instantiates a new Remove by id res.
     *
     * @param error the error
     */
    public RemoveByIdRes(String error) {
        super(Commands.REMOVE_BY_ID, error);
    }
}