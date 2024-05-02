package common.build.response;

import common.util.Commands;

/**
 * The type Info res.
 */
public class InfoRes extends Response {
    /**
     * The Info message.
     */
    public final String infoMessage;

    /**
     * Instantiates a new Info res.
     *
     * @param infoMessage the info message
     * @param error       the error
     */
    public InfoRes(String infoMessage, String error) {
        super(Commands.INFO, error);
        this.infoMessage = infoMessage;
    }
}