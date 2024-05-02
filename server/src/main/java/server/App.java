package server;

import common.util.Commands;
import server.commands.*;
import server.handler.CommandHandler;
import server.managers.CommandManager;
import server.managers.DumpManager;
import server.network.UDPDatagramServer;
import server.repo.HumanBeingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Серверная часть приложения.
 *
 */
public class App {
    /**
     * The constant PORT.
     */
    public static final int PORT = 1506;

    /**
     * The constant logger.
     */
    public static Logger logger = LoggerFactory.getLogger("ServerLogger");

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Введите имя загружаемого файла как аргумент командной строки");
            System.exit(1);
        }

        var dumpManager = new DumpManager(args[0]);
        var repository = new HumanBeingRepository(dumpManager);
        if(!repository.validateAll()) {
            logger.error("Невалидные продукты в загруженном файле!");
            System.exit(2);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(repository::save));

        var commandManager = new CommandManager() {{
            register(Commands.HELP, new Help(this));
            register(Commands.INFO, new Info(repository));
            register(Commands.SHOW, new Show(repository));
            register(Commands.ADD, new Add(repository));
            register(Commands.UPDATE, new Update(repository));
            register(Commands.REMOVE_BY_ID, new RemoveById(repository));
            register(Commands.CLEAR, new Clear(repository));
            register(Commands.HEAD, new Head(repository));
            register(Commands.SUM_OF_IMPACT_SPEED, new SumOfImpactSpeed(repository));
        }};

        try {
            var server = new UDPDatagramServer(InetAddress.getLocalHost(), PORT, new CommandHandler(commandManager));
            server.setAfterHook(repository::save);
            server.run();
        } catch (SocketException e) {
            logger.error("Случилась ошибка сокета", e);
        } catch (UnknownHostException e) {
            logger.error("Неизвестный хост", e);
        }
    }
}