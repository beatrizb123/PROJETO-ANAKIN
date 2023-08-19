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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ANAKIN.MODEL.DAO.CadastroDAO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class TelaCadastroVIEW extends JFrame {

	private Container cont;
	private JLabel lblNomeUser;
	private JLabel lblSenha;
	private JLabel lblPalavraChave;
	private JTextField txtfNomeUser;
	private JTextField txtfPalavraChave;
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	private JButton btnVoltar;
	private JCheckBox ckbMostrarSenha;
	private JLabel lblOla;
	private ImageIcon imgLogo, imgIcon;
	private JLabel lblLogo;
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

	public JPasswordField getPfSenha() {
		return pfSenha;
	}

	public JTextField getTxtfPalavraChave() {
		return txtfPalavraChave;
	}

	public TelaCadastroVIEW() {
		this.setTitle("Cadastro");
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.fonte = new Font("Arial", Font.BOLD, 20);

		this.lblOla = new JLabel("Olá! Seja Bem Vindo ao ANAKIN!");
		this.lblOla.setBounds(460, 10, 380, 150);
		this.lblOla.setForeground(new Color(90, 61, 171));
		this.lblOla.setFont(fonte);
		this.add(lblOla);

		this.lblNomeUser = new JLabel("Insira seu nome de usuário:");
		this.lblNomeUser.setFont(fonte);
		this.lblNomeUser.setBounds(460, 70, 300, 150);
		this.add(lblNomeUser);

		this.lblSenha = new JLabel("Insira uma senha: ");
		this.lblSenha.setBounds(460, 220, 200, 25);
		this.lblSenha.setFont(fonte);
		this.add(lblSenha);

		this.lblPalavraChave = new JLabel("Insira uma palavra-chave:");
		this.lblPalavraChave.setFont(fonte);
		this.lblPalavraChave.setBounds(460, 300, 260, 25);
		this.add(lblPalavraChave);

		this.txtfNomeUser = new JTextField(14);
		this.txtfNomeUser.setBounds(460, 170, 260, 25);
		this.add(txtfNomeUser);

		this.txtfPalavraChave = new JTextField(14);
		this.txtfPalavraChave.setBounds(460, 330, 260, 25);
		this.add(txtfPalavraChave);

		this.pfSenha = new JPasswordField(8);
		this.pfSenha.setBounds(460, 250, 260, 25);
		this.add(pfSenha);

		this.btnEntrar = new JButton("CADASTRAR");
		this.btnEntrar.setBackground(new Color(90, 61, 171));
		this.btnEntrar.setForeground(Color.WHITE);
		this.btnEntrar.setBounds(620, 370, 110, 25);
		this.btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroDAO Cad = new CadastroDAO();
				UsuarioVO infor = new UsuarioVO();

				String usuario, senha;
				usuario = txtfNomeUser.getText();
				senha = pfSenha.getText();

				infor.setNome_usuario(usuario);
				infor.setSenha_usuario(senha);

				Cad.cadastrarUsuario(infor);
				MenuPrincipalVIEW telap = new MenuPrincipalVIEW();
				telap.setVisible(true);
				dispose();

			}
		});
		this.add(btnEntrar);

		this.btnVoltar = new JButton("VOLTAR");
		this.btnVoltar.setBounds(495, 370, 110, 25);
		this.btnVoltar.setBackground(Color.white);
		this.btnVoltar.setForeground(new Color(90, 61, 171));
		this.btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaInicialVIEW telaInicial = new TelaInicialVIEW();
				telaInicial.setVisible(true);
				telaInicial.setResizable(false);
			}
		});
		this.add(btnVoltar);

		this.ckbMostrarSenha = new JCheckBox("Mostrar senha");
		this.ckbMostrarSenha.setBounds(610, 278, 260, 15);
		this.ckbMostrarSenha.setFont(new Font("Arial", Font.BOLD, 12));
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

		this.imgLogo = new ImageIcon(getClass().getResource("Logo1.png"));
		this.lblLogo = new JLabel(imgLogo);
		this.lblLogo.setBounds(30, 50, 380, 400);
		this.add(lblLogo);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("jupiter.png"));

	}

}