package Logica;


import java.util.LinkedList;
import java.util.PriorityQueue;

import Plantas.Planta;
import Zombies.Zombie;

public class Fila{
	protected LinkedList<Zombie> listaZombies;
	protected PriorityQueue <Planta> listaPlantas;
	protected PriorityQueue <Proyectil> listaProyectiles;
	
	public Fila () {
		listaZombies = new LinkedList<Zombie>();
		listaPlantas = new PriorityQueue(new Comparador<Planta>());
		listaProyectiles = new PriorityQueue(new Comparador<Proyectil>());
	}
}
