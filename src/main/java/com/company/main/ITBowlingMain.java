package com.company.main;

import com.company.game.BowlingGamePlatform;
import com.company.game.BowlingRollerImpl;
import com.company.model.BowlingGame;
import com.company.model.results.BowlingGameResult;

public class ITBowlingMain {

  public static void main(String[] args) {
    BowlingGamePlatform bowlingGamePlatform = new BowlingGamePlatform(new BowlingRollerImpl());
    BowlingGame game = new BowlingGame();
    bowlingGamePlatform.playBowlingGame(game);
    BowlingGameResult bowlingGameResult = game.getBowlingGameResult();

    System.out.println(bowlingGameResult);
  }
}
