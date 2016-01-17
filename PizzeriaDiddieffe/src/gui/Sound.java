package gui;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sound {
	private String soundName;
	
	public void setSound(String soundName){
		this.soundName=soundName;
	}
	
	
	 public void playSound()
	 {
		 try {
			    File file=new File(soundName);
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
			catch (Exception e) {
			    System.out.println("errore");
			}
	 }
}
