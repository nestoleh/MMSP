package utils;

import entities.Table;

/**
 * Conver data to veb view
 * Created by oleg on 11/21/15.
 */
public class WebContent {

    public static String getPageHeader() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>RGR</title>\n" +
                "\t<link rel=\"stylesheet\" href=\"/style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\t";
    }

    public static String getPageFooter() {
        return "\t\n" +
                "</body>\n" +
                "</html>";
    }

    public static String transformToHeader(String text) {
        return "<h1>" + text + "</h1>";
    }

    public static String transformToSubheader(String text) {
        return "<h3>" + text + "</h3>";
    }

    public static String transformToAnswer(String text) {
        return "<div class='answer'>" + text + "</div>";
    }

    public static String transformToTable(Table table, boolean isFrequency) {
        if (isFrequency) {
            return transformFrequencyTable(table);
        }
        return transformToTable(table);
    }

    public static String transformToTable(Table table) {
        StringBuilder str = new StringBuilder();
        str.append("<table>").append("<tr>").append("<th>").append("</th>");
        for (int i = 0; i < table.getTableCaption().size(); i++) {
            str.append("<th>").append(table.getTableCaption().get(i)).append("</th>");
        }
        str.append("</tr>");
        for (int i = 0; i < table.getTable().length; i++) {
            str.append("<tr>")
                    .append("<td class='th'>")
                    .append(table.getTableCaption().get(i))
                    .append("</td>");
            for (int j = 0; j < table.getTable().length; j++) {
                str.append("<td>").append(table.getTable()[i][j]).append("</td>");
            }
            str.append("</tr>");
        }
        str.append("</table>");
        return str.toString();
    }

    private static String transformFrequencyTable(Table table) {
        StringBuilder str = new StringBuilder();
        str.append("<table>").append("<tr>").append("<th>").append("</th>");
        for (int i = 0; i < table.getTableCaption().size(); i++) {
            str.append("<th>").append(table.getTableCaption().get(i)).append("</th>");
        }
        str.append("</tr>");
        for (int i = 0; i < table.getFrequencyTable().length; i++) {
            str.append("<tr>")
                    .append("<td class='th'>")
                    .append(table.getTableCaption().get(i))
                    .append("</td>");
            for (int j = 0; j < table.getFrequencyTable().length; j++) {
                str.append("<td style=\"background: rgba(255,0,0," + table.getFrequencyTable()[i][j] + ")\">").append(table.getFrequencyTable()[i][j]).append("</td>");
            }
            str.append("</tr>");
        }
        str.append("</table>");
        return str.toString();
    }


}
