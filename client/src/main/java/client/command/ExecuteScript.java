package client.command;

import client.util.console.Cons;

/**
 * Команда 'execute_script'. Выполнить скрипт из файла.
 *
 */
public class ExecuteScript extends Command {
    private final Cons console;

    /**
     * Instantiates a new Execute script.
     *
     * @param console the console
     */
    public ExecuteScript(Cons console) {
        super("execute_script <file_name>");
        this.console = console;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        if (arguments[1].isEmpty()) {
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        console.println("Выполнение скрипта '" + arguments[1] + "'...");
        return true;
    }
}