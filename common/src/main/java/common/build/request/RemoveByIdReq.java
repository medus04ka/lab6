package common.build.request;

import common.util.Commands;

/**
 * The type Remove by id req.
 */
public class RemoveByIdReq extends Request {
    /**
     * The Id.
     */
    public final int id;

    /**
     * Instantiates a new Remove by id req.
     *
     * @param id the id
     */
    public RemoveByIdReq(int id) {
        super(Commands.REMOVE_BY_ID);
        this.id = id;
    }
}
