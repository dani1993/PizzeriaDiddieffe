package tests;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.Sound;

public class SoundTest {

	private Sound fakeSound;
	private String soundName;
	private String existingSound = "res/addToOrderSound.wav";

	@Before
	public void setUpSound() {
		fakeSound = new Sound();
	}

	@Test(expected = FileNotFoundException.class)
	public void wrongSoundNameTest() throws Exception{
		soundName = "notExistWavFile.wav";
		playCurrentSound(soundName);
	}

	@Test
	public void playCurrectSound() throws Exception{
		soundName = existingSound;
		playCurrentSound(soundName);
	}

	@Test(expected = Exception.class)
	public void noSoundNameTest() throws Exception{
		playCurrentSound(soundName);
	}

	private void playCurrentSound(String currentSound) throws Exception {
		fakeSound.setSound(currentSound);
		fakeSound.playSound();
	}
}