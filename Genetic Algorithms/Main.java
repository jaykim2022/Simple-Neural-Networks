import java.util.*;

public class Main {
    public static void main(String[] args) {
        Environment e1 = new Environment("cat", 100);
        System.out.println();
        System.out.println(e1.runSimulation(2500));
        // List<String> test = GeneticAlgo.genPopulation(20, 5);
        // for (String ele : test) {
        //     System.out.println(ele);
        // }
    }
}
