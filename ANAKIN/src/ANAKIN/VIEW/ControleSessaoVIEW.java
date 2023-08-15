package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ControleSessaoVIEW extends JFrame { 
	
	private Container container;
	private JTextArea areaPersonagem;
	private JLabel lblPersonagens;
	private JButton btnAdd;
	private ImageIcon imgIcon;

	public ControleSessaoVIEW() {
		//instanciação dos objetos
		this.setTitle("Controle de Sessao ★ ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 940, 550);
		this.setLayout(null);
		this.setBackground(new Color(250,247,255));
		this.setVisible(true);
		this.container = getContentPane();
		
		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));	
		
		this.lblPersonagens = new JLabel ("PERSONAGENS");
		this.lblPersonagens.setBounds(35,30,155,40);
		this.lblPersonagens.setForeground(new Color(90,61,171));
		this.lblPersonagens.setHorizontalAlignment(SwingConstants.NORTH_EAST);
		this.lblPersonagens.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(lblPersonagens);
		
		this.areaPersonagem = new JTextArea();
		this.areaPersonagem.setBackground(new Color(225,206,255));
		this.areaPersonagem.setBounds(35,70,430,160);
		this.areaPersonagem.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90,61,171), 5));

		this.add(areaPersonagem);
		
		this.btnAdd = new JButton("Adicionar Personagens");
		this.btnAdd.setFont(new Font("Arial",Font.BOLD,15));
		this.btnAdd.setBounds(35,250,200,50);
		this.btnAdd.setBackground(new Color(90, 61, 171));
		this.btnAdd.setForeground(Color.white);
		this.add(btnAdd);
		
		
		
	}

}

