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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ANAKIN.MODEL.DAO.ManterSessaoDAO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class MenuPrincipalVIEW extends JFrame {

	// declaração das variaveis
	private Container container;
	private JLabel lblAnakin, lblNome;
	private JLabel sombraAnakin;
	private JLabel lblimagem;
	private JTextField txt;
	private ImageIcon imgIcon;
	private JButton btnControlSessao;
	private JMenuBar mnbBarra;
	private JMenu mnConfig, mnSessoes;
	private JMenuItem miAlterarConta, miLogout, miSair, miSessoes, miBuscar;

	public MenuPrincipalVIEW() {

		// instanciação dos objetos
		this.setTitle("Projeto ANAKIN ★ ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));
		this.container = getContentPane();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

		UsuarioVO teste = new UsuarioVO();
		String nome = teste.getNome_Usuario();

		this.lblNome = new JLabel(nome);
		this.lblNome.setBounds(15, 15, 100, 100);
		this.lblNome.setForeground(new Color(90, 61, 171));
		this.lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNome.setFont(new Font("Arial", Font.BOLD, 12));
		this.add(lblNome);

		this.lblAnakin = new JLabel("ANAKIN");
		this.lblAnakin.setBounds(255, 100, 400, 165);
		this.lblAnakin.setForeground(new Color(90, 61, 171));
		this.lblAnakin.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAnakin.setFont(new Font("Arial", Font.BOLD, 85));
		this.add(lblAnakin);

		this.sombraAnakin = new JLabel("ANAKIN");
		this.sombraAnakin.setBounds(260, 100, 400, 165);
		this.sombraAnakin.setForeground(new Color(204, 192, 228));
		this.sombraAnakin.setHorizontalAlignment(SwingConstants.CENTER);
		this.sombraAnakin.setFont(new Font("Arial", Font.BOLD, 85));
		this.add(sombraAnakin);

		this.btnControlSessao = new JButton("Controle de Sessao");
		this.btnControlSessao.setFont(new Font("Arial Black", Font.BOLD, 14));
		this.btnControlSessao.setBounds(360, 240, 200, 40);
		this.btnControlSessao.setToolTipText("Cria nova sessão");
		this.btnControlSessao.setBackground(new Color(90, 61, 171));
		this.btnControlSessao.setForeground(Color.white);
		this.btnControlSessao.addActionListener(new ActionListener() {

			// Botão que leva para o controle de sessão

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ControleSessaoVIEW tela = new ControleSessaoVIEW();
				tela.setVisible(true);

			}
		});
		this.add(btnControlSessao);

		this.mnbBarra = new JMenuBar();
		this.setJMenuBar(mnbBarra);

		this.mnConfig = new JMenu("Configurações");
		this.mnConfig.setMnemonic('C');
		this.mnbBarra.add(mnConfig);

		this.mnSessoes = new JMenu("Minhas Sessões");
		this.mnSessoes.setMnemonic('S');
		this.mnbBarra.add(mnSessoes);

		this.miSessoes = new JMenuItem("Sessões salvas");
		this.miSessoes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MinhasSessoesVIEW tela = new MinhasSessoesVIEW();
				tela.setVisible(true);
			}
		});
		this.mnSessoes.add(miSessoes);

		this.miLogout = new JMenuItem("Logout");
		this.miLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				TelaInicialVIEW telaInicial = new TelaInicialVIEW();
				telaInicial.setVisible(true);
				ManterSessaoDAO MSD = new ManterSessaoDAO();
				MSD.finalizaSessao();

			}
		});
		this.mnConfig.add(miLogout);

		this.miAlterarConta = new JMenuItem("Alterar Senha");
		this.miAlterarConta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EsqueceuSenhaVIEW tela = new EsqueceuSenhaVIEW();
				tela.setVisible(true);
			}
		});
		this.mnConfig.add(miAlterarConta);
		// sai da conta
		this.miSair = new JMenuItem("Sair");
		this.miSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		this.mnConfig.add(miSair);

	}

}
