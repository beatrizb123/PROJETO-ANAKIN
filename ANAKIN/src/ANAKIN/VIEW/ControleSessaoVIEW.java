package ANAKIN.VIEW;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ANAKIN.MODEL.DAO.AcessarControleSessaoDAO;
import ANAKIN.MODEL.DAO.ControleSessaoDAO;
import ANAKIN.MODEL.DAO.DadosDAO;
import ANAKIN.MODEL.DAO.FichaProtagonistaDAO;
import ANAKIN.MODEL.DAO.ManterSessaoDAO;
import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class ControleSessaoVIEW extends JFrame {

	private Container container;
	private JLabel lblNome, lblInventario, lblAnotacoes, lblvolta, lblbtnDados, lblDados;
	private JLabel lblProtagonistas, lblNPCs;
	private JButton btnSalva, btnLimpar, btnRetorna, btnDados;
	private ImageIcon imgIcon, iconVoltar, iconVoltar2, iconbtnDados;
	private JScrollPane spInventario, spAnotacao;
	private JTextArea txtAnotacao, txtInventario;
	private JTextField tfNome;
	private JPanel jpProtagonistas, jpNPCs;
	private ImageIcon menuWall;
	private JLabel bckgMenu;
	private JLabel lblProtagonista;
	private ImageIcon iconProtagonista;
	private JLabel lblbtnProtagonista;
	private ImageIcon iconNPC;
	private JLabel lblbtnNPC;
	private JLabel lblNPC;

	private JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9;
	int i = 0;
	 static int id;
	public int retornaid(){
		AcessarControleSessaoDAO ACSD = new AcessarControleSessaoDAO();
		int id = ACSD.retornaIDSessaoDAO();
		return id;
	}
	public ResultSet retornainforSessao(int id) {
		AcessarControleSessaoDAO ACSD = new AcessarControleSessaoDAO();
		ResultSet infor = ACSD.AcessarSessaoDAO(id);
		return infor;
	}
	public JTextArea getTxtAnotacao() {
		return txtAnotacao;
	}

	public void setTxtAnotacao(JTextArea txtAnotacao) {
		this.txtAnotacao = txtAnotacao;
	}

	public JTextArea getTxtInventario() {
		return txtInventario;
	}

	public void setTxtInventario(JTextArea txtInventario) {
		this.txtInventario = txtInventario;
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public ControleSessaoVIEW() {
		// instanciação dos objetos
		
		this.setTitle("Controle de Sessao ★ ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 940, 550);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		this.setResizable(false);

		this.container = getContentPane();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

		this.lblInventario = new JLabel("Inventario");
		this.lblInventario.setBounds(320, 240, 155, 40);
		this.lblInventario.setForeground(new Color(90, 61, 171));
		this.lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblInventario.setFont(new Font("Arial", Font.BOLD, 18));
		
		this.add(lblInventario);

		this.txtInventario = new JTextArea();
		this.txtInventario.setFont(new Font("Helvetica", Font.BOLD, 14));
		this.txtInventario.setLineWrap(true);
		this.txtInventario.setWrapStyleWord(true);
		this.spInventario = new JScrollPane(txtInventario);
		this.spInventario.setBounds(300, 275, 200, 180);
		this.spInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));

		
		this.container.add(spInventario);

		this.lblAnotacoes = new JLabel("Anotações");
		this.lblAnotacoes.setBounds(635, 240, 155, 40);
		this.lblAnotacoes.setForeground(new Color(90, 61, 171));
		this.lblAnotacoes.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAnotacoes.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblAnotacoes);

		this.txtAnotacao = new JTextArea();
		this.txtAnotacao.setFont(new Font("Helvetica", Font.PLAIN, 13));
		this.txtAnotacao.setLineWrap(true);
		this.txtAnotacao.setWrapStyleWord(true);
		this.spAnotacao = new JScrollPane(txtAnotacao);
		this.spAnotacao.setBounds(540, 275, 350, 180);

		this.spAnotacao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));

		this.container.add(spAnotacao);

		// BOTÃO DE LIMPAR APAGA TUDO DO TXTANOTACAO

		this.btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtAnotacao.setText("");

			}
		});

		this.btnLimpar.setBounds(540, 460, 100, 25);
		this.btnLimpar.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnLimpar.setBackground(new Color(90, 61, 171));
		this.btnLimpar.setForeground(Color.white);
		this.btnLimpar.setToolTipText("Apaga anotações");
		this.btnLimpar.setToolTipText("Apaga anotações");
		this.btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.add(btnLimpar);

		iconVoltar = new ImageIcon(getClass().getResource("voltar1.png"));
		iconVoltar2 = new ImageIcon(getClass().getResource("voltar2.png"));
		this.lblvolta = new JLabel(iconVoltar);
		this.lblvolta.setBackground(Color.black);
		this.lblvolta.setBounds(10, 3, 30, 30);
		this.lblvolta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblvolta.setIcon(iconVoltar2);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblvolta.setIcon(iconVoltar);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				MenuPrincipalVIEW tela = new MenuPrincipalVIEW();
				tela.setVisible(true);
			}
		});
		this.add(lblvolta);

		this.lblNome = new JLabel("Nome da sessão:");
		this.lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblNome.setBounds(30, 35, 150, 25);
		this.lblNome.setForeground(new Color(90, 61, 171));
		this.add(lblNome);

		this.tfNome = new JTextField(20);
		this.tfNome.setBounds(30, 60, 180, 25);
		this.tfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.add(tfNome);

		this.btnSalva = new JButton("Salvar");
		this.btnSalva.setBounds(70, 95, 100, 30);
		this.btnSalva.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnSalva.setBackground(new Color(90, 61, 171));
		this.btnSalva.setForeground(Color.white);
		this.btnSalva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ControleSessaoDAO salvar = new ControleSessaoDAO();
				ControleSessaoVO controle = new ControleSessaoVO();
				UsuarioVO user = new UsuarioVO();
				ManterSessaoDAO teste = new ManterSessaoDAO();

				String inventario, anotacoes, nome, usuario;

				inventario = txtInventario.getText();
				anotacoes = txtAnotacao.getText();
				usuario = user.getNome_Usuario();
				usuario = teste.chamar();

				if (teste.chamar() == null) {
					usuario = user.getNome_Usuario();
					System.out.println(usuario);

				}

				controle.setInventario_sessao(inventario);
				controle.setAnotacoes_sessao(anotacoes);

				System.out.println(user.getNome_Usuario());

				salvar.salvarInformacoes(controle);

				JOptionPane.showMessageDialog(null, "INFORMAÇÕES FORAM SALVAS!");

			}
		});
		this.add(btnSalva);

		this.lblProtagonistas = new JLabel("Protagonistas");
		this.lblProtagonistas.setBounds(318, 3, 155, 40);
		this.lblProtagonistas.setForeground(new Color(90, 61, 171));
		this.lblProtagonistas.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblProtagonistas.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblProtagonistas);

		this.lblNPCs = new JLabel("NPC's");
		this.lblNPCs.setBounds(660, 3, 155, 40);
		this.lblNPCs.setForeground(new Color(90, 61, 171));
		this.lblNPCs.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNPCs.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblNPCs);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		scrollPane.setBackground(new Color(235, 223, 255));
		scrollPane.setBounds(250, 40, 300, 180);
		add(scrollPane);

		JPanel borderlaoutpanel = new JPanel();
		scrollPane.setViewportView(borderlaoutpanel);
		borderlaoutpanel.setLayout(new BorderLayout(0, 0));

		JPanel columnpanel = new JPanel();
		borderlaoutpanel.add(columnpanel, BorderLayout.NORTH);
		columnpanel.setLayout(new GridLayout(0, 3, 0, 3));
		columnpanel.setBackground(new Color(235, 223, 255));

		FichaProtagonistaDAO FPD = new FichaProtagonistaDAO();
		Timer tempo = new Timer();
		TimerTask atualizador = new TimerTask() {

			@Override
			public void run() {
				int total = FPD.RetornaTantoDeFichas();
				
				if (total > i) {
					i = i + 1;
					SwingUtilities.invokeLater(new Runnable() {
			            @Override
			            public void run() {
					JPanel rowPanel = new JPanel();
					rowPanel.setPreferredSize(new Dimension(70, 120));
					columnpanel.add(rowPanel);
					rowPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(235, 223, 255), 4));

					rowPanel.setBackground(new Color(250, 247, 255));
					rowPanel.setLayout(new GridLayout(5, 1));

					JLabel nome = new JLabel("NOME");
					nome.setHorizontalAlignment((int) CENTER_ALIGNMENT);
					rowPanel.add(nome);

					JLabel vida = new JLabel("100/100");
					vida.setHorizontalAlignment((int) CENTER_ALIGNMENT);
					rowPanel.add(vida);

					JLabel def = new JLabel("100/100");
					def.setHorizontalAlignment((int) CENTER_ALIGNMENT);
					rowPanel.add(def);

					JLabel mag = new JLabel("100/100");
					mag.setHorizontalAlignment((int) CENTER_ALIGNMENT);
					rowPanel.add(mag);

					JButton btn = new JButton("...");
					btn.setBackground(new Color(250, 247, 255));

					rowPanel.add(btn);
			            } 
			            });

				}

			}

		};tempo.scheduleAtFixedRate(atualizador, 0, 2000);

		this.jpProtagonistas = new JPanel();
		this.jpProtagonistas.setLayout(null);
		this.jpProtagonistas.setBackground(new Color(235, 223, 255));
		this.jpProtagonistas.setBounds(250, 40, 300, 180);
		this.jpProtagonistas.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.jpProtagonistas.setLayout(new GridLayout(5, 2));
		/*
		 * this.add(jpProtagonistas);
		 * 
		 * this.jp1 = new JPanel(); this.jp1.setBackground(Color.black);
		 * this.jpProtagonistas.add(jp1);
		 * 
		 * this.jp2 = new JPanel(); this.jp2.setBackground(Color.white);
		 * this.jpProtagonistas.add(jp2);
		 * 
		 * this.jp3 = new JPanel(); this.jp3.setBackground(Color.green);
		 * this.jpProtagonistas.add(jp3);
		 * 
		 * this.jp4 = new JPanel(); this.jp4.setBackground(Color.blue);
		 * this.jpProtagonistas.add(jp4);
		 * 
		 * this.jp5 = new JPanel(); this.jp5.setBackground(Color.pink);
		 * this.jpProtagonistas.add(jp5);
		 * 
		 * this.jp6 = new JPanel(); this.jp6.setBackground(Color.cyan);
		 * this.jpProtagonistas.add(jp6);
		 * 
		 * this.jp7 = new JPanel(); this.jp7.setBackground(Color.gray);
		 * this.jpProtagonistas.add(jp7);
		 * 
		 * this.jp8 = new JPanel(); this.jp8.setBackground(Color.magenta);
		 * this.jpProtagonistas.add(jp8);
		 * 
		 * this.jp9 = new JPanel(); this.jp9.setBackground(Color.red);
		 * this.jpProtagonistas.add(jp9);
		 */

		this.jpNPCs = new JPanel();
		this.jpNPCs.setLayout(null);
		this.jpNPCs.setBackground(new Color(235, 223, 255));
		this.jpNPCs.setBounds(590, 40, 300, 180);
		this.jpNPCs.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.add(jpNPCs);

		this.iconProtagonista = new ImageIcon(getClass().getResource("Ficha_Protagonista.png"));
		this.lblbtnProtagonista = new JLabel(iconProtagonista);
		this.lblbtnProtagonista.setToolTipText("Adicionar Protagonista");
		this.lblbtnProtagonista.setBounds(-15, 90, 180, 180);
		this.lblbtnProtagonista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnProtagonista.setIcon(iconProtagonista);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnProtagonista.setIcon(iconProtagonista);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				FichaProtagonistaDAO FPD = new FichaProtagonistaDAO();
				FichaProtagonistaVIEW ficha = new FichaProtagonistaVIEW();
				AuxiliarVO AV = new AuxiliarVO();
				id = AV.getIdsessao();
				FPD.criandoficha(id);
				ficha.setVisible(true);

			}
		});
		this.add(lblbtnProtagonista);

		this.lblProtagonista = new JLabel("Protagonistas");
		this.lblProtagonista.setForeground(new Color(90, 61, 171));
		this.lblProtagonista.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblProtagonista.setBounds(125, 130, 190, 100);
		this.lblProtagonista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblProtagonista.setForeground(Color.gray);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblProtagonista.setForeground(new Color(90, 61, 171));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				FichaProtagonistaVIEW ficha = new FichaProtagonistaVIEW();
				ficha.setVisible(true);
			}
		});
		this.add(lblProtagonista);

		this.iconNPC = new ImageIcon(getClass().getResource("Ficha_NPC.png"));
		this.lblbtnNPC = new JLabel(iconNPC);
		this.lblbtnNPC.setToolTipText("Adicionar Protagonista");
		this.lblbtnNPC.setBounds(-15, 195, 180, 180);
		this.lblbtnNPC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnNPC.setIcon(iconNPC);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnNPC.setIcon(iconNPC);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// A telinha da Ficha de NPCs lala

			}
		});
		this.add(lblbtnNPC);

		this.lblNPC = new JLabel("NPCs");
		this.lblNPC.setForeground(new Color(90, 61, 171));
		this.lblNPC.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblNPC.setBounds(150, 225, 190, 100);
		this.add(lblNPC);

		this.iconbtnDados = new ImageIcon(getClass().getResource("Botao_Dados.png"));
		this.lblbtnDados = new JLabel(iconbtnDados);
		this.lblbtnDados.setToolTipText("Dados de Jogo");
		this.lblbtnDados.setBounds(-15, 320, 180, 180);
		this.lblbtnDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnDados.setIcon(iconbtnDados);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnDados.setIcon(iconbtnDados);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				DadosdeJogoVIEW dados = new DadosdeJogoVIEW();
				dados.setVisible(true);
				// DadosdeJogoVIEW dadosV = new DadosdeJogoVIEW();
				// dadosV.setVisible(true);

			}
		});
		this.add(lblbtnDados);

		this.lblDados = new JLabel("Dados");
		this.lblDados.setForeground(new Color(90, 61, 171));
		this.lblDados.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblDados.setBounds(145, 340, 100, 100);
		this.lblDados = new JLabel("Dados");
		this.lblDados.setForeground(new Color(90, 61, 171));
		this.lblDados.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblDados.setBounds(145, 340, 100, 100);
		this.lblDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblDados.setForeground(Color.gray);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDados.setForeground(new Color(90, 61, 171));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				DadosdeJogoVIEW tela = new DadosdeJogoVIEW();
				tela.setVisible(true);
			}
		});
		this.add(lblDados);

		this.menuWall = new ImageIcon(getClass().getResource("Background.png"));
		this.menuWall = new ImageIcon(menuWall.getImage().getScaledInstance(940, 550, Image.SCALE_DEFAULT));
		this.bckgMenu = new JLabel(menuWall);
		this.bckgMenu.setBounds(-230, -110, 1366, 768);
		this.add(bckgMenu);

	}

}