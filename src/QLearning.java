
import java.util.*;

public class QLearning {
  
  private GameData gameData;
  private Memory memory;

  public QLearning (GameData gameData) {
    this.gameData = gameData;
    this.memory = new Memory();
  }

  public Edge play () {
    ArrayList<StateActionPair> list = new ArrayList<StateActionPair>();
    double[] vector = new double[(gameData.getRows() - 1) * (gameData.getColumns() - 1)];
    for (int y = 1; y < gameData.getRows(); y++) {
      for (int x = 1; x < gameData.getColumns(); x++) {
        list.add(new StateActionPair(gameData.getEdges(), memory.getValue(), x, y));
      }
    }
    for (int i = 0; i < list.size(); i++) {
      vector[i] = list.get(i).getVector().getMax();
    }
    StateActionPair selectedZone = list.get(new PlayVector(vector).randomPick());
    return selectedZone.randomPick();
  }
}

