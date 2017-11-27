import java.util.*;

public class GameManager {
  private GameData gameData;
  private Machine machine;

  public GameManager(int rows, int columns) {
    gameData = new GameData(rows, columns);
    machine = new Machine(gameData);
    run();
  }

  public GameData getGameData () {
    return gameData;
  }

  private void run() {
    Scanner scan = new Scanner(System.in);
    while (true) {
      if (gameData.isPlayerTurn()) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("New %dx%d board started!\n", gameData.getMatrix().length, gameData.getMatrix()[0].length);
        drawBoard();
        System.out.printf("Player: %d \tMachine: %d\n", gameData.getPlayerPoints(), gameData.getMachinePoints());
        System.out.print("Enter initial point (x0 y0): ");
        String s = scan.nextLine();
        int x0 = Integer.parseInt(s.split(" ")[0]);
        int y0 = Integer.parseInt(s.split(" ")[1]);
        System.out.print("Enter terminal point (x1 y1): ");
        s = scan.nextLine();
        int x1 = Integer.parseInt(s.split(" ")[0]);
        int y1 = Integer.parseInt(s.split(" ")[1]);
        if (!gameData.addEdge(new Edge(x0, y0, x1, y1, true))) {
          continue;
        }
      } else {
        gameData.addEdge(machine.play());
        
      }
      if (gameData.getMachinePoints() + gameData.getPlayerPoints() == gameData.getRows() * gameData.getColumns()) {
        endGame();
        break;
      }
    }
    scan.close();
  }

  public void drawBoard() {
    System.out.println("\n\n\n\n\n\n");
    for (int i = 0; i < gameData.getMatrix().length + 1; i++) {
      for (int k = 0; k < gameData.getMatrix()[0].length + 1; k++) {
        drawRow(k, i);
      }
      System.out.print("\n");
      for (int intro = 0; intro < 7; intro++) {
        for (int k = 0; k < gameData.getMatrix().length + 1; k++) {
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
      for (Edge e : gameData.getEdges()) {
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
    for (Edge e : gameData.getEdges()) {
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

  private void endGame() {
    if (gameData.getMachinePoints() > gameData.getPlayerPoints()) {
      System.out.println("\n\n\n\nYOU LOSE!\n\n\n\n");
      System.out.printf("Player: %d \tMachine: %d\n", gameData.getPlayerPoints(), gameData.getMachinePoints());
    } else if (gameData.getMachinePoints() < gameData.getPlayerPoints()) {
      System.out.println("\n\n\n\nYOU WIN!\n\n\n\n");
      System.out.printf("Player: %d \tMachine: %d\n", gameData.getPlayerPoints(), gameData.getMachinePoints());
    } else {
      System.out.println("\n\n\n\nTIE!\n\n\n\n");
      System.out.printf("Player: %d \tMachine: %d\n", gameData.getPlayerPoints(), gameData.getMachinePoints());
    }
  }
}
