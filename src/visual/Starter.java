package visual;

import entities.DataMMSP;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gekoreed on 11/10/15.
 */
public class Starter extends Application {

    Group group;
    int height = 800;
    List<Line> lines = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        DataMMSP data = Main.getData();
        List<Double> xs = data.getDataset(0);
        List<Double> ys = data.getDataset(1);

        Group root = new Group();
        Scene scene = new Scene(root, height, height);
        stage.setScene(scene);

        Double prevY = ys.get(0);
        Double prevX = xs.get(0);
        // пересунути графік вправо до всіх позитивних X
        Double incrX = xs.stream().min((e, b) -> (e.compareTo(b))).get();
        // пересунути графік вниз до всіх позитивних Y
        Double incrY = ys.stream().min((e, b) -> (e.compareTo(b))).get();

        // Збільшити або зменшити график щоб він вліз у вікно
        Double maxX = xs.stream().max((e, b) -> (e.compareTo(b))).get();
        Double scaler = Math.abs((double) height / maxX / 2);

        for (int i = 0; i < xs.size() - 1; i++) {
            lines.add(new Line(
                    scaler * (prevX - incrX),
                    scaler * (prevY - incrY),
                    scaler * (xs.get(i) - incrX),
                    scaler * (ys.get(i) - incrY)));
            prevX = xs.get(i);
            prevY = ys.get(i);
        }

        group = new Group();
        group.getChildren().addAll(lines);

        scene.setRoot(group);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}