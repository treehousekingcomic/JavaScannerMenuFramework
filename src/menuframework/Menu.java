/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

import java.util.Scanner;

/**
 *
 * @author Ali
 */
public class Menu<OptionType extends MenuOptionType> {
    
    public static final String LOOSE_PROMPT_CHARACTER = " > ";
    public static final String STRICT_PROMPT_SYMBOL = " # ";
    
    protected String name;
    protected String prompt;
    
    protected MenuOptionMap<OptionType> options;
    
    
    public Menu(String name, String prompt) {
        this.name = name;
        this.prompt = prompt;
        
        this.options = new MenuOptionMap<>();
    }
    @SafeVarargs // only reading
    public Menu(String name, String prompt, MenuOptionBranch<OptionType>... branches) {
        this.name = name;
        this.prompt = prompt;
        
        this.options = new MenuOptionMap<>();
        for (MenuOptionBranch<OptionType> mob : branches) {
            this.options.put(mob.getIdentifier(), mob);
        }
    }

    public MenuOptionMap<OptionType> getOptions() {
        return options;
    }
    public void clearOptions() {
        options.clear();
    }
    public MenuOptionBranch<OptionType> addOption(MenuOptionBranch<OptionType> mob) {
        return options.put(mob.getIdentifier(), mob);
    }
    public MenuOptionBranch<OptionType> removeOption(MenuOptionBranch<OptionType> mob) {
        return options.remove(mob.getIdentifier());
    }
    
    
    public void display() {
        MenuOptionBranch<OptionType> choice = null;
        while (choice == null) {
            System.out.println("*TODO* CLEAR SCREEN" + "\n".repeat(5));
            System.out.println(name);
            System.out.println("-".repeat(name.length()));

            for (MenuOptionBranch<OptionType> mob : options.values()) {
                System.out.println(String.format("[%s] - %s", mob.getIdentifier(), mob.getName()));
            }
            
            String _prompt = prompt + LOOSE_PROMPT_CHARACTER;
            System.out.println("-".repeat(_prompt.length()));
            System.out.print(_prompt);

            Scanner input = new Scanner(System.in);
            String raw = input.nextLine();

            choice = options.getRaw(raw);
        }
        choice.getFunction().execute();
    }
}
