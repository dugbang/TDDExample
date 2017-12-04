package com.example.shbae.tddexample;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by shbae on 2017-11-27.
 */

public class BowlingTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void canRoll() throws Exception {
        game.roll(0);
    }

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        assertThat(game.score(), is(0));
    }

    @Test
    public void oneStrike() throws Exception {
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.score(), is(26));
    }

    private void rollStrike() {
        game.roll(10);
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12, 10);
        assertThat(game.score(), is(300));
    }

    @Test
    public void oneSpare() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.score(), is(16));
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        assertThat(game.score(), is(20));
    }
}
