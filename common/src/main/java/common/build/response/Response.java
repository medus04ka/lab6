package common.build.response;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Response.
 */
public abstract class Response implements Serializable {
    private final String name;
    private final String error;

    /**
     * Instantiates a new Response.
     *
     * @param name  the name
     * @param error the error
     */
    public Response(String name, String error) {
        this.name = name;
        this.error = error;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(name, response.name) && Objects.equals(error, response.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, error);
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}