package Fabrica;

import Plantas.Girasol;
import Plantas.LanzaGuisantes;
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
		Planta lanzaGuisantes = new LanzaGuisantes();
		
		return lanzaGuisantes;
	}

	public Planta createPlantaB() {
		Planta lanzaGuisantesD = new LanzaGuisantes();
		return lanzaGuisantesD;
	}
}
