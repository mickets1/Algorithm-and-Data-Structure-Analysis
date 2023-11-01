package uppgift1;

public class Edge {
  private int src;
  private int dst;
  private double weight;

  // constructor for default weight of: 1.0
  public Edge(int src, int dst) {
    this(src, dst, 1.0);
  }

  // Constructor for variable weight.
  public Edge(int src, int dst, double weight) {
    this.src = src;
    this.dst = dst;
    this.weight = weight;
  }

  public int getSrc() {
    return this.src;
  }

  public int getDst() {
    return this.dst;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getWeight() {
    return this.weight;
  }

  @Override
    public String toString() {
      return this.src + "-" + this.dst;
    }
}
