
import java.util.*;

public class Memory {
  
  private Hashtable<Integer, PlayVector> memory;

  public Memory () {
    memory = new Hashtable<Integer, PlayVector>();
    populate();
  }
  
  public Hashtable<Integer, PlayVector> getValue () {
    return memory;
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
