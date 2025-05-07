package space.aliweb.menuframework.prompt;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static space.aliweb.menuframework.Config.LOOSE_PROMPT_SYMBOL;
import static space.aliweb.menuframework.Config.STRICT_PROMPT_SYMBOL;
import static space.aliweb.menuframework.Config.clearScreen;

import org.fusesource.jansi.Ansi;
import space.aliweb.menuframework.input.Input;

public class Prompt<OutputType, PromptType extends Input<OutputType>> {

    protected String prompt;
    protected boolean abortable;
    protected boolean clearScreen;

    protected PromptHandler<PromptType> handler;

    public Prompt(String prompt, boolean abortable, boolean clearScreen, PromptHandler<PromptType> handler) {
        this.prompt = prompt;
        this.abortable = abortable;
        this.clearScreen = clearScreen;

        this.handler = handler;
    }

    public OutputType ask() {
        String raw = null;
        OutputType result = null;

        int tries = 0;
        while (result == null) {
            if (clearScreen) {
                clearScreen();
            }

            if (tries != 0) {
                System.out.println("Invalid input entered");
            }
            tries++;

            String _prompt = prompt + (abortable ? LOOSE_PROMPT_SYMBOL : STRICT_PROMPT_SYMBOL);
            System.out.println("-".repeat(_prompt.length()));

            if (abortable) {
                System.out.println(); // Prompt will go here
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

            if (abortable) {
                System.out.println(Ansi.ansi().cursorDown(0));
                if (raw.strip().equals("<")) {
                    throw new PromptAbortedException();
                }
            }

            result = handler.getInputDefinition().satisfies(raw);
        }
        handler.getAction().execute(raw);
        return result;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public PromptHandler<PromptType> getHandler() {
        return handler;
    }

    public void setBranch(PromptHandler<PromptType> handler) {
        this.handler = handler;
    }
}
