package visual;

import entities.DataMMSP;
import generators.turtle_generator.turtle_algorithms.TurtleAlgorithms;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gekoreed on 11/10/15.
 */
public class Starter extends Application {

    Group group;
    int height = 800;
    List<Line> lines = new ArrayList<>();
    ListView methodList;

    @Override
    public void start(Stage stage) throws Exception {
        methodList = getListView();
        Group root = new Group();
        Scene scene = new Scene(root, height, height);
        stage.setScene(scene);
        group = new Group();

        generate(TurtleAlgorithms.SPIRAL_COVER.toString());

        scene.setRoot(group);
        stage.show();
    }

    private void generate(String method) {
        DataMMSP data = Main.getData(4, method);
        List<Double> xs = data.getDataset(0);
        List<Double> ys = data.getDataset(1);
        Double prevY = ys.get(0);
        Double prevX = xs.get(0);
        // пересунути графік вправо до всіх позитивних X
        Double incrX = xs.stream().min((e, b) -> (e.compareTo(b))).get();
        // пересунути графік вниз до всіх позитивних Y
        Double incrY = ys.stream().min((e, b) -> (e.compareTo(b))).get();

        // Збільшити або зменшити график щоб він вліз у вікно
        Double maxX = xs.stream().max((e, b) -> (e.compareTo(b))).get();
        Double scaler = Math.abs((double) (height-150) / maxX / 2);

        lines.clear();
        for (int i = 0; i < xs.size() - 1; i++) {
            lines.add(new Line(
                    scaler * (prevX - incrX),
                    scaler * (prevY - incrY),
                    scaler * (xs.get(i) - incrX),
                    scaler * (ys.get(i) - incrY)));
            prevX = xs.get(i);
            prevY = ys.get(i);
        }

        group.getChildren().clear();
        group.getChildren().add(methodList);
        group.getChildren().addAll(lines);
    }

    private ListView getListView() {
        ListView methodList = new ListView();
        methodList.setItems(FXCollections.observableList(Arrays.asList(TurtleAlgorithms.values())));
        methodList.setTranslateX(height - 150);
        methodList.setTranslateY(30);
        methodList.setMaxWidth(145);
        methodList.getSelectionModel().selectedItemProperty().addListener((observableValue, s, name) -> {
            if (name != null) {
                generate(String.valueOf(name));
            }
        });
        return methodList;
    }


    public static void main(String[] args) {
        launch(args);
    }
}