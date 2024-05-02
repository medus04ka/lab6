package server.commands;

import common.build.request.Request;
import common.build.response.*;
import server.repo.HumanBeingRepository;

/**
 * Команда 'show'. Выводит все элементы коллекции.
 */
public class Show extends Command {
    private final HumanBeingRepository humanBeingRepository;

    /**
     * Instantiates a new Show.
     *
     * @param humanBeingRepository the human being repository
     */
    public Show(HumanBeingRepository humanBeingRepository) {
        super("show", "вывести все элементы коллекции");
        this.humanBeingRepository = humanBeingRepository;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public Response apply(Request request) {
        try {
            return new ShowRes(humanBeingRepository.sorted(), null);
        } catch (Exception e) {
            return new ShowRes(null, e.toString());
        }
    }
}