package space.aliweb.menuframework.menu;

import org.fusesource.jansi.Ansi;
import space.aliweb.menuframework.option.MenuOption;
import static space.aliweb.menuframework.Config.LOOSE_PROMPT_SYMBOL;
import static space.aliweb.menuframework.Config.STRICT_PROMPT_SYMBOL;
import static space.aliweb.menuframework.Config.clearScreen;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    protected String name;
    protected String prompt;
    protected boolean abortable;

    protected MenuOptionMap<MenuOption<?>> options;

    public Menu(String name, String prompt) {
        this.name = name;
        this.prompt = prompt;
        this.abortable = false;

        this.options = new MenuOptionMap<>();
    }

    @SafeVarargs
    public Menu(String name, String prompt, boolean abortable, MenuOptionHandler<? extends MenuOption<?>> ... branches) {
        this.name = name;
        this.prompt = prompt;
        this.abortable = abortable;

        this.options = new MenuOptionMap<>();
        for (MenuOptionHandler<? extends MenuOption<?>> mob : branches) {
            this.options.put(mob.getOptionDefinition(), mob);
        }
    }

    public MenuOptionMap<? extends MenuOption<?>> getOptions() {
        return options;
    }
    public void clearOptions() {
        options.clear();
    }
    public MenuOptionHandler<? extends MenuOption<?>> addOption(MenuOptionHandler<? extends MenuOption<?>> mob) {
        return options.put(mob.getOptionDefinition(), mob);
    }
    public MenuOptionHandler<?> removeOption(MenuOptionHandler<?> mob) {
        return options.remove(mob.getOptionDefinition());
    }

    public void display() {
        String raw = null;
        MenuOptionHandler handler = null;
        while (handler == null) {
            clearScreen();
            System.out.println(name);
            System.out.println("-".repeat(name.length()));

            for (MenuOptionHandler mob : options.values()) {
                if (mob.isHidden()) {
                    continue;
                }
                System.out.println(String.format("[%s] - %s", mob.getOptionDefinition(), mob.getName()));
            }

            String _prompt = prompt + (abortable ? LOOSE_PROMPT_SYMBOL : STRICT_PROMPT_SYMBOL);
            System.out.println("-".repeat(_prompt.length()));
            if (abortable) {
                System.out.println(); // Prompt will go here
                System.out.println("Enter < to cancel");
                System.out.println(Ansi.ansi().cursorUp(3));
                System.out.print(_prompt);
            } else {
                System.out.print(_prompt);
            }

            Scanner input = new Scanner(System.in);
            try {
                raw = input.nextLine();
            }
            catch (NoSuchElementException nseE) {
                continue;
            }

            if (abortable) {
                System.out.println(Ansi.ansi().cursorDown(0));
                if (raw.strip().equals("<")) {
                    throw new MenuAbortedException();
                }
            }

            handler = options.getRaw(raw);
        }
        handler.getAction().execute(raw);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrompt() {
        return prompt;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    public boolean isAbortable() {
        return abortable;
    }
    public void setAbortable(boolean isAbortable) {
        this.abortable = isAbortable;
    }
}
