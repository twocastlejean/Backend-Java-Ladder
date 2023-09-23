package ladder;

import ladder.creator.AutoLadderCreator;
import ladder.creator.LadderGameFactory;
import ladder.creator.ManualLadderCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void 수동_사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(numberOfRow, numberOfPerson);

        //then
        assertNotNull(manualLadderCreator);
    }

    @Test
    void 자동_사다리_생성_확인() {
        //given
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(5);

        //when
        AutoLadderCreator autoLadderCreator = new AutoLadderCreator(numberOfRow, numberOfPerson);

        assertNotNull(autoLadderCreator);
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(1);
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(numberOfRow, numberOfPerson);
        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        //given
        int nthOfPerson = 4;
        Position position = Position.of(nthOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, ()->ladderGame.run(position));
    }

    @Test
    void 수동_사다리_결과_확인() {
        //when
        NaturalNumber numberOfRow = NaturalNumber.of(3);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(numberOfRow, numberOfPerson);

        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        manualLadderCreator.drawLine(Position.of(0),Position.of(0));
        manualLadderCreator.drawLine(Position.of(1),Position.of(1));
        manualLadderCreator.drawLine(Position.of(2),Position.of(0));

        //given
        int nthOfPerson = 0;
        Position position = Position.of(nthOfPerson);

        //then
        System.out.println("select " + nthOfPerson);
        assertEquals(2, ladderGame.run(position));
        System.out.println("--------------------\n");

        //given
        nthOfPerson = 1;
        position = Position.of(nthOfPerson);

        //then
        System.out.println("select " + nthOfPerson);
        assertEquals(1, ladderGame.run(position));
        System.out.println("--------------------\n");

        //given
        nthOfPerson = 2;
        position = Position.of(nthOfPerson);

        //then
        System.out.println("select " + nthOfPerson);
        assertEquals(0, ladderGame.run(position));
        System.out.println("--------------------\n");
    }

    @Test
    void 자동_사다리_결과_확인() {
        NaturalNumber numOfRow = NaturalNumber.of(3);
        NaturalNumber numOfPerson = NaturalNumber.of(4);
        Position startPosition = Position.of((int) ((Math.random() * 10000) % numOfPerson.getNumber()));

        LadderGame ladderGame = LadderGameFactory.createAutoLadderGame(numOfRow, numOfPerson);
        ladderGame.run(startPosition);
    }
}