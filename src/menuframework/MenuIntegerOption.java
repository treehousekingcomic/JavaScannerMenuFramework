/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

/**
 *
 * @author Ali
 */
public class MenuIntegerOption extends MenuOptionType {
    protected Integer number;
    public MenuIntegerOption(Integer number) {
        this.number = number;
    }
    
    @Override
    public Integer getValue() {
        return number;
    }

    @Override
    public boolean is(String raw) {
        try {
            return number.equals(Integer.valueOf(raw));
        } catch (NumberFormatException nfE) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
