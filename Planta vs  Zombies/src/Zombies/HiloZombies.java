package Zombies;

import java.util.LinkedList;

import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;
import GUI.GUI;
import TDALista.PositionList;

//vienen predeterminados desde un txt solo los manejo de aca
public class HiloZombies implements Runnable{
	//Atributos de instancia
	public LinkedList<LinkedList<Zombie>> oleadas;
	public Thread h1;
	protected GUI ventana;
	
	public HiloZombies (GUI v) {
		ventana = v;
		oleadas = ventana.getNivel().getOleadas();
	}
		
	public void run () {
		int dormir = 20000;
		while(!oleadas.isEmpty()) {
			try {
				
				Thread.sleep(dormir);
				LinkedList <Zombie> oleada = oleadas.getFirst();
				if (!oleada.isEmpty()) {
					Zombie zombie = oleada.remove(); // primer zombie de la lista
					zombie.caminar();
				}
				else {
					dormir /= 2;  
					oleadas.remove(oleadas.getFirst());
				}
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}

}
