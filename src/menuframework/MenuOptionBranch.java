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
    protected boolean hidden;
    
    
    public MenuOptionBranch(OptionType identifier, String name, MenuOptionFunction function) {
        this.identifier = identifier;
        this.name = name;
        this.function = function;
        this.hidden = false;
    }
    public MenuOptionBranch(OptionType identifier, String name, boolean hidden, MenuOptionFunction function) {
        this(identifier, name, function);
        this.hidden = hidden;
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
    
    public boolean isHidden() {
        return hidden;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
