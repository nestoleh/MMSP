package generators.turtle_generator.stringGenerators;

import generators.turtle_generator.StringGenerator;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;

/**
 * Created by gekoreed on 10/25/15.
 */
public class ChainStringGenerator implements StringGenerator {
    @Override
    public String generate(String input, TurtleAlgorithmParameters turtleParameters) {
        StringBuilder res = new StringBuilder();
        String start = turtleParameters.getStart();
        for (int i = 0; i < turtleParameters.getIterations(); i++) {
            if (i > 0) start = res.toString();
            res.setLength(0);
            for (int j = 0; j < start.length(); j++) {
                switch (start.charAt(j)) {
                    case 'F':
                        res.append(turtleParameters.getRule("F"));
                        break;
                    case 'b':
                        res.append(turtleParameters.getRule("b"));
                        break;
                    default:
                        res.append(start.charAt(j));
                }
            }
        }
        return res.toString();
    }
}
