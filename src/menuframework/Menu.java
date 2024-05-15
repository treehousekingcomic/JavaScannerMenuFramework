/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

import java.util.Scanner;
import org.fusesource.jansi.Ansi;

/**
 *
 * @author Ali
 */
public class Menu {
    
    public static final String LOOSE_PROMPT_CHARACTER = " > ";
    public static final String STRICT_PROMPT_SYMBOL = " # ";
    
    protected String name;
    protected String prompt;
    protected boolean isAbortable;
    
    protected MenuOptionMap<MenuOptionType> options;
    
    
    
    public Menu(String name, String prompt) {
        this.name = name;
        this.prompt = prompt;
        this.isAbortable = false;
        
        this.options = new MenuOptionMap<>();
        
        
    }
    @SafeVarargs // only reading
    public Menu(String name, String prompt, boolean abortable, MenuOptionBranch<? extends MenuOptionType> ... branches) {
        this.name = name;
        this.prompt = prompt;
        this.isAbortable = abortable;
        
        this.options = new MenuOptionMap<>();
        for (MenuOptionBranch<? extends MenuOptionType> mob : branches) {
            this.options.put(mob.getIdentifier(), mob);
        }
    }

    public MenuOptionMap getOptions() {
        return options;
    }
    public void clearOptions() {
        options.clear();
    }
    public MenuOptionBranch addOption(MenuOptionBranch<? extends MenuOptionType> mob) {
        return options.put(mob.getIdentifier(), mob);
    }
    public MenuOptionBranch removeOption(MenuOptionBranch mob) {
        return options.remove(mob.getIdentifier());
    }
    
    
    public void display() {
        MenuOptionBranch choice = null;
        while (choice == null) {
            System.out.println("\033\143");
            System.out.println(name);
            System.out.println("-".repeat(name.length()));

            for (MenuOptionBranch mob : options.values()) {
                if (mob.isHidden()) continue;
                System.out.println(String.format("[%s] - %s", mob.getIdentifier(), mob.getName()));
            }
            
            String _prompt = prompt + (isAbortable ? LOOSE_PROMPT_CHARACTER : STRICT_PROMPT_SYMBOL);
            System.out.println("-".repeat(_prompt.length()));
            if (isAbortable) {
                System.out.println(""); // Prompt will go here
                System.out.println("Enter < to cancel");
                System.out.println(Ansi.ansi().cursorUp(3));
                System.out.print(_prompt);
            } else {
                System.out.print(_prompt);
            }

            Scanner input = new Scanner(System.in);
            String raw = input.nextLine();
            
            if (isAbortable) {
                System.out.println(Ansi.ansi().cursorDown(0));
                if (raw.strip().equals("<")) {
                    throw new MenuAbortException();
                }
            }

            choice = options.getRaw(raw);
        }
        choice.getFunction().execute();
    }
}
