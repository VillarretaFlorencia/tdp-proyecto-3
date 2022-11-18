package GUI;

import javax.swing.JPanel;

import Logica.Nivel;
import Logica.Posicion;
import Logica.Sol;
import Plantas.Planta;

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
	Nivel nivel = Nivel.getNivel();
	int soles = 0;
	int precioPlantaA;
	int precioPlantaB;
	public PanelJardin() {
		soles = 100;
		this.setBounds(0, 0, 570, 380);
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
	
	// NIVEL YA NO LO OBTENGO DE PANEL ES GLOBAL LO EN TODOS
	// DONDE DICE MODIFICAR IRIA SETPLANTA
	public void setSeleccion(int selec) {
		seleccion = selec;
	}
	public int getSeleccion() {
		return  seleccion;
	}
	
	public void setNivel(int i) {//aca hacemos el set del nivel
		nivel.iniciarJuego(i);
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
		nivel.iniciarJuego(1);	//limpiar labels
	}
	
	/*Este tiene dos funciones, para incrementar soles de forma normal solo has: modificarsoles(50)\
	 * en el caso de querer decrementar por que compro una planta simplemente usa un negativo: modificarsoles(-<precio>)*/
	public void modificarSoles(int i) {
		soles = soles + i;
	}
	

	public int getSoles() {
		return soles;
	}
	
	public int getPrecioPlantaA() {
		return precioPlantaA;
	}
	
	public int getPrecioPlantaB() {
		return precioPlantaB;
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
				//if(panel.getNivel().getNivelLVL()<=2) {
					switch(panel.getSeleccion()) {
					case 1: if((panel.getSoles()-panel.getPrecioPlantaA())>=0) {
						panel.modificarSoles(-panel.getPrecioPlantaA());
						System.out.println("Pongo una planta nueva, precio: "+panel.getPrecioPlantaA());
						panel.getNivel().modificar(new Posicion(posX,posY), panel.getSeleccion());
						panel.insert(posX,posY);
					}break;
					
					case 2:if((panel.getSoles()-50)>=0) {
						panel.modificarSoles(-50);
						System.out.println("Pongo una planta nueva");
						panel.getNivel().modificar(new Posicion(posX,posY), panel.getSeleccion());
						panel.insert(posX,posY);
					}break;
					
					case 3:if((panel.getSoles()-50)>=0) {
						panel.modificarSoles(-50);
						System.out.println("Pongo una planta nueva");
						panel.getNivel().modificar(new Posicion(posX,posY), panel.getSeleccion());
						panel.insert(posX,posY);
					}break;
					
					case 4:if((panel.getSoles()-panel.getPrecioPlantaB())>=0) {
						panel.modificarSoles(-panel.getPrecioPlantaB());
						System.out.println("Pongo una planta nueva, precio: "+panel.getPrecioPlantaB());
						panel.getNivel().modificar(new Posicion(posX,posY), panel.getSeleccion());
						panel.insert(posX,posY);
					}break;
					}
				//}
				
				panel.setSeleccion(0);
			}else {
				System.out.println("ya hay una planta aqui");
				System.out.println("Aqui hay: "+panel.getNivel().getEntidad(posX, posY).getClass().getSimpleName());
				panel.setSeleccion(0);
			}
		}
	}
	
	public void colocarPlanta (Planta p) {}

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
