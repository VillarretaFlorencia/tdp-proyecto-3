package Fabrica;

import Plantas.HumoSeta;
import Plantas.Planta;
import Plantas.SetaDesporadora;

/**
 * Esta clase define el comportamiento de la fabrica durante los niveles de noche
 * 
 *
 */
public class FactoryNoche extends Factory {

  public Planta createPlantaA() {
    Planta plantaA = new SetaDesporadora();
    return plantaA;
  }

  public Planta createPlantaB() {
    Planta plantaB = new HumoSeta();
    return plantaB;
  }
}
