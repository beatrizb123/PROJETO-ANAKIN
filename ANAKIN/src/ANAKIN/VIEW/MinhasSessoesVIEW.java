package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MinhasSessoesVIEW extends JPanel{
	
	private Container container;
	private JLabel lblMs;
	
	public MinhasSessoesVIEW() {
		
		//this.setTitle("Projeto ANAKIN ★ ");
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setBounds(0, 0, 940, 550);
		this.setLayout(null);
		this.setBackground(new Color(250,247,255));
		//this.setVisible(true);
		
		this.lblMs = new JLabel("Minhas Sessões");
		this.lblMs.setBounds(360, 15, 170, 50);		
		this.lblMs.setForeground(new Color(90,61,171));
		this.lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMs.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(lblMs);
	}

	
}
	

