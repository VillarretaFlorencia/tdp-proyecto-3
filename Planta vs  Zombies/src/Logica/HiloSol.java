package Logica;

import javax.swing.JFrame;

public class HiloSol implements Runnable{
	protected int hiloSol;
	protected JFrame ventana;
	
	public HiloSol(JFrame ventana) {
		this.ventana = ventana;
		hiloSol = 0;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(hiloSol);
				this.lblNewLabel_1.set
			}
		}
	}
}
