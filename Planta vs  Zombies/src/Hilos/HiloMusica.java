package Hilos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class HiloMusica implements Runnable {
	
	protected String musica;
	protected long milisegundos;
	
	public HiloMusica() {
		musica = "./recursos/MusicaPlantas.mp3";
		milisegundos = 0;
	}

	@Override
	public void run() {
		
			while (true){
				milisegundos ++;
				if (milisegundos % 88000 == 0) {
					try {
						File archivo = new File(getClass().getClassLoader().getResource(musica).toURI());
						FileInputStream fis = new FileInputStream(archivo);
					    Player playMP3 = new Player(fis);
					    playMP3.play();
					} catch (JavaLayerException | URISyntaxException | FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
	}

}
	



