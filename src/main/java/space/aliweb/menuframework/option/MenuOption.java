package space.aliweb.menuframework.option;

public abstract class MenuOption<T> {
    public abstract T getValue();
    public abstract boolean is(String raw);
}
