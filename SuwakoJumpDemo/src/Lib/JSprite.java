package Lib;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class JSprite {
    protected ImageObserver imageObserver;
    protected Image drawImage;
    public Point drawPosition, cutPosition;
    public Point sheetSize, imageSize;
    public boolean toDisposed;

    public JSprite(ImageObserver imageObserver, Image image, Point drawPosition, Point imageSize) {
        this(imageObserver, image, drawPosition, imageSize, new Point(1, 1), new Point(0, 0));
    }

    public JSprite(ImageObserver imageObserver, Image image, Point drawPosition, Point imageSize, Point sheetSize, Point cutPosition) {
        this.imageObserver = imageObserver;
        this.drawImage = image;
        this.drawPosition = drawPosition;
        this.imageSize = imageSize;
        this.sheetSize = sheetSize;
        this.cutPosition = cutPosition;
    }

    public abstract void draw(Graphics g);

    public abstract void update();
}
