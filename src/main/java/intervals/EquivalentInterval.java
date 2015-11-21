package intervals;

import alphabets.Alphabet;
import entities.DifferenceRange;
import entities.IntervalRule;

import java.util.*;

/**
 * Created by Oleg on 15.11.2015.
 */
public class EquivalentInterval implements IntervalInterface {

    private Alphabet alphabet;
    private DifferenceRange differenceRange;
    IntervalRule intervalRule;


    public EquivalentInterval(Alphabet alphabet, DifferenceRange differenceRange) {
        this.alphabet = alphabet;
        this.differenceRange = differenceRange;
    }

    public EquivalentInterval() { }

    @Override
    public IntervalRule getIntervalRule() {
        intervalRule = new IntervalRule();
        Set<Double> unique_1 = new HashSet<>();
        Set<Double> unique_2 = new HashSet<>();
        for (double item : differenceRange.getRange()) {
            if (item <= 0) {
                unique_1.add(item);
            }
            if (item >= 0) {
                unique_2.add(item);
            }
        }
        List<Double> dr_min = new ArrayList<>(unique_1);
        Collections.sort(dr_min);
        List<Double> dr_max = new ArrayList<>(unique_2);
        Collections.sort(dr_max);
        diffByAlphabet(dr_min, alphabet.getSmallAlphabet());
        diffByAlphabet(dr_max, alphabet.getBigAlphabet());
        return intervalRule;
    }

    @Override
    public void setDiffrenceRange(DifferenceRange diffrenceRange) {
        this.differenceRange = diffrenceRange;

    }

    @Override
    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    private void diffByAlphabet(List<Double> list, String alp) {
        double min = Collections.min(list);
        double max = Collections.max(list);
        double step = Math.abs(max - min) / alphabet.size();

        double currMin = min;
        double currMax = currMin + step;
        for (int i = 0; i < alphabet.size() - 1; i++) {
            intervalRule.addNewRule(currMin, currMax, alp.charAt(i));
            currMin = currMax;
            currMax = currMin + step;
        }
        intervalRule.addNewRule(currMin, max, alp.charAt(alp.length()-1));
    }

}
