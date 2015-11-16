package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 16.11.2015.
 */
public class IntervalRule {
    private List<IntervalItem> rules;

    public IntervalRule() {
        rules = new ArrayList<>();
    }

    public void addNewRule(double min, double max, char letter) {
        rules.add(new IntervalItem(min, max, letter));

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (IntervalItem item : rules){
            str.append(item.letter);
            str.append("\tmin = "+item.min);
            str.append("\tmax = "+item.max+"\n");
        }
        return str.toString();
    }

    private class IntervalItem {
        public double min;
        public double max;
        public char letter;

        public IntervalItem(double min, double max, char letter) {
            this.min = min;
            this.max = max;
            this.letter = letter;
        }
    }

}
