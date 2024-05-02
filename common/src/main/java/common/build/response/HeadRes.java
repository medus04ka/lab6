package common.build.response;

import common.model.HumanBeing;
import common.util.Commands;

/**
 * The type Head res.
 */
public class HeadRes extends Response {
    /**
     * The Person.
     */
    public final HumanBeing person;

    /**
     * Instantiates a new Head res.
     *
     * @param person the person
     * @param error  the error
     */
    public HeadRes(HumanBeing person, String error) {
        super(Commands.HEAD, error);
        this.person = person;
    }
}