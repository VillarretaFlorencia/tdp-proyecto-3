package Zombies;

import java.util.LinkedList;

import Fila.ArregloFilas;
import Logica.Nivel;

//vienen predeterminados desde un txt solo los manejo de aca
public class HiloZombies implements Runnable{
	//Atributos de instancia
	public LinkedList<LinkedList<Zombie>> oleadas;
	protected Nivel nivel = Nivel.getNivel();
	
	 
	public HiloZombies () {
		oleadas = nivel.getOleadas();
	}
		
	public void run () {
		int dormir = 2000;
		while(!oleadas.isEmpty()) {
			try {
				LinkedList <Zombie> oleada = oleadas.getFirst();
				while (!oleada.isEmpty()) {
					System.out.println("oleada no vacia");
					System.out.println(oleada.size());
					Zombie zombie = oleada.remove(); // primer zombie de la lista
					nivel.setZombie (zombie);
					Thread.sleep(dormir);
				}
				oleadas.remove(oleadas.getFirst());
				//ventana.getNuevaOleada();
				Thread.sleep(200);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
