import Map.Grid;
import Map.Mybox;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class MainApp extends Application{
    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;
    private final Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
    private final Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        PerspectiveCamera camera = new PerspectiveCamera();

        Mybox mybox = new Mybox(10000.0, 10000.0, 1);
        Sphere sphere = new Sphere(50);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        sphere.setMaterial(material);

        Image im = new Image("/Images/red_sandstone_pavement_diff_4k.jpg");
        ImageView myimageview = new ImageView(im);
        myimageview.setPreserveRatio(true);
        myimageview.getTransforms().add(new Translate(-im.getWidth() / 2, -im.getHeight() / 2, 800));


        mybox.setTranslateZ(0);
        camera.setTranslateZ(-1000);

        // Ajouter une lumière pour mieux voir le plan
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(-300);
        light.setTranslateY(-300);
        light.setTranslateZ(-300);

        Group root = new Group();
        Grid grid = new Grid(5,5);


        mybox.setTranslateY(400);


        root.getChildren().add(mybox);
        root.getChildren().add(light);
        root.getChildren().add(sphere);





        Scene scene = new Scene(root, 600, 400);
        scene.setCamera(camera);
        scene.setOnMousePressed(event -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = rotateX.getAngle();
            anchorAngleY = rotateY.getAngle();
        });

        scene.setOnMouseDragged(event -> {
            rotateY.setAngle(anchorAngleY + (anchorX - event.getSceneX()));
            rotateX.setAngle(anchorAngleX - (anchorY - event.getSceneY()));
        });

        // Gestion du défilement pour le positionnement vertical de la caméra
        scene.setOnScroll(event -> {
            double deltaY = event.getDeltaY();
            camera.setTranslateZ(camera.getTranslateZ() + deltaY); // Zoom in ou out
        });
        camera.getTransforms().addAll(rotateX, rotateY);
        camera.setTranslateZ(-800);
        primaryStage.setTitle("resoud");
        primaryStage.setScene(scene);
        primaryStage.show();
        mybox.rotateByX(-80);
        sphere.setTranslateZ(-23);
        sphere.setTranslateY(mybox.getTranslateY());
        //scene.setFill(Color.BLACK);

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case UP:
                   sphere.setTranslateZ(sphere.getTranslateZ()+10);
                    sphere.setTranslateY(sphere.getTranslateY()-10);
                    break;
                case DOWN:
                    sphere.setTranslateZ(sphere.getTranslateZ()-10);
                    sphere.setTranslateY(sphere.getTranslateY()+10);

                    break;
                case LEFT:
                    sphere.setTranslateX(sphere.getTranslateX()-10);
                    break;
                case RIGHT:
                    sphere.setTranslateX(sphere.getTranslateX()+10);
                    break;
                case Z:
                    camera.setTranslateZ(camera.getTranslateZ()+100);
                    break;
                case A:
                    camera.setTranslateZ(camera.getTranslateZ()-100);
                    break;
            }
            //light.setTranslateX(sphere.getTranslateX());
            //light.setTranslateY(sphere.getTranslateY());
            //light.setTranslateZ(sphere.getTranslateZ());
        });



    }




    public static void main(String[] args) {
        launch(args);
    }}
