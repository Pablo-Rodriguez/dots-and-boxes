
import java.util.*;

public class QLearning {
  
  private GameData gameData;
  private StateActionPair stateActionPair;

  public QLearning (GameData gameData) {
    this.gameData = gameData;
    this.stateActionPair = new StateActionPair(gameData.getEdges());
  }

  public Edge play () {
    for (int y = 1; y < gameData.getRows(); y++) {
      for (int x = 1; x < gameData.getColumns(); x++) {
        stateActionPair.getPair(x, y);
      }
    }
    return new Edge(2, 2, 2, 3, false);
  }
}

