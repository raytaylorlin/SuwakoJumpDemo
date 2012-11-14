package Sprites;

import Lib.JSprite;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class CountScore extends JSprite {
    private static final Point drawInitSize = new Point(16, 24);
    private static final Point drawInitPoint = new Point(100, 7);

    private static Image scoreNumberImage;
    private ArrayList<ScoreNumber> numberList = new ArrayList<ScoreNumber>();
    private int realScore, showNumber;

    public CountScore(ImageObserver imageObserver, Image image) {
        super(imageObserver, image, drawInitPoint, drawInitSize);
        this.scoreNumberImage = image;
        this.numberList.add(new ScoreNumber(imageObserver, image, drawInitPoint, drawInitSize, 0));
    }

    public void draw(Graphics g) {
        for (int i = 0; i < this.numberList.size(); i++) {
            this.numberList.get(i).draw(g);
        }
    }

    public void update() {
        if (this.showNumber < this.realScore) {
            this.showNumber += 10;
            int number = this.showNumber;
            int bitTotal = (int) (Math.log10(this.showNumber)) + 1;
            for (int i = 0; i < bitTotal; i++) {
                if (i < this.numberList.size()) {
                    this.numberList.get(i).setShowNumber(number % 10);
                    this.numberList.get(i).setBitIndex(bitTotal - i - 1);
                } else {
                    this.numberList.add(new ScoreNumber(imageObserver, this.scoreNumberImage, drawInitPoint, drawInitSize, number % 10));
                }
                number /= 10;
            }

        }
        for (int i = 0; i < this.numberList.size(); i++) {
            this.numberList.get(i).update();
        }
    }

    public void increaseScore(int n) {
        this.realScore += n;
    }

    public void setNewPosition(Point point) {
        for (int i = 0; i < this.numberList.size(); i++) {
            this.numberList.get(i).drawPosition = point;
        }
    }
}
