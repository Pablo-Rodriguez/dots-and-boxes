public class Test {
  private static GameManager manager;

  public static void main(String[] args) {
    manager = new GameManager(3, 3);
    /*test1();
    test2();*/
  }

  private static void test1() {
    manager.getGameData().addEdge(new Edge(0, 0, 1, 0, false));
    System.out.println("Not yet");
    manager.getGameData().addEdge(new Edge(0, 0, 0, 1, false));
    System.out.println("Not yet");
    manager.getGameData().addEdge(new Edge(1, 0, 1, 1, false));
    System.out.println("Not yet");
    manager.getGameData().addEdge(new Edge(0, 1, 1, 1, false));
  }

  private static void test2() {
    manager.getGameData().addEdge(new Edge(1, 0, 2, 0, false));
    System.out.println("Not yet");
    manager.getGameData().addEdge(new Edge(1, 1, 2, 1, false));
    System.out.println("Not yet");
    manager.getGameData().addEdge(new Edge(2, 0, 2, 1, false));
  }
}
