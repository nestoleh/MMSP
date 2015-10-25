package generators.turtle_generator.turtle_algorithms;

import entities.Rule;

import java.util.Arrays;

/**
 * ENUM of created turtle algorithms
 * Created by Oleg on 24.10.2015.
 */
public enum TurtleAlgorithms {
    CHAIN {
        public TurtleAlgorithmParameters getParameters() {
            return new TurtleAlgorithmParameters(
                    Math.PI / 2,
                    0,
                    "F+F+F+F",
                    Arrays.asList(
                            new Rule("F", "F+b-F-FFF+F+b-F"),
                            new Rule("b", "bbb"))
            );
        }
    },

    // variant  19
    SPIRAL_COVER {
        public TurtleAlgorithmParameters getParameters() {
            return new TurtleAlgorithmParameters(
                    Math.PI / 12,
                    0,
                    "AAAA",
                    Arrays.asList(
                            new Rule("A", "X+X+X+X+X+X+"),
                            new Rule("X", "[F+F+F+F[--X-Y]+++++F++++++++F-F-F-F"),
                            new Rule("Y", "[F+F+F+F[--Y]+++++F++++++++F-F-F-F"))
            );
        }
    };

    public abstract TurtleAlgorithmParameters getParameters();
}
