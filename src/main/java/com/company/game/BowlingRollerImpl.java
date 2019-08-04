package com.company.game;

import com.company.model.BowlingFrame;

import java.util.concurrent.ThreadLocalRandom;

public class BowlingRollerImpl implements BowlingRoller {
  public int roll(int pinsStandingBeforeRoll) {
    int pinsHit = ThreadLocalRandom.current().nextInt(0, BowlingFrame.MAX_NUMBER_OF_PINS + 1);
    return pinsHit <= pinsStandingBeforeRoll ? pinsHit : 0;
  }
}
