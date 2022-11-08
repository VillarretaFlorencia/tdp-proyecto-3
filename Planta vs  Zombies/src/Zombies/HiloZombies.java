package Zombies;

import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;
import GUI.GUI;
import TDALista.PositionList;

//vienen predeterminados desde un txt solo los manejo de aca
public class HiloZombies implements Runnable{
	//Atributos de instancia
	public PositionList<PositionList<Zombie>> oleadas;
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
				PositionList<Zombie> oleada = oleadas.first().element();
				if (!oleada.isEmpty()) {
					Zombie zombie = oleada.remove(oleada.last());
					zombie.caminar();
				}
				else {
					dormir /= 2;  
					oleadas.remove(oleadas.first());
				}
			} catch (EmptyListException | InvalidPositionException | InterruptedException e) {e.printStackTrace();}
		}
	}

}
