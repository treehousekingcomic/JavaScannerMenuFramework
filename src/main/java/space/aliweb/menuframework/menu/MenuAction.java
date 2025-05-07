package space.aliweb.menuframework.menu;

@FunctionalInterface
public interface MenuAction {
    void execute(String raw);
}
