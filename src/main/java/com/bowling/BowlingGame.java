package com.bowling;

public class BowlingGame {

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int totalScore = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                // strike: 10 et les 2 prochain
                totalScore += 10 + strikeBonus(frameIndex);
                frameIndex++; // passe a la frame suivance
            } else if (isSpare(frameIndex)) {
                // spare: 10 + prochain
                totalScore += 10 + spareBonus(frameIndex);
                frameIndex += 2; // On passe à la frame suivante (2 lancers consommés)
            } else {
                // frame normale (pas de strike ou spare)
                totalScore += sumOfPinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return totalScore;
    }
    private boolean isStrike(int index) {
        return rolls[index] == 10;
    }
    private boolean isSpare(int index) {
        return rolls[index] + rolls[index + 1] == 10;
    }
    private int strikeBonus(int index) {
        return rolls[index + 1] + rolls[index + 2];
    }
    private int spareBonus(int index) {
        return rolls[index + 2];
    }
    private int sumOfPinsInFrame(int index) {
        return rolls[index] + rolls[index + 1];
    }
}
