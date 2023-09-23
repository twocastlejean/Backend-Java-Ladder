package ladder;

import ladder.creator.ManualLadderCreator;

public class LadderGame {

    private final ManualLadderCreator manualLadderCreator;

    public LadderGame(ManualLadderCreator manualLadderCreator) {
        this.manualLadderCreator = manualLadderCreator;
    }


    public int run(Position position) {
        LadderRunner ladderRunner = new LadderRunner(manualLadderCreator.getRows());
        return ladderRunner.run(position);
    }
}
