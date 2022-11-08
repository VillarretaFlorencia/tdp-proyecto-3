package Fabrica;

import Plantas.Girasol;
import Plantas.Nuez;
import Plantas.Planta;
import Zombies.Zombie;


public interface Factory {

public Planta createPlantaA();
public Planta createPlantaB();
public Girasol createPlantaGirasol();
public Nuez createPlantaNuez();
public Zombie createZombieNormal();
public Zombie createZombiePeriodico();
public Zombie createZombieBalde();
public Zombie createZombiePuerta();
public Zombie createZombieCono();
public Zombie createZombieVolador();
public Zombie createZombieBandera();

}
