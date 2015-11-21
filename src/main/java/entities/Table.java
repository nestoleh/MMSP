package entities;

import alphabets.Alphabet;
import utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static utils.Util.round;

/**
 * Created by Oleg on 16.11.2015.
 */
public class Table {
    private ArrayList<Character> tableCaption;
    private HashMap<Character, Integer> lettersCountMap = new HashMap();
    private int[][] table;
    private double[][] frequencyTable;

    public Table(Alphabet alphabet, String line) {
        tableCaption = new ArrayList<>();

        // caption
        generateCaption(alphabet);

        // table
        generateTable(alphabet, line);

        countLetters(alphabet, line);
        generateFrequencyTable();
    }

    private void generateCaption(Alphabet alphabet) {
        String small_alphabet = (new StringBuilder(alphabet.getSmallAlphabet()).reverse().toString());
        for (int i = 0; i < alphabet.size(); i++) {
            tableCaption.add(small_alphabet.charAt(i));
        }
        for (int i = 0; i < alphabet.size(); i++) {
            tableCaption.add(alphabet.getBigAlphabet().charAt(i));
        }
    }

    private void generateTable(Alphabet alphabet, String line) {
        table = new int[alphabet.size() * 2][alphabet.size() * 2];
        for (int i = 0; i < line.length() - 1; i++) {
            table[getCaptionIndex(line.charAt(i))][getCaptionIndex(line.charAt(i + 1))]++;
        }
    }

    private void countLetters(Alphabet alphabet, String line) {
        for (int i = 0; i < alphabet.getBigAlphabet().length(); i++) {
            lettersCountMap.put(alphabet.getBigAlphabet().charAt(i), 0);
            lettersCountMap.put(alphabet.getSmallAlphabet().charAt(i), 0);
        }
        for (int i = 0; i < line.length(); i++) {
            lettersCountMap.put(line.charAt(i), ((Integer) lettersCountMap.get(line.charAt(i))) + 1);
        }
    }

    private void generateFrequencyTable() {
        frequencyTable = new double[table.length][table.length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                int count = ((Integer) lettersCountMap.get(tableCaption.get(i)));
                if (count != 0) {
                    frequencyTable[i][j] = round((table[i][j] / (double) count), 2);
                }
            }
        }
    }

    private int getCaptionIndex(char c) {
        for (int i = 0; i < tableCaption.size(); i++) {
            if (c == tableCaption.get(i).charValue()) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Character> getTableCaption() {
        return tableCaption;
    }

    public int[][] getTable() {
        return table;
    }

    public ArrayList<LinguaRule> generateLinguaRules(){
        ArrayList<LinguaRule> rules = new ArrayList<>();
        for (int i = 0; i < frequencyTable.length; i++) {
            for (int j = 0; j < frequencyTable.length; j++) {
                rules.add(new LinguaRule(tableCaption.get(i),tableCaption.get(j),frequencyTable[i][j]));
            }
        }
        return rules;
    }

    public String frequencyTableToString() {
        StringBuilder str = new StringBuilder(" \t");
        for (Character aTableCaption : tableCaption) {
            str.append(aTableCaption).append("   \t");
        }
        str.append("\n");
        for (int i = 0; i < frequencyTable.length; i++) {
            str.append(tableCaption.get(i)).append(" \t");
            for (int j = 0; j < frequencyTable[i].length; j++) {
                str.append(frequencyTable[i][j]).append(" \t");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public String tableToString() {
        StringBuilder str = new StringBuilder("\t");
        for (Character aTableCaption : tableCaption) {
            str.append(aTableCaption).append("\t");
        }
        str.append("\n");
        for (int i = 0; i < table.length; i++) {
            str.append(tableCaption.get(i)).append("\t");
            for (int j = 0; j < table[i].length; j++) {
                str.append(table[i][j]).append("\t");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public double[][] getFrequencyTable() {
        return frequencyTable;
    }
}
