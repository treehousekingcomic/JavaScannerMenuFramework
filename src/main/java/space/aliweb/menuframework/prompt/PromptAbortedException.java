package space.aliweb.menuframework.prompt;

import space.aliweb.menuframework.menu.MenuException;

public class PromptAbortedException extends MenuException {
    public PromptAbortedException() {
    }

    public PromptAbortedException(String message) {
        super(message);
    }
}
