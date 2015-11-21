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
            setUp("2", "chain");
            String html = WebContent.getPageHeader()+ rgr.getWebContent() + WebContent.getPageFooter();
            return html;
        });
        Spark.get("/:iter/:var", (req, res) -> {
            String iter = req.params(":iter");
            String variant = req.params(":var");
            boolean done = setUp(iter, variant);
            if (!done)
                return "No such algorithm";
            return WebContent.getPageHeader()+ rgr.getWebContent() + WebContent.getPageFooter();
        });
    }

    private static boolean setUp(String iter, String variant) {
        TurtleAlgorithms algorithm = TurtleAlgorithms.getAlgorithm(Integer.valueOf(variant));
        if (algorithm == null)
            return false;
        DataGeneratorInterface dataGenerator = setUpTurtleGenerator(Integer.valueOf(iter), algorithm);                  // generator
        IntervalInterface interval = new EquivalentInterval();                                                              // interval
        rgr = new RGR(dataGenerator, interval, Alphabet.SMALL_ENGLISH);
        return true;
    }

    private static DataGeneratorInterface setUpTurtleGenerator(int iterations, TurtleAlgorithms algorithm) {
        TurtleAlgorithmParameters parameters = algorithm.getParameters();
        parameters.setIterations(iterations);
        DataGeneratorInterface generator = new TurtleDataGenerator(parameters);
        return generator;
    }
}
