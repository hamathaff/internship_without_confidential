import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class CustomSphere extends Sphere {

    public CustomSphere(double radius) {
        super(radius);
        init();
    }

    private void init() {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        this.setMaterial(material);
    }
}
