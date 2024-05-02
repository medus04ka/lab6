package common.build.response;

import common.util.Commands;

/**
 * The type Add res.
 */
public class AddRes extends Response {
    /**
     * The New id.
     */
    public final int newId;

    /**
     * Instantiates a new Add res.
     *
     * @param newId the new id
     * @param error the error
     */
    public AddRes(int newId, String error) {
        super(Commands.ADD, error);
        this.newId = newId;
    }
}