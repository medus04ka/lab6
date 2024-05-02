package common.build.response;

import common.util.Commands;

/**
 * The type Help res.
 */
public class HelpRes extends Response {
    /**
     * The Help message.
     */
    public final String helpMessage;

    /**
     * Instantiates a new Help res.
     *
     * @param helpMessage the help message
     * @param error       the error
     */
    public HelpRes(String helpMessage, String error) {
        super(Commands.HELP, error);
        this.helpMessage = helpMessage;
    }
}