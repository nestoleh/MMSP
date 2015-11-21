package intervals;

import alphabets.Alphabet;
import entities.DifferenceRange;
import entities.IntervalRule;

/**
 * Created by Oleg on 15.11.2015.
 */
public interface IntervalInterface {

    public IntervalRule getIntervalRule();
    public void setDiffrenceRange(DifferenceRange diffrenceRange);
    public void setAlphabet(Alphabet alphabet);

}
