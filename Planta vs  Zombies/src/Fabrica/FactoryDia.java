package Fabrica;

import javax.swing.ImageIcon;

import GUI.Gameplay;
import Plantas.Girasol;
import Plantas.LanzaGuisantes;
import Plantas.LanzaGuisantesDoble;
import Plantas.Nuez;
import Plantas.Planta;
import Zombies.Zombie;
import Zombies.ZombieBalde;
import Zombies.ZombieBandera;
import Zombies.ZombieCono;
import Zombies.ZombieNormal;
import Zombies.ZombiePeriodico;
import Zombies.ZombiePuerta;
import Zombies.ZombieVolador;

public class FactoryDia extends Factory {

	public Planta createPlantaA() {
		ImageIcon icono = new ImageIcon(Gameplay.class.getResource("/recursos/peashooter.gif"));
		//										   icon.getImage()
		Planta lanzaGuisantes = new LanzaGuisantes();
		return lanzaGuisantes;
	}

	public Planta createPlantaB() {
		ImageIcon icono = new ImageIcon(Gameplay.class.getResource("/recursos/repeater.gif"));
		//											   icon.getImage()
		Planta lanzaGuisantesD = new LanzaGuisantesDoble();
		return lanzaGuisantesD;
	}
}
