package Sprites;

import java.awt.*;
import java.awt.image.ImageObserver;

public class VanishBoard extends Board {
    public VanishBoard(ImageObserver imageObserver, Image image, Point drawPosition) {
        super(imageObserver, image, drawPosition, BOARD_FRAME_SIZE, new Point(1, 1), new Point(400, 45));
    }

    @Override
    public void doAction() {

    }

    public void vanish() {
        this.drawPosition.x=-100;
        this.toDisposed = true;
    }
}
