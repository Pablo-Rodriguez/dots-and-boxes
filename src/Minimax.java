import java.util.*;
import java.util.concurrent.TimeUnit;
public class Minimax {

  private GameData gameData;
  private boolean foundBox;

  public Minimax (GameData gameData) {
    this.gameData = gameData;
  }

  public Edge play () {
    foundBox = false;
    Edge e = lookForBox();
    if (foundBox) {
      return e;
    } else {
      return new Edge(2, 2, 2, 3, false);
    }
  }

  private Edge lookForBox(){
    int machinePoints = gameData.getMachinePoints();
    for (int i = 0; i < gameData.getMatrix().length; i++) {
      for (int j = 0; j < gameData.getMatrix().length +1; j++) {
        if (gameData.addEdge(new Edge(i, j, i + 1, j, false))) {
          if (gameData.getMachinePoints() > machinePoints) {
            gameData.setMachinePoints(machinePoints);
            gameData.removeEdge(i, j, i + 1, j);
            foundBox = true;
            return new Edge(i, j, i + 1, j, false);
          } else {
            gameData.removeEdge(i, j, i + 1, j);
          }
        }
      }
    }
    for (int i = 0; i < gameData.getMatrix().length +1; i++) {
      for (int j = 0; j < gameData.getMatrix().length; j++) {
        if (gameData.addEdge(new Edge(i, j, i, j + 1, false))) {
          if (gameData.getMachinePoints() > machinePoints) {
            gameData.setMachinePoints(machinePoints);
            gameData.removeEdge(i, j, i, j + 1);
            foundBox = true;
            return new Edge(i, j, i, j + 1, false);
          } else {
            gameData.removeEdge(i, j, i, j + 1);
          }
        }
      }
    }
    return new Edge(10,10,10,10,false);
  }
}

