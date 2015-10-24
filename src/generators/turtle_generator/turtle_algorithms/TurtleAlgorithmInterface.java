package generators.turtle_generator.turtle_algorithms;

import java.util.List;

/**
 * Interface for all turtle algorithm
 * Created by Oleg on 24.10.2015.
 */
public interface TurtleAlgorithmInterface {

    public List<List<Double>> generate(String start, String ruleF, String ruleB, int countI, double theta, double alpha);
}
