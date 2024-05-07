import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class Chambre extends Group {
    private Porte porte;
    private static final double LARGEUR_CHAMBRE = 400;
    private static final double HAUTEUR_CHAMBRE = 200;
    private static final double PROFONDEUR_CHAMBRE = 300;
    private static final double EPAISSEUR_MUR = 10;
    private static final double ANGLE_ROTATION = 20;
    private static final double LARGEUR_PORTE = 80;
    private static final double HAUTEUR_PORTE = 150;

    private Box murGauche;
    private Box murDroit;
    private Box murAvant;
    private Box murArriere;
    private Box plafond;
    private Box sol;

    public Chambre() {
        porte = new Porte();
        porte.setTranslateY(-HAUTEUR_CHAMBRE / 2 + HAUTEUR_PORTE / 2);

        murGauche = createWall(EPAISSEUR_MUR, HAUTEUR_CHAMBRE, PROFONDEUR_CHAMBRE, Color.GRAY);
        murDroit = createWall(EPAISSEUR_MUR, HAUTEUR_CHAMBRE, PROFONDEUR_CHAMBRE, Color.GRAY);
        murAvant = createWall(LARGEUR_CHAMBRE - 2 * EPAISSEUR_MUR, HAUTEUR_CHAMBRE, EPAISSEUR_MUR, Color.GRAY);
        murArriere = createWall(LARGEUR_CHAMBRE - 2 * EPAISSEUR_MUR, HAUTEUR_CHAMBRE, EPAISSEUR_MUR, Color.GRAY);

        plafond = new Box(LARGEUR_CHAMBRE, EPAISSEUR_MUR, PROFONDEUR_CHAMBRE);
        plafond.setTranslateY(-HAUTEUR_CHAMBRE / 2 + EPAISSEUR_MUR / 2);
        PhongMaterial plafondMaterial = new PhongMaterial(Color.GRAY);
        plafondMaterial.setDiffuseColor(Color.GRAY);
        plafondMaterial.setSpecularColor(Color.GRAY);
        plafond.setMaterial(plafondMaterial);

        sol = createGround(LARGEUR_CHAMBRE, PROFONDEUR_CHAMBRE);
        sol.setTranslateY(HAUTEUR_PORTE / 2);

        getChildren().addAll(murGauche, murDroit, murAvant, murArriere, plafond, sol, porte);
    }

    private Box createWall(double largeur, double hauteur, double profondeur, Color couleur) {
        Box mur = new Box(largeur, hauteur, profondeur);
        PhongMaterial material = new PhongMaterial(couleur);
        material.setDiffuseColor(couleur);
        material.setSpecularColor(Color.WHITE); // Ajustement de la couleur pour une réflexion réaliste
        mur.setMaterial(material);
        return mur;
    }

    private Box createGround(double largeur, double profondeur) {
        Box sol = new Box(largeur, 0.1, profondeur);
        PhongMaterial material = new PhongMaterial(Color.GREEN);
        material.setDiffuseColor(Color.GREEN);
        material.setSpecularColor(Color.WHITE); // Ajustement de la couleur pour une réflexion réaliste
        sol.setMaterial(material);
        return sol;
    }

    public void rotateByX(double angle) {
        this.getTransforms().add(new Rotate(angle, Rotate.X_AXIS));
    }

    public void rotateByY(double angle) {
        this.getTransforms().add(new Rotate(angle, Rotate.Y_AXIS));
    }

    public void rotateByZ(double angle) {
        this.getTransforms().add(new Rotate(angle, Rotate.Z_AXIS));
    }
}
