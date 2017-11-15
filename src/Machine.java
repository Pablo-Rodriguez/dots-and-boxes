import java.util.*;

public class Machine {

  private GameData gameData;
  private QLearning qlearning;
  private Minimax minimax;

  public Machine(GameData gameData) {
    this.gameData = gameData;
    qlearning = new QLearning(gameData);
    minimax = new Minimax(gameData);
  }

  public boolean canPlaySafely() {
    for (int i = 0; i < gameData.getRows(); i++) {
      for (int j = 0; j < gameData.getColumns(); j++) {
        if (gameData.getMatrix()[i][j].getEdges() == 3) {
          return false;
        }
      }
    }
    return true;
  }

  public Edge play() {
    if (canPlaySafely()) {
      return qlearning.play();
    } else {
      return minimax.play();
    }
  }
}
