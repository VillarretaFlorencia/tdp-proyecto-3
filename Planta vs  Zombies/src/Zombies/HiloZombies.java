package Zombies;

import java.util.LinkedList;

import Fila.ArregloFilas;
import GUI.PanelJardin;
import Logica.Nivel;

//vienen predeterminados desde un txt solo los manejo de aca
public class HiloZombies implements Runnable{
	//Atributos de instancia
	public LinkedList<LinkedList<Zombie>> oleadas;
	public Thread h1;
	protected PanelJardin ventana;
	protected Nivel nivel = Nivel.getNivel();
	protected ArregloFilas filas;
	 
	public HiloZombies (PanelJardin v) {
		ventana = v;
		filas = nivel.getFilas();
		oleadas = nivel.getOleadas();
	}
		
	public void run () {
		int dormir = 10000;
		while(!oleadas.isEmpty()) {
			try {
				LinkedList <Zombie> oleada = oleadas.getFirst();
				while (!oleada.isEmpty()) {
					Zombie zombie = oleada.remove(); // primer zombie de la lista
					nivel.setZombie (zombie);
					Thread.sleep(dormir);
				}
				oleadas.remove(oleadas.getFirst());
				//ventana.getNuevaOleada();
				Thread.sleep(20000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
