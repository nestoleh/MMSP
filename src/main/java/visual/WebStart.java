package visual;

import entities.WebContent;
import spark.Spark;

/**
 * Created by gekoreed on 11/21/15.
 */
public class WebStart {
    public static void main(String[] args) {
        Spark.port(8081);
        Spark.get("/", (req, res) -> {

            WebContent content = Main.start();

            return content.toString();
        });
    }
}
