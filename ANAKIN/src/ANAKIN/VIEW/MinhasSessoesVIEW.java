package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ANAKIN.MODEL.DAO.CadastroDAO;

public class MinhasSessoesVIEW extends JFrame{
	
	private Container container;
	private JLabel lblMs, lblMens;
	private JTextField tfBusca;
	private JButton btnBusca;
	
	public MinhasSessoesVIEW() {
		
		this.setTitle("Projeto ANAKIN ★ ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 300, 450);
		this.setLayout(null);
		this.setResizable(false);
		this.setBackground(new Color(250,247,255));
		this.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
		
		this.lblMs = new JLabel("Minhas Sessões");
		this.lblMs.setBounds(30, 15, 200, 25);		
		this.lblMs.setForeground(new Color(90,61,171));
		this.lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMs.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(lblMs);
		
		this.lblMens = new JLabel("Insira o nome da sua sessão:");
		this.lblMens.setBounds(10, 45, 200, 25);
		this.lblMens.setForeground(new Color(90,61,171));
		this.lblMens.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMens.setFont(new Font("Arial", Font.BOLD, 13));
		this.add(lblMens);
		
		this.tfBusca = new JTextField(20);
		this.tfBusca.setBounds(20, 75, 150, 25);
		this.add(tfBusca);
		
		this.btnBusca = new JButton("Buscar");
		this.btnBusca.setBounds(20, 105, 100, 25);
		this.btnBusca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroDAO info = new CadastroDAO();
				int id = info.usaId();
				
				
				
			}
		});

		
		
	}

	
}
	

