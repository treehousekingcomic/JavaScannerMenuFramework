/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

/**
 *
 * @author Ali
 */
public class PromptIntegerPromptable implements Promptable<Integer> {
    
    @Override
    public Integer safisfies(String raw) {    
        try {
            return Integer.valueOf(raw);
        } catch (NumberFormatException nfE) {
            return null;
        }
    }
}
