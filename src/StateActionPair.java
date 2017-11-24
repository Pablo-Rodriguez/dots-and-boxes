
import java.util.*;

public class StateActionPair {

  private int x;
  private int y;
  private int state;
  private Memory memory;
  private PlayVector vector;

  public StateActionPair (ArrayList<Edge> edges, Memory memory, int x, int y) {
    this.x = x;
    this.y = y;
    this.memory = memory;
    this.state = getState(edges, x, y);
    this.vector = memory.getValue().get(this.state);
  }

  public String findEdge (ArrayList<Edge> edges, Edge against) {
    for (Edge edge:edges) {
      if (edge.equals(against)) {
        return "1";
      }
    }
    return "0";
  }
  
  public PlayVector getVector () {
    return this.vector;
  }

  public int getState (ArrayList<Edge> edges, int x, int y) {
    String[] state = new String[12];
    
    for (int i = 0; i < state.length; i++) {
      state[i] = findEdge(edges, actionToEdge(i));
    }

    return Integer.parseInt(String.join("", state), 2);
  }

  private Edge actionToEdge (int i) {
    switch (i) {
      case 0:
        return new Edge(x - 1, y - 1, x, y - 1, false);
      case 1:
        return new Edge(x, y - 1, x + 1, y - 1, false);
      case 2:
        return new Edge(x - 1, y - 1, x - 1, y, false);
      case 3:
        return new Edge(x, y - 1, x, y, false);
      case 4:
        return new Edge(x + 1, y - 1, x + 1, y, false);
      case 5:
        return new Edge(x - 1, y, x, y, false);
      case 6:
        return new Edge(x, y, x + 1, y, false);
      case 7:
        return new Edge(x - 1, y, x - 1, y + 1, false);
      case 8:
        return new Edge(x, y, x, y + 1, false);
      case 9:
        return new Edge(x + 1, y, x + 1, y + 1, false);
      case 10:
        return new Edge(x - 1, y + 1, x, y + 1, false);
      case 11:
        return new Edge(x, y + 1, x + 1, y + 1, false);
      default:
        return new Edge(x - 1, y - 1, x, y - 1, false);
    }
  }

  public Edge randomPick () {
    int nextAction = vector.randomPick();
    memory.addPlay(this.state, nextAction);
    return actionToEdge(nextAction);
  }
}
