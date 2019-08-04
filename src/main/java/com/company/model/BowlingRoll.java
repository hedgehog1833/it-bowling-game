package com.company.model;

public class BowlingRoll {
  private final int pinsStandingAfterRoll;
  private final int pinsHit;

  public BowlingRoll(int pinsStandingBeforeRoll, int pinsHit) {
    this.pinsHit = pinsHit;
    pinsStandingAfterRoll = pinsStandingBeforeRoll - pinsHit;
  }

  public int getPinsStandingAfterRoll() {
    return pinsStandingAfterRoll;
  }

  public int getPinsHit() {
    return pinsHit;
  }

  @Override
  public String toString() {
    return "Roll: Pins standing before roll = " + (pinsStandingAfterRoll + pinsHit) + "; Pins hit = " + pinsHit + "; Pins standing after roll = " + pinsStandingAfterRoll;
  }
}
