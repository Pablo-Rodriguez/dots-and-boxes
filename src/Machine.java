import java.util.*;

public class Machine {

  private ArrayList<Edge> edges;
  private Box[][] matrix;
  private int rows;
  private int columns;
  private QLearning qlearning;
  private Minimax minimax;

  public Machine (ArrayList<Edge> edges, Box[][] matrix, int rows, int columns) {
    this.edges = edges;
    this.rows = rows;
    this.columns = columns;
    this.matrix = matrix;
    qlearning = new QLearning(edges, matrix, rows, columns);
    minimax = new Minimax(edges, matrix, rows, columns);
  }

  public boolean canPlaySafely () {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (matrix[i][j].getEdges() <= 2) {
          return true;
        }
      }
    }
    return false;
  }

  public Edge play (GameManager gm) {
  //  if (canPlaySafely()) {
    //  return qlearning.play();
    //} else {
      return minimax.play(gm);
    //}
  }
}
