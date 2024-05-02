package server.commands;

import common.build.request.Request;
import common.build.response.Response;

/**
 * The interface Executable.
 */
public interface Executable {
    /**
     * Выполнить что-либо.
     *
     * @param request запрос с данными для выполнения команды
     * @return результат выполнения
     */
    Response apply(Request request);
}