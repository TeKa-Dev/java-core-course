package module_1_introduction_to_Java;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerEx {

    // создаем новый логгер, задаем имя - название этого класса
    private final static Logger LOGGER = Logger.getLogger(LoggerEx.class.getName());

    // как созать левел для логгера
    private final static Level level = Level.SEVERE;

    public static void main(String[] args) {

        // вывод лога в консоль
        LOGGER.log(Level.INFO, "this is INFO");
        LOGGER.log(Level.WARNING, "this is WARNING");
        LOGGER.log(level, "this ir SEVERE");
    }
}
