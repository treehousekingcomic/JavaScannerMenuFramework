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
    
    protected boolean positiveOnly;
    
    public PromptIntegerPromptable() {
        this.positiveOnly = false;
    }
    public PromptIntegerPromptable(boolean positiveOnly) {
        this.positiveOnly = positiveOnly;
    }
    
    @Override
    public Integer safisfies(String raw) {    
        try {
            Integer integer = Integer.valueOf(raw);
            if (positiveOnly && integer < 0) return null;
            return integer;
        } catch (NumberFormatException nfE) {
            return null;
        }
    }
}
