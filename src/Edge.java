public class Edge {
  protected int x0;
  protected int y0;
  protected int x1;
  protected int y1;
  private boolean player;

  public Edge(int x0, int y0, int x1, int y1, boolean player) {
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
    this.player = player;
  }

  public boolean isOwnedByPlayer() {
    return this.player;
  }

  public boolean equals(Edge e) {
    if ((this.x0 == e.x0 && this.y0 == e.y0 && this.x1 == e.x1 && this.y1 == e.y1) ||
        (this.x0 == e.x1 && this.y0 == e.y1 && this.x1 == e.x0 && this.y1 == e.y0)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isHorizontal() {
    return (x1 - x0) != 0;
  }
}
