package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SequenceDetectorTest {

    @ParameterizedTest
    @CsvSource({
            "'TEST', F",
            "'T', _1",
            "'TE', _2",
            "'TES', _3",
            "'abcTESabc', S",
            "'TESTING', F",
            "'abTESTcdTESTef', F",
            "'123T456E789S', S",
            "'TESST', _1",
            "'SOMERANDOMTEXT', _1",
            "'TESTER', F",
            "'TEXES', S",
            "'', S",
            "'TESTXYZTEST', F",
            "'TESTABCTES', F",
            "'TTETST', _1",
            "'TES123TEST', F",
            "'TTTESTE', F",
            "'TESTTT', F"
    })
    void testSequenceDetector(String input, String expectedPhase) {
        SequenceDetector detector = new SequenceDetector();

        for (char c : input.toCharArray()) {
            detector.processChar(c);
        }

        assertEquals(SequenceDetector.Phase.valueOf(expectedPhase), detector.getCurrentPhase());
    }
}
