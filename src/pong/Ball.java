package pong;

import gui.Window;

public class Ball extends GameObject {
    private static final int radius = 5;
    private int vx, vy;
    
    public Ball(int x, int y) {
        super(x, y, 2*radius, 2*radius);

        double signX = Math.random() > 0.5 ? 1 : -1;
        double signY = Math.random() > 0.5 ? 1 : -1;

        this.vx = (int) (signX * (2 + (Math.random() * 4)));
        this.vy = (int) (signY * (2 + (Math.random() * 4)));
    }

    public void bounceOfHorizontal() {
        vy *= -1;
    }

    public void bounceOfVertical() {
        vx *= -1;
    }

    public void step() {
        x += vx;
        y += vy;
    }

    @Override
    public void draw(Window window) {
        window.setColor(0,0,0);
        window.fillCircle(x, y, radius);
    }
}
