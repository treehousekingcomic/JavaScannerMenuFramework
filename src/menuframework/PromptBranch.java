/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

/**
 *
 * @author Ali
 */
public class PromptBranch<PromptType extends Promptable> {
    protected PromptType identifier;
    protected MenuOptionFunction function;
    
    
    public PromptBranch(PromptType identifier, MenuOptionFunction function) {
        this.identifier = identifier;
        this.function = function;
    }

    public PromptType getIdentifier() {
        return identifier;
    }

    public MenuOptionFunction getFunction() {
        return function;
    }
}
