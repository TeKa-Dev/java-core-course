package III_base_of_OOP;

public class Robot {
    private int x = 0;
    private int y = 0;
    Direction direction;

    public Robot(int x, int y, Direction dir) {
        this.direction = dir;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        System.out.println("turnLeft");
        if (direction == Direction.DOWN) {
            this.direction = Direction.RIGHT;
            return;
        }

        if (direction == Direction.UP) {
            this.direction = Direction.LEFT;
            return;
        }

        if (direction == Direction.LEFT) {
            this.direction = Direction.DOWN;
            return;
        }

        if (direction == Direction.RIGHT) {
            this.direction = Direction.UP;
            return;
        }
    }

    public void turnRight() {
        System.out.println("turnRight");
        if (this.direction == Direction.DOWN) {
            System.out.println("Вниз -> влево");
            this.direction = Direction.LEFT;
            return;
        }

        if (this.direction == Direction.UP) {
            System.out.println("Вверх -> вправо");
            this.direction = Direction.RIGHT;
            return;
        }

        if (this.direction == Direction.LEFT) {
            System.out.println("Влево -> вверх");
            this.direction = Direction.UP;
            return;
        }

        if (this.direction == Direction.RIGHT) {
            System.out.println("Вправо -> вниз");
            this.direction = Direction.DOWN;
            return;
        }
    }

    public void stepForward() {
        System.out.print("движение ");
        if (direction == Direction.DOWN) {
            System.out.println("вниз");
            this.y--;
        }

        if (direction == Direction.UP) {
            System.out.println("вверх");
            this.y++;
        }

        if (direction == Direction.LEFT) {
            System.out.println("налево");
            this.x--;
        }

        if (direction == Direction.RIGHT) {
            System.out.println("направо");
            this.x++;
        }
    }
}

//    Direction, направление взгляда робота, - это перечисление:
enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}
