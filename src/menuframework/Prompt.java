/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuframework;

import java.util.NoSuchElementException;
import java.util.Scanner;
import static menuframework.Menu.LOOSE_PROMPT_CHARACTER;
import static menuframework.Menu.STRICT_PROMPT_SYMBOL;
import org.fusesource.jansi.Ansi;

/**
 *
 * @author Ali
 */
public class Prompt<ObjectType, PromptType extends Promptable<ObjectType>> {
    public static final String LOOSE_PROMPT_CHARACTER = " > ";
    public static final String STRICT_PROMPT_SYMBOL = " # ";
    
    protected String prompt;
    protected boolean isAbortable;
    protected boolean clearSreen;
    
    protected PromptBranch<PromptType> branch;
    
    public Prompt(String prompt, boolean abortable, boolean clearScreen, PromptBranch<PromptType> branch) {
        this.prompt = prompt;
        this.isAbortable = abortable;
        this.clearSreen = clearScreen;
        
        this.branch = branch;
    }
    
    public String getPrompt() {
        return prompt;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    public PromptBranch<? extends Promptable> getBranch() {
        return branch;
    }
    public void setBranch(PromptBranch<PromptType> branch) {
        this.branch = branch;
    }
    
    public ObjectType ask() {
        String raw = null;
        ObjectType result = null;
        PromptBranch choice = null;
        while (choice == null) {
            if (clearSreen) System.out.print("\033\143");
            
            String _prompt = prompt + (isAbortable ? LOOSE_PROMPT_CHARACTER : STRICT_PROMPT_SYMBOL);
            System.out.println("-".repeat(_prompt.length()));
            if (isAbortable) {
                System.out.println(""); // Prompt will go here
                System.out.println("Enter < to cancel");
                System.out.println(Ansi.ansi().cursorUp(3));
                System.out.print(_prompt);
            } else {
                System.out.print(_prompt);
            }

            Scanner input = new Scanner(System.in);
            try {
                raw = input.nextLine();
            }
            catch (NoSuchElementException nseE) {
                continue;
            }
            
            if (isAbortable) {
                System.out.println(Ansi.ansi().cursorDown(0));
                if (raw.strip().equals("<")) {
                    throw new PromptAbortException();
                }
            }
            
            result = branch.getIdentifier().safisfies(raw);
            if (result != null) {
                choice = branch;
            }
        }
        choice.getFunction().execute(raw);
        return result;
    }
    
}
