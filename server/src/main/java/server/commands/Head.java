package server.commands;

import common.build.request.Request;
import common.build.response.*;
import server.repo.HumanBeingRepository;

/**
 * Команда 'head'. Выводит первый элемент коллекции.
 *
 */
public class Head extends Command {
    private final HumanBeingRepository humanBeingRepository;

    /**
     * Instantiates a new Head.
     *
     * @param humanBeingRepository the human being repository
     */
    public Head(HumanBeingRepository humanBeingRepository) {
        super("head", "вывести первый элемент коллекции");
        this.humanBeingRepository = humanBeingRepository;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public Response apply(Request request) {
        try {
            return new HeadRes(humanBeingRepository.first(), null);
        } catch (Exception e) {
            return new HeadRes(null, e.toString());
        }
    }
}