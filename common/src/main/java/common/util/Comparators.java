package common.util;
import common.model.HumanBeing;
import java.util.Comparator;

/**
 * The type Comparators.
 */
public class Comparators implements Comparator<HumanBeing> {
    public int compare(HumanBeing a, HumanBeing b){
        return a.getImpactSpeed().compareTo(b.getImpactSpeed());
    }
}
