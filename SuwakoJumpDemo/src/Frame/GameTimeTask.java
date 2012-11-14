package Frame;

import java.util.TimerTask;

public class GameTimeTask extends TimerTask {
    private GameLogic gameLogic;
    private CanvasPanel canvasPanel;

    public GameTimeTask(GameLogic gameLogic, CanvasPanel canvasPanel) {
        this.gameLogic = gameLogic;
        this.canvasPanel = canvasPanel;
    }

    public void run() {
        this.draw();
        this.update();
    }

    private void draw() {
//        this.canvasPanel.paintComponent(this.canvasPanel.getGraphics());
        this.canvasPanel.repaint();
    }

    private void update() {
        this.gameLogic.update();
    }

//    private void remove(Lib.JSprite sprite) {
//        if (this.spritesVector.contains(sprite)) {
//            this.spritesVector.removeElement(sprite);
//        }
//    }
}
