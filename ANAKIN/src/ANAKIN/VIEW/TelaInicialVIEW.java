package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaInicialVIEW extends JFrame {

	private Container container;
	private JLabel lblAnakin;
	private JLabel sombraAnakin;
	private JButton btnLogin;
	private JButton btnCadastrar;
	private ImageIcon imagem;
	private JLabel lblImagem;
	private ImageIcon imgIcon;

	// Get e Set

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public TelaInicialVIEW() {
		// instanciação dos objetos
		this.setTitle("Projeto ANAKIN");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.container = getContentPane();

		this.imagem = new ImageIcon(getClass().getResource("Logo1.png"));
		this.lblImagem = new JLabel(imagem);
		this.lblImagem.setBounds(30, 50, 400, 400);
		add(lblImagem);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

		this.lblAnakin = new JLabel("ANAKIN");
		this.lblAnakin.setBounds(400, 150, 400, 165);
		this.lblAnakin.setForeground(new Color(90, 61, 171));
		this.lblAnakin.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAnakin.setFont(new Font("Arial", Font.BOLD, 92));
		this.add(lblAnakin);

		this.sombraAnakin = new JLabel("ANAKIN");
		this.sombraAnakin.setBounds(405, 150, 400, 165);
		this.sombraAnakin.setForeground(new Color(204, 192, 228));
		this.sombraAnakin.setHorizontalAlignment(SwingConstants.CENTER);
		this.sombraAnakin.setFont(new Font("Arial", Font.BOLD, 92));
		this.add(sombraAnakin);

		this.btnLogin = new JButton("Login");
		this.btnLogin.setFont(new Font("Arial Black", Font.BOLD, 14));
		this.btnLogin.setBounds(615, 288, 114, 31);
		this.btnLogin.setBackground(Color.white);
		this.btnLogin.setForeground(new Color(90, 61, 171));
		this.btnLogin.addActionListener(new ActionListener() {
			
			// direciona para a tela de Login 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaLoginVIEW telaLogin = new TelaLoginVIEW();
				telaLogin.setVisible(true);
				telaLogin.setResizable(false);

			}
		});

		this.add(btnLogin);

		this.btnCadastrar = new JButton("Cadastrar");
		this.btnCadastrar.setFont(new Font("Arial Black", Font.BOLD, 14));
		this.btnCadastrar.setBounds(480, 288, 120, 31);
		this.btnCadastrar.setBackground(new Color(90, 61, 171));
		this.btnCadastrar.setForeground(Color.white);
		this.btnCadastrar.addActionListener(new ActionListener() {
			
			//direciona para a tela de cadastro 

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaCadastroVIEW telaCadastro = new TelaCadastroVIEW();
				telaCadastro.setVisible(true);
				telaCadastro.setResizable(false);

			}
		});
		this.add(btnCadastrar);

	}

}




