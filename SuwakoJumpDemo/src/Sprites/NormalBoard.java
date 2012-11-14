package Sprites;

import java.awt.*;
import java.awt.image.ImageObserver;

public class NormalBoard extends Board {
    public NormalBoard(ImageObserver imageObserver, Image image, Point drawPosition) {
        super(imageObserver, image, drawPosition, BOARD_FRAME_SIZE, new Point(1, 1), new Point(400, 0));
    }

}

