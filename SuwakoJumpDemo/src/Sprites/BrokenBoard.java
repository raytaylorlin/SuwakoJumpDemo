package Sprites;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BrokenBoard extends Board {
    private static final int actionTotalCount = 3;
    private boolean isBroken;
    private int actionCount;

    public BrokenBoard(ImageObserver imageObserver, Image image, Point drawPosition) {
        super(imageObserver, image, drawPosition, BOARD_FRAME_SIZE, new Point(1, 1), new Point(400, 15));
    }

    @Override
    public void doAction() {
        if (this.isBroken) {
            if (this.actionCount < actionTotalCount) {
                this.drawPosition.y += 2;
                this.actionCount++;
            } else {
                this.toDisposed = true;
            }
        }
    }

    public void setBroken() {
        this.actionCount = 0;
        this.isBroken = true;
    }
}
