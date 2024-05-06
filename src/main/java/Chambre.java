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
    private static final double HAUTEUR_PORTE = 150; // Hauteur de la porte

    private Box murGauche;
    private Box murDroit;
    private Box murAvant;
    private Box murArriere;
    private Box plafond;
    private Box sol;

    public Chambre() {
        porte = new Porte();
        porte.setTranslateY(-HAUTEUR_CHAMBRE / 2 + HAUTEUR_PORTE / 2); // Positionnement de la porte au bas de la chambre

        // Création des murs
        murGauche = createWall(EPAISSEUR_MUR, HAUTEUR_CHAMBRE, PROFONDEUR_CHAMBRE, Color.GRAY);
        murDroit = createWall(EPAISSEUR_MUR, HAUTEUR_CHAMBRE, PROFONDEUR_CHAMBRE, Color.GRAY);
        murAvant = createWall(LARGEUR_CHAMBRE - 2 * EPAISSEUR_MUR, HAUTEUR_CHAMBRE, EPAISSEUR_MUR, Color.GRAY);
        murArriere = createWall(LARGEUR_CHAMBRE - 2 * EPAISSEUR_MUR, HAUTEUR_CHAMBRE, EPAISSEUR_MUR, Color.GRAY);

        // Création des murs invisibles
        Box murGaucheInvisible = createInvisibleWall(EPAISSEUR_MUR, HAUTEUR_CHAMBRE, PROFONDEUR_CHAMBRE);
        Box murDroitInvisible = createInvisibleWall(EPAISSEUR_MUR, HAUTEUR_CHAMBRE, PROFONDEUR_CHAMBRE);
        Box murAvantInvisible = createInvisibleWall(LARGEUR_CHAMBRE - 2 * EPAISSEUR_MUR, HAUTEUR_CHAMBRE, EPAISSEUR_MUR);
        Box murArriereInvisible = createInvisibleWall(LARGEUR_CHAMBRE - 2 * EPAISSEUR_MUR, HAUTEUR_CHAMBRE, EPAISSEUR_MUR);

        // Positionnement des murs
        murGauche.setTranslateX(-(LARGEUR_CHAMBRE - EPAISSEUR_MUR - LARGEUR_PORTE) / 2);
        murDroit.setTranslateX((LARGEUR_CHAMBRE - EPAISSEUR_MUR - LARGEUR_PORTE) / 2 + LARGEUR_PORTE);
        murAvant.setTranslateZ(-(PROFONDEUR_CHAMBRE - EPAISSEUR_MUR) / 2);
        murArriere.setTranslateZ((PROFONDEUR_CHAMBRE - EPAISSEUR_MUR) / 2);

        // Positionnement des murs invisibles
        murGaucheInvisible.setTranslateX(-(LARGEUR_CHAMBRE - EPAISSEUR_MUR - LARGEUR_PORTE) / 2 - EPAISSEUR_MUR);
        murDroitInvisible.setTranslateX((LARGEUR_CHAMBRE - EPAISSEUR_MUR - LARGEUR_PORTE) / 2 + LARGEUR_PORTE + EPAISSEUR_MUR);
        murAvantInvisible.setTranslateZ(-(PROFONDEUR_CHAMBRE - EPAISSEUR_MUR) / 2 - EPAISSEUR_MUR);
        murArriereInvisible.setTranslateZ((PROFONDEUR_CHAMBRE - EPAISSEUR_MUR) / 2 + EPAISSEUR_MUR);

        // Création du plafond
        plafond = new Box(LARGEUR_CHAMBRE, EPAISSEUR_MUR, PROFONDEUR_CHAMBRE);
        plafond.setTranslateY(-HAUTEUR_CHAMBRE / 2 + EPAISSEUR_MUR / 2);
        PhongMaterial plafondMaterial = new PhongMaterial(Color.GRAY);
        plafondMaterial.setDiffuseColor(Color.GRAY);
        plafondMaterial.setSpecularColor(Color.GRAY);
        plafond.setMaterial(plafondMaterial);

        // Création du sol (terrain)
        sol = createGround(LARGEUR_CHAMBRE, PROFONDEUR_CHAMBRE);
        sol.setTranslateY(HAUTEUR_PORTE / 2); // Positionnement du sol sous la porte
        PhongMaterial solMaterial = new PhongMaterial(Color.GREEN); // Vous pouvez ajuster la couleur pour représenter un sol réaliste

        // Ajout des éléments à la chambre
        getChildren().addAll(murGauche, murDroit, murAvant, murArriere, plafond, sol, porte);
    }

    private Box createWall(double largeur, double hauteur, double profondeur, Color couleur) {
        Box mur = new Box(largeur, hauteur, profondeur);
        PhongMaterial material = new PhongMaterial(couleur);
        material.setDiffuseColor(Color.GRAY);
        material.setSpecularColor(Color.GRAY);
        mur.setMaterial(material);
        return mur;
    }

    private Box createGround(double largeur, double profondeur) {
        Box sol = new Box(largeur, 0.1, profondeur);
        PhongMaterial material = new PhongMaterial(Color.GREEN); // Vous pouvez ajuster la couleur pour représenter un sol réaliste
        material.setDiffuseColor(Color.GREEN);
        material.setSpecularColor(Color.GREEN);
        sol.setMaterial(material);
        return sol;
    }

    // Méthode pour effectuer une rotation autour de l'axe X
    public void rotateByX(double angle) {
        this.getTransforms().add(new Rotate(angle, Rotate.X_AXIS));
    }

    // Méthode pour effectuer une rotation autour de l'axe Y
    public void rotateByY(double angle) {
        this.getTransforms().add(new Rotate(angle, Rotate.Y_AXIS));
    }

    // Méthode pour effectuer une rotation autour de l'axe Z
    public void rotateByZ(double angle) {
        this.getTransforms().add(new Rotate(angle, Rotate.Z_AXIS));
    }
    private Box createInvisibleWall(double largeur, double hauteur, double profondeur) {
        Box mur = new Box(largeur, hauteur, profondeur);
        PhongMaterial material = new PhongMaterial(Color.BLACK); // Couleur noire pour le mur invisible
        material.setDiffuseColor(Color.BLACK);
        material.setSpecularColor(Color.BLACK);
        material.setDiffuseColor(Color.rgb(0, 0, 0, 0)); // Opacité complète (0% de visibilité)
        mur.setMaterial(material);
        return mur;
    }

}
