package Sprites;

import Lib.RandomHelper;
import Frame.MainGame;
import java.awt.*;
import java.awt.image.ImageObserver;

public class MovingBoard extends Board {
    private static final int MOVE_RANGE = MainGame.GAME_FIELD_WIDTH - 80;
    private boolean isOneSideMoving = false;
    private boolean isVerticalMoving = false;
    private int currentMovingLocation = 0;
    private int velocity = 3;

    public MovingBoard(ImageObserver imageObserver, Image image, Point drawPosition, boolean isVerticalMoving) {
        super(imageObserver, image, drawPosition, BOARD_FRAME_SIZE, new Point(1, 1), new Point(400, 30));
        this.drawPosition.x = this.currentMovingLocation = RandomHelper.getRandom(MOVE_RANGE);
        this.isVerticalMoving = isVerticalMoving;
    }

    @Override
    public void doAction() {
        if (this.currentMovingLocation <= 0 || this.currentMovingLocation >= MOVE_RANGE) {
            this.isOneSideMoving = !this.isOneSideMoving;
        }
        int delta = velocity * (this.isOneSideMoving ? 1 : -1);
        this.currentMovingLocation += delta;
        //垂直移动
        if (this.isVerticalMoving) {
            this.drawPosition.y += delta;
        }
        //水平移动
        else {
            this.drawPosition.x += delta;
        }
    }
}
