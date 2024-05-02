package common.build.request;

import common.model.HumanBeing;
import common.util.Commands;

/**
 * The type Update req.
 */
public class UpdateReq extends Request {
    /**
     * The ID.
     */
    public final int id;
    /**
     * The Updated person.
     */
    public final HumanBeing updatedPerson;

    /**
     * Instantiates a new Update req.
     *
     * @param id            the id
     * @param updatedPerson the updated person
     */
    public UpdateReq(int id, HumanBeing updatedPerson) {
        super(Commands.UPDATE);
        this.id = id;
        this.updatedPerson = updatedPerson;
    }
}
