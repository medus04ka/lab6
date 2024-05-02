package common.build.response;

import common.model.HumanBeing;
import common.util.Commands;

import java.util.List;

/**
 * The type Show res.
 */
public class ShowRes extends Response {
    /**
     * The Person.
     */
    public final List<HumanBeing> person;

    /**
     * Instantiates a new Show res.
     *
     * @param person the person
     * @param error  the error
     */
    public ShowRes(List<HumanBeing> person, String error) {
        super(Commands.SHOW, error);
        this.person = person;
    }
}