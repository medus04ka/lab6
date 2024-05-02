package common.build.request;

import common.util.Commands;

/**
 * The type Help req.
 */
public class HelpReq extends Request {
    /**
     * Instantiates a new Help req.
     */
    public HelpReq() {
        super(Commands.HELP);
    }
}