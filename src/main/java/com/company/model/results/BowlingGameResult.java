package com.company.model.results;

import com.company.model.BowlingFrame;

import java.util.List;

public class BowlingGameResult {
  private final int score;

  public BowlingGameResult(List<BowlingFrame> bowlingFrames) {
    score = bowlingFrames.stream().map(BowlingFrame::getBowlingFrameResult).mapToInt(BowlingFrameResult::calculateOverallScore).sum();
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    return "BowlingGameResult: score = " + score;
  }
}
