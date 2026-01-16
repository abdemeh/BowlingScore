package com.bowling;

public class Main {
    public static void main(String[] args) {
        BowlingGame monMatch = new BowlingGame();

        monMatch.roll(4);
        monMatch.roll(6);

        monMatch.roll(5);
        monMatch.roll(3);

        monMatch.roll(10);

        monMatch.roll(5);
        monMatch.roll(4);

        monMatch.roll(7);
        monMatch.roll(3);

        monMatch.roll(10);

        monMatch.roll(10);

        monMatch.roll(10);

        monMatch.roll(9);
        monMatch.roll(1);

        monMatch.roll(10);
        monMatch.roll(10);

        int resultat = monMatch.score();
        System.out.println("Le score total est : " + resultat);
        ScoreSaver.save(resultat);
    }
}