package AudioMusic;

import javazoom.jl.player.Player;

public class HiloAudio implements Runnable {
	protected AudioPlayer audio;
	
public HiloAudio() {
	
}
public void AudioOn() {
	audio = new AudioPlayer("/recursos/musicaPlantas.mp3");
}
}
