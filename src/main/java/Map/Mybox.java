package Map;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class Mybox extends Box {
    private Box mirrorBox; // Référence au miroir de cette boîte

    public Mybox(double width, double height, double depth) {
        super(width, height, depth);
        init();
        createMirror(width, height, depth); // Créer un miroir lors de l'initialisation
    }

    private void init(){
        Image texture = new Image("/Images/red_sandstone_pavement_diff_4k.jpg");
        PhongMaterial phongMaterial= new PhongMaterial();
        phongMaterial.setDiffuseMap(texture);
        this.setMaterial(phongMaterial);
    }

    private void createMirror(double width, double height, double depth) {
        mirrorBox = new Box(width, height, depth); // Créer une boîte de même taille pour le miroir
        PhongMaterial mirrorMaterial = new PhongMaterial();
        mirrorMaterial.setDiffuseMap(new Image("/Images/red_sandstone_pavement_diff_4k.jpg"));
        mirrorBox.setMaterial(mirrorMaterial);

        mirrorBox.getTransforms().addAll(
                new Scale(-1, 1, 1), // Appliquer une mise à l'échelle négative sur l'axe X pour l'effet miroir
                new Translate(width, 2*height, 0) // Positionner le miroir à droite de l'original
        );
    }

    public Box getMirrorBox() {
        return mirrorBox; // Accès au miroir pour l'ajouter à la scène si nécessaire
    }

    public void rotateByX(double angle) {
        this.getTransforms().add(new Rotate(angle, Rotate.X_AXIS));
        mirrorBox.getTransforms().add(new Rotate(angle, Rotate.X_AXIS)); // Appliquer la même rotation au miroir
    }

    public void rotateByY(double angle) {
        this.getTransforms().add(new Rotate(angle, Rotate.Y_AXIS));
        mirrorBox.getTransforms().add(new Rotate(angle, Rotate.Y_AXIS)); // Appliquer la même rotation au miroir
    }

    public void updateBasedOnSphere(double x, double y) {
        // Mise à jour de la couleur basée sur la position d'une sphère, par exemple
        PhongMaterial material = new PhongMaterial();
        if (Math.abs(this.getTranslateX() - x) < 50 && Math.abs(this.getTranslateY() - y) < 50) {
            material.setDiffuseColor(Color.GREEN);
        } else {
            material.setDiffuseColor(Color.RED);
        }
        this.setMaterial(material);
        mirrorBox.setMaterial(material); // Appliquer le même matériau au miroir
    }
}
