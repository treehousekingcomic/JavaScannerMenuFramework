import org.junit.Test;
import space.aliweb.menuframework.input.StringInput;
import space.aliweb.menuframework.menu.Menu;
import space.aliweb.menuframework.menu.MenuOptionHandler;
import space.aliweb.menuframework.option.MenuIntegerOption;
import space.aliweb.menuframework.option.MenuStringOption;
import space.aliweb.menuframework.prompt.Prompt;
import space.aliweb.menuframework.prompt.PromptHandler;

public class MainTest {

    @Test
    public void prompt1() {
        Prompt<String, StringInput> prompt = new Prompt<>("Enter a string", true, true,
                new PromptHandler<>(new StringInput(), (raw) -> {})
        );
        String r = prompt.ask();
        System.out.println(r);
    }

    @Test
    public void menu1() {
        MenuOptionHandler<MenuStringOption> mob = new MenuOptionHandler<>(new MenuStringOption("d"), "d", (raw) -> {});

        Menu stringyMenu = new Menu("Test Menu with strings as options", "Enter Option", false,
                new MenuOptionHandler<>(new MenuStringOption("apple"), "Apple", (raw) -> {
                    System.out.println("You like apple juice");
                }),
                new MenuOptionHandler<>(new MenuStringOption("orange"), "Orange", (raw) -> {
                    System.out.println("You like orange juice");
                })
        );
        stringyMenu.addOption(mob);
        stringyMenu.display();
    }

    @Test
    public void menu2() {
        Menu numericalMenu = new Menu("Test Menu with numbers as options", "Enter Option", true,
                new MenuOptionHandler<>(new MenuIntegerOption(0), "Print zero", (raw) -> {
                    System.out.println("0");
                }),
                //The type of MenuOptionBranch must match the menu type (MenuIntegerOption) otherwise error!
                new MenuOptionHandler<MenuIntegerOption>(new MenuIntegerOption(1), "Do something", (raw) -> {
                    System.out.println("Beep Boop Boop Beep");
                }),
                new MenuOptionHandler<>(new MenuIntegerOption(2), "Do something else", (raw) -> {
                    System.out.println("Hi");
                })
        );

        numericalMenu.display();
    }
}
