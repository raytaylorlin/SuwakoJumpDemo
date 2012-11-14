package Frame;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;

public class MainGame extends JFrame {
    public static final int GAME_FIELD_WIDTH = 400;
    public static final int GAME_FIELD_HEIGHT = 600;
    public static final int GAME_SCORE_BAR_HEIGHT = 40;
    public static final int GAME_FRAME_RATE = 25;
    public static final int WINDOW_X_OFFSET = 20;
    public static final int WINDOW_Y_OFFSET = 36;

    private Timer timer;
    private GameTimeTask gameTimeTask;
    private CanvasPanel canvasPanel;

    public MainGame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Suwako Jump 1.0a");
        this.setLocation(20, 20);
        this.setResizable(false);
        this.canvasPanel = new CanvasPanel();

        JScrollPane scrollPane = new JScrollPane(this.canvasPanel);
        Container content = this.getContentPane();
        content.add(scrollPane, BorderLayout.CENTER);

        this.setSize(GAME_FIELD_WIDTH + WINDOW_X_OFFSET, GAME_FIELD_HEIGHT + GAME_SCORE_BAR_HEIGHT + WINDOW_Y_OFFSET);
        this.setVisible(true);
        this.addKeyListener(this.canvasPanel);
    }

    public void start() {
        this.init();
        this.timer.schedule(this.gameTimeTask, 0, 1000 / GAME_FRAME_RATE);
    }

    private void init() {
        this.timer = new Timer();
        GameLogic gameLogic = new GameLogic(this, this.canvasPanel);
        this.gameTimeTask = new GameTimeTask(gameLogic, this.canvasPanel);
    }

    public static void main(String[] args) {
        MainGame mainGame = new MainGame();
        mainGame.start();
    }
}