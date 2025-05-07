package space.aliweb.menuframework.input;

public class IntegerInput implements Input<Integer> {
    protected boolean positiveOnly;

    public IntegerInput() {
        this.positiveOnly = false;
    }
    public IntegerInput(boolean positiveOnly) {
        this.positiveOnly = positiveOnly;
    }

    @Override
    public Integer satisfies(String raw) {
        try {
            Integer integer = Integer.valueOf(raw);
            if (positiveOnly && integer < 0) return null;
            return integer;
        } catch (NumberFormatException nfE) {
            return null;
        }
    }
}
