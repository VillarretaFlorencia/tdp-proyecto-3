package AudioMusic;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class AudioPlayer implements Runnable {
	
	protected String file;
	protected long milisegundos;
	
	public AudioPlayer() {
		file = "./recursos/MusicaPlantas.mp3";
	}

	@Override
	public void run() {
		try{
			while (milisegundos % 88000==0){
			File f = new File(getClass().getClassLoader().getResource(this.file).toURI());
			FileInputStream fis = new FileInputStream(f);
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		}
		}
		catch(Exception ex)
		{  
			ex.printStackTrace();
		}
	}

}
	



