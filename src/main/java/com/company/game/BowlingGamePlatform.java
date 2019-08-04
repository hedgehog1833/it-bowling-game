package com.company.game;

import com.company.model.BowlingFrame;
import com.company.model.BowlingGame;
import com.company.model.BowlingRoll;

public class BowlingGamePlatform {

  private final BowlingRoller bowlingRoller;

  public BowlingGamePlatform(BowlingRoller bowlingRoller) {
    this.bowlingRoller = bowlingRoller;
  }

  public void playBowlingGame(BowlingGame bowlingGame) {
    for (BowlingFrame bowlingFrame : bowlingGame.getBowlingFrames()) {
      playFrame(bowlingGame, bowlingFrame);
      System.out.println();
    }

    System.out.println();
    for (BowlingFrame bowlingFrame : bowlingGame.getBowlingFrames()) {
      System.out.println(bowlingFrame);
      System.out.println(bowlingFrame.getBowlingFrameResult());
    }

    bowlingGame.createBowlingGameResult();
  }

  private void playFrame(BowlingGame bowlingGame, BowlingFrame bowlingFrame) {
    int pinsStanding = BowlingFrame.MAX_NUMBER_OF_PINS;
    int numberOfRolls = BowlingFrame.DEFAULT_NUMBER_OF_ROLLS;
    int rollsPlayed = 0;

    System.out.println(bowlingFrame);

    while (rollsPlayed < numberOfRolls && pinsStanding > 0) {
      BowlingRoll bowlingRoll = new BowlingRoll(pinsStanding, bowlingRoller.roll(pinsStanding));
      bowlingFrame.addBowlingRoll(bowlingRoll);

      consumeBonus(bowlingGame, bowlingRoll);
      pinsStanding = bowlingRoll.getPinsStandingAfterRoll();
      rollsPlayed++;

      if (bowlingFrame.isLastFrame() && bowlingRoll.getPinsStandingAfterRoll() == 0 && rollsPlayed <= 2) {
        numberOfRolls++;
        pinsStanding = BowlingFrame.MAX_NUMBER_OF_PINS;
      }

      System.out.println(bowlingRoll);
    }

    bowlingFrame.createBowlingFrameResult();
  }

  private void consumeBonus(BowlingGame bowlingGame, BowlingRoll bowlingRoll) {
    for (BowlingFrame bowlingFrame : bowlingGame.getBowlingFrames()) {
      if (bowlingFrame.getCurrentNumberOfBonusRolls() > 0) {
        bowlingFrame.addBonusScore(bowlingRoll.getPinsHit());
      }
    }
  }
}
