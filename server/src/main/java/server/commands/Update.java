package server.commands;

import common.build.request.*;
import common.build.response.*;
import server.repo.HumanBeingRepository;

/**
 * Команда 'update'. Обновляет элемент коллекции.
 *
 */
public class Update extends Command {
    private final HumanBeingRepository humanBeingRepository;

    /**
     * Instantiates a new Update.
     *
     * @param humanBeingRepository the human being repository
     */
    public Update(HumanBeingRepository humanBeingRepository) {
        super("update <ID> {element}", "обновить значение элемента коллекции по ID");
        this.humanBeingRepository = humanBeingRepository;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public Response apply(Request request) {
        var req = (UpdateReq) request;
        try {
            if (!humanBeingRepository.checkExist(req.id)) {
                return new UpdateRes("Продукта с таким ID в коллекции нет!");
            }
            if (!req.updatedPerson.validate()) {
                return new UpdateRes( "Поля продукта не валидны! Продукт не обновлен!");
            }

            humanBeingRepository.getById(req.id).update(req.updatedPerson);
            return new UpdateRes(null);
        } catch (Exception e) {
            return new UpdateRes(e.toString());
        }
    }
}