
import java.util.*;

public class GameData {
  
  private ArrayList<Edge> edges = new ArrayList<Edge>();
  private Box[][] matrix;
  private int rows;
  private int columns;
  public int playerPoints = 0;
  public int machinePoints = 0; 
  public boolean playerTurn = false;

  public GameData (int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    matrix = new Box[rows][columns];
    populateMatrix();
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

  public void changeTurn () {
    playerTurn = !playerTurn;
  }

  private void populateMatrix() {
    for (int x = 0; x < this.matrix.length; x++) {
      for (int y = 0; y < this.matrix[x].length; y++) {
        matrix[x][y] = new Box();
      }
    }
  }

  public boolean addEdge(Edge newEdge) {
    for (Edge e : edges) {
      if (e.equals(newEdge)) {
        return false;
      }
    }
    edges.add(newEdge);
    checkBoxes(newEdge, true);
    return true;
  }

  public void removeEdge(int x0, int y0, int x1, int y1){
    Iterator<Edge> it = edges.iterator();
    while (it.hasNext()) {
      Edge edge = it.next();
      if (edge.x0 == x0 && edge.y0 == y0 && edge.x1 == x1 && edge.y1 == y1) {
        checkBoxes(edge, false);
        it.remove();
      }
    }
  }

  private void checkBox(int x, int y, boolean isNew) {
    Box b = matrix[x][y];
    if(isNew){
      b.addEdge();
    }else{
      b.removeEdge();
    }
    if (b.getEdges() == 4) {
      if (playerTurn) {
        this.playerPoints++;
      } else {
        this.machinePoints++;
      }
    }
  }

  private void checkBoxes(Edge newEdge, boolean isNew) {
    int x = newEdge.x0 == matrix[0].length ? newEdge.x0 - 1 : newEdge.x0;
    int y = newEdge.y0 == matrix.length ? newEdge.y0 - 1 : newEdge.y0;
    checkBox(x, y, isNew);
    if (newEdge.isHorizontal()) {
      if (newEdge.y0 > 0 && newEdge.y0 < matrix.length) {
        checkBox(x, newEdge.y0 - 1, isNew);
      }
    } else {
      if (newEdge.x0 > 0 && newEdge.x0 < matrix[y].length) {
        checkBox(newEdge.x0 - 1, y, isNew);
      }
    }
  }
}
