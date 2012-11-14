package Lib;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundEffect extends Applet {
    public AudioClip audioClip;

    public SoundEffect(String fileName) {
        try {
            File file = new File(fileName);
            URL url = file.toURI().toURL();
            this.audioClip = newAudioClip(url);
        } catch (MalformedURLException e) {

        }
    }
}
