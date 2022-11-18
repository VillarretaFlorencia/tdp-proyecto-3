package Fabrica;

import javax.swing.ImageIcon;

import Plantas.Girasol;
import Plantas.HumoSeta;
import Plantas.Nuez;
import Plantas.Planta;
import Plantas.SetaDesporadora;
import Zombies.Zombie;
import Zombies.ZombieBalde;
import Zombies.ZombieBandera;
import Zombies.ZombieCono;
import Zombies.ZombieNormal;
import Zombies.ZombiePeriodico;
import Zombies.ZombiePuerta;
import Zombies.ZombieVolador;

public class FactoryNoche extends Factory {

	@Override
	public Planta createPlantaA() {
		ImageIcon icono = new ImageIcon(Factory.class.getResource("/recursos/PuffShroom.gif"));
								//		   icon.getImage()
		Planta plantaA= new SetaDesporadora();
		
		return plantaA;
	}

	@Override
	public Planta createPlantaB() {
		ImageIcon icono = new ImageIcon(Factory.class.getResource("/recursos/FumeShroom.gif"));
						 //		     icon.getImage()
		Planta plantaB= new HumoSeta();
		
		return plantaB;
	}
}
