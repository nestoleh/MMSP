import entities.DataMMSP;
import generators.DataGeneratorInterface;
import generators.turtle_generator.TurtleDataGenerator;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithms;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // STEP 0: Chose your algorithm
        TurtleAlgorithmParameters parameters = TurtleAlgorithms.CHAIN.getParameters();
        parameters.setIterations(3);// set iterations count

        // STEP 1: Create your generator
        DataGeneratorInterface generator = new TurtleDataGenerator(parameters);

        // STEP 3: Generate data
        generator.generate();
        DataMMSP data = generator.getData();

        // STEP 4: show your data
        System.out.println(data);
    }
}

