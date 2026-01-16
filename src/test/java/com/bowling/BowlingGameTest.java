package com.bowling;

import junit.framework.TestCase;
import org.junit.Test;

public class BowlingGameTest extends TestCase {

    @Test
    public void testNoSpareNoStrike() {
        BowlingGame g = new BowlingGame();
        g.roll(4);
        g.roll(4); // frame 1: 4+4
        g.roll(3);
        g.roll(2); // frame 2: 3+2
        // On complète avec des zéros
        for (int i = 0; i < 16; i++) g.roll(0);
        assertEquals(13, g.score());
    }

    @Test
    public void testGameNull() {
        // ne touche aucune quille (total = 0)
        BowlingGame g = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            g.roll(0);
        }
        assertEquals(0, g.score());
    }

    @Test
    public void testAllOnes() {
        // score 1 à chaque lancer (total = 20)
        BowlingGame g = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            g.roll(1);
        }
        assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare() {
        BowlingGame g = new BowlingGame();
        g.roll(6);
        g.roll(4); // Spare 6+4=10
        g.roll(3); // le bonus est 3
        g.roll(2);
        for (int i = 0; i < 16; i++) {
            g.roll(0);
        }
        assertEquals(18, g.score());
    }

    @Test
    public void testOneStrike() {
        BowlingGame g = new BowlingGame();
        g.roll(10);
        g.roll(3);
        g.roll(4);
        for (int i = 0; i < 16; i++) {
            g.roll(0);
        }
        assertEquals(24, g.score());
    }

    @Test
    public void testTwoStrikesOneAfterOther() {
        BowlingGame g = new BowlingGame();
        g.roll(10);
        g.roll(10);
        g.roll(3);
        g.roll(1);
        for (int i = 0; i < 16; i++) {
            g.roll(0);
        }
        assertEquals(41, g.score());
    }

    @Test
    public void testPerfectGame() {
        // 12 strikes, max de score 300
        BowlingGame g = new BowlingGame();
        for (int i = 0; i < 12; i++) {
            g.roll(10);
        }
        assertEquals(300, g.score());
    }

    @Test
    public void testSpareInLastFrame() {
        BowlingGame g = new BowlingGame();
        for (int i = 0; i < 18; i++) {
            g.roll(0);
        }
        g.roll(5);
        g.roll(5);
        g.roll(8);
        assertEquals(18, g.score());
    }

    @Test
    public void testStrikeInLastFrame() {
        BowlingGame g = new BowlingGame();
        for (int i = 0; i < 18; i++) {
            g.roll(0);
        }
        g.roll(10);
        g.roll(10);
        g.roll(10);
        assertEquals(30, g.score());
    }

    @Test
    public void testOneStrikeOneSpare() {
        BowlingGame g = new BowlingGame();
        for (int i = 0; i < 6; i++) {
            g.roll(0);
        }

        g.roll(3);
        g.roll(7);
        g.roll(0);
        g.roll(0);
        g.roll(10);

        for (int i = 0; i < 6; i++) {
            g.roll(0);
        }
        assertEquals(20, g.score());
    }
}