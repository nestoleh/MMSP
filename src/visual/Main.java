package visual;

import alphabets.Alphabet;
import entities.DataMMSP;
import entities.DifferenceRange;
import entities.IntervalRule;
import generators.DataGeneratorInterface;
import generators.DifferenceGenerator;
import generators.turtle_generator.TurtleDataGenerator;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithms;
import intervals.EquivalentInterval;
import intervals.IntervalInterface;

import java.util.List;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        DataMMSP data = getData(3, TurtleAlgorithms.CHAIN.toString());

        // STEP 4: show your data
        System.out.println("START DATA:");
        System.out.println(data);

        // STEP 5: create difference range for all dimensions
        List<DifferenceRange> differenceRanges = DifferenceGenerator.generateDifference(data);
        System.out.println("DIFFERENCE RANGES:");
        for (DifferenceRange differenceRange : differenceRanges) {
            System.out.println(differenceRange);
        }
        System.out.println();

        // STEP 6: create rules for x line
        IntervalInterface interval = new EquivalentInterval(Alphabet.SMALL_ENGLISH, differenceRanges.get(0));
        IntervalRule intervalRule_x = interval.getIntervalRule();
        System.out.println(intervalRule_x.toString());

    }

    public static DataMMSP getData(int iterations, String algorithm) {
        // STEP 0: Chose your algorithm
        TurtleAlgorithmParameters parameters = TurtleAlgorithms.valueOf(algorithm).getParameters();
        parameters.setIterations(iterations);// set iterations count

        // STEP 1: Create your generator
        DataGeneratorInterface generator = new TurtleDataGenerator(parameters);

        // STEP 3: Generate data
        generator.generate();
        return generator.getData();
    }

}

