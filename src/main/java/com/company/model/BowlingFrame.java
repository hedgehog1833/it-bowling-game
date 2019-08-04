package com.company.model;

import com.company.model.results.BowlingFrameResult;

import java.util.*;

public class BowlingFrame {
  public static final int MAX_NUMBER_OF_PINS = 10;
  public static final int DEFAULT_NUMBER_OF_ROLLS = 2;
  private static final int BONUS_SPARE = 1;
  private static final int BONUS_STRIKE = 2;

  private final int id;
  private final List<BowlingRoll> bowlingRolls;
  private BowlingFrameResult bowlingFrameResult;
  private int currentNumberOfBonusRolls;

  BowlingFrame(int id) {
    this.id = id;
    this.bowlingRolls = new ArrayList<>();
  }

  public int getCurrentNumberOfBonusRolls() {
    return currentNumberOfBonusRolls;
  }

  public void addBowlingRoll(BowlingRoll bowlingRoll) {
    bowlingRolls.add(bowlingRoll);
  }

  public BowlingFrameResult getBowlingFrameResult() {
    return bowlingFrameResult;
  }

  public void createBowlingFrameResult() {
    bowlingFrameResult = new BowlingFrameResult(bowlingRolls);
    addBonusRoll();
  }

  private void addBonusRoll() {
    if (isLastFrame()) {
      return;
    }

    Bonus bonus = bowlingFrameResult.getBonus();

    if (bonus == Bonus.SPARE) {
      currentNumberOfBonusRolls = BONUS_SPARE;
    } else if (bonus == Bonus.STRIKE) {
      currentNumberOfBonusRolls = BONUS_STRIKE;
    }
  }

  public void addBonusScore(int bonusScore) {
    bowlingFrameResult.addBonusScore(bonusScore);
    currentNumberOfBonusRolls--;
  }

  public boolean isLastFrame() {
    return id == BowlingGame.NUMBER_OF_FRAMES;
  }

  @Override
  public String toString() {
    return "Frame: " + id;
  }
}
