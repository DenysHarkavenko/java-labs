package org.example;

public class SequenceDetector {
    public enum Phase {
        S, _1, _2, _3, F
    }

    private Phase currentPhase;
    private boolean sequenceFound;

    public SequenceDetector() {
        this.currentPhase = Phase.S;
        this.sequenceFound = false;
    }

    public void reset() {
        this.currentPhase = Phase.S;
        this.sequenceFound = false;
    }

    public Phase processChar(char inputChar) {
        if (sequenceFound) {
            return currentPhase;
        }

        switch (currentPhase) {
            case S:
                if (inputChar == 'T') currentPhase = Phase._1;
                else currentPhase = Phase.S;
                break;
            case _1:
                if (inputChar == 'E') currentPhase = Phase._2;
                else currentPhase = Phase.S;
                break;
            case _2:
                if (inputChar == 'S') currentPhase = Phase._3;
                else currentPhase = Phase.S;
                break;
            case _3:
                if (inputChar == 'T') {
                    currentPhase = Phase.F;
                    sequenceFound = true;
                } else currentPhase = Phase.S;
                break;
            case F:
                break;
        }
        return currentPhase;
    }

    public boolean isSequenceDetected() {
        return sequenceFound;
    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }
}
