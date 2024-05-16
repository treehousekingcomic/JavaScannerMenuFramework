/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

/**
 *
 * @author Ali
 */
public class PromptStringPromptable implements Promptable<String> {

    @Override
    public String safisfies(String raw) {
        return raw; /* Every string satisfies a String prompt */
    }
    
}
