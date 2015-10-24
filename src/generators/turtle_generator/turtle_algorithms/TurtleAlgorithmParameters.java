package generators.turtle_generator.turtle_algorithms;

import entities.Rule;
import generators.turtle_generator.StringGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Set of parameters for turtle algorithm
 * Created by Oleg on 24.10.2015.
 */
public class TurtleAlgorithmParameters {

    private double theta;
    private double alpha;
    private String start;
    private int iterations;
    Map<String, String> rules = new HashMap<>();
    public StringGenerator generator;

    public TurtleAlgorithmParameters(double theta, int alpha, String start, List<Rule> rules, StringGenerator generator) {
        this.generator = generator;
        setTheta(theta);
        setAlpha(alpha);
        setStart(start);
        for (Rule rule : rules) {
            addRule(rule);
        }
    }

    public void addRule(Rule rule){
        rules.put(rule.name, rule.rule);
    }

    public String getRule(String name){
        if (rules.keySet().contains(name))
            return rules.get(name);
        return "";
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

    public void setIterations(int iterations) {
        if (iterations < 1) {
            this.iterations = 1;
        } else {
            this.iterations = iterations;
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

    public int getIterations() {
        return iterations;
    }


    /**
     * Appplying rules to string
     * @return formed to calculate string
     */
    public String generate() {
        return generator.generate(getStart(), this);
    }
}
