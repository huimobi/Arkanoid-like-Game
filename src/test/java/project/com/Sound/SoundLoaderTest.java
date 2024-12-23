package project.com.Sound;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.com.Sound.SoundLoader;
import project.com.Sound.SoundTrack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;


import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SoundLoaderTest {
    private SoundLoader soundLoader;
    @BeforeEach
    void setUp(){
        this.soundLoader=new SoundLoader();
    }

    @Test
    void testLoadSoundSuccess() throws Exception {
        AudioInputStream mockAudioInputStream = mock(AudioInputStream.class);
        Clip mockClip = mock(Clip.class);
        Clip result = soundLoader.loadSound(mockAudioInputStream, mockClip);
        verify(mockClip).open(mockAudioInputStream);
        assertEquals(mockClip, result);
    }

    @Test
    void testLoadSoundFailure() throws LineUnavailableException, IOException {
        AudioInputStream audioInput = Mockito.mock(AudioInputStream.class);
        Clip musicClip = Mockito.mock(Clip.class);
        doThrow(new FileNotFoundException()).when(musicClip).open(Mockito.any());

        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> new SoundTrack(new SoundLoader().loadSound(audioInput, musicClip)),
                "SoundTrack was supposed to throw Exception");

        Assertions.assertEquals("Unable to load sound file!", thrown.getMessage());
    }

}
