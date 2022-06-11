package module_4_checking;

import java.util.logging.Level;
import java.util.logging.Logger;

// Задача 4.3.6

/*
Создайте в статичном публичном методе logging логгер с именем com.javamentor.logging.Test, залогируйте им два сообщения:
первое "Все хорошо" с уровнем INFO и второе "Произошла ошибка" с уровнем WARNING
 */
public class Log {

    public static void main(String[] args) {
        logging();
    }

private static final Logger LOGGER = Logger.getLogger(Test.class.getName());
public static void logging() {
    LOGGER.log(Level.INFO, "Все хорошо");
    LOGGER.log(Level.WARNING, "Произошла ошибка");
}
}
class Test {}
