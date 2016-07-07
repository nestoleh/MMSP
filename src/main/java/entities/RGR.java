package entities;

import alphabets.Alphabet;
import generators.DataGeneratorInterface;
import generators.DifferenceGenerator;
import intervals.IntervalInterface;

import java.util.ArrayList;
import java.util.List;

import static utils.WebContent.*;

/**
 * RGR class
 * Created by Oleg on 21.11.2015.
 */
public class RGR {

    private DataGeneratorInterface dataGenerator;
    private IntervalInterface interval;
    private Alphabet alphabet;

    private StringBuilder content = new StringBuilder();

    public RGR(DataGeneratorInterface dataGenerator, IntervalInterface interval, Alphabet alphabet) {
        this.dataGenerator = dataGenerator;
        this.interval = interval;
        this.alphabet = alphabet;
        doWork();
    }

    public String getWebContent() {
        return content.toString();
    }

    private void doWork() {
        //  generate data
        dataGenerator.generate();
        DataMMSP data = dataGenerator.getData();

        // show generated data
        content.append(transformToHeader("Start data:"));
        for (int i = 0; i < data.getDimensions().length; i++) {
            content.append(transformToAnswer(data.getDimension(i) + " = " + data.getDataset(i).toString()));
        }

        // create difference range for all dimensions
        List<DifferenceRange> differenceRanges = DifferenceGenerator.generateDifference(data);
        content.append(transformToHeader("DIFFERENCE RANGES"));
        for (DifferenceRange differenceRange : differenceRanges) {
            content.append(transformToAnswer(differenceRange.toString()));
        }

        //  create rules for lines
        ArrayList<IntervalRule> intervalRules = new ArrayList<>();
        interval.setAlphabet(alphabet);
        for (int i = 0; i < data.getDimensionsCount(); i++) {
            interval.setDiffrenceRange(differenceRanges.get(i));
            IntervalRule intervalRule = interval.getIntervalRule();
            intervalRules.add(intervalRule);
            content.append(transformToSubheader("Interval " + data.getDimension(i) + ":"));
            content.append(transformToAnswer(intervalRule.toWeb()));
        }

        // generate alphabet line
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < intervalRules.size(); i++) {
            String line = intervalRules.get(i).generateAlphabetLine(differenceRanges.get(i).getRange());
            lines.add(line);
            content.append(transformToSubheader("LINE " + data.getDimensions()[i] + ":"));
            content.append(transformToAnswer(line));
        }


        // STEP 8: generate table
        for (int i = 0; i < lines.size(); i++) {
            // table
            Table table = new Table(alphabet, lines.get(i));
            content.append(transformToSubheader("TABLE " + data.getDimensions()[i] + ":"));
            content.append(transformToTable(table));
            //frequency table
            content.append(transformToSubheader("Frequency TABLE " + data.getDimensions()[i] + ":"));
            content.append(transformToTable(table, true));
            // rules
            content.append(transformToSubheader("LINGUA RULES " + data.getDimensions()[i] + ":"));
            ArrayList<LinguaRule> rules = table.generateLinguaRules();
            rules.forEach(linguaRule -> {
                if (linguaRule.getP() > 0) {
                    content.append(transformToAnswer(linguaRule.toString()));
                }
            });
        }
    }
}
