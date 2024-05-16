/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menuframework;
import org.fusesource.jansi.AnsiConsole;

/**
 *
 * @author Ali
 */
public class MenuFramework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // http://www.angelikalanger.com/GenericsFAQ/FAQSections/ProgrammingIdioms.html :D
        // http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#Topic2
        
        //run(() -> hi()); 
        
        AnsiConsole.systemInstall();
        
        /*
        Prompt<String, PromptStringPromptable> prompt = new Prompt<>("Enter string", true, true, 
                new PromptBranch<>(new PromptStringPromptable(), (raw) -> {})
        );
        String r = prompt.display();
        System.out.println(r);
        */
        
        /*
        MenuOptionBranch<MenuOptionType> mob = new MenuOptionBranch<>(new MenuStringOption("d"), "d", (raw) -> {});
        
        Menu stringyMenu = new Menu("Test Menu with strings as options", "Enter Option", false,
                new MenuOptionBranch<>(new MenuStringOption("apple"), "Apple", (raw) -> {
                    System.out.println("You like apple juice");
                }),
                new MenuOptionBranch<>(new MenuStringOption("orange"), "Orange", (raw) -> {
                    System.out.println("You like orange juice");
                })
        );
        stringyMenu.addOption(mob);
        stringyMenu.display();
        
        // Menu with Integer as its selectable options
        // Because java doesn't allow custom boxing/unboxing a  wrapper class is necessary to wrap classes
        Menu numericalMenu = new Menu("Test Menu with numbers as options", "Enter Option", true,
                new MenuOptionBranch<>(new MenuIntegerOption(0), "Print zero", (raw) -> {
                    System.out.println("0");
                }),
                //The type of MenuOptionBranch must match the menu type (MenuIntegerOption) otherwise error!
                new MenuOptionBranch<MenuIntegerOption>(new MenuIntegerOption(1), "Do something", (raw) -> {
                    System.out.println("Beep Boop Boop Beep");
                }),
                new MenuOptionBranch<>(new MenuIntegerOption(2), "Do something else", (raw) -> {
                    System.out.println("Hi");
                })
        );
        
        numericalMenu.display();
        */
    }
}
