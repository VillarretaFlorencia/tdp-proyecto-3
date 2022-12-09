package Fabrica;

import Plantas.Girasol;
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
/**
 * Esta clase con modelo factory nos permite crear las entidades.
 * 
 *
 */
public abstract class Factory {

  /**
   * Retorna una Planta -> Girasol 
   * @return Girasol
   */
  public Girasol createPlantaGirasol() {
    Girasol girasol = new Girasol();
    return girasol;
  }
  /**
   * Retorna una Planta -> Nuez
   * @return Nuez
   */
  public Nuez createPlantaNuez() {
    Nuez nuez = new Nuez();
    return nuez;
  }

  /**
   * Retorna una Planta:
   * En nivel de dia -> LanzaGuisantes
   * En nivel de noche -> SetaEsporadora
   * @return Planta
   */
  public abstract Planta createPlantaA();
  
  /**
   * Retorna una Planta:
   * En nivel de dia -> Repetidor
   * En nivel de noche -> HumoSeta
   * @return Planta
   */
  public abstract Planta createPlantaB();
  
  /**
   * Retorna una Zombie -> Bandera
   * @return Zombie Bandera
   */
  public Zombie createZombieBandera() {
    Zombie zombieBandera = new ZombieBandera();
    return zombieBandera;
  }
  
  /**
   * Retorna una Zombie -> Normal
   * @return Zombie 
   */
  public Zombie createZombieNormal() {
    Zombie zombieNormal = new ZombieNormal();
    return zombieNormal;
  }

  /**
   * Retorna una Zombie -> Zombie con periodico
   * @return Zombie con Periodico
   */
  public Zombie createZombiePeriodico() {
    Zombie zombiePeriodico = new ZombiePeriodico();
    return zombiePeriodico;
  }
  
  /**
   * Retorna una Zombie -> Zombie con cono
   * @return Zombie con cono
   */
  public Zombie createZombieCono() {
    Zombie zombieCono = new ZombieCono();
    return zombieCono;
  }

  /**
   * Retorna una Zombie -> Zombie con balde
   * @return Zombie con balde
   */
  public Zombie createZombieBalde() {
    Zombie zombieBalde = new ZombieBalde();
    return zombieBalde;
  }

  /**
   * Retorna una Zombie -> Zombie con Puerta
   * @return Zombie con puerta
   */
  public Zombie createZombiePuerta() {
    Zombie zombiePuerta = new ZombiePuerta();
    return zombiePuerta;
  }

  /**
   * Retorna una Zombie -> Zombie volador
   * @return Zombie Volador
   */
  public Zombie createZombieVolador() {
    Zombie zombieVolador = new ZombieVolador();
    return zombieVolador;
  }

}
