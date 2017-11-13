import java.util.*;
import java.util.concurrent.TimeUnit;
public class Minimax {

  private ArrayList<Edge> edges;
  private Box[][] matrix;
  private int rows;
  private int columns;
  private GameManager gm;
  private boolean foundBox;

  public Minimax (ArrayList<Edge> edges, Box[][] matrix, int rows, int columns) {
    this.edges = edges;
    this.rows = rows;
    this.columns = columns;
    this.matrix = matrix;
  }

  public Edge play (GameManager gm) {
    this.gm=gm;
    foundBox = false;
    Edge e = lookForBox();
    if(foundBox){
      return e;
    }else{
      return new Edge(2, 2, 2, 3, false);
    }
  }

  private Edge lookForBox(){
    int machinePoints = gm.machinePoints;
    for(int i = 0; i < this.matrix.length; i++){
      for(int j = 0; j < this.matrix.length +1; j++){

        if (gm.addEdge(new Edge(i,j,i+1,j, false))) {
          try{
          }catch(Exception e){

          }
          if(gm.machinePoints > machinePoints){
            gm.machinePoints--;
            gm.removeEdge(i,j,i+1,j);
            foundBox = true;
            return new Edge(i,j,i+1,j,false);
          }else{
            gm.removeEdge(i,j,i+1,j);
          }
        }
      }
    }
    for(int i = 0; i < this.matrix.length +1; i++){
      for(int j = 0; j < this.matrix.length; j++){
        if (gm.addEdge(new Edge(i,j,i,j+1, false))) {
          try{
          }catch(Exception e){

          }
          if(gm.machinePoints > machinePoints){
            gm.machinePoints--;
            gm.removeEdge(i,j,i,j+1);
            foundBox=true;
            return new Edge(i,j,i,j+1,false);
          }else{
            gm.removeEdge(i,j,i,j+1);
          }
        }
      }
    }
    return new Edge(10,10,10,10,false);
  }
}
