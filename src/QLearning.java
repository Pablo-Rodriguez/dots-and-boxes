
import java.util.*;

public class QLearning {
  
  private GameData gameData;
  private Memory memory;
  private int playerPoints = 0;
  private int machinePoints = 0;

  public QLearning (GameData gameData) {
    this.gameData = gameData;
    this.memory = new Memory();
  }

  public Edge play () {
    double feedback = (gameData.getMachinePoints() - machinePoints) - (gameData.getPlayerPoints() - playerPoints);
    memory.train(feedback);
    playerPoints = gameData.getPlayerPoints();
    machinePoints = gameData.getMachinePoints();
    ArrayList<StateActionPair> list = new ArrayList<StateActionPair>();
    double[] vector = new double[(gameData.getRows() - 1) * (gameData.getColumns() - 1)];
    for (int y = 1; y < gameData.getRows(); y++) {
      for (int x = 1; x < gameData.getColumns(); x++) {
        list.add(new StateActionPair(gameData.getEdges(), memory, x, y));
      }
    }
    for (int i = 0; i < list.size(); i++) {
      PlayVector vec = list.get(i).getVector();
      System.out.println(vec);
      vector[i] = vec.getMax();
    }
    StateActionPair selectedZone = list.get(new PlayVector(vector).randomPick());
    Edge currentPlay = selectedZone.randomPick();
    return currentPlay;
  }
}

