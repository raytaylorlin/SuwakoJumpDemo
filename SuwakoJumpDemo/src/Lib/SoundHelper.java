package Lib;

import javax.swing.*;

public class SoundHelper extends JApplet{
    public static void play(SoundEffect se){
        se.audioClip.play();
    }
}
