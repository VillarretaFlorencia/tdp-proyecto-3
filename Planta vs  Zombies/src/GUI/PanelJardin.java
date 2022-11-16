package GUI;

import javax.swing.JPanel;

import Logica.Nivel;
import Logica.Posicion;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class PanelJardin extends JPanel{
	Gameplay gameplay = null;
	int seleccion = 0;
	private JLabel[][] label = new JLabel[9][6];
	Nivel nivel;
	public PanelJardin() {
		nivel = new Nivel(1);
		this.setBounds(0, 0, 570, 38);
		setOpaque(false);
		EventosDelRaton raton = new EventosDelRaton();
		raton.setPanel(this);//dentro del controlador del panel ponemos este panel
		setLayout(null);
		addMouseListener(raton);
		for(int x = 0;x < 9; x++) {
			for(int y = 0; y < 6; y++) {
				label[x][y] =  new JLabel("poggers");//el string es para ver si aparecian > no funciono
				label[x][y].setBounds((63*x)+21, (63*y)+22, 27, 47);
			}
		}
		
		
	}
	public void setSeleccion(int selec) {
		seleccion = selec;
	}
	public int getSeleccion() {
		return  seleccion;
	}
	
	public void setNivel(int i) {
		nivel=new Nivel(i);
	}
	
	public void setNivel(Nivel n) {
		nivel = n;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public JLabel[][] getLabels(){
		return label;
	}
	
	public void setGameplay(Gameplay lp) {
		gameplay = lp;
	}
	
	public Gameplay getGameplay() {
		return gameplay;
	}
	public void insert(int posX, int posY) {
		System.out.println("Nivel: "+ nivel.getNivelLVL());
		gameplay.modificar(posX, posY, seleccion);
		
	}
	public void restart() {
		nivel = new Nivel(1);
	}
}

class EventosDelRaton implements MouseListener{
	private PanelJardin panel;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(panel.getSeleccion()!=0) {//solo si ha seleccionado algo
			System.out.println("Coordenadas del mouse: "+e.getX()+ " | "+e.getY());
			int posX = (int) (Math.floor(e.getX()/63));
			int posY= (int) (Math.floor((e.getY()/63)));
			System.out.println("Posicion en la grilla: "+(posX)+ " | "+(5-posY));
			System.out.println("Seleccion: "+ panel.getSeleccion());
			
			if(panel.getNivel().getEntidad(posX, posY)==null) {
				System.out.println("Pongo una planta nueva");
				panel.getNivel().modificar(new Posicion(posX,posY), panel.getSeleccion());
				panel.insert(posX,posY);
				panel.setSeleccion(0);
			}else {
				System.out.println("ya hay una planta aqui");
				System.out.println("Aqui hay: "+panel.getNivel().getEntidad(posX, posY).getClass().getSimpleName());
				panel.setSeleccion(0);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setPanel(PanelJardin p) {
		panel = p;
	}
	
	public PanelJardin getPanel() {
		return panel;
	}
	
}
