package GUI;

import javax.swing.JPanel;

import Logica.Nivel;
import Logica.Posicion;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class PanelJardin extends JPanel{
	int seleccion = 0;
	Nivel nivel = new Nivel(1);
	public PanelJardin() {
		this.setBounds(0, 0, 540, 300);// esto nos da rectangulos de tamaño 540x294
		setLayout(new GridLayout(6, 9, 0, 0));
		setOpaque(false);
		EventosDelRaton raton = new EventosDelRaton();
		raton.setPanel(this);//dentro del controlador del panel ponemos este panel
		addMouseListener(raton);
		
		
		
	}
	public void setSeleccion(int selec) {
		seleccion = selec;
	}
	public int getSeleccion() {
		return  seleccion;
	}
	
	public void setNivel(Nivel n) {
		nivel = n;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
}

class EventosDelRaton implements MouseListener{
	private PanelJardin panel;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Coordenadas del mouse: "+e.getX()+ " | "+e.getY());
		int posX = (int) Math.floor(e.getX()/60);
		int posY= (int) Math.floor(5-(e.getY()/50));
		System.out.println("Posicion en la grilla: "+Math.floor(e.getX()/60)+ " | "+Math.floor(5-(e.getY()/50)));
		System.out.println("Seleccion: "+ panel.getSeleccion());
		
		if(panel.getNivel().getEntidad(posX, posY)==null) {
			System.out.println("Pongo una planta nueva");
			panel.getNivel().modificar(new Posicion(posX,posY), panel.getSeleccion());
			panel.setSeleccion(0);
		}else {
			System.out.println("ya hay una planta aqui");
			panel.setSeleccion(0);
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
