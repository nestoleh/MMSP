import entities.DataMMSP;
import generators.DataGeneratorInterface;
import generators.turtle_generator.TurtleDataGenerator;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithms;

public class Main {

    public static void main(String[] args) {
        // STEP 0: Chose your algorithm
        TurtleAlgorithmParameters turtleAlgorithmParameters = TurtleAlgorithms.CHRISTALS.getParameters();
        turtleAlgorithmParameters.setCountI(3);                                                                             // set iterations count

        // STEP 1: Create your generator
        DataGeneratorInterface generator = new TurtleDataGenerator(turtleAlgorithmParameters);

        // STEP 3: Generate data
        generator.generate();
        DataMMSP data = generator.getData();

        // STEP 4: show your data
        System.out.println(data.toString());
    }
}

