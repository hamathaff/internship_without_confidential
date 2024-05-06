import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;

public class Porte extends Group {

    private static final double LARGEUR_PORTE = 80;
    private static final double HAUTEUR_PORTE = 160;
    private static final double EPAISSEUR_PORTE = 5;
    private static final double RAYON_POIGNEE = 6;

    private Box cadrePorte;
    private Cylinder poignee;

    public Porte() {
        cadrePorte = createFrame();
        poignee = createHandle();

        getChildren().addAll(cadrePorte, poignee);
    }

    private Box createFrame() {
        Box cadre = new Box(LARGEUR_PORTE, HAUTEUR_PORTE, EPAISSEUR_PORTE);
        cadre.setMaterial(new PhongMaterial(Color.BROWN));
        return cadre;
    }

    private Cylinder createHandle() {
        Cylinder handle = new Cylinder(RAYON_POIGNEE, RAYON_POIGNEE * 2);
        handle.setMaterial(new PhongMaterial(Color.SILVER));
        handle.setRotationAxis(Rotate.X_AXIS);
        handle.setRotate(90);
        handle.setTranslateX((LARGEUR_PORTE + RAYON_POIGNEE) / 2);
        return handle;
    }
}
