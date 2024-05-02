package server.commands;

import common.build.request.Request;
import common.build.response.*;
import server.repo.HumanBeingRepository;

/**
 * Команда 'info'. Выводит информацию о коллекции.
 *
 */
public class Info extends Command {
    private final HumanBeingRepository humanBeingRepository;

    /**
     * Instantiates a new Info.
     *
     * @param humanBeingRepository the human being repository
     */
    public Info(HumanBeingRepository humanBeingRepository) {
        super("info", "вывести информацию о коллекции");
        this.humanBeingRepository = humanBeingRepository;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public Response apply(Request request) {
        var lastInitTime = humanBeingRepository.getLastInitTime();
        var lastInitTimeString = (lastInitTime == null) ? "в данной сессии инициализации еще не происходило" :
                lastInitTime.toLocalDate().toString() + " " + lastInitTime.toLocalTime().toString();

        var lastSaveTime = humanBeingRepository.getLastSaveTime();
        var lastSaveTimeString = (lastSaveTime == null) ? "в данной сессии сохранения еще не происходило" :
                lastSaveTime.toLocalDate().toString() + " " + lastSaveTime.toLocalTime().toString();

        var message = "Сведения о коллекции:\n" +
                " Тип: " + humanBeingRepository.type() + "\n" +
                " Количество элементов: " + humanBeingRepository.size() + "\n" +
                " Дата последнего сохранения: " + lastSaveTimeString + "\n" +
                " Дата последней инициализации: " + lastInitTimeString;
        return new InfoRes(message, null);
    }
}