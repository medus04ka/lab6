package common.build.response;

import common.util.Commands;

/**
 * The type Sum of impact speed res.
 */
public class SumOfImpactSpeedRes extends Response {
    /**
     * The Sum.
     */
    public final long sum;

    /**
     * Instantiates a new Sum of impact speed res.
     *
     * @param sum   the sum
     * @param error the error
     */
    public SumOfImpactSpeedRes(long sum, String error) {
        super(Commands.SUM_OF_IMPACT_SPEED, error);
        this.sum = sum;
    }
}