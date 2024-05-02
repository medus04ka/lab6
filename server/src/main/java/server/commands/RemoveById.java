package server.commands;

import common.build.request.*;
import common.build.response.*;
import server.repo.HumanBeingRepository;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции.
 *
 */
public class RemoveById extends Command {
    private final HumanBeingRepository humanBeingRepository;

    /**
     * Instantiates a new Remove by id.
     *
     * @param humanBeingRepository the human being repository
     */
    public RemoveById(HumanBeingRepository humanBeingRepository) {
        super("remove_by_id <ID>", "удалить элемент из коллекции по ID");
        this.humanBeingRepository = humanBeingRepository;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public Response apply(Request request) {
        var req = (RemoveByIdReq) request;

        try {
            if (!humanBeingRepository.checkExist(req.id)) {
                return new RemoveByIdRes("Продукта с таким ID в коллекции нет!");
            }

            humanBeingRepository.remove(req.id);
            return new RemoveByIdRes(null);
        } catch (Exception e) {
            return new RemoveByIdRes(e.toString());
        }
    }
}