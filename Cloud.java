import java.awt.*;

public class Cloud {
    private int x, y;
    private int width, height;
    private Image cloudImage;

    public Cloud(int x, int y, int width, int height, Image cloudImage) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.cloudImage = cloudImage;

        this.cloudImage = cloudImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    // Metodo per disegnare la nuvola
    public void draw(Graphics g) {
        g.drawImage(cloudImage, x, y, null);  // Disegna la nuvola
    }
}
