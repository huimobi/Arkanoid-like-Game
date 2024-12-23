package project.com.Sound;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.sound.sampled.Clip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SoundTrackTest {

    private Clip mockClip;
    private SoundTrack soundTrack;

    @BeforeEach
    void setUp() {
        mockClip = mock(Clip.class);

        soundTrack = new SoundTrack(mockClip);
    }

    @Test
    void testStart() {
        soundTrack.start();


        verify(mockClip).setMicrosecondPosition(0);
        verify(mockClip).start();
        verify(mockClip).loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Test
    void testStop() {
        soundTrack.stop();

        verify(mockClip).stop();
    }

    @Test
    void testSetSound() {
        Clip newMockClip = mock(Clip.class);

        soundTrack.setSound(newMockClip);

        assertEquals(newMockClip, soundTrack.getSound());
    }

    @Test
    void testGetSound() {
        assertEquals(mockClip, soundTrack.getSound());
    }
}
