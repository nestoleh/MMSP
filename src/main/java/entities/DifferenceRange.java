package entities;

import java.util.Collections;
import java.util.List;

import static utils.Util.round;

/**
 * class for difference range
 * Created by Oleg on 07.11.2015.
 */
public class DifferenceRange {
    private String rangeLabel;
    private List<Double> range;


    public String getRangeLabel() {
        return rangeLabel;
    }

    public void setRangeLabel(String rangeLabel) {
        this.rangeLabel = rangeLabel;
    }

    public List<Double> getRange() {
        return range;
    }

    public void setRange(List<Double> range) {
        this.range = range;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(rangeLabel.toUpperCase() + " => \t");
        for (double d : range) {
            res.append(round(d, 2));
            res.append(",\t");
        }
        return res.toString();
    }
}
