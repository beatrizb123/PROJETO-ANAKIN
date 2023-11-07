package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

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
	private JMenuBar mnbBarra;
	private JMenu mnConfig, mnSessoes;
	private JMenuItem miAlterarConta, miLogout, miSair, miSessoes, miBuscar;
	private ImageIcon menuWall; 
	private JLabel bckgMenu; 
	
	private JLabel lblIconControle, lblCriar;
	private ImageIcon iconControleSessao;


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
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/Icones/jupiter.png")));

		ManterSessaoDAO teste = new ManterSessaoDAO();
		UsuarioVO user = new UsuarioVO();
		String nome = teste.chamar();
		if (teste.chamar() == null) {
			nome = user.getNome_Usuario();
		}

		this.lblNome = new JLabel("OLÁ, " + nome + "!");
		this.lblNome.setBounds(10, 35, 200, 25);
		this.lblNome.setForeground(new Color(90, 61, 171));
		this.lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		this.add(lblNome);

		this.lblAnakin = new JLabel("ANAKIN");
		this.lblAnakin.setBounds(255, 65, 400, 165);
		this.lblAnakin.setForeground(new Color(90, 61, 171));
		this.lblAnakin.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAnakin.setFont(new Font("Arial", Font.BOLD, 85));
		this.add(lblAnakin);

		this.sombraAnakin = new JLabel("ANAKIN");
		this.sombraAnakin.setBounds(260, 65, 400, 165);
		this.sombraAnakin.setForeground(new Color(204, 192, 228));
		this.sombraAnakin.setHorizontalAlignment(SwingConstants.CENTER);
		this.sombraAnakin.setFont(new Font("Arial", Font.BOLD, 85));
		this.add(sombraAnakin);
		
		this.iconControleSessao = new ImageIcon(getClass().getResource("/Imagens/Botões/Controle_Sessao.png"));
		this.lblIconControle = new JLabel(iconControleSessao);
		this.lblIconControle.setToolTipText("Controle de Sessão");
		this.lblIconControle.setBounds(370, 215, 180, 180);
		this.lblIconControle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblIconControle.setIcon(iconControleSessao);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblIconControle.setIcon(iconControleSessao);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
				NovoControleSessaoVIEW tela = new NovoControleSessaoVIEW();
				tela.setVisible(true);
			}
		});
		this.add(lblIconControle);
		
		this.lblCriar =  new JLabel("Criar sua Sessão");
		this.lblCriar.setForeground(new Color(90,61,171));
		this.lblCriar.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblCriar.setBounds(400,320,170,170);
		this.add(lblCriar);


		this.lblCriar =  new JLabel("Criar sua Sessão");
		this.lblCriar.setForeground(new Color(90,61,171));
		this.lblCriar.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblCriar.setBounds(400,320,170,170);
		this.add(lblCriar);


		this.mnbBarra = new JMenuBar();
		this.setJMenuBar(mnbBarra);

		this.mnConfig = new JMenu("Configurações");
		this.mnConfig.setMnemonic('C');
		this.mnbBarra.add(mnConfig);

		this.mnSessoes = new JMenu("Minhas Sessões");
		this.mnSessoes.setMnemonic('M');
		this.mnbBarra.add(mnSessoes);

		this.miSessoes = new JMenuItem("Sessões salvas");
		this.miSessoes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
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
		
		this.menuWall = new ImageIcon(getClass().getResource("/Imagens/Background/Background.png"));
		this.menuWall = new ImageIcon(menuWall.getImage().getScaledInstance(940, 550, Image.SCALE_DEFAULT));
		this.bckgMenu = new JLabel(menuWall);
		this.bckgMenu.setBounds(-230,-110, 1366, 768);
		this.add(bckgMenu);
		
		this.mnbBarra.setBackground(new Color(90,61,171)); 
		this.mnConfig.setForeground(new Color(250,247,255));
		this.mnSessoes.setForeground(new Color(250,247,255)); 


	}

}
