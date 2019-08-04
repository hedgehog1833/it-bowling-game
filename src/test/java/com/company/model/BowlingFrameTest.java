package com.company.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingFrameTest {

  @Test
  void createBowlingFrameResultNoBonus() {
    BowlingFrame bowlingFrame = new BowlingFrame(1);

    BowlingRoll bowlingRoll1 = new BowlingRoll(10, 5);
    BowlingRoll bowlingRoll2 = new BowlingRoll(5, 0);

    bowlingFrame.addBowlingRoll(bowlingRoll1);
    bowlingFrame.addBowlingRoll(bowlingRoll2);

    assertNull(bowlingFrame.getBowlingFrameResult());
    assertEquals(0, bowlingFrame.getCurrentNumberOfBonusRolls());

    bowlingFrame.createBowlingFrameResult();

    assertNotNull(bowlingFrame.getBowlingFrameResult());
    assertEquals(Bonus.NONE, bowlingFrame.getBowlingFrameResult().getBonus());
    assertEquals(5, bowlingFrame.getBowlingFrameResult().calculateOverallScore());
    assertEquals(0, bowlingFrame.getCurrentNumberOfBonusRolls());
  }

  @Test
  void createBowlingFrameResultSpareBonus() {
    BowlingFrame bowlingFrame = new BowlingFrame(1);

    BowlingRoll bowlingRoll1 = new BowlingRoll(10, 5);
    BowlingRoll bowlingRoll2 = new BowlingRoll(5, 5);

    bowlingFrame.addBowlingRoll(bowlingRoll1);
    bowlingFrame.addBowlingRoll(bowlingRoll2);

    assertNull(bowlingFrame.getBowlingFrameResult());
    assertEquals(0, bowlingFrame.getCurrentNumberOfBonusRolls());

    bowlingFrame.createBowlingFrameResult();

    assertNotNull(bowlingFrame.getBowlingFrameResult());
    assertEquals(Bonus.SPARE, bowlingFrame.getBowlingFrameResult().getBonus());
    assertEquals(10, bowlingFrame.getBowlingFrameResult().calculateOverallScore());
    assertEquals(1, bowlingFrame.getCurrentNumberOfBonusRolls());
  }

  @Test
  void createBowlingFrameResultStrikeBonus() {
    BowlingFrame bowlingFrame = new BowlingFrame(1);

    BowlingRoll bowlingRoll1 = new BowlingRoll(10, 10);

    bowlingFrame.addBowlingRoll(bowlingRoll1);

    assertNull(bowlingFrame.getBowlingFrameResult());
    assertEquals(0, bowlingFrame.getCurrentNumberOfBonusRolls());

    bowlingFrame.createBowlingFrameResult();

    assertNotNull(bowlingFrame.getBowlingFrameResult());
    assertEquals(Bonus.STRIKE, bowlingFrame.getBowlingFrameResult().getBonus());
    assertEquals(10, bowlingFrame.getBowlingFrameResult().calculateOverallScore());
    assertEquals(2, bowlingFrame.getCurrentNumberOfBonusRolls());
  }

  @Test
  void createBowlingFrameResultLastFrame() {
    BowlingFrame bowlingFrame = new BowlingFrame(10);

    BowlingRoll bowlingRoll1 = new BowlingRoll(10, 10);
    BowlingRoll bowlingRoll2 = new BowlingRoll(10, 10);
    BowlingRoll bowlingRoll3 = new BowlingRoll(10, 10);

    bowlingFrame.addBowlingRoll(bowlingRoll1);
    bowlingFrame.addBowlingRoll(bowlingRoll2);
    bowlingFrame.addBowlingRoll(bowlingRoll3);


    assertNull(bowlingFrame.getBowlingFrameResult());
    assertEquals(0, bowlingFrame.getCurrentNumberOfBonusRolls());

    bowlingFrame.createBowlingFrameResult();

    assertNotNull(bowlingFrame.getBowlingFrameResult());
    assertEquals(Bonus.STRIKE, bowlingFrame.getBowlingFrameResult().getBonus());
    assertEquals(30, bowlingFrame.getBowlingFrameResult().calculateOverallScore());
    assertEquals(0, bowlingFrame.getCurrentNumberOfBonusRolls());
  }
}