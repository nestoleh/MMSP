package generators.turtle_generator.turtle_algorithms;

/**
 * ENUM of created turtle algorithms
 * Created by Oleg on 24.10.2015.
 */
public enum TurtleAlgorithms {
    CHAIN {
        public TurtleAlgorithmParameters getParameters() {
            TurtleAlgorithmParameters turtleAlgorithmParameters = new TurtleAlgorithmParameters(
                    Math.PI / 2,
                    0,
                    "F+F+F+F",
                    "F+b-F-FFF+F+b-F",
                    "bbb"
                    );
            return turtleAlgorithmParameters;
        }
    },

    CHRISTALS {
        public TurtleAlgorithmParameters getParameters() {
            TurtleAlgorithmParameters turtleAlgorithmParameters = new TurtleAlgorithmParameters(
                    Math.PI / 2,
                    0,
                    "F-F-F-F",
                    "FF-F-F-F",
                    ""
            );
            return turtleAlgorithmParameters;
        }
    };

    public abstract TurtleAlgorithmParameters getParameters();
    }
