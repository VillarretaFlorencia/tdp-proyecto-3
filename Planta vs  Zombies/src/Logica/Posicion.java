package Logica;

public class Posicion {
	private int posX;
	private int posY;
	
	public Posicion(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	public void setX(int x) {
		posX = x;
	}
	
	public void setY(int y) {
		posY = y;
	}
}
