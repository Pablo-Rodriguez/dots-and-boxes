public class Box {
  private boolean player;
  private int edges = 0;

  public Box() {
  }

  public Box(boolean player) {
    this.player = player;
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
}