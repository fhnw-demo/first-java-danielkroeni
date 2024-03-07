package pong;

import gui.Window;

public class PongGame {
    private static final int PLAYER_DISTANCE = 50;

    private int width;
    private int height;

    private Ball ball;
    private Player leftPlayer;
    private Player rightPlayer;

    private GameObject north, east, south, west;

    public PongGame(int width, int height) {
        this.width = width;
        this.height = height;

        ball = new Ball(width/2, height/2);
        leftPlayer = new Player(PLAYER_DISTANCE, height/2);
        rightPlayer = new Player(width-PLAYER_DISTANCE, height/2);

        north = new GameObject(width/2,  0,        width, 0);
        south = new GameObject(width/2,  height,   width, 0);
        west = new GameObject( 0,        height/2, 0,     height);
        east = new GameObject( width,    height/2, 0,     height);
    }

    /**
     * Bringt den Spielzustand um eine Zeiteinheit weiter.
     */
    public void step() {
        
        ball.step();

        // Kollision mit Top oder Bottom
        if(ball.intersects(north) || ball.intersects(south)) {
            ball.bounceOfHorizontal();
        }

        // Kollision mit Player
        if(ball.intersects(leftPlayer) || ball.intersects(rightPlayer)) {
            ball.bounceOfVertical();
        }

        // Kollision mit linker Wand
        if(ball.intersects(west)) {
            rightPlayer.incScore();
            restart();
            return;
        }

        // Kollision mit rechter Wand
        if(ball.intersects(east)) {
            leftPlayer.incScore();
            restart();
            return;
        }
    }

    /**
     * Initialisiert den Ball neu in der Mitte des Feldes.
     */
    public void restart() {
        ball = new Ball(width/2, height/2);
    }

    /**
     * Zeichnet das ganze Spiel auf das gegebene Window.
     * @param window das Fenster zum raufzeichnen.
     */
    public void drawGame(Window window) {
        for (GameObject gObj : new GameObject[]{ball, leftPlayer, rightPlayer, north, east, south, west}) {
            gObj.draw(window);
        }

        drawScore(window);
    }

    /**
     * Zeichnet den Punktestand auf das gegebene Window.
     * @param window das Fenster zum raufzeichnen.
     */
    private void drawScore(Window window) {
        window.setColor(0, 0, 0);
        window.setFontSize(20);
        window.drawStringCentered(leftPlayer.getScore() + ":" + rightPlayer.getScore(), width / 2, 50);
    }

    /**
     * Prozessiert Benutzereingaben.
     * @param window das Fenster um die Eingaben auszulesen.
     */
    public void handleEvents(Window window) {
        if (window.isKeyPressed("w")) {
            moveUp(leftPlayer);
        }
        if (window.isKeyPressed("s")) {
            moveDown(leftPlayer);
        }
        if (window.isKeyPressed("up")) {
            moveUp(rightPlayer);
        }
        if (window.isKeyPressed("down")) {
            moveDown(rightPlayer);
        }
    }

    /**
     * Bewegt einen Balken nach oben, wenn er dabei das Spielfeld nicht verlässt.
     * @param player der zu verschiebende Balken.
     */
    public void moveUp(Player player) {
        if(!player.intersects(north)) { 
            player.moveUp();
        }
    }

    /**
     * Bewegt einen Balken nach unten, wenn er dabei das Spielfeld nicht verlässt.
     * @param player der zu verschiebende Balken.
     */
    public void moveDown(Player player) {
        if(!player.intersects(south)) { 
            player.moveDown();
        }
    }
}
