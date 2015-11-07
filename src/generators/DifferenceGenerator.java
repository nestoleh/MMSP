package generators;

import entities.DataMMSP;
import entities.DifferenceRange;

import java.util.ArrayList;
import java.util.List;

/**
 * Class generate difference for range
 * Created by Oleg on 07.11.2015.
 */
public class DifferenceGenerator {
    static public List<DifferenceRange> generateDifference(DataMMSP data){
        List<DifferenceRange> differenceRanges = new ArrayList<>();
        for (int i = 0; i < data.getAllDatasets().size(); i++) {
            DifferenceRange range = generateDifferenceRange(data.getDataset(i), data.getDimension(i));
            differenceRanges.add(range);
        }
        return differenceRanges;
    }

    private static DifferenceRange generateDifferenceRange(List<Double> dataset, String label) {
        DifferenceRange range = new DifferenceRange();
        range.setRangeLabel(label);
        List<Double> rangeList = new ArrayList<>();
        for (int i = 0; i < dataset.size()-1; i++) {
            rangeList.add(dataset.get(i+1)-dataset.get(i));
        }
        range.setRange(rangeList);
        return range;
    }
}
