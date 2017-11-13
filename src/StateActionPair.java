
import java.util.*;

public class StateActionPair {

  private ArrayList<Edge> edges;

  public StateActionPair (ArrayList<Edge> edges) {
    this.edges = edges;
  }

  public boolean findEdge (int x0, int y0, int x1, int y1) {
    Edge against = new Edge(x0, y0, x1, y1, false);
    for (Edge edge:edges) {
      if (edge.equals(against)) {
        return true;
      }
    }
    return false;
  }

  private void printState (boolean [] state) {
    System.out.print("[");
    for (boolean edge:state) {
      if (edge) {
        System.out.print("1");
      } else {
        System.out.print("0");
      }
    }
    System.out.println("]");
  }

  public void getPair (int x, int y) {
    boolean[] state = new boolean[12];

    state[0] = findEdge(x - 1, y - 1, x, y - 1);
    state[1] = findEdge(x, y - 1, x + 1, y - 1);

    state[2] = findEdge(x - 1, y - 1, x - 1, y);
    state[3] = findEdge(x, y - 1, x, y);
    state[4] = findEdge(x + 1, y - 1, x + 1, y);
    
    state[5] = findEdge(x - 1, y, x, y);
    state[6] = findEdge(x, y, x + 1, y);
    
    state[7] = findEdge(x - 1, y, x - 1, y + 1);
    state[8] = findEdge(x, y, x, y + 1);
    state[9] = findEdge(x + 1, y, x + 1, y + 1);
    
    state[10] = findEdge(x - 1, y + 1, x, y + 1);
    state[11] = findEdge(x, y + 1, x + 1, y + 1);

    printState(state);
  }
}
