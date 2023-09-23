package ladder.creator;

import ladder.NaturalNumber;
import ladder.Position;
import ladder.Row;

public class AutoLadderCreator implements LadderCreator{
    private final Row[] rows;

    public AutoLadderCreator(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
        createRandom(numberOfRow, numberOfPerson);
    }

    public void createRandom(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        Position row, col;
        int count = 0;
        while (count < numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3) {
            row = Position.of(getRandom(numberOfRow.getNumber()));
            col = Position.of(getRandom(numberOfPerson.getNumber()));
            try {
                drawLine(row, col);
            } catch (IllegalArgumentException e) {
                continue;
            }
            count++;
        }
    }

    private int getRandom(int num) {
        return (int) ((Math.random() * 10000) % num);
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
