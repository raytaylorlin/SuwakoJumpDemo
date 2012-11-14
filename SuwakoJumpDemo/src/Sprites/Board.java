package Sprites;

import Lib.JSprite;
import Frame.MainGame;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Board extends JSprite {
    protected static final int UP_MOVING_V = 20;
    protected static final Point BOARD_FRAME_SIZE = new Point(80, 15);

    public boolean isDownMoving, isUpMoving;
    protected int fallingCount, fallingDuration;
    protected int fallingTotalCount = 1;

    public Board(ImageObserver imageObserver, Image image, Point drawPosition, Point imageSize, Point sheetSize, Point cutPosition) {
        super(imageObserver, image, drawPosition, imageSize, sheetSize, cutPosition);
    }

    public void draw(Graphics g) {
        g.drawImage(this.drawImage, this.drawPosition.x, this.drawPosition.y,
                this.drawPosition.x + this.imageSize.x, this.drawPosition.y + this.imageSize.y,
                this.cutPosition.x, this.cutPosition.y,
                this.cutPosition.x + this.imageSize.x, this.cutPosition.y + this.imageSize.y, this.imageObserver);
    }

    public void update() {
        if (this.isDownMoving) {
            this.drawPosition.y += this.fallingDuration / this.fallingTotalCount;
            this.fallingCount++;
            if (this.fallingCount == this.fallingTotalCount) {
                this.isDownMoving = false;
            }
        } else if (this.isUpMoving) {
            this.drawPosition.y -= UP_MOVING_V;
            if (this.drawPosition.y < -200) {
                this.isUpMoving = false;
                this.toDisposed = true;
            }
        }
        this.doAction();
        if (this.drawPosition.y > MainGame.GAME_FIELD_HEIGHT + MainGame.GAME_SCORE_BAR_HEIGHT) {
            this.toDisposed = true;
        }
    }

    public void doAction() {
    }

    public void setFallingDown(int duration, int fallingTime) {
        this.isDownMoving = true;
        this.fallingCount = 0;
        this.fallingDuration = duration;
        this.fallingTotalCount = fallingTime * 2;
    }
}
