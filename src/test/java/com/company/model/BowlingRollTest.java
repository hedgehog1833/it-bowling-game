package com.company.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingRollTest {

  @Test
  void getPinsStandingAfterRoll() {
    BowlingRoll bowlingRoll1 = new BowlingRoll(10, 5);
    BowlingRoll bowlingRoll2 = new BowlingRoll(10, 10);
    BowlingRoll bowlingRoll3 = new BowlingRoll(10, 0);

    assertEquals(5, bowlingRoll1.getPinsStandingAfterRoll());
    assertEquals(0, bowlingRoll2.getPinsStandingAfterRoll());
    assertEquals(10, bowlingRoll3.getPinsStandingAfterRoll());
  }
}