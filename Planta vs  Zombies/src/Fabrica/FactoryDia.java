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

public class FactoryDia implements Factory {

	@Override
	public Planta createPlantaA() {
		Planta lanzaGuisantes = new LanzaGuisantes();
		
		return lanzaGuisantes;
	}

	@Override
	public Planta createPlantaB() {
		Planta lanzaGuisantesD = new LanzaGuisantes();
		return null;
	}

	@Override
	public Girasol createPlantaGirasol() {
		Girasol girasol = new Girasol();
		return girasol;
	}

	@Override
	public Nuez createPlantaNuez() {
		Nuez nuez = new Nuez();
		return nuez;
	}

	@Override
	public Zombie createZombieNormal() {
		Zombie zombieNormal= new ZombieNormal();
		return zombieNormal;
	}
	@Override
	public Zombie createZombiePeriodico() {
		Zombie zombiePeriodico= new ZombiePeriodico();
		return zombiePeriodico;
	}

	@Override
	public Zombie createZombieBalde() {
		Zombie zombieBalde= new ZombieBalde();
		return zombieBalde;
	}

	@Override
	public Zombie createZombiePuerta() {
		Zombie zombiePuerta= new ZombiePuerta();
		return zombiePuerta;
	}

	@Override
	public Zombie createZombieCono() {
		Zombie zombieCono =new ZombieCono();
		return zombieCono;
	}

	@Override
	public Zombie createZombieVolador() {
		Zombie zombieVolador= new ZombieVolador();
		return zombieVolador;
	}

	@Override
	public Zombie createZombieBandera() {
		Zombie zombieBandera= new ZombieBandera();
		return zombieBandera;
	}

}
