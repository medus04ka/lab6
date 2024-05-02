package common.build.request;

import common.model.HumanBeing;
import common.util.Commands;

/**
 * The type Add req.
 */
public class AddReq extends Request {
    /**
     * The Person.
     */
    public final HumanBeing person;

    /**
     * Instantiates a new Add req.
     *
     * @param humanBeing the human being
     */
    public AddReq(HumanBeing humanBeing) {
         super(Commands.ADD);
         this.person = humanBeing;
        }
    }

