package Zombies;

import java.util.LinkedList;

import Cronometro.Cronometro;
import Fila.ArregloFilas;
import Logica.Nivel;

//vienen predeterminados desde un txt solo los manejo de aca
public class HiloZombies implements Runnable{
	//Atributos de instancia
	public LinkedList<LinkedList<Zombie>> oleadas;
	protected Nivel nivel = Nivel.getNivel();
	Thread hc;
	int dormir;
	 
	public HiloZombies () {
		oleadas = nivel.getOleadas();
		dormir = 1000;
	}
		
	public void run () {
		
		while(!oleadas.isEmpty()) {
			try {
				LinkedList <Zombie> oleada = oleadas.getFirst() ;
				while (!oleada.isEmpty()) {
					System.out.println("oleada no vacia");
					System.out.println(oleada.size());
					Zombie zombie = oleada.remove(); // primer zombie de la lista
					nivel.setZombie (zombie);
				}
				
				oleadas.remove(oleadas.getFirst());
				//ventana.getNuevaOleada();
				Thread.sleep(60000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		    	
	}
	
	
}
