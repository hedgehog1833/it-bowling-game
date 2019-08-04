package com.company.model.results;

import com.company.model.Bonus;
import com.company.model.BowlingRoll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingFrameResultTest {

  @Test
  void bonusNone() {
    List<BowlingRoll> bowlingRolls = Arrays.asList(new BowlingRoll(10, 0),
            new BowlingRoll(10, 0));
    BowlingFrameResult bowlingFrameResult = new BowlingFrameResult(bowlingRolls);

    assertEquals(Bonus.NONE,bowlingFrameResult.getBonus());
  }

  @Test
  void bonusSpare() {
    List<BowlingRoll> bowlingRolls = Arrays.asList(new BowlingRoll(10, 6),
            new BowlingRoll(4, 4));
    BowlingFrameResult bowlingFrameResult = new BowlingFrameResult(bowlingRolls);

    assertEquals(Bonus.SPARE,bowlingFrameResult.getBonus());
  }

  @Test
  void bonusStrike() {
    List<BowlingRoll> bowlingRolls = Collections.singletonList(new BowlingRoll(10, 10));
    BowlingFrameResult bowlingFrameResult = new BowlingFrameResult(bowlingRolls);

    assertEquals(Bonus.STRIKE,bowlingFrameResult.getBonus());
  }

  @Test
  void calculateOverallScore() {
    List<BowlingRoll> bowlingRolls = Collections.singletonList(new BowlingRoll(10, 10));
    BowlingFrameResult bowlingFrameResult = new BowlingFrameResult(bowlingRolls);

    assertEquals(10, bowlingFrameResult.calculateOverallScore());

    bowlingFrameResult.addBonusScore(5);

    assertEquals(15, bowlingFrameResult.calculateOverallScore());

    bowlingFrameResult.addBonusScore(5);

    assertEquals(20, bowlingFrameResult.calculateOverallScore());
  }
}
