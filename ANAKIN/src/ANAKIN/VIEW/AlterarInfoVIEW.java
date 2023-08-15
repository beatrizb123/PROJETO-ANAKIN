package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AlterarInfoVIEW extends JFrame{
	private Container cont;
	private JLabel lblMsg, lblUser, lblSenha;
	private JTextField txtfUser, txtfSenha;
	private JButton btnConfirmar;
	
	public AlterarInfoVIEW() {
		this.setTitle("Alterar informacoes");
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(300, 200, 300, 250);
		this.setBackground(new Color(250, 247, 255));

		
		this.lblMsg = new JLabel("Insira seu novo user e senha para alterar!");
		this.lblUser = new JLabel("Novo User:");
		this.lblSenha = new JLabel("Nova Senha:");
		
		this.txtfUser = new JTextField();		
		this.txtfSenha = new JTextField();
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBackground(new Color(90, 61, 171));
		this.btnConfirmar.setForeground(Color.white);
		
		this.lblMsg.setBounds(25, 10, 300, 20);
		this.lblUser.setBounds(40, 45, 100, 20);
		this.txtfUser.setBounds(40, 65, 150, 20);
		this.lblSenha.setBounds(40, 105, 100, 20);
		this.txtfSenha.setBounds(40, 125, 150, 20);
		this.btnConfirmar.setBounds(70, 155, 90, 20);
		
		this.add(lblMsg);
		this.add(lblUser);
		this.add(lblSenha);
		this.add(txtfUser);
		this.add(txtfSenha);
		this.add(btnConfirmar);
	}
	
	public static void main(String[] args) {
		AlterarInfoVIEW altera = new AlterarInfoVIEW();
		altera.setVisible(true);
	}
	
}
