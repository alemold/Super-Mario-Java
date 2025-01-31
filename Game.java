import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Game extends JPanel {
    private Floor floor; // Crea l'oggetto Floor
    
    private Cloud cloud;
    private Image cloudImage;

    public Game() {
        setPreferredSize(new Dimension(1920, 1080));
        setFocusable(true);

        cloudImage = Toolkit.getDefaultToolkit().getImage("images/cloud.png");

        // Inizializza il pavimento con l'immagine e la dimensione dei tiles
        floor = new Floor("images/floor.jpg", 32);
        cloud = new Cloud(500, 100, 200, 60, cloudImage);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //SFONDO
        g.setColor(new Color(100, 149, 237));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Ottieni la larghezza e l'altezza della finestra
        int screenWidth = getWidth();
        int screenHeight = getHeight();

        // Numero di colonne (tile per larghezza schermo)
        int cols = screenWidth / 32;

        // Crea la matrice per il pavimento
        int[][] floorMatrix = new int[2][cols]; // Due righe per il pavimento

        // Disegna il pavimento utilizzando la classe Floor
        floor.draw(g, floorMatrix, screenHeight, 64, 64); // Passiamo la matrice, altezza e larghezza dei tile
        cloud.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Super Mario Moldy");
        // Imposta la finestra per adattarsi alla dimensione dello schermo
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Ottieni le dimensioni dello schermo
        frame.setSize(screenSize);  // Imposta la finestra alla dimensione dello schermo

        // Finestra normale con barra del titolo
        frame.setResizable(false);  // Disabilita il ridimensionamento
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game gamePanel = new Game();
        frame.add(gamePanel);
        frame.setVisible(true);  // Mostra la finestra
    }
}
