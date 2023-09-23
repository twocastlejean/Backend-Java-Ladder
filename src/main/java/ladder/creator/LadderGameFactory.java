package ladder.creator;

import ladder.LadderGame;
import ladder.NaturalNumber;

public class LadderGameFactory {
    public static LadderGame createAutoLadderGame(NaturalNumber numOfRow, NaturalNumber numOfPerson) {
        return new LadderGame(new AutoLadderCreator(numOfRow, numOfPerson));
    }

    public static LadderGame createManualLadderGame(NaturalNumber numOfRow, NaturalNumber numOfPerson) {
        return new LadderGame(new ManualLadderCreator(numOfRow, numOfPerson));
    }
}
