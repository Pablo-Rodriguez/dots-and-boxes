
public class PlayVector {

  private double[] vector;

  public PlayVector (String[] state, int size) {
    vector = new double[size];
    for (int i = 0; i < vector.length; i++) {
      vector[i] = state[i].equals("1") ? 0.0 : 1.0;
    }
    normalize();
  }

  public PlayVector (double[] vector) {
    this.vector = vector;
    normalize();
  }
  
  public double getMax () {
    double max = 0;
    for (double i:vector) {
      max = i > max ? i : max;
    }
    return max;
  }

  public int countNonZero () {
    int acc = 0;
    for (double i:vector) {
      if (i > 0) {
        acc++;
      }
    }
    return acc;
  }

  public void normalize () {
    double acc = 0;
    for (double i:vector) {
      acc += i;
    }
    if (acc != 0) {
      acc = 1 / acc;
    } else {
      acc = 0;
    }
    for (int i = 0; i < vector.length; i++) {
      vector[i] *= acc;
    }
  }

  public int randomPick () {
    double random = Math.random();
    double acc = 0;
    for (int i = 0; i < vector.length; i++) {
      acc += vector[i];
      if (random <= acc) {
        return i;
      }
    }
    return 0;
  }

  @Override
  public String toString () {
    String str = "";
    for (int i = 0; i < vector.length; i++) {
      str += String.valueOf(vector[i]);
      if (i < vector.length - 1) {
        str += " ";
      }
    }
    return str;
  }
}

