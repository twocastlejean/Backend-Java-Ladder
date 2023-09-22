package ladder;

public class Ladder {
    private final int[][] ladder;

    Ladder(NaturalNumber person, NaturalNumber height) {
        ladder = new int[person.getNumber()][height.getNumber()];
    }


    public int run(int select) {
        int position = select;

        if (select < 0 || select > ladder.length) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }

        for (int i = 0; i < ladder[0].length; i++) {
            position = getPosition(position, i);
        }

        return position;
    }

    private int getPosition(int position, int i) {
        if (ladder[position][i] == Direction.RIGHT.getValue()) {
            position++;
        }
        else if (ladder[position][i] == Direction.LEFT.getValue()) {
            position--;
        }
        return position;
    }

    public void drawLine(int x, int y) {
        if (x < 0 || x > ladder.length) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
        if (y < 0 || y > ladder.length) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }

        ladder[x][y] = Direction.RIGHT.getValue();
        ladder[x + 1][y] = Direction.LEFT.getValue();
    }
}
