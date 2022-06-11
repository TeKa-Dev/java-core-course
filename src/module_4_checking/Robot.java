package module_4_checking;

// Задача 4.2.8 - 4.2.9

/*
Ваша задача - реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение
в заданную точку и затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.
 */
public class Robot {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection robot = null;
        for (int i = 1; i <= 3; i++) {
            try {
                robot = robotConnectionManager.getConnection();
                robot.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException rce) {
                if (i == 3) {
                    throw rce;
                }
            } finally {
                try {
                    robot.close();
                } catch (Exception e) {
                    // ignore
                }
            }
        }
    }
    
// Реши предыдущую задачу с использованием try-with-resources

    public static void moveRobot_tws(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 1; i <= 3; i++) {
            try (RobotConnection rc = robotConnectionManager.getConnection()) {
                rc.moveRobotTo(toX, toY);
                i += 3;
            } catch (RobotConnectionException rce) {
                if (i == 3) {
                    throw rce;
                }
            }
        }
    }

}


interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}


interface RobotConnectionManager {
    RobotConnection getConnection();
}


class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
