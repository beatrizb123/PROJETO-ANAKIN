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

public class TelaLoginVIEW extends JFrame {
	private Container container;
	private JLabel lblUser, lblSenha, lblOla, lblLogo;
	private JTextField txtfUser, txtfSenha;
	private JButton btnVoltar, btnEntrar;
	private ImageIcon imgLogo, imgIcon;
	private Font fonte;

	public JTextField getTxtfUser() {
		return txtfUser;
	}

	public JTextField getTxtfSenha() {
		return txtfSenha;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public TelaLoginVIEW() {
		this.setTitle("Login");
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);
		this.setVisible(true);
		this.fonte = new Font("Arial", Font.BOLD, 20);

		this.lblUser = new JLabel("Username:");
		this.lblUser.setFont(fonte);
		this.lblUser.setBounds(460, 120, 300, 150);
		this.add(lblUser);

		this.lblSenha = new JLabel("Senha:");
		this.lblSenha.setFont(fonte);
		this.lblSenha.setBounds(460, 270, 200, 25);
		this.add(lblSenha);

		this.lblOla = new JLabel("Olá, bem vindo de volta!");
		this.lblOla.setFont(fonte);
		this.lblOla.setBounds(460, 60, 380, 150);
		this.add(lblOla);

		this.txtfUser = new JTextField(14);
		this.txtfUser.setBounds(460, 220, 260, 25);
		this.add(txtfUser);

		this.txtfSenha = new JTextField(8);
		this.txtfSenha.setBounds(460, 300, 260, 25);
		this.add(txtfSenha);

		this.btnVoltar = new JButton("VOLTAR");
		this.btnVoltar.setBackground(new Color(90, 61, 171));
		this.btnVoltar.setForeground(Color.WHITE);
		this.btnVoltar.setBounds(495, 350, 110, 25);
		this.add(btnVoltar);

		this.btnEntrar = new JButton("ENTRAR");
		this.btnEntrar.setBackground(new Color(90, 61, 171));
		this.btnEntrar.setForeground(Color.WHITE);
		this.btnEntrar.setBounds(620, 350, 110, 25);
		this.add(btnEntrar);

		this.imgLogo = new ImageIcon(getClass().getResource("Logo2.png"));
		this.lblLogo = new JLabel(imgLogo);
		this.lblLogo.setBounds(30, 50, 400, 400);
		this.add(lblLogo);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

	}

}
