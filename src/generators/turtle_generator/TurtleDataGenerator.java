package generators.turtle_generator;

import entities.DataMMSP;
import generators.DataGeneratorInterface;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithmParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Generate data using turtle algorithm
 * Created by Oleg on 24.10.2015.
 */
public class TurtleDataGenerator implements DataGeneratorInterface {


    private DataMMSP data;
    private TurtleAlgorithmParameters turtleParameters;

    public TurtleDataGenerator(TurtleAlgorithmParameters parameters){
        this.turtleParameters = parameters;
        data = new DataMMSP();
        data.setDimensions(new String[]{"x", "y"});
    }

    @Override
    public DataMMSP getData() {
        return data;
    }

    @Override
    public void generate() {
        List<Double> x_list = new ArrayList<>();
        x_list.add(0d);
        List<Double> y_list = new ArrayList<>();
        y_list.add(0d);
        double[] h = new double[]{0,0};
        Stack<StackDataTemplate> stack = new Stack<>();
        String resStr = turtleParameters.generate();
        for (int i = 0; i < resStr.length(); i++) {
            switch (resStr.charAt(i)) {
                case '+':
                    turtleParameters.setAlpha(turtleParameters.getAlpha() + turtleParameters.getTheta());
                    break;
                case '-':
                    turtleParameters.setAlpha(turtleParameters.getAlpha() - turtleParameters.getTheta());
                    break;
                case 'F':
                    h[0] = h[0] + Math.cos(turtleParameters.getAlpha());
                    h[1] = h[1] + Math.sin(turtleParameters.getAlpha());
                    x_list.add(h[0]);
                    y_list.add(h[1]);
                    break;
                case '[':
                    stack.push(new StackDataTemplate(h, turtleParameters.getAlpha()));
                    break;
                case ']':
                    StackDataTemplate tmp = stack.pop();
                    turtleParameters.setAlpha(tmp.alpha);
                    h = tmp.h;
                    x_list.add(h[0]);
                    y_list.add(h[1]);
                    break;
            }
        }
        List<List<Double>> res = new ArrayList<>();
        res.add(x_list);
        res.add(y_list);
        data.addDatasets(res);
    }

    private class StackDataTemplate {
        public double[] h = new double[2];
        public double alpha;

        public StackDataTemplate(double[] h, double alpha) {
            this.h = h;
            this.alpha = alpha;
        }
    }

}
