package Map; // Assurez-vous que le package est correctement déclaré

import javafx.scene.layout.GridPane;

public class Grid extends GridPane {
    private int width;
    private int height;
    private Mybox[][] cells; // Tableau pour stocker les références aux Mybox

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Mybox[width][height]; // Initialisation du tableau
        initializeCells();
    }

    private void initializeCells() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Mybox m = new Mybox(100, 1, 100); // Création d'une nouvelle Mybox
                cells[i][j] = m; // Stockage de la Mybox dans le tableau
                this.add(m, i, j); // Ajout de la Mybox à la GridPane à la position (i, j)
                // Ajuster la position y si nécessaire en fonction de l'application
                m.setTranslateY(-m.getHeight() / 2);
            }
        }
    }

    public Mybox getCell(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return cells[x][y]; // Retourne la Mybox située à la position (x, y)
        } else {
            return null; // Gestion d'accès hors des limites du tableau
        }
    }
}
