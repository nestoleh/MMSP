package visual;

import com.sun.xml.internal.ws.util.Pool;
import entities.DataMMSP;
import entities.DifferenceRange;
import generators.DataGeneratorInterface;
import generators.DifferenceGenerator;
import generators.turtle_generator.TurtleDataGenerator;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithms;

import java.util.List;

import static java.util.Collections.*;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        DataMMSP data = getData(3, TurtleAlgorithms.SPIRAL_COVER.toString());

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

        //
        sort(differenceRanges.get(0).getRange());
        System.out.println(differenceRanges.get(0));
    }

    public static DataMMSP getData(int iterations, String algorithm){
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

