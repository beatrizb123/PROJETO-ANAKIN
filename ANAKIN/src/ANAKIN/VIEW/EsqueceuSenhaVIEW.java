package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EsqueceuSenhaVIEW extends JFrame{
	private Container cont;
	private JLabel lblPalavraChave;
	private JTextField txtfPalavraChave;
	private JButton btnConfirmar;
	
	public EsqueceuSenhaVIEW() {
		this.setTitle("Alterar informacoes");
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(300, 200, 300, 250);
		this.setBackground(new Color(250, 247, 255));
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.lblPalavraChave = new JLabel("Informe sua palavra chave para recuperar sua senha:");
		this.lblPalavraChave.setBounds(25, 10, 300, 20);
		this.add(lblPalavraChave);
	}
}
