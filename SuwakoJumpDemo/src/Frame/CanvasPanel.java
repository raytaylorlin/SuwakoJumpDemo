package Frame;

import Lib.JSprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CanvasPanel extends JPanel implements KeyListener {
    public static boolean LeftKeyPressed = false;
    public static boolean RightKeyPressed = false;
    public static boolean EnterKeyPressed = false;

    private ArrayList<JSprite> spritesList = new ArrayList<JSprite>();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < spritesList.size(); i++) {
            JSprite sprite = spritesList.get(i);
            sprite.draw(g);
        }
    }

    public void add(JSprite sprite) {
        this.spritesList.add(sprite);
    }

    public void remove(JSprite sprite) {
        if (this.spritesList.contains(sprite)) {
            this.spritesList.remove(sprite);
        }
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                LeftKeyPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                RightKeyPressed = true;
                break;
            case KeyEvent.VK_ENTER:
                EnterKeyPressed = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                LeftKeyPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                RightKeyPressed = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//            EnterKeyPressed = true;
//        }
    }
}

