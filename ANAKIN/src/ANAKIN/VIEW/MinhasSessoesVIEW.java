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

public class MinhasSessoesVIEW extends JFrame{
	
	private Container container;
	private JLabel lblMs;
	
	public MinhasSessoesVIEW() {
		
		this.setTitle("Projeto ANAKIN ★ ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 300, 450);
		this.setLayout(null);
		this.setBackground(new Color(250,247,255));
		this.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
		
		this.lblMs = new JLabel("Minhas Sessões");
		this.lblMs.setBounds(30, 15, 200, 50);		
		this.lblMs.setForeground(new Color(90,61,171));
		this.lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMs.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(lblMs);
	}

	
}
	

