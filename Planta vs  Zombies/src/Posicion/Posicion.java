package Posicion;

public class Posicion {

  private int posX;
  private int posY;

  public Posicion(int x, int y) { //x:fila, y:columna
    posX = x;
    posY = y;
  }

  public void setX(int x) {
    posX = x;
  }

  public void setY(int y) {
    posY = y;
  }
  
  public int getX() {
    return posX;
  }

  public int getY() {
    return posY;
  }
  
}
