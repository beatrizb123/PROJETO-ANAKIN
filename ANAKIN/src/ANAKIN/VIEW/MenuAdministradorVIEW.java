package TelasProjeto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MenuAdministradorVIEW extends JFrame {
	
	
	private Container container;
	private ImageIcon imgIcon;
	private ImageIcon menuWall;
	private JLabel bckgMenu;
	private JPanel JpIcone;
	private JLabel lblAdm;
	private JLabel lblUsuario;
	private ScrollPane recebelista = new ScrollPane();
	private JTextField tfBusca;
	private JButton btnAbrir;
	private ImageIcon iconLupa;
	private JLabel lblbtnLupa;
	private JButton btnCancelar;
	private JMenuBar menuBar;
	private JMenu mnConfig;
	private JMenuItem miAlterarConta, miLogout, miSair, miExcluirConta;
	
	public MenuAdministradorVIEW() {
		this.setTitle("Administrador ★ ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 535, 270);
		//this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		this.setResizable(false);
		
		this.container = getContentPane();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));
	
		this.lblAdm = new JLabel("Olá Administrador!");
		this.lblAdm.setBounds(5, 10, 200, 25);
		this.lblAdm.setForeground(new Color(90, 61, 171));
		this.lblAdm.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAdm.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(lblAdm);
		
		this.JpIcone = new JPanel(); 
		this.JpIcone.setLayout(null);
		this.JpIcone.setBackground(new Color(235,223,255));
		this.JpIcone.setBounds(30, 35, 150, 140);
		this.JpIcone.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.add(JpIcone);
		

		this.tfBusca = new JTextField(" Informe nome do Usuario",20);
		this.tfBusca.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		//this.tfBusca.setFont(new Font("Arial", Font.BOLD,12));
		this.tfBusca.setBounds(30, 185, 152, 25);
		this.add(tfBusca);
		
		this.recebelista.setBounds(210,35,280, 140);
		add(recebelista);
		
		this.iconLupa = new ImageIcon(getClass().getResource("lupa2.png"));
		this.lblbtnLupa = new JLabel(iconLupa);
		this.lblbtnLupa.setToolTipText("Pesquisa");
		this.lblbtnLupa.setBounds(108, 105, 180, 180);
		this.lblbtnLupa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnLupa.setIcon(iconLupa);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnLupa.setIcon(iconLupa);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// A telinha da Ficha de NPCs lala
				
			}
		});
		this.add(lblbtnLupa);
		
		this.btnAbrir = new JButton("Abrir");
		this.btnAbrir.setBounds(260, 180, 85, 25);
		this.btnAbrir.setBackground(new Color(90, 61, 171));
		this.btnAbrir.setFont(new Font("Arial", Font.BOLD,12));
		this.btnAbrir.setForeground(Color.WHITE);
		this.add(btnAbrir);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(360, 180, 85, 25);
		this.btnCancelar.setBackground(new Color(90, 61, 171));
		this.btnCancelar.setFont(new Font("Arial", Font.BOLD,12));
		this.btnCancelar.setForeground(Color.WHITE);
		this.add(btnCancelar);

		this.menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		this.mnConfig = new JMenu("Configurações");
		this.mnConfig.setMnemonic('C');
		this.menuBar.add(mnConfig);
		
		this.miLogout = new JMenuItem("Logout");
		this.miLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				TelaInicialVIEW telaInicial = new TelaInicialVIEW();
				telaInicial.setVisible(true);
				//ManterSessaoDAO MSD = new ManterSessaoDAO();
				//MSD.finalizaSessao();

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
		
		this.miSair = new JMenuItem("Sair");
		this.miSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		this.mnConfig.add(miSair);
		
		this.miExcluirConta = new JMenuItem("Excluir Conta");
		this.miExcluirConta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				ExcluirContaVIEW tela = new ExcluirContaVIEW();
				tela.setVisible(true);	
			}
			
		});
		this.mnConfig.add(miExcluirConta);
		
		this.menuBar.setBackground(new Color(90,61,171)); 
		this.mnConfig.setForeground(new Color(250,247,255));
		
		
		this.menuWall = new ImageIcon(getClass().getResource("Dados e Combate.png"));
		this.menuWall = new ImageIcon(menuWall.getImage().getScaledInstance(560, 510, Image.SCALE_DEFAULT));
		this.bckgMenu = new JLabel(menuWall);
		this.bckgMenu.setBounds(-20,-90, 1366, 768);
		this.add(bckgMenu);
	
	}
	public static void abre() {
		MenuAdministradorVIEW frame = new MenuAdministradorVIEW();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width)/2,(tela.height - frame.getSize().height)/2);
	}
	public static void main(String[] args) {
		MenuAdministradorVIEW.abre();
	}
	
}
