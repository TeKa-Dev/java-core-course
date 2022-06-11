package module_3_base_of_OOP;

public class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
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
        System.out.print("turnLeft ");
        if (direction == Direction.DOWN) {
            this.direction = Direction.RIGHT;
            System.out.println("RIGHT");
            return;
        }

        if (direction == Direction.UP) {
            this.direction = Direction.LEFT;
            System.out.println("LEFT");
            return;
        }

        if (direction == Direction.LEFT) {
            this.direction = Direction.DOWN;
            System.out.println("DOWN");
            return;
        }

        if (direction == Direction.RIGHT) {
            this.direction = Direction.UP;
            System.out.println("UP");
        }
    }

    public void turnRight() {
        System.out.print("turnRight ");
        if (this.direction == Direction.DOWN) {
            this.direction = Direction.LEFT;
            System.out.println("LEFT");
            return;
        }

        if (this.direction == Direction.UP) {
            this.direction = Direction.RIGHT;
            System.out.println("RIGHT");
            return;
        }

        if (this.direction == Direction.LEFT) {
            this.direction = Direction.UP;
            System.out.println("UP");
            return;
        }

        if (this.direction == Direction.RIGHT) {
            this.direction = Direction.DOWN;
            System.out.println("DOWN");
        }
    }

    public void stepForward() {
        System.out.print("stepForward ");
        if (direction == Direction.DOWN) {
            this.y--;
            System.out.println("Y = " + y);
        }

        if (direction == Direction.UP) {
            this.y++;
            System.out.println("Y = " + y);
        }

        if (direction == Direction.LEFT) {
            this.x--;
            System.out.println("X = " + x);
        }

        if (direction == Direction.RIGHT) {
            this.x++;
            System.out.println("X = " + x);
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
