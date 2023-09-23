package ladder;

public class Node {

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public Position move(Position position) {
        if (isRight()) {
            return position.next();
        }
        if (isLeft()) {
            return position.prev();
        }
        return position;
    }

    public void printNodes(boolean isCurrentPosition) {
        if(isCurrentPosition) {
            if(direction.isRight()) System.out.print(direction.getValue() + "* ");
            else System.out.print(direction.getValue() + "*  ");
        }
        else {
            if(direction.isRight()) System.out.print(direction.getValue() + "  ");
            else System.out.print(direction.getValue() + "   ");
        }
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    public boolean isLeft() {
        return direction == Direction.LEFT;
    }

    public static Node of(Direction direction) {
        return new Node(direction);
    }
}
