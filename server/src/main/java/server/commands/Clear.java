package server.commands;

import common.build.response.ClearRes;
import common.build.request.Request;
import common.build.response.Response;
import server.repo.HumanBeingRepository;

/**
 * Команда 'clear'. Очищает коллекцию.
 *
 */
public class Clear extends Command {
    private final HumanBeingRepository humanBeingRepository;

    /**
     * Instantiates a new Clear.
     *
     * @param humanBeingRepository the human being repository
     */
    public Clear(HumanBeingRepository humanBeingRepository) {
        super("clear", "очистить коллекцию");
        this.humanBeingRepository = humanBeingRepository;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public Response apply(Request request) {
        try {
            humanBeingRepository.clear();
            return new ClearRes(null);
        } catch (Exception e) {
            return new ClearRes(e.toString());
        }
    }
}