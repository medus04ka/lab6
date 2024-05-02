package server.managers;

import server.commands.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Управляет командами.
 */
public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Добавляет команду.
     *
     * @param commandName Название команды.
     * @param command     Команда.
     */
    public void register(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Gets commands.
     *
     * @return Словарь команд.
     */
    public Map<String, Command> getCommands() {
        return commands;
    }
}