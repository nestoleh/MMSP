package entities;

/**
 * Created by gekoreed on 11/21/15.
 */
public class WebContent {
    public String intervalX;
    public String intervalY;
    public String lineX;
    public String lineY;
    public String tableX;
    public String tableY;

    @Override
    public String toString() {
        String tabx = "<table border=\"1\"><tr><td></td>" + tableX
                .replaceAll("\t","</td><td>")
                .replaceAll("\n","</td></tr><tr><td>") +"</table><br><br>";
        String taby = "<table border=\"1\"><tr><td></td>" + tableY
                .replaceAll("\t","</td><td>")
                .replaceAll("\n","</td></tr><tr><td>") +"</table><br><br>";

        return intervalX + "<br><br>"+intervalY + "<br><br>"
                + lineX + "<br><br>"+ lineY  +"<br><br>"+tabx + taby;

    }
}
