package Logica;

import java.awt.Rectangle;

import javax.swing.JLabel;


import Visitores.Visitor;

public abstract class Entidad extends JLabel{
	
	public abstract Rectangle getBounds();
}
