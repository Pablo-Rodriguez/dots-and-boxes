import java.util.*;

public class GameManager {
  private ArrayList<Edge> edges = new ArrayList<Edge>();
  private Box[][] matrix;
  private Machine machine;
  private int playerPoints = 0;
  private int machinePoints = 0;
  private boolean player;

  public GameManager(int rows, int columns) {
    matrix = new Box[rows][columns];
    populateMatrix();
    machine = new Machine(edges, matrix, rows, columns);
    run();
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
      if (player) {
        this.playerPoints++;
      } else {
        this.machinePoints++;
      }
    }
  }

  private void run() {
    Scanner scan = new Scanner(System.in);
    while (true) {
      if (player) {
        System.out.println(player);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("New %dx%d board started!\n", this.matrix.length, this.matrix.length);
        drawBoard();
        System.out.printf("Player: %d \tMachine: %d\n", this.playerPoints, this.machinePoints);
        System.out.print("Enter initial point (x0 y0): ");
        String s = scan.nextLine();
        int x0 = Integer.parseInt(s.split(" ")[0]);
        int y0 = Integer.parseInt(s.split(" ")[1]);
        System.out.print("Enter terminal point (x1 y1): ");
        s = scan.nextLine();
        int x1 = Integer.parseInt(s.split(" ")[0]);
        int y1 = Integer.parseInt(s.split(" ")[1]);
        if (!this.addEdge(new Edge(x0, y0, x1, y1, player))) {
          break;
        }
      } else {
        this.addEdge(machine.play());
      }
      this.player = !this.player;
    }
    scan.close();
  }

  private void drawBoard() {
    System.out.println("\n\n\n\n\n\n");
    for (int i = 0; i < this.matrix.length + 1; i++) {
      for (int k = 0; k < this.matrix.length + 1; k++) {
        drawRow(k, i);
      }
      System.out.print("\n");
      for (int intro = 0; intro < 7; intro++) {
        for (int k = 0; k < this.matrix.length + 1; k++) {
          drawColumn(i, i + 1, k);
        }
        System.out.print("\n");
      }
    }
  }

  private void drawRow(int x, int y) {
    if (x == 0) {
      System.out.printf("%14s", "*");
    } else {
      Edge newEdge = new Edge(x - 1, y, x, y, false);
      for (Edge e : edges) {
        if (e.equals(newEdge)) {
          System.out.print("--------------");
          newEdge = null;
          break;
        }
      }
      if (newEdge != null) {
        System.out.printf("%14s", "");
      }
      System.out.print("*");
    }
  }

  private void drawColumn(int y0, int y1, int x) {
    Edge newEdge = new Edge(x, y0, x, y1, false);
    if (x == 0) {
      System.out.printf("%13s", "");
    }
    for (Edge e : edges) {
      if (e.equals(newEdge)) {
        System.out.printf("%-15s", "|");
        newEdge = null;
        break;
      }
    }
    if (newEdge != null) {
      System.out.printf("%15s", "");
    }
  }
}
