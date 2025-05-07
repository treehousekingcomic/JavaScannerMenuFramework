package space.aliweb.menuframework.option;

public class MenuStringOption extends MenuOption<String> {
    protected String string;

    public MenuStringOption(String string) {
        this.string = string;
    }

    @Override
    public String getValue() {
        return string;
    }

    @Override
    public boolean is(String raw) {
        return string.equalsIgnoreCase(raw.strip());
    }

    @Override
    public String toString() {
        return string;
    }
}
