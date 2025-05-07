package space.aliweb.menuframework;
import org.fusesource.jansi.AnsiConsole;
import space.aliweb.menuframework.input.StringInput;
import space.aliweb.menuframework.prompt.Prompt;
import space.aliweb.menuframework.prompt.PromptHandler;

public class Main {
    public static void main(String[] args) {
        boolean noJansiInstallFlag = false;

        for (String arg : args) {
            if (arg.equalsIgnoreCase("--no-jansi-install")) {
                noJansiInstallFlag = true;
            }
        }

        if (!noJansiInstallFlag) {
            AnsiConsole.systemInstall();
        }
    }
}
