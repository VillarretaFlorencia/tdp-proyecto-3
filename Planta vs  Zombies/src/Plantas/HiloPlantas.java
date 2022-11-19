package Plantas;

import java.util.LinkedList;

import Logica.Nivel;

public class HiloPlantas implements Runnable{
	//Atributos de instancia
	public LinkedList<Planta> plantas;
	
	Nivel n = Nivel.getNivel();
	
	public HiloPlantas () {
		plantas = n.getFilas().getTodasLasPlantas();
	}
	
	public void run () {
		while (!plantas.isEmpty()) {
			for (Planta p: plantas) {
				p.atacar();
			}
		}
	}

}
