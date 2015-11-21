package entities;

/**
 * Created by Oleg on 21.11.2015.
 */
public class LinguaRule {
    private char from;
    private char to;
    private double p;

    public LinguaRule(char from, char to, double p) {
        this.from = from;
        this.to = to;
        this.p = p;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return from + " - (" + p + ") -> " + to;
    }
}
