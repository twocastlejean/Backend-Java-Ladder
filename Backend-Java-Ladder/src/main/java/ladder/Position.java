package ladder;

public class Position {
    private int position;

    public Position(int position) {
        validatePostion(position);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public Position prev() {
        return new Position(position - 1);
    }

    public Position next() {
        return new Position(position + 1);
    }

    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    public boolean isBiggerThan(int position) {
        return this.position > position;
    }

    public static void validatePostion(int position) {
        if (!isPosition(position)) {
            throw new IllegalArgumentException("잘못된 사다리 위치입니다.");
        }
    }

    private static boolean isPosition(int position) {
        return position >= 0;
    }
}
