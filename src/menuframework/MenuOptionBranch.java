/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

/**
 *
 * @author Ali
 */
public class MenuOptionBranch<OptionType extends MenuOptionType> {
    protected OptionType identifier;
    protected String name;
    protected MenuOptionFunction function;
    
    public MenuOptionBranch(OptionType identifier, String name, MenuOptionFunction function) {
        this.identifier = identifier;
        this.name = name;
        this.function = function;
    }

    public OptionType getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public MenuOptionFunction getFunction() {
        return function;
    }
}
