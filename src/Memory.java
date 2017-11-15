
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Memory {
  
  static private final String filename = "./qlearning-memory.txt";
  private Hashtable<Integer, PlayVector> memory;

  public Memory () {
    try {
      memory = loadFromFile();
      System.out.println("Encontrada memoria archivada. Cargando memoria desde archivo.");
    } catch (Exception e) {
      memory = new Hashtable<Integer, PlayVector>();
      populate();
      saveToFile();
      System.out.println("Memoria inexistente o no accesible. Creando nueva memoria.");
    }
  }
  
  public Hashtable<Integer, PlayVector> getValue () {
    return memory;
  }

  private Hashtable<Integer, PlayVector> loadFromFile () throws Exception {
    FileReader fr = null;
    BufferedReader br = null;
    try {
      Hashtable<Integer, PlayVector> loaded = new Hashtable<Integer, PlayVector>();
      fr = new FileReader(filename);
      br = new BufferedReader(fr);
      String line;
      String[] stateAction;
      Integer state;
      double[] actions;

      while((line = br.readLine()) != null) {
        stateAction = line.split(" ");
        state = Integer.parseInt(stateAction[0]);
        actions = new double[stateAction.length - 1];
        for (int i = 1; i < stateAction.length; i++) {
          actions[i - 1] = Double.parseDouble(stateAction[i]);
        }
        loaded.put(state, new PlayVector(actions));
      }
      
      br.close();
      fr.close();

      return loaded;
    } catch (Exception e) {
      try {
        br.close();
        fr.close();
      } catch (Exception err) {}
      throw e;
    }
  }

  private void saveToFile () {
    FileWriter fw = null;
    BufferedWriter bw = null;
    try {
      fw = new FileWriter(filename);
      bw = new BufferedWriter(fw);

      for (Map.Entry<Integer, PlayVector> entry:memory.entrySet()) {
        bw.write(entry.getKey() + " " + entry.getValue().toString() + "\n");
      }
      bw.close();
      fw.close();
    } catch (Exception e) {
      try {
        bw.close();
        fw.close();
      } catch (Exception err) {}
      System.out.println("No se ha podido guardar el estado de QLearning");
    }
  }

  public void populate () {
    for (int i = 0; i < (Math.pow(2, 12) - 1); i++) {
      memory.put(i, generateVectorFromState(i));
    }
  }

  public PlayVector generateVectorFromState (int i) {
    String str = Integer.toBinaryString(i);
    int offset = 12 - str.length();
    for (int j = 0; j < offset; j++) {
      str = "0".concat(str);
    }
    return new PlayVector(str.split(""), 12);
  }
}
