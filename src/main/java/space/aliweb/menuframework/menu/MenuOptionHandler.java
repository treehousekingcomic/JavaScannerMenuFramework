package space.aliweb.menuframework.menu;

import space.aliweb.menuframework.option.MenuOption;

public class MenuOptionHandler<OptionDefinition extends MenuOption<?>> {
    protected OptionDefinition optionDefinition;
    protected String name;
    protected MenuAction action;
    protected boolean hidden;

    public MenuOptionHandler(OptionDefinition optionDefinition, String name, MenuAction action) {
        this.optionDefinition = optionDefinition;
        this.name = name;
        this.action = action;
        this.hidden = false;
    }

    public MenuOptionHandler(OptionDefinition optionDefinition, String name, MenuAction action, boolean hidden) {
        this(optionDefinition, name, action);
        this.hidden = hidden;
    }

    public OptionDefinition getOptionDefinition() {
        return optionDefinition;
    }

    public String getName() {
        return name;
    }

    public MenuAction getAction() {
        return action;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
