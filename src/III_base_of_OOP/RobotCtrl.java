package III_base_of_OOP;

// Задача 3.3.13

/*
На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
Ось X смотрит слева направо, ось Y - снизу вверх. (Помните, как рисовали графики функций в школе?)

В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз, направо или налево.
Ваша задача — привести робота в заданную точку игрового поля.

Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):
*/

public class RobotCtrl {

    public static void main(String[] args) {
        final int t;
        Robot r = new Robot(13, 16, Direction.UP);

        moveRobot(r, 4, 4);
        System.out.println(r.getX() + " " + r.getY());
    }

public static void moveRobot(Robot robot, int toX, int toY) {

    Direction dirX = robot.getX() > toX ? Direction.LEFT : Direction.RIGHT;  // направление цели относительно робота по X
    Direction dirY = robot.getY() > toY ? Direction.DOWN : Direction.UP;     // направление цели относительно робота по Y

        while (robot.getDirection() != dirX) {    // крутимся пока не повернемся в сторону цели по X
            robot.turnLeft();
        }
        while (robot.getX() != toX) {       // идем пока координаты не станут одинаковые
            robot.stepForward();
        }
        while (robot.getDirection() != dirY) {    // повторяем тоже самое по Y
            robot.turnLeft();
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }

    //  почему-то не работает если вынести циклы во внешние методы
//    turnTo(robot, dirX);
//    goTo(robot, toX);
//
//    turnTo(robot, dirY);
//    goTo(robot, toY);
}

private static void turnTo(Robot robot, Direction dirGoal) {
    while (robot.getDirection() != dirGoal) {
        robot.turnLeft();
    }
}

private static void goTo(Robot robot, int goal) {
    while (robot.getY() != goal) {
        robot.stepForward();
    }

}

}

