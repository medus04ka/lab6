package server.commands;

import common.build.request.*;
import common.build.response.*;
import server.repo.HumanBeingRepository;

/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 *
 */
public class Add extends Command {
    private final HumanBeingRepository humanBeingRepository;

    /**
     * Instantiates a new Add.
     *
     * @param humanBeingRepository the human being repository
     */
    public Add(HumanBeingRepository humanBeingRepository) {
        super("add {element}", "добавить новый элемент в коллекцию");
        this.humanBeingRepository = humanBeingRepository;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public Response apply(Request request) {
        var req = (AddReq) request;
        try {
            if (!req.person.validate()) {
                return new AddRes(-1, "Поля друга не валидны! Продукт не добавлен!");
            }
            var newId = humanBeingRepository.add(req.person);
            return new AddRes(newId, null);
        } catch (Exception e) {
            return new AddRes(-1, e.toString());
        }
    }
}