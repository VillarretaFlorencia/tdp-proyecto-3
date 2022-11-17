package Proyectil;

import javax.swing.JFrame;

import Logica.Fila;

public class HiloProyectil implements Runnable{
	//Atributos de instancia
	protected Thread h1;
	protected int n;
	protected Proyectil proyectil; 
	//protected JFrame ventana;
	
	public HiloProyectil(Proyectil p) {
		proyectil = p;
	}
	
	public void run () {
		while(proyectil.getActivo()) {
			try {
				Thread.sleep(1000);
				proyectil.move();
			}catch (InterruptedException e) {
				e.getMessage();
			}
		}
	}
}