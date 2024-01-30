

public class ToyStore {

}
class Toy implements Comparable<Toy> {
    private String id;
    private String name;
    private int weight;

    public Toy(String id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Weight: " + weight;
    }

    public int compareTo(Toy toy) {
        return Integer.compare(weight, toy.weight);
    }
}


