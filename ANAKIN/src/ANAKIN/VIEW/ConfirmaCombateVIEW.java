package TelasProjeto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class ConfirmaCombateVIEW extends JFrame{
	private JPanel panel;
	private JCheckBox check;
	private JCheckBox selecionaTudo;
	private ImageIcon imgIcon;
	private Border border;
	private JButton btConfirmar;
	
	
	public ConfirmaCombateVIEW() {
		//Instanciação de Objetos
		this.setTitle("Combate");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 280, 250);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		this.setResizable(false);
		
		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

		this.panel = new JPanel(new GridLayout(0,1));
		this.border = BorderFactory.createTitledBorder("Protagonistas");
		((TitledBorder) this.border).setTitleColor((new Color(90, 61, 171)));
		((TitledBorder) this.border).setTitleFont(new Font("Arial", Font.BOLD, 16));
		((TitledBorder) this.border).setTitleJustification(TitledBorder.CENTER);
		this.panel.setBorder(border);
		this.add(panel);
		
		
		this.check = new JCheckBox("Anakin Skywalker");
		
		this.panel.add(check);
		this.check = new JCheckBox("Obi Wan Kenobi");
		this.panel.add(check);
		this.check = new JCheckBox("Scherlock Holmes ");
		this.panel.add(check);
		this.panel.add(check);
		this.check = new JCheckBox("Kaz Brekker");
		this.panel.add(check);
		this.check = new JCheckBox("Inej Ghafa");
		this.panel.add(check);
		this.check = new JCheckBox("Jesper Fahey");
		this.panel.add(check);
		this.check = new JCheckBox("Wylan Van eck");
		this.panel.add(check);
		this.check = new JCheckBox("Nina Zenik");
		this.panel.add(check);
		this.check = new JCheckBox("Matthias Helvar");
		this.panel.add(check);
		
		this.btConfirmar = new JButton("Confirmar");
		this.btConfirmar.setBackground(new Color(90, 61, 171));
		this.btConfirmar.setForeground(Color.white);
		this.btConfirmar.setFont(new Font("Arial", Font.BOLD, 15));
		

		this.add(panel,BorderLayout.CENTER);
		this.add(btConfirmar, BorderLayout.SOUTH);
		
		
		
	}
	
	public static void abre() {
		ConfirmaCombateVIEW frame = new ConfirmaCombateVIEW();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width)/2,(tela.height - frame.getSize().height)/2);
	}
	
	public static void main (String[] args) {
		ConfirmaCombateVIEW.abre();
	}
}

