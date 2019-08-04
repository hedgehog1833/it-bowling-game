package com.company.model.results;

import com.company.model.Bonus;
import com.company.model.BowlingFrame;
import com.company.model.BowlingRoll;

import java.util.ArrayList;
import java.util.List;

public class BowlingFrameResult {
  private final int rollsScore;
  private final Bonus bonus;
  private final List<Integer> bonusScores;

  public BowlingFrameResult(List<BowlingRoll> bowlingRolls) {
    bonusScores = new ArrayList<>();
    rollsScore = bowlingRolls.stream().map(BowlingRoll::getPinsHit).reduce(0, Integer::sum);

    if (allPinsHitFirstTry(bowlingRolls)) {
      bonus = Bonus.STRIKE;
    } else if (allPinsHitLastTry(bowlingRolls)) {
      bonus = Bonus.SPARE;
    } else {
      bonus = Bonus.NONE;
    }
  }

  public Bonus getBonus() {
    return bonus;
  }

  public void addBonusScore(int bonusScore) {
    bonusScores.add(bonusScore);
  }

  public int calculateOverallScore() {
    return rollsScore + bonusScores.stream().mapToInt(integer -> integer).sum();
  }

  private boolean allPinsHitFirstTry(List<BowlingRoll> bowlingRolls) {
    return bowlingRolls.get(0).getPinsHit() == BowlingFrame.MAX_NUMBER_OF_PINS;
  }

  private boolean allPinsHitLastTry(List<BowlingRoll> bowlingRolls) {
    return bowlingRolls.get(bowlingRolls.size() - 1).getPinsStandingAfterRoll() == 0;
  }

  @Override
  public String toString() {
    return "FrameResult: " + "Rolls score = " + rollsScore + "; Bonus : " + bonus + "; Bonus scores: " + bonusScores;
  }
}
