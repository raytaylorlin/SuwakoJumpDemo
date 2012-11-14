package Sprites;

import Lib.JSprite;

import java.awt.*;
import java.awt.image.ImageObserver;

public class ScoreNumber extends JSprite {
    private static final int NUMBER_WIDTH = 16;
    private static final int NUMBER_HEIGHT = 24;

    private int showNumber, bitIndex;

    public ScoreNumber(ImageObserver imageObserver, Image image, Point drawPosition, Point imageSize, int bitIndex) {
        super(imageObserver, image, drawPosition, imageSize, new Point(10, 1), new Point(0, 0));
        this.bitIndex = bitIndex;
    }

    public void draw(Graphics g) {
        g.drawImage(this.drawImage, this.drawPosition.x + NUMBER_WIDTH * this.bitIndex, this.drawPosition.y,
                this.drawPosition.x + NUMBER_WIDTH * (this.bitIndex + 1), this.drawPosition.y + NUMBER_HEIGHT,
                NUMBER_WIDTH * this.showNumber, this.cutPosition.y,
                NUMBER_WIDTH * (this.showNumber + 1), this.cutPosition.y + NUMBER_HEIGHT, this.imageObserver);
    }

    public void update() {
//        if (this.showNumber != this.realNumber) {
//            this.cutPosition.x = this.showNumber * NUMBER_WIDTH;
//        }
    }

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }

    public void setBitIndex(int bitIndex) {
        this.bitIndex = bitIndex;
    }

}
