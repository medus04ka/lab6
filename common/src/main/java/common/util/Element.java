package common.util;

import java.io.Serializable;

/**
 * The type Element.
 */
public abstract class Element implements Comparable<Element>, Validator, Serializable {
    /**
     * Gets id.
     *
     * @return the id
     */
    abstract public int getId();
}