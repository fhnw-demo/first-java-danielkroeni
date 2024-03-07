package pong;

import gui.Window;

/**
 * Diese Klasse beschreibt ein Spieler (Balken).
 */
public class Player extends GameObject {
    private int score = 0;

    public Player(int x, int y) {
        super(x, y, 10, 100);
    }

    /**
     * Gibt den Punktestand zurück.
     * @return den Punktestand dieses Spielers.
     */
    public int getScore() {
        return score;
    }

    /**
     * Inkrementiert den Spielstand.
     */
    public void incScore() {
        score++;
    }

    /**
     * Bewegt den Balken nach oben.
     */
    public void moveUp() {
        move(0, -10);
    }

    /**
     * Bewegt den Balken nach unten.
     */
    public void moveDown() {
        move(0, 10);
    }

    @Override
    public void draw(Window window) {
        window.setColor(0,0,0);
        window.fillRect(x-width/2 , y-height/2, width, height);
    }
}
