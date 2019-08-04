package com.company.model;

import com.company.model.results.BowlingGameResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BowlingGame {
  static final int NUMBER_OF_FRAMES = 10;

  private final List<BowlingFrame> bowlingFrames;
  private BowlingGameResult bowlingGameResult;

  public BowlingGame() {
    this.bowlingFrames = IntStream.rangeClosed(1, NUMBER_OF_FRAMES).mapToObj(BowlingFrame::new).collect(Collectors.toUnmodifiableList());
  }

  public List<BowlingFrame> getBowlingFrames() {
    return bowlingFrames;
  }

  public BowlingGameResult getBowlingGameResult() {
    return bowlingGameResult;
  }

  public void createBowlingGameResult() {
    bowlingGameResult = new BowlingGameResult(bowlingFrames);
  }
}
