package visual;

import alphabets.Alphabet;
import entities.RGR;
import generators.DataGeneratorInterface;
import generators.turtle_generator.TurtleDataGenerator;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithms;
import intervals.EquivalentInterval;
import intervals.IntervalInterface;
import spark.Spark;
import utils.WebContent;

/**
 * Created by gekoreed on 11/21/15.
 */
public class WebStart {
    private static RGR rgr;

    public static void main(String[] args) {
        Spark.port(8081);
        Spark.staticFileLocation("/public");
        Spark.get("/", (req, res) -> {
            setUp();
            String html = WebContent.getPageHeader()+ rgr.getWebContent() + WebContent.getPageFooter();
            return html;
        });
    }

    private static void setUp() {
        DataGeneratorInterface dataGenerator = setUpTurtleGenerator(3, TurtleAlgorithms.CHAIN.toString());                  // generator
        IntervalInterface interval = new EquivalentInterval();                                                              // interval

        rgr = new RGR(dataGenerator, interval, Alphabet.SMALL_ENGLISH);
    }

    private static DataGeneratorInterface setUpTurtleGenerator(int iterations, String algorithm) {
        TurtleAlgorithmParameters parameters = TurtleAlgorithms.valueOf(algorithm).getParameters();
        parameters.setIterations(iterations);
        DataGeneratorInterface generator = new TurtleDataGenerator(parameters);
        return generator;
    }
}
