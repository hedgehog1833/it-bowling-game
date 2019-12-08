package com.company.game;

import com.company.model.BowlingGame;
import com.company.model.results.BowlingGameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class BowlingGamePlatformTest {

  @Mock
  private BowlingRoller bowlingRoller;
  private BowlingGamePlatform bowlingGamePlatform;

  @BeforeEach
  void setUp() {
    bowlingGamePlatform = new BowlingGamePlatform(bowlingRoller);
  }

  @Test
  void playPerfectBowlingGame() {
    Mockito.when(bowlingRoller.roll(anyInt())).thenReturn(10);

    BowlingGame bowlingGame = new BowlingGame();
    bowlingGamePlatform.playBowlingGame(bowlingGame);
    BowlingGameResult bowlingGameResult = bowlingGame.getBowlingGameResult();

    assertEquals(301, bowlingGameResult.getScore());
  }

  @Test
  void playWorstBowlingGame() {
    Mockito.when(bowlingRoller.roll(anyInt())).thenReturn(0);

    BowlingGame bowlingGame = new BowlingGame();
    bowlingGamePlatform.playBowlingGame(bowlingGame);
    BowlingGameResult bowlingGameResult = bowlingGame.getBowlingGameResult();

    assertEquals(0, bowlingGameResult.getScore());
  }

  @Test
  void playExerciseSheetBowlingGame() {
    Mockito.when(bowlingRoller.roll(anyInt())).thenReturn(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6);

    BowlingGame bowlingGame = new BowlingGame();
    bowlingGamePlatform.playBowlingGame(bowlingGame);
    BowlingGameResult bowlingGameResult = bowlingGame.getBowlingGameResult();

    assertEquals(133, bowlingGameResult.getScore());
  }
}
