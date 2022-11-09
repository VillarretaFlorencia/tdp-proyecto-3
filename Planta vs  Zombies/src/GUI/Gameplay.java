package GUI;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Gameplay extends JPanel implements ActionListener{
	private JButton btnRestart;
	public Gameplay() {
		JLabel lblGame = new JLabel("");
		lblGame.setBounds(0, 0, 600, 341);
		setBounds(0,0,570,335);
		ImageIcon imagenInicio = new ImageIcon(this.getClass().getResource("/recursos/mainBG.png"));
		Image start = imagenInicio.getImage();
		start = start.getScaledInstance(570, 335,  java.awt.Image.SCALE_SMOOTH);
		imagenInicio = new ImageIcon(start);
		lblGame.setIcon(imagenInicio);
		lblGame.setVisible(true);
		setVisible(true);
		setLayout(null);
		add(lblGame);
		
		btnRestart = new JButton("Restart");
		btnRestart.setBounds(481, 0, 89, 23);
		add(btnRestart);
	}
	
	public JButton getRestartButton() {
		return btnRestart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
