package generators.turtle_generator.stringGenerators;

import generators.turtle_generator.StringGenerator;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;

/**
 * Created by gekoreed on 10/25/15.
 */
public class SpiralStringGenerator implements StringGenerator {
    @Override
    public String generate(String input, TurtleAlgorithmParameters turtleParameters) {
        StringBuilder res = new StringBuilder();
        String start = turtleParameters.getStart();
        for (int i = 0; i < turtleParameters.getIterations(); i++) {
            if (i > 0) start = res.toString();
            res.setLength(0);
            for (int j = 0; j < start.length(); j++) {
                switch (start.charAt(j)) {
                    case 'A':
                        res.append(turtleParameters.getRule("A"));
                        break;
                    case 'X':
                        res.append(turtleParameters.getRule("X"));
                        break;
                    case 'Y':
                        res.append(turtleParameters.getRule("Y"));
                        break;
                    default:
                        res.append(start.charAt(j));
                }
            }
        }
        return res.toString();
    }
}
