package space.aliweb.menuframework;

/**
 * Config class for the use of the framework within a project.
 * All options are global and static.
 */
public final class Config {
    public static String LOOSE_PROMPT_SYMBOL = " > ";
    public static String STRICT_PROMPT_SYMBOL = " # ";
    public static String CLEAR_SCREEN_ESCAPE_CODES = "\033\143";

    private Config() {
    }

    /**
     * The loose prompt symbol is used when a prompt is abortable.
     *
     * @param loosePromptSymbol the symbol to be used, default is {@code " > "} (spaces included)
     */
    public static void setLoosePromptSYMBOL(String loosePromptSymbol) {
        LOOSE_PROMPT_SYMBOL = loosePromptSymbol;
    }

    /**
     * The strict prompt symbol is used when a prompt is not abortable.
     *
     * @param strictPromptSymbol the symbol to be used, default is {@code " # "} (spaces included)
     */
    public static void setStrictPromptSymbol(String strictPromptSymbol) {

        STRICT_PROMPT_SYMBOL = strictPromptSymbol;
    }

    /**
     * The ANSI escape codes to be printed out to clear the screen.
     *
     * @param clearScreenEscapeCodes a string consisting of ANSI escape codes, default is {@code \033\143 }
     */
    public static void setClearScreenEscapeCodes(String clearScreenEscapeCodes) {
        CLEAR_SCREEN_ESCAPE_CODES = clearScreenEscapeCodes;
    }

    /**
     * Clears the screen by printing out the CLEAR_SCREEN_ESCAPE_CODES.
     */
    public static void clearScreen() {
        System.out.println(CLEAR_SCREEN_ESCAPE_CODES);
    }
}
