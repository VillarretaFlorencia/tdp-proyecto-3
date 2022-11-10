package Fabrica;

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
		
		Planta plantaA= new HumoSeta();
		
		return plantaA;
	}

	@Override
	public Planta createPlantaB() {
		Planta plantaB= new SetaDesporadora();
		
		return plantaB;
	}
}
