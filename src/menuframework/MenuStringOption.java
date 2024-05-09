/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

/**
 *
 * @author Ali
 */
public class MenuStringOption extends MenuOptionType<String> {
    protected String string;
    public MenuStringOption(String string) {
        this.string = string;
    }
    
    @Override
    public String getValue() {
        return string;
    }

    @Override
    public boolean is(String raw) {
        return string.equalsIgnoreCase(raw);
    }

    @Override
    public String toString() {
        return string;
    }
}
