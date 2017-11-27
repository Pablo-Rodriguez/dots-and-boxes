import java.util.*;
import java.util.concurrent.TimeUnit;
public class Minimax {

  private GameData gameData;

  public Minimax(GameData gameData) {
    this.gameData = gameData;
  }

  public Edge play() {
    ArrayList<Box> boxes = almostClosedBoxes();
    if (boxes.size() == 1) {
      return getMissingEdge(boxes.get(0));
    }else{
      HashMap<Integer,Edge> values = new HashMap<Integer, Edge>();
      for(int i = 0; i < gameData.getMatrix().length +1; i++){
        for(int j = 0; j < gameData.getMatrix().length; j++){
          Edge edge = new Edge(i, j, i, j+1, false);
          int value =miniMax(gameData,edge,3,false);
          if(value != 100){
            values.put(value,edge);
          }
        }
      }
      for(int i = 0; i < gameData.getMatrix().length; i++){
        for(int j = 0; j < gameData.getMatrix().length +1; j++){
          Edge edge = new Edge(i, j, i+1, j, false);
          int value = miniMax(gameData,edge,3,false);
          if(value != 100){
            values.put(value,edge);
          }
        }
      }
      HashMap.Entry<Integer,Edge> biggest=values.entrySet().iterator().next();
      int selected = biggest.getKey();
      for(HashMap.Entry<Integer, Edge> hm  : values.entrySet()) {
        if(hm.getKey() > selected){
          biggest = hm;
        }
      }
      return biggest.getValue();
    }
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


  private int miniMax(GameData gameData,Edge edge, int depth, boolean isPlayerTurn){
    GameData gd= new GameData(gameData.getEdges(), gameData.getMatrix(), gameData.getRows(), gameData.getColumns(), gameData.getPlayerPoints(), gameData.getMachinePoints(), isPlayerTurn);
    int machinePoints = gd.getMachinePoints();
    int playerPoints = gd.getPlayerPoints();
    int value = 0;
    if(gd.addEdge(edge)) {
      if(gd.getPlayerPoints() > playerPoints){
        value =  -1;
      }else if(gd.getMachinePoints() > machinePoints){
        value = 1;
      }else{
        value = 0;
      }
      if(depth == 1){
        return value;
      }
      else{

        depth --;
        isPlayerTurn = !isPlayerTurn;
        HashMap<Integer,Edge> vals = new HashMap<Integer, Edge>();
        for(int i = 0; i < gd.getMatrix().length +1; i++){
          for(int j = 0; j < gd.getMatrix().length; j++){
            Edge e = new Edge(i, j, i, j+1, isPlayerTurn);
            int val =miniMax(gd,e,depth,isPlayerTurn);
            if(val != 100){
              vals.put(val,edge);
            }
          }
        }

        for(int i = 0; i < gd.getMatrix().length; i++){
          for(int j = 0; j < gd.getMatrix().length +1; j++){
            Edge e = new Edge(i, j, i+1, j, isPlayerTurn);
            int val = miniMax(gd,e,depth,isPlayerTurn);
            if(val != 100){
              vals.put(val,edge);
            }
          }
        }

        HashMap.Entry<Integer,Edge> biggest=vals.entrySet().iterator().next();
        int selected = biggest.getKey();
        for(HashMap.Entry<Integer, Edge> hm  : vals.entrySet()) {
            if(hm.getKey() > selected){
              biggest = hm;
            }
        }

        return value+biggest.getKey();
      }
    }else{
      return 100;
    }
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
