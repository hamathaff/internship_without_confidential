import Map.Mybox;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

public class Chambre extends Group {
    private static final double LARGEUR_CHAMBRE = 400;
    private static final double HAUTEUR_CHAMBRE = 200;
    private static final double PROFONDEUR_CHAMBRE = 300;
    private static final double EPAISSEUR_MUR = 10;  // Définir l'épaisseur des murs ici
    private static final double LARGEUR_PORTE = 80;
    private static final double HAUTEUR_PORTE = 150;

    private Mybox murGauche;
    private Mybox murDroit;
    private Mybox murAvant;
    private Mybox murArriere;
    private Mybox plafond;
    private Mybox mybox;
    private Porte porte;
    private Mybox murPetitGauche;
    private Mybox murPetitDroit;
    private Mybox murPorteToit;// Vous devez définir cette classe

    public Chambre() {
        murGauche = new Mybox(10, HAUTEUR_CHAMBRE, PROFONDEUR_CHAMBRE);
        murDroit = new Mybox(10, HAUTEUR_CHAMBRE, PROFONDEUR_CHAMBRE);
        murAvant = new Mybox(LARGEUR_CHAMBRE, HAUTEUR_CHAMBRE, 10);
        murArriere = new Mybox(LARGEUR_CHAMBRE, HAUTEUR_CHAMBRE, 10);
        double largeurPetitsMurs = 50;  // La largeur des petits murs de chaque côté de la porte
        murPetitGauche = new Mybox(EPAISSEUR_MUR, HAUTEUR_CHAMBRE, largeurPetitsMurs);
        murPetitDroit = new Mybox(EPAISSEUR_MUR, HAUTEUR_CHAMBRE, largeurPetitsMurs);
        murPetitGauche.setTranslateZ(-PROFONDEUR_CHAMBRE / 2 + largeurPetitsMurs / 2);
        murPetitDroit.setTranslateZ(PROFONDEUR_CHAMBRE / 2 - largeurPetitsMurs / 2);

        plafond = new Mybox(LARGEUR_CHAMBRE, 10, PROFONDEUR_CHAMBRE);
        mybox = new Mybox(LARGEUR_CHAMBRE, 10, PROFONDEUR_CHAMBRE);

        // Positionnez les murs correctement
        murGauche.setTranslateX(-LARGEUR_CHAMBRE / 2 + 5);
        murDroit.setTranslateX(LARGEUR_CHAMBRE / 2 - 5);
        murAvant.setTranslateZ(-PROFONDEUR_CHAMBRE / 2 + 5);
        murArriere.setTranslateZ(PROFONDEUR_CHAMBRE / 2 - 5);

        plafond.setTranslateY(-HAUTEUR_CHAMBRE / 2 + 5);
        mybox.setTranslateY(HAUTEUR_CHAMBRE / 2 - 5);

        porte = new Porte();  // Assurez-vous que Porte est correctement définie
        porte.setTranslateY(-HAUTEUR_CHAMBRE / 2 + 75);  // Hauteur de la porte
        murPorteToit = new Mybox(LARGEUR_CHAMBRE, EPAISSEUR_MUR, PROFONDEUR_CHAMBRE - 2 * largeurPetitsMurs);
        murPorteToit.setTranslateY(-HAUTEUR_CHAMBRE / 2 + EPAISSEUR_MUR / 2 + HAUTEUR_PORTE);



        getChildren().addAll(murGauche, murDroit, murAvant, murArriere, plafond, mybox,porte);
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

    public void moovbyx(){
        this.setTranslateX(this.getTranslateX()+10);
    }
    public void moovbyy(){
        this.setTranslateY(this.getTranslateY()+10);
    }
    public void moovbyxm(){
        this.setTranslateX(this.getTranslateX()-10);
    }

    public void moovbyym(){
        this.setTranslateY(this.getTranslateY()-10);
    }

}
