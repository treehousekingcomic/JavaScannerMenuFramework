package space.aliweb.menuframework.option;

public class MenuIntegerOption extends MenuOption<Integer> {
    protected Integer number;

    public MenuIntegerOption(Integer number) {
        this.number = number;
    }

    @Override
    public Integer getValue() {
        return number;
    }

    @Override
    public boolean is(String raw) {
        try {
            return number.equals(Integer.valueOf(raw));
        } catch (NumberFormatException nfE) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
