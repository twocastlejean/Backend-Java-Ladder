package ladder;

public class LadderRunner {
    private final Row[] rows;
    private LadderPrinter ladderPrinter;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        this.ladderPrinter = new LadderPrinter(rows);
        for (int i = 0; i < rows.length; i++) {
            ladderPrinter.printBefore();
            ladderPrinter.printLadder(Position.of(i), position);

            position = rows[i].nextPosition(position);

            ladderPrinter.printAfter();
            ladderPrinter.printLadder(Position.of(i), position);
        }

        return position.getValue();
    }
}
