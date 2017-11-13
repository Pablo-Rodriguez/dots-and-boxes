
import java.util.*;

public class QLearning {
  
  private ArrayList<Edge> edges;
  private Box[][] matrix;
  private int rows;
  private int columns;
  private StateActionPair stateActionPair;

  public QLearning (ArrayList<Edge> edges, Box[][] matrix, int rows, int columns) {
    this.edges = edges;
    this.rows = rows;
    this.columns = columns;
    this.matrix = matrix;
    this.stateActionPair = new StateActionPair(edges);
  }

  public Edge play () {
    for (int y = 1; y < rows; y++) {
      for (int x = 1; x < columns; x++) {
        stateActionPair.getPair(x, y);
      }
    }
    return new Edge(2, 2, 2, 3, false);
  }
}

