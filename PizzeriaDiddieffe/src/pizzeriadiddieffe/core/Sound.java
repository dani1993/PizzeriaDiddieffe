package pizzeriadiddieffe.core;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sound implements SoundPlayerInterface {
	private String soundName;

	public void setSound(String soundName) {
		this.soundName = soundName;
	}

	@Override
	public void playSound() throws Exception {
		File file = new File(soundName);
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		Clip clip;

		stream = AudioSystem.getAudioInputStream(file);
		format = stream.getFormat();
		info = new DataLine.Info(Clip.class, format);
		clip = (Clip) AudioSystem.getLine(info);
		clip.open(stream);
		clip.start();
	}
}