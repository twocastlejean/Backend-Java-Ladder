package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @Test
    @DisplayName("사다리 줄 생성 전 정상 작동 여부")
    void run_test_without_line() {
        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfHeight = NaturalNumber.of(5);

        Ladder ladder = new Ladder(numberOfPerson, numberOfHeight);


        assertEquals(3, ladder.run(3));
    }

    @Test
    @DisplayName("사다리 줄 생성 후 정상 작동 여부")
    void run_test_with_line() {

        NaturalNumber numberOfPerson = NaturalNumber.of(4);
        NaturalNumber numberOfHeight = NaturalNumber.of(4);
        Ladder ladder = new Ladder(numberOfPerson, numberOfHeight);

        ladder.drawLine(0,0);
        ladder.drawLine(0,1);
        ladder.drawLine(1,2);
        ladder.drawLine(2,3);
        ladder.drawLine(2,0);

        assertEquals(0, ladder.run(0));
        assertEquals(3, ladder.run(1));
        assertEquals(2, ladder.run(2));
        assertEquals(1, ladder.run(3));
    }

    @Test
    @DisplayName("예외처리 체크")
    void run_exception_test() {
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        NaturalNumber numberOfHeight = NaturalNumber.of(3);
        Ladder ladder = new Ladder(numberOfPerson, numberOfHeight);

        assertThrows(IllegalArgumentException.class, () -> ladder.run(5));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(4, 2));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(2, 4));
    }

}