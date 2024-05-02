package client.command;

import client.util.console.Cons;
import common.util.Commands;

/**
 * Команда 'exit'. Завершает выполнение.
 *
 */
public class Exit extends Command {
    private final Cons console;

    /**
     * Instantiates a new Exit.
     *
     * @param console the console
     */
    public Exit(Cons console) {
        super("exit");
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        console.println("Завершение выполнения...");
        console.println("""
                      \s
               ／＞　 フ\s
      　　　　| 　u　 u|\s
       　　　／`ミ _x 彡    | Пока - пока :3 |
      　 　 /　　　 　 |\s
      　　 /　 ヽ　　 ﾉ\s
      ／￣|　　 |　|　|\s
      | (￣ヽ＿_ヽ_)_)\s
      ＼二つ""".indent(1));
        return true;
    }
}