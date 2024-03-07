package pong;

import gui.Window;

/**
 * Diese Klasse modelliert ein Spiel Objekt, welches eine Position hat und gezeichnet werden kann.
 */
public class GameObject {
    int x, y; // Referenzpunkt in der Mitte
    int width, height;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void draw(Window window) {
        window.setColor(255,0,0);
        window.setStrokeWidth(1);
        window.drawRect(x - width/2, y - height/2, width, height);
    }

    // https://silentmatt.com/rectangle-intersection/
    public boolean intersects(GameObject other) {
        return x - width/2  < other.x + other.width/2
            && x + width/2  > other.x - other.width/2
            && y - height/2 < other.y + other.height/2
            && y + height/2 > other.y - other.height/2;
    }
}