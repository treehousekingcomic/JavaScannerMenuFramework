package space.aliweb.menuframework.input;

public class StringInput implements Input<String> {
    @Override
    public String satisfies(String raw) {
        return raw; /* Every string satisfies the default string prompt */
    }
}
