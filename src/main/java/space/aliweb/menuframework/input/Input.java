package space.aliweb.menuframework.input;

/**
 * Implement this interface to define an input type with a custom validator.
 *
 * @param <T> the type of object the output results in
 */
public interface Input<T> {
    /**
     * Validates if the user input can be parsed into a valid output.
     *
     * @implNote the method must return {@code null} to indicate the user's input is invalid
     * @param raw the raw string from the user
     * @return a valid object if the input is valid, otherwise null
     */
    T satisfies(String raw);
}
