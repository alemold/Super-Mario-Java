import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Floor {
    private Image floorImage;
    private int tileSize;

    // Constructor
    public Floor(String imagePath, int tileSize) {
        this.tileSize = tileSize;
        ImageIcon icon = new ImageIcon(imagePath);
        // Scala l'immagine per adattarla alla dimensione della cella
        this.floorImage = icon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
    }

    // Metodo per disegnare il pavimento in base alla matrice
    public void draw(Graphics g, int[][] floorMatrix, int screenHeight, int tileWidth, int tileHeight) {
        // Cicla su tutte le righe e colonne nella matrice
        for (int row = 0; row < floorMatrix.length; row++) {
            for (int col = 0; col < floorMatrix[row].length; col++) {
                // Calcola la posizione di ogni tile
                int x = col * tileWidth;
                int y = screenHeight - (row + 1) * tileHeight; // Dispone i tiles in basso

                // Disegna ogni tile nel punto x, y
                g.drawImage(floorImage, x, y, tileWidth, tileHeight, null);
            }
        }
    }
}
