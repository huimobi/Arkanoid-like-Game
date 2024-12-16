package project.com.Sound;

import javax.sound.sampled.Clip;

public interface Sound {

    void start();
    void stop();

    void setSound(Clip sound);
    Clip getSound();
}
