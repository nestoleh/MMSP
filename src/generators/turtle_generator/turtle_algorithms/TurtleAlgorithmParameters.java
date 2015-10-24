package generators.turtle_generator.turtle_algorithms;

/**
 * Set of parameters for turtle algorithm
 * Created by Oleg on 24.10.2015.
 */
public class TurtleAlgorithmParameters {

    private double theta;
    private double alpha;
    private String start;
    private String ruleF;
    private String ruleB;
    private int countI;

    public TurtleAlgorithmParameters(double theta, double alpha, String start, String ruleF, String ruleB) {
        setTheta(theta);
        setAlpha(alpha);
        setStart(start);
        setRuleF(ruleF);
        setRuleB(ruleB);
        countI = 1;
    }

    public TurtleAlgorithmParameters(double theta, double alpha, String start, String ruleF, String ruleB, int countI) {
        this(theta, alpha, start, ruleF, ruleB);
        setCountI(countI);
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

    public double getTheta() {
        return theta;
    }

    public double getAlpha() {
        return alpha;
    }

    public String getStart() {
        return start;
    }

    public String getRuleF() {
        return ruleF;
    }

    public String getRuleB() {
        return ruleB;
    }

    public int getCountI() {
        return countI;
    }
}
