package server.commands;

import common.model.HumanBeing;
import common.build.request.Request;
import common.build.response.*;
import server.repo.HumanBeingRepository;

/**
 * Команда 'sum_of_impactSpeed'. Сумма скорости всех продуктов.
 */
public class SumOfImpactSpeed extends Command {
    private final HumanBeingRepository humanBeingRepository;

    public SumOfImpactSpeed(HumanBeingRepository humanBeingRepository) {
        super("sum_of_impactSpeed", "вывести сумму значений поля impactSpeed для всех элементов коллекции");
        this.humanBeingRepository = humanBeingRepository;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public Response apply(Request request) {
        try {
            return new SumOfImpactSpeedRes(getSumOfPrice(), null);
        } catch (Exception e) {
            return new SumOfImpactSpeedRes(-1, e.toString());
        }
    }

    private Long getSumOfPrice() {
        return humanBeingRepository.get().stream()
                .map(HumanBeing::getImpactSpeed)
                .mapToLong(Long::longValue)
                .sum();
    }
}