public class Box {
  private boolean player;
  private int x;
  private int y;
  private int edges = 0;

  public Box(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean isOwnedByPlayer() {
    return this.player;
  }

  public void addEdge() {
    this.edges++;
  }

  public int getEdges() {
    return this.edges;
  }

  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }
}
