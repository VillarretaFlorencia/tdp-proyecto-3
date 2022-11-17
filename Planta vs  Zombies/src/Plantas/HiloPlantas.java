package Plantas;

import java.util.LinkedList;

import GUI.PanelJardin;
import Logica.Nivel;
import Zombies.Zombie;

public class HiloPlantas implements Runnable{
	//Atributos de instancia
	public LinkedList<Planta> plantas;
	public Thread h1;
	protected PanelJardin ventana;
	
	public HiloPlantas (PanelJardin v) {
		ventana = v;
		plantas = ventana.getNivel().getPlntasEnPantalla();
	}
		
	public void run () {
		while (!plantas.isEmpty()) {
			for (Planta p: plantas) {
				if (p.getRango());
			}
		}
	}
}
