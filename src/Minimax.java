import java.util.*;

public class Minimax {

  private GameData gameData;

  public Minimax(GameData gameData) {
    this.gameData = gameData;
  }

  public Edge play() {
    ArrayList<Box> boxes = almostClosedBoxes();
    if (boxes.size() == 1) {
      return getMissingEdge(boxes.get(0));
    }
    return getMissingEdge(boxes.get(0));
  }

  private ArrayList<Box> almostClosedBoxes() {
    ArrayList<Box> boxes = new ArrayList<Box>();
    for (int i = 0; i < gameData.getRows(); i++) {
      for (int j = 0; j < gameData.getColumns(); j++) {
        if (gameData.getMatrix()[i][j].getEdges() == 3) {
          boxes.add(gameData.getMatrix()[i][j]);
        }
      }
    }
    return boxes;
  }

  private Edge getMissingEdge(Box b) {
    Edge e = new Edge(b.getX(), b.getY(), b.getX() + 1, b.getY(), false);
    if (!edgeExists(e)) {
      return e;
    }
    e = new Edge(b.getX(), b.getY(), b.getX(), b.getY() + 1, false);
    if (!edgeExists(e)) {
      return e;
    }
    e = new Edge(b.getX() + 1, b.getY(), b.getX() + 1, b.getY() + 1, false);
    if (!edgeExists(e)) {
      return e;
    }
    return new Edge(b.getX(), b.getY() + 1, b.getX() + 1, b.getY() + 1, false);
  }

  private boolean edgeExists(Edge newEdge) {
    for (Edge e : this.gameData.getEdges()) {
      if (e.equals(newEdge)) {
        return true;
      }
    }
    return false;
  }
}
