package space.aliweb.menuframework.prompt;

import space.aliweb.menuframework.input.Input;
import space.aliweb.menuframework.menu.MenuAction;

public class PromptHandler<InputDefinition extends Input<?>> {
    protected InputDefinition inputDefinition;
    protected MenuAction action;

    public PromptHandler(InputDefinition inputDefinition, MenuAction action) {
        this.inputDefinition = inputDefinition;
        this.action = action;
    }

    public InputDefinition getInputDefinition() {
        return inputDefinition;
    }

    public MenuAction getAction() {
        return action;
    }
}
