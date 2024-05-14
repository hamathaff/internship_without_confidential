import Map.Grid;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.transform.Rotate;

public class My_Application extends Application {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Chambre ch = new Chambre();
        Scene scene = new Scene(ch, WIDTH, HEIGHT);
        Camera camera = new PerspectiveCamera();
        scene.setCamera(camera);
        ch.setTranslateX(WIDTH/2);
        ch.setTranslateY(HEIGHT/2);
        primaryStage.setTitle("chambre");
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case UP:

                    //ch.rotateByX(-10);
                    //ch.moovbyym();
                    camera.setTranslateY(camera.getTranslateY()-10);
                    break;
                case DOWN:
                    //ch.rotateByX(10);
                    //ch.moovbyy();
                   camera.setTranslateY(camera.getTranslateY()+10);
                    break;
                case LEFT:
                    ch.rotateByY(-10);
                    break;
                case RIGHT:
                    ch.rotateByY(10);
                    break;
                case Z:
                    ch.setTranslateZ(ch.getTranslateZ()+100);
                    break;
                case A:
                    ch.setTranslateZ(ch.getTranslateZ()-100);
                    break;
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
