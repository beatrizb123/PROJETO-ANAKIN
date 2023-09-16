package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ANAKIN.MODEL.DAO.LoginDAO;
import ANAKIN.MODEL.DAO.ManterSessaoDAO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class TelaLoginVIEW extends JFrame {
	// declaração das variaveis
	private Container container;
	private JLabel lblUser, lblSenha, lblOla, lblLogo, lblEsqueceuSenha;
	private JTextField txtfUser;
	private JPasswordField pfSenha;
	private JButton btnVoltar, btnEntrar;
	private JCheckBox ckbMostrarSenha, ckManterSessao;
	private ImageIcon imgLogo, imgIcon;
	private Font fonte;

	public JTextField getTxtfUser() {
		return txtfUser;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public JPasswordField getPfSenha() {
		return pfSenha;
	}

	public TelaLoginVIEW() {
		this.setTitle("Login");
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);
		this.setVisible(true);
		this.fonte = new Font("Arial", Font.BOLD, 20);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.lblOla = new JLabel("Olá, bem vindo de volta!");
		this.lblOla.setFont(fonte);
		this.lblOla.setForeground(new Color(90, 61, 171));
		this.lblOla.setBounds(460, 40, 380, 150);
		this.add(lblOla);

		this.lblUser = new JLabel("Username:");
		this.lblUser.setFont(fonte);
		this.lblUser.setBounds(460, 100, 300, 150);
		this.add(lblUser);

		this.lblSenha = new JLabel("Senha:");
		this.lblSenha.setFont(fonte);
		this.lblSenha.setBounds(460, 250, 200, 25);
		this.add(lblSenha);

		this.lblEsqueceuSenha = new JLabel("Esqueceu a senha?");
		this.lblEsqueceuSenha.setFont(new Font("Arial", Font.BOLD, 12));
		Font under = lblEsqueceuSenha.getFont();
		Map<TextAttribute, Object> at = new HashMap<>(under.getAttributes());
		at.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblEsqueceuSenha.setFont(under.deriveFont(at));
		this.lblEsqueceuSenha.setForeground(Color.black);
		this.lblEsqueceuSenha.setBounds(608, 312, 200, 15);
		this.lblEsqueceuSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblEsqueceuSenha.setForeground(Color.gray);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblEsqueceuSenha.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				EsqueceuSenhaVIEW tela = new EsqueceuSenhaVIEW();
				tela.setVisible(true);
			}
		});
		this.add(lblEsqueceuSenha);

		this.txtfUser = new JTextField(14);
		this.txtfUser.setBounds(460, 200, 260, 25);
		this.add(txtfUser);

		this.pfSenha = new JPasswordField(8);
		this.pfSenha.setBounds(460, 280, 260, 25);
		this.add(pfSenha);

		this.btnVoltar = new JButton("VOLTAR");
		this.btnVoltar.setBackground(Color.white);
		this.btnVoltar.setForeground(new Color(90, 61, 171));
		this.btnVoltar.setBounds(495, 350, 110, 25);
		this.btnVoltar.addActionListener(new ActionListener() {

			@Override
			// retorna para tela inicial
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialVIEW telaInicial = new TelaInicialVIEW();
				telaInicial.setVisible(true);
				telaInicial.setResizable(false);
			}
		});
		this.add(btnVoltar);

		this.btnEntrar = new JButton("ENTRAR");
		this.btnEntrar.setBackground(new Color(90, 61, 171));
		this.btnEntrar.setForeground(Color.WHITE);
		this.btnEntrar.setBounds(620, 350, 110, 25);
		this.btnEntrar.addActionListener(new ActionListener() {

			@Override
			// confirma o login e direciona para o menu principal
			public void actionPerformed(ActionEvent e) {
				try {
					if (ckManterSessao.isSelected()) {
						int valor1 = 1;
						ManterSessaoDAO MSD1 = new ManterSessaoDAO();
						MSD1.Sessaomanter(valor1);
					} else {
						int valor = 0;
						ManterSessaoDAO MSD = new ManterSessaoDAO();
						MSD.Sessaomanter(valor);

					}

					String usuario, senha;
					usuario = txtfUser.getText();
					senha = pfSenha.getText();
					UsuarioVO autent = new UsuarioVO();
					autent.setNome_usuario(usuario);
					autent.setSenha_usuario(senha);
					LoginDAO dados = new LoginDAO();

					ResultSet testeAuntent = dados.autenticaUsuario(autent);
					if (testeAuntent.next()) {
						MenuPrincipalVIEW menuPrincipal = new MenuPrincipalVIEW();
						menuPrincipal.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Senha ou usuario invalido!");
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro);
				}
			}
		});
		this.add(btnEntrar);

		this.imgLogo = new ImageIcon(getClass().getResource("Logo2.png"));
		this.lblLogo = new JLabel(imgLogo);
		this.lblLogo.setBounds(30, 50, 400, 400);
		this.add(lblLogo);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

		this.ckbMostrarSenha = new JCheckBox("Mostrar senha");
		this.ckbMostrarSenha.setBounds(460, 310, 130, 15);
		this.ckbMostrarSenha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ckbMostrarSenha.isSelected()) {
					pfSenha.setEchoChar((char) 0);
				} else {
					pfSenha.setEchoChar('*');
				}

			}
		});
		this.add(ckbMostrarSenha);

		this.ckManterSessao = new JCheckBox("Deseja manter sessao?");
		this.ckManterSessao.setBounds(460, 325, 170, 30);
		this.add(ckManterSessao);

	}

}