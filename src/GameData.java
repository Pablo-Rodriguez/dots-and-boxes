
import java.util.*;

public class GameData {

  private ArrayList<Edge> edges  = new ArrayList<Edge>();
  private Box[][] matrix;
  private int rows;
  private int columns;
  private int playerPoints = 0;
  private int machinePoints = 0;
  private boolean playerTurn = true;

  public GameData (int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    matrix = new Box[rows][columns];
    populateMatrix();
  }
  public GameData (ArrayList<Edge> new_edges, Box[][] new_matrix, int rows, int columns, int playerPoints, int machinePoints, boolean playerTurn){
    edges=new ArrayList<Edge>();
    this.rows = rows;
    this.columns = columns;
    this.playerPoints = playerPoints;
    this.machinePoints = machinePoints;
    matrix = new Box[rows][columns];
    populateMatrix();
    for(Edge e: new_edges){
      addEdge(e);
    }
    this.playerTurn = playerTurn;


  }
  public ArrayList<Edge> getEdges () {
    return this.edges;
  }

  public Box[][] getMatrix () {
    return this.matrix;
  }

  public int getRows () {
    return this.rows;
  }

  public int getColumns () {
    return this.columns;
  }

  public int getPlayerPoints () {
    return this.playerPoints;
  }

  public int getMachinePoints () {
    return this.machinePoints;
  }

  public boolean isPlayerTurn () {
    return this.playerTurn;
  }

  public void setMachinePoints (int machinePoints) {
    this.machinePoints = machinePoints;
  }

  private void changeTurn () {
    playerTurn = !playerTurn;
  }

  private void populateMatrix() {
    for (int x = 0; x < this.matrix.length; x++) {
      for (int y = 0; y < this.matrix[x].length; y++) {
        matrix[x][y] = new Box(x, y);
      }
    }
  }

  public boolean addEdge(Edge newEdge) {
    if (!isEdgeValid(newEdge)) {
      return false;
    }
    for (Edge e : edges) {
      if (e.equals(newEdge)) {
        return false;
      }
    }
    edges.add(newEdge);
    checkBoxes(newEdge);
    return true;
  }

  private int checkBox(int x, int y) {
    Box b = matrix[x][y];
    b.addEdge();
    if (b.getEdges() == 4) {
      if (playerTurn) {
        this.playerPoints++;
      } else {
        this.machinePoints++;
      }
      return 1;
    }
    return 0;
  }

  private void checkBoxes(Edge newEdge) {
    int x = newEdge.x0 == matrix[0].length ? newEdge.x0 - 1 : newEdge.x0;
    int y = newEdge.y0 == matrix.length ? newEdge.y0 - 1 : newEdge.y0;
    int points = checkBox(x, y);
    if (newEdge.isHorizontal()) {
      if (newEdge.y0 > 0 && newEdge.y0 < matrix.length) {
        points += checkBox(x, newEdge.y0 - 1);
      }
    } else {
      if (newEdge.x0 > 0 && newEdge.x0 < matrix[y].length) {
        points += checkBox(newEdge.x0 - 1, y);
      }
    }
    if (points == 0) {
      this.changeTurn();
    }
  }

  private boolean isEdgeValid(Edge newEdge) {
    if (newEdge.x0 < 0 || newEdge.y0 < 0 || newEdge.x1 < 0 || newEdge.y1 < 0) {
      return false;
    }
    if (newEdge.x1 > this.columns || newEdge.y1 > this.rows || newEdge.x0 > this.columns || newEdge.y0 > this.rows) {
      return false;
    }
    if (newEdge.x1 - newEdge.x0 == 1 && newEdge.y1 - newEdge.y0 == 0) {
      return true;
    }
    if (newEdge.x1 - newEdge.x0 == 0 && newEdge.y1 - newEdge.y0 == 1) {
      return true;
    }
    return false;
  }
}
