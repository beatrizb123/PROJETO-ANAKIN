package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	// declaração das variaveis
	private Container cont;
	private JLabel lblNomeUser;
	private JLabel lblSenha;
	private JLabel lblFilme;

	private JTextField txtfNomeUser, txtfFilme;

	private JPasswordField pfSenha;
	private JButton btnEntrar;
	private JButton btnVoltar;
	private JCheckBox ckbMostrarSenha;
	private JLabel lblOla;
	private ImageIcon imgLogo, imgIcon;
	private JLabel lblLogo;
	private Font fonte;

	// get e set
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

	public JTextField getFilme() {
		return txtfFilme;
	}

	public TelaCadastroVIEW() {
		// instanciação dos objetos
		this.setTitle("Cadastro");
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.fonte = new Font("Arial", Font.BOLD, 20);

		this.lblOla = new JLabel("Olá! Seja Bem Vindo ao ANAKIN!");
		this.lblOla.setBounds(460, 85, 370, 25);
		this.lblOla.setFont(fonte);
		this.lblOla.setForeground(new Color(90, 61, 171));
		this.add(lblOla);

		this.lblNomeUser = new JLabel("Insira seu nome de usuário:");
		this.lblNomeUser.setFont(fonte);
		this.lblNomeUser.setBounds(460, 130, 300, 25);
		this.add(lblNomeUser);

		this.txtfNomeUser = new JTextField(14);
		this.txtfNomeUser.setBounds(460, 160, 260, 25);
		this.add(txtfNomeUser);

		this.lblSenha = new JLabel("Insira uma senha: ");
		this.lblSenha.setBounds(460, 200, 200, 25);
		this.lblSenha.setFont(fonte);
		this.add(lblSenha);

		this.pfSenha = new JPasswordField(8);
		this.pfSenha.setBounds(460, 230, 260, 25);
		this.add(pfSenha);

		this.ckbMostrarSenha = new JCheckBox("Mostrar senha");
		this.ckbMostrarSenha.setBounds(460, 260, 260, 15);
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

		this.lblFilme = new JLabel("Informe o nome do seu filme favorito:");
		this.lblFilme.setFont(new Font("Arial", Font.BOLD, 17));
		this.lblFilme.setBounds(460, 285, 400, 25);
		this.add(lblFilme);

		this.txtfFilme = new JTextField(40);
		this.txtfFilme.setBounds(460, 315, 260, 25);
		this.add(txtfFilme);

		this.btnEntrar = new JButton("CADASTRAR");
		this.btnEntrar.setBackground(new Color(90, 61, 171));
		this.btnEntrar.setForeground(Color.WHITE);
		this.btnEntrar.setBounds(620, 360, 110, 25);

		// Confirma o cadastro do novo usuário e direciona para o menu Principal
		this.btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CadastroDAO Cad = new CadastroDAO();
				UsuarioVO infor = new UsuarioVO();

				String usuario, senha, filme;
				usuario = txtfNomeUser.getText();
				senha = pfSenha.getText();
				filme = txtfFilme.getText();

				if (usuario == null || senha == null || filme == null) {
					JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS PRECISAM SER PREENCHIDOS!");
				} else {
					try {
						infor.setNome_usuario(usuario);
						infor.setSenha_usuario(senha);
						infor.setFilme_usuario(filme);

						Cad.cadastrarUsuario(infor);
						setVisible(false);
						MenuPrincipalVIEW telap = new MenuPrincipalVIEW();
						telap.setVisible(true);

					} catch (Exception erro) {
						JOptionPane.showMessageDialog(null, "CadastroVIEW: " + erro);
					}
				}

			}
		});
		this.add(btnEntrar);

		this.btnVoltar = new JButton("VOLTAR");
		this.btnVoltar.setBounds(495, 360, 110, 25);
		this.btnVoltar.setBackground(Color.white);
		this.btnVoltar.setForeground(new Color(90, 61, 171));

		// retorna para tela inicial
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

		this.imgLogo = new ImageIcon(getClass().getResource("Logo1.png"));
		this.lblLogo = new JLabel(imgLogo);
		this.lblLogo.setBounds(30, 50, 380, 400);
		this.add(lblLogo);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

	}

}
