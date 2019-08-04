# IT Bowling
This is a terminal based slot machine like bowling game.

It follows the standard bowling rules of ten frames per game. Each but the last frame consists of up to two rolls. The last frame consists of up to three rolls. The game result is the number of pins hit per frame plus eventual boni. Hitting all ten pins with the first roll is a strike. If all pins are down after the second roll it is a spare. A spare adds the amount of pins downed in the next roll as bonus to the frame, a strike the next two rolls.
If the player has a spare or strike in the last frame another roll is allowed, with a maximum of three rolls. The last frame does not add any bonus points. So the highest score for the last frame is 30 (three strikes).

# How to play the game
Clone the repository via 
```
git clone https://github.com/hedgehog1833/it-bowling-game.git
```
and execute the class ITBowlingMain.
Java 10 is required
