import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class ToyStore {
    private final int[] weights;
    private final PriorityQueue<Toy> queue;

    public ToyStore(String[] ids, String[] names, int[] weights) {
        this.weights = weights;
        this.queue = new PriorityQueue<>();
        for (int i = 0; i < ids.length; i++) {
            queue.add(new Toy(ids[i], names[i], weights[i]));
        }
    }

    public Toy getToy() {
        Random random = new Random();
        int randomNum = random.nextInt(100);
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }
        int cumulativeWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            cumulativeWeight += weights[i];
            if (randomNum <= (cumulativeWeight * 100 / totalWeight)) {
                return queue.toArray(new Toy[queue.size()])[i];
            }
        }
        return null;
    }

    public void saveToLogFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < 10; i++) {
                Toy toy = getToy();
                writer.println(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void main(String[] args) {
        String[] ids = {"1", "2", "3"};
        String[] names = {"игрушка1", "игрушка2", "игрушка3"};
        int[] weights = {20, 20, 60};

        ToyStore toyQueue = new ToyStore(ids, names, weights);
        toyQueue.saveToLogFile("log.txt");
    }
}
public static void PrintToy() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Название  игрушки: ");
    String name = scanner.nextLine();
    System.out.println("Введите id: ");

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

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", weight: " + weight;
    }

    @Override
    public int compareTo(Toy toy) {
        return Integer.compare(weight, toy.weight);
    }
}

public void main() {
}
