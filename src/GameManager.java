import java.util.*;

public class GameManager {
  private ArrayList<Edge> edges = new ArrayList<Edge>();
  private Box[][] matrix;

  public GameManager(int rows, int columns) {
    matrix = new Box[rows][columns];
    populateMatrix();
    System.out.println("New " + rows + "x" + columns + " board started!");
  }

  public boolean addEdge(Edge newEdge) {
    for (Edge e : edges) {
      if (e.equals(newEdge)) {
        return false;
      }
    }
    edges.add(newEdge);
    checkBoxes(newEdge);
    return true;
  }

  private void populateMatrix() {
    for (int x = 0; x < this.matrix.length; x++) {
      for (int y = 0; y < this.matrix[x].length; y++) {
        matrix[x][y] = new Box();
      }
    }
  }

  private void checkBoxes(Edge newEdge) {
    int x = newEdge.x0 == matrix[0].length ? newEdge.x0 - 1 : newEdge.x0;
    int y = newEdge.y0 == matrix.length ? newEdge.y0 - 1 : newEdge.y0;
    checkBox(x, y);
    if (newEdge.isHorizontal()) {
      if (newEdge.y0 > 0 && newEdge.y0 < matrix.length) {
        checkBox(x, newEdge.y0 - 1);
      }
    } else {
      if (newEdge.x0 > 0 && newEdge.x0 < matrix[y].length) {
        checkBox(newEdge.x0 - 1, y);
      }
    }
  }

  private void checkBox(int x, int y) {
    Box b = matrix[x][y];
    b.addEdge();
    if (b.getEdges() == 4) {
      System.out.println("Box filled");
    }
  }
}