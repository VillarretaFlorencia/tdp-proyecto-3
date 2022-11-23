package GUI;

import javax.swing.JPanel;

import Logica.Nivel;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LvlSelector extends JLayeredPane implements ActionListener{
	private JButton selection1, selection2, selection3, selection4;
	Nivel nivel = Nivel.getNivel();
	public LvlSelector() {
		setBounds(0,0,570,450);
		setLayout(null);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(LvlSelector.class.getResource("/recursos/seleselectionSurface.png")));
		background.setBounds(-167, -16, 668, 503);
		add(background,Integer.valueOf(1));
		
		JLabel backgroundB = new JLabel("");
		backgroundB.setIcon(new ImageIcon(LvlSelector.class.getResource("/recursos/selectorBG.jpg")));
		backgroundB.setBounds(-222, -16, 814, 487);
		add(backgroundB,Integer.valueOf(0));
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon reStartIcon = new ImageIcon(LvlSelector.class.getResource("/recursos/selectionBanner.png"));
		Image reStart = reStartIcon.getImage();
		reStart = reStart.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
		reStartIcon = new ImageIcon(reStart);
		lblNewLabel.setIcon(reStartIcon);
		lblNewLabel.setBounds(39, 11, 262, 134);
		add(lblNewLabel,Integer.valueOf(2));
		
		selection1 = new JButton("");
		reStartIcon = new ImageIcon(LvlSelector.class.getResource("/recursos/selection1.png"));
		reStart = reStartIcon.getImage();
		reStart = reStart.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);
		reStartIcon = new ImageIcon(reStart);
		selection1.setIcon(reStartIcon);
		selection1.setBounds(63, 133, 104, 59);
		selection1.setOpaque(false);
		selection1.setContentAreaFilled(false);
		selection1.setBorderPainted(false);
		add(selection1,Integer.valueOf(2));
		
		selection2 = new JButton("");
		reStartIcon = new ImageIcon(LvlSelector.class.getResource("/recursos/selection2.png"));
		reStart = reStartIcon.getImage();
		reStart = reStart.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);
		reStartIcon = new ImageIcon(reStart);
		selection2.setIcon(reStartIcon);
		selection2.setBounds(63, 203, 104, 47);
		selection2.setOpaque(false);
		selection2.setContentAreaFilled(false);
		selection2.setBorderPainted(false);
		add(selection2,Integer.valueOf(2));
		
		selection3 = new JButton("");
		reStartIcon = new ImageIcon(LvlSelector.class.getResource("/recursos/selection3.png"));
		reStart = reStartIcon.getImage();
		reStart = reStart.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);
		reStartIcon = new ImageIcon(reStart);
		selection3.setIcon(reStartIcon);
		selection3.setBounds(63, 271, 104, 53);
		selection3.setOpaque(false);
		selection3.setContentAreaFilled(false);
		selection3.setBorderPainted(false);
		add(selection3,Integer.valueOf(2));
		
		selection4 = new JButton("");
		reStartIcon = new ImageIcon(LvlSelector.class.getResource("/recursos/selection4.png"));
		reStart = reStartIcon.getImage();
		reStart = reStart.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);
		reStartIcon = new ImageIcon(reStart);
		selection4.setIcon(reStartIcon);
		selection4.setBounds(63, 335, 109, 55);
		selection4.setOpaque(false);
		selection4.setContentAreaFilled(false);
		selection4.setBorderPainted(false);
		add(selection4,Integer.valueOf(2));
	}

	
	
	public JButton getSelect1() {
		return selection1;
	}
	public JButton getSelect2() {
		return selection2;
	}
	public JButton getSelect3() {
		return selection3;
	}
	public JButton getSelect4() {
		return selection4;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
