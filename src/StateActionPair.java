
import java.util.*;

public class StateActionPair {

  private ArrayList<Edge> edges;

  public StateActionPair (ArrayList<Edge> edges) {
    this.edges = edges;
  }

  public String findEdge (int x0, int y0, int x1, int y1) {
    Edge against = new Edge(x0, y0, x1, y1, false);
    for (Edge edge:edges) {
      if (edge.equals(against)) {
        return "1";
      }
    }
    return "0";
  }

  private void printState (String[] state) {
    System.out.print("[");
    for (String edge:state) {
      System.out.print(edge);
    }
    System.out.println("]");
  }

  public int getState (int x, int y) {
    String[] state = new String[12];

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
    return Integer.parseInt(String.join("", state), 2);
  }

  public void getPair (int x, int y) {
    getState(x, y);
  }
}
