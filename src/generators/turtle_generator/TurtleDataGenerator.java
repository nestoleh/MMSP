package generators.turtle_generator;

import entities.DataMMSP;
import generators.DataGeneratorInterface;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmInterface;

import java.util.List;

/**
 * Generate data using tutrtle algorithm
 * Created by Oleg on 24.10.2015.
 */
public class TurtleDataGenerator implements DataGeneratorInterface {

    private double theta = Math.PI / 8;
    private double alpha = 0;

    private String start;
    private String ruleF;
    private String ruleB;
    private int countI;

    private DataMMSP data;
    private TurtleAlgorithmInterface turtleAlgorithm;

    public TurtleDataGenerator(TurtleAlgorithmInterface turtleAlgorithm, String start, String ruleF, String ruleB, int countI) {
        setTurtleAlgorithm(turtleAlgorithm);
        setStart(start);
        setRuleF(ruleF);
        setRuleB(ruleB);
        setCountI(countI);
        data = new DataMMSP();
        data.setDimensions(new String[]{"x", "y"});
    }


    @Override
    public DataMMSP getData() {
        return data;
    }

    @Override
    public void generate() {
        List<List<Double>> datasets = turtleAlgorithm.generate(start, ruleF, ruleB, countI, theta, alpha);
        data.addDatasets(datasets);
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public void setStart(String start) {
        if (start == null) {
            this.start = "";
        } else {
            this.start = start;
        }
    }

    public void setRuleF(String ruleF) {
        if (ruleF == null) {
            this.ruleF = "";
        } else {
            this.ruleF = ruleF;
        }
    }

    public void setRuleB(String ruleB) {
        if (ruleB == null) {
            this.ruleB = "";
        } else {
            this.ruleB = ruleB;
        }
    }

    public void setCountI(int countI) {
        if (countI < 1) {
            this.countI = 1;
        } else {
            this.countI = countI;
        }
    }

    public void setTurtleAlgorithm(TurtleAlgorithmInterface turtleAlgorithm) {
        this.turtleAlgorithm = turtleAlgorithm;
    }
}
