package generators.turtle_generator;

import entities.DataMMSP;
import generators.DataGeneratorInterface;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;

/**
 * Generate data using tutrtle algorithm
 * Created by Oleg on 24.10.2015.
 */
public class TurtleDataGenerator implements DataGeneratorInterface {


    private DataMMSP data;
    private TurtleAlgorithmParameters turtleParameters;

    public TurtleDataGenerator(TurtleAlgorithmParameters turtleParameters) {
        this.turtleParameters = turtleParameters;
        data = new DataMMSP();
        data.setDimensions(new String[]{"x", "y"});
    }

    @Override
    public DataMMSP getData() {
        return data;
    }

    @Override
    public void generate() {

    }

}
