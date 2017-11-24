
public class PlayVector {

  private double[] vector;

  public PlayVector (String[] state, int size) {
    vector = new double[size];
    for (int i = 0; i < vector.length; i++) {
      vector[i] = state[i].equals("1") ? 0.0 : 1.0;
    }
  }

  public PlayVector (double[] vector) {
    this.vector = vector;
  }

  public void train (int action, double feedback, double learningRate) {
    vector[action] += learningRate * feedback;
  }

  private double[] normalize () {
    double[] normalized = new double[vector.length];
    double acc = 0;
    for (double i:vector) {
      acc += i;
    }
    for (int i = 0; i < vector.length; i++) {
      normalized[i] = acc > 0 ? vector[i] / acc : 0;
    }
    return normalized;
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

  public int randomPick () {
    double random = Math.random();
    double acc = 0;
    double[] normalized = normalize();
    for (int i = 0; i < normalized.length; i++) {
      acc += normalized[i];
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

