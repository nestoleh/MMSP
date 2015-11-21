package visual;

import alphabets.Alphabet;
import entities.*;
import generators.DataGeneratorInterface;
import generators.DifferenceGenerator;
import generators.turtle_generator.TurtleDataGenerator;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithms;
import intervals.EquivalentInterval;
import intervals.IntervalInterface;

import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        start();

    }

    public static WebContent start() {
        WebContent webContent = new WebContent();
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

        // STEP 6: create rules for  lines
        IntervalInterface interval = new EquivalentInterval(Alphabet.SMALL_ENGLISH, differenceRanges.get(0));
        // x-line
        IntervalRule intervalRule_x = interval.getIntervalRule();
        System.out.println("\nInterval X:");
        webContent.intervalX = intervalRule_x.toWeb();
        System.out.println(intervalRule_x.toString());
        // y-line
        interval.setDiffrenceRange(differenceRanges.get(1));
        IntervalRule intervalRule_y = interval.getIntervalRule();
        System.out.println("Interval Y:");
        webContent.intervalY = intervalRule_y.toWeb();
        System.out.println(intervalRule_y.toString());

        // STEP 7: generate alphabet line
        String line_x = intervalRule_x.generateAlphabetLine(differenceRanges.get(0).getRange());
        System.out.println("\nLINE X:");
        System.out.println(line_x);
        webContent.lineX = line_x;
        String line_y = intervalRule_y.generateAlphabetLine(differenceRanges.get(1).getRange());
        System.out.println("LINE Y:");
        webContent.lineY = line_y;
        System.out.println(line_y);

        // STEP 8: generate table
        // table x
        Table table_x = new Table(Alphabet.SMALL_ENGLISH, line_x);
        System.out.println("\n TABLE X:");
        System.out.println(table_x.toString());
        webContent.tableX = table_x.toString();
        // table y
        Table table_y = new Table(Alphabet.SMALL_ENGLISH, line_y);
        System.out.println("\n TABLE Y:");
        System.out.println(table_y.toString());
        webContent.tableY = table_y.toString();


        return webContent;
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

