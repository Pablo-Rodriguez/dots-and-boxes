
import java.util.*;

public class Minimax {
  
  private ArrayList<Edge> edges;
  private Box[][] matrix;
  private int rows;
  private int columns;

  public Minimax (ArrayList<Edge> edges, Box[][] matrix, int rows, int columns) {
    this.edges = edges;
    this.rows = rows;
    this.columns = columns;
    this.matrix = matrix;
  }

  public Edge play () {
    return new Edge(2, 2, 2, 3, false);
  }
}

