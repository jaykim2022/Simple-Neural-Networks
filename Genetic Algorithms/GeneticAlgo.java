import java.util.*;

public class GeneticAlgo {
    public static String genRandomString(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int test = ((int)(Math.random() * 27) + 97);
            sb.append((char) (test == 123 ? 32 : test));
        }
        return sb.toString();
    }

    public static List<String> genPopulation(int nElements, int length) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < nElements; i++) {
            res.add(genRandomString(length));
        }
        return res;
    }

    public static double fitness(String src, String guess) {
        if (src.length() != guess.length()) {
            return -1;
        }

        int count = 0;

        for (int i = 0; i < src.length(); i++) {
            count += src.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        return count + 0.5;
    }

    public static String pollPopulation(List<String> elements, String target) {
        double sum = 0;
        HashMap<String, Double> map = new HashMap<>();

        //double max = 0.0;
        //String bestOffspring = "";

        for (String element : elements) {
            map.put(element, fitness(target, element));
            sum += map.get(element);
            // if (map.get(element) > max) {
            //     max = map.get(element);
            //     bestOffspring = element;
            // }
        }

        double score = Math.random();
        double cur = 0;
        //System.out.println("For target " + target + ": ");
        //System.out.println("The best offspring was " + bestOffspring + " with a survival rate of " + (max / sum));

        for (String element : elements) {
            cur += map.get(element) / sum;
            if (cur > score) {
                //System.out.println(element + " wins with a selection rate of " + (map.get(element) / sum));
                return element;
            }
        }
        return "";
    }
}