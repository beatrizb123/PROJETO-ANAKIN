package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TelaCadastroVIEW extends JFrame {
	private Container cont1;

	private JLabel lblNomeUser;
	private JLabel lblSenha;
	private JTextField txtfNomeUser;
	private JTextField txtfSenha;
	private JButton btnEntrar;
	private JButton btnVoltar;
	private JLabel lblOla;
	private ImageIcon imgLogo;
	private JLabel lblLogo;
	private JLabel lblImagem;
	private ImageIcon imgIcon;
	private Font fonte;

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JTextField getTxtfNomeUser() {
		return txtfNomeUser;
	}

	public JTextField getTxtfSenha() {
		return txtfSenha;
	}

	public TelaCadastroVIEW() {
		this.setTitle("Cadastro");
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);

		this.fonte = new Font("Arial", Font.BOLD, 20);

		this.lblNomeUser = new JLabel("Insira seu nome de usuário:");
		this.lblNomeUser.setFont(fonte);
		this.lblNomeUser.setBounds(460, 120, 300, 150);
		this.add(lblNomeUser);

		this.lblSenha = new JLabel("Insira uma senha: ");
		this.lblSenha.setBounds(460, 270, 200, 25);
		this.lblSenha.setFont(fonte);
		this.add(lblSenha);

		this.lblOla = new JLabel("Olá! Seja Bem Vindo ao ANAKIN!");
		this.lblOla.setBounds(460, 60, 380, 150);
		this.lblOla.setFont(fonte);
		this.add(lblOla);

		this.txtfNomeUser = new JTextField(14);
		this.txtfNomeUser.setBounds(460, 220, 260, 25);
		this.add(txtfNomeUser);

		this.txtfSenha = new JTextField(8);
		this.txtfSenha.setBounds(460, 300, 260, 25);
		this.add(txtfSenha);

		this.btnEntrar = new JButton("CADASTRAR");
		this.btnEntrar.setBackground(new Color(90, 61, 171));
		this.btnEntrar.setForeground(Color.WHITE);
		this.btnEntrar.setBounds(620, 350, 110, 25);
		this.add(btnEntrar);

		this.btnVoltar = new JButton("VOLTAR");
		this.btnVoltar.setBounds(495, 350, 110, 25);
		this.btnVoltar.setBackground(new Color(90, 61, 171));
		this.btnVoltar.setForeground(Color.white);
		this.add(btnVoltar);

		this.imgLogo = new ImageIcon(getClass().getResource("Logo1.png"));
		this.lblLogo = new JLabel(imgLogo);
		this.lblLogo.setBounds(30, 50, 400, 400);
		this.add(lblLogo);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));


	}

}
