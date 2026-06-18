package Map;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Terrain3DView extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Création du terrain et des murs
        Mybox floor = new Mybox(500, 10, 500); // Dimensions hypothétiques du sol
        floor.setTranslateX(250);
        floor.setTranslateY(250);
        floor.setTranslateZ(0);
        root.getChildren().add(floor);

        Mybox wall1 = new Mybox(500, 100, 10);
        wall1.setTranslateX(250);
        wall1.setTranslateY(125);
        wall1.setTranslateZ(-250);
        root.getChildren().add(wall1);

        Mybox wall2 = new Mybox(500, 100, 10);
        wall2.setTranslateX(250);
        wall2.setTranslateY(375);
        wall2.setTranslateZ(250);
        root.getChildren().add(wall2);

        // Configuration de la caméra perspective
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setFarClip(1500);
        camera.setTranslateZ(-1000);
        camera.setTranslateY(-100);
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(30); // Inclinaison pour une meilleure vue de la 3D

        // Configuration de la scène
        Scene scene = new Scene(root, 800, 600, true);
        scene.setCamera(camera);
        scene.setFill(Color.LIGHTBLUE);

        primaryStage.setTitle("Vue 3D du Terrain avec Camera Perspective");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
