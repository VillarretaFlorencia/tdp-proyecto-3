package Logica;

public class Proyectil extends Entidad{
	private int danio;
	private Posicion pos;
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Nivel juego;
	
	public Proyectil(Posicion pos) {
		this.pos = pos;
		danio = 0;
	}
	public void atacar() {
		
	}
	public Posicion getPosicion(Posicion p) {
		
	}

	void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > juego.getWidth() - DIAMETER)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > juego.getHeight() - DIAMETER)
			juego.gameOver();
		if (collision()){
			ya = -1;
			y = juego.racquet.getTopY() - DIAMETER;
		}
		x = x + xa;
		y = y + ya;
	}

	private boolean colision() {
		return juego.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
