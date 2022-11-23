package AudioMusic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Musica {

public static void main (String [] ars) {
	musica ("/recursos/mainBG.png\");");
	
}

public static void  musica (String musicLocation) {
	 
	try {
		File musicPath= new File (musicLocation);

		if(musicPath.exists()) {
			AudioInputStream audioInput= AudioSystem.getAudioInputStream(musicPath);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
			clip.loop(clip.LOOP_CONTINUOUSLY);
		}
		else {
			System.out.println("No se puede encontrar la carpeta");
		}
	
	}catch(Exception e) {
		e.getMessage();
	}
}
}