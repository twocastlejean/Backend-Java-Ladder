package ladder;

public class LadderPrinter {
    private final Row[] rows;
    private NaturalNumber numberOfRow;
    private NaturalNumber numberOfPerson;
    private Position positionOfRow;
    private Position positionOfCol;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
        this.numberOfRow = NaturalNumber.of(rows.length);
        this.numberOfPerson = NaturalNumber.of(rows[0].getNodes().length);
    }

    public void printLadder(Position row, Position col) {
        this.positionOfRow = row;
        this.positionOfCol = col;
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            for (int j = 0; j < numberOfPerson.getNumber(); j++) {
                rows[i].getNodes()[j].printNodes(isCurrentPosition(Position.of(i), Position.of(j)));
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isCurrentPosition(Position row, Position col) {
        return (positionOfRow.getValue() == row.getValue()) && (positionOfCol.getValue() == col.getValue());
    }

    public void printBefore() {
        System.out.println("Before");
    }

    public void printAfter() {
        System.out.println("After");
    }
}
