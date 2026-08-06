import java.util.*;

public class Environment {
    List<String> elements;
    int stringLength;
    String target;
    int simulationRound;
    double mutationRate;
    
    public Environment(String target, int nElements) {
        this.stringLength = target.length();
        this.elements = GeneticAlgo.genPopulation(nElements, this.stringLength);
        this.target = target;
        this.simulationRound = 1;
        this.mutationRate = 0.01;
    }

    public void runSelectionRound() {
        // for (String element : this.elements) {
        //     System.out.println(simulationRound + ": " + element);
        // }
        simulationRound++;
        List<String> newGeneration = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            String parent1 = GeneticAlgo.pollPopulation(elements, target);
            String parent2 = GeneticAlgo.pollPopulation(elements, target);

            newGeneration.add(reproduce(parent1, parent2));
        }
        this.elements = newGeneration;
    }

    public String reproduce(String parent1, String parent2) {
        StringBuilder child = new StringBuilder();

        for (int i = 0; i < parent1.length(); i++) {
            child.append(Math.random() > 0.5 ? parent1.charAt(i) : parent2.charAt(i));
        }

        for (int j = 0; j < child.length(); j++) {
            int mutation = ((int)(Math.random() * 27) + 97);
            child.setCharAt(j, Math.random() < mutationRate ? (char) (mutation == 123 ? 32 : mutation) : child.charAt(j));
        }
        return child.toString();
    }

    public String runSimulation(int nRounds) {
        for (int i = 0; i < nRounds; i++) {
            runSelectionRound();
        }

        for (String ele : elements) {
            System.out.println(ele);
        }

        return GeneticAlgo.pollPopulation(this.elements, target);
    }
}
