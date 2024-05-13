/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menuframework;

import java.util.ArrayList;

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
        
        //run(() -> hi());
        
        /*
        
        Menu<MenuStringOption> stringyMenu = new Menu<>("Test Menu with strings as options", "Enter Option",
                new MenuOptionBranch<>(new MenuStringOption("apple"), "Apple", () -> {
                    System.out.println("You like apple juice");
                }),
                new MenuOptionBranch<>(new MenuStringOption("orange"), "Orange", () -> {
                    System.out.println("You like orange juice");
                })
        );
        stringyMenu.display();
       
        
        // Menu with Integer as its selectable options
        // Because java doesn't allow custom boxing/unboxing a  wrapper class is necessary to wrap classes
        Menu<MenuIntegerOption> numericalMenu = new Menu<>("Test Menu with numbers as options", "Enter Option",
                new MenuOptionBranch<>(new MenuIntegerOption(0), "Print zero", () -> {
                    System.out.println("0");
                }),
                //The type of MenuOptionBranch must match the menu type (MenuIntegerOption) otherwise error!
                new MenuOptionBranch<MenuIntegerOption>(new MenuIntegerOption(1), "Do something", () -> {
                    System.out.println("Beep Boop Boop Beep");
                }),
                // The type of MenuOptionBranch declared in the diamond operator must match the datetype of identifier
                // Here, empty diamong operator, if identifier is "2" then error!!!
                new MenuOptionBranch<>(new MenuIntegerOption(2), "Do something else", () -> {
                    System.out.println("Hi");
                })
        );
        
        numericalMenu.display();

        */
    }
}
