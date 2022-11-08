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

public class FactoryNoche implements Factory {

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

	@Override
	public Girasol createPlantaGirasol() {
		
		Girasol girasol= new Girasol();
		
		return girasol;
	}

	@Override
	public Nuez createPlantaNuez() {
	
		Nuez nuez= new Nuez();
		
		return nuez;
	}

	@Override
	public Zombie createZombieNormal() {
		Zombie zombieNormal= new ZombieNormal();
		return zombieNormal;
	}

	@Override
	public Zombie createZombiePeriodico() {
		Zombie  zombiePeriodico= new ZombiePeriodico();
		return zombiePeriodico;
	}

	@Override
	public Zombie createZombieBalde() {
		ZombieBalde zombieBalde = new ZombieBalde();
		return zombieBalde;
	}

	@Override
	public Zombie createZombiePuerta() {

		Zombie zombiePuerta= new ZombiePuerta();
		return null;
	}

	@Override
	public Zombie createZombieCono() {
		
	 Zombie zombieCono= new ZombieCono();
		
	 return zombieCono;
	}

	@Override
	public Zombie createZombieVolador() {

		Zombie zombieVolador= new ZombieVolador();
		return zombieVolador;
	}

	@Override
	public Zombie createZombieBandera() {
		
		Zombie  zombieCono= new ZombieBandera();
		return zombieCono;
	}

}
