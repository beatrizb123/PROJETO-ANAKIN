 package ANAKIN.VIEW;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ANAKIN.MODEL.BO.MiniFichasNPCBO;
import ANAKIN.MODEL.BO.MiniFichasProtaBO;
//import ANAKIN.MODEL.BO.MiniFichasProtaBO;
import ANAKIN.MODEL.DAO.AbrirSessaoDAO;
import ANAKIN.MODEL.DAO.ControleSessaoDAO;
import ANAKIN.MODEL.DAO.FichaNPCDAO;
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
	private ImageIcon iconbtnCombate;
	private JLabel lblbtnCombate;
	private JLabel lblCombate; 
	int IndiceAtual = 0, tanto,IndiceAtual2 = 0 ;
	private MiniFichasProtaBO miniFProtagonista ;
	private MiniFichasNPCBO miniFNPC;
	FichaProtagonistaDAO FPD = new FichaProtagonistaDAO();
	FichaNPCDAO FND = new FichaNPCDAO();

	
	
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



	public void setTfNome(String nome) {
		this.tfNome.setText("aa");
	}



	public ControleSessaoVIEW() {
		// instanciação dos objetos
		AbrirSessaoDAO ASD = new AbrirSessaoDAO();
		ControleSessaoVO CSV = new ControleSessaoVO();
		int i = ASD.VereficaSessaoAcessada();
		if(i > 0) {
			try {
				ResultSet informaçoes = ASD.retornaInforSessao();
				while (informaçoes.next()) {
					String Nome = informaçoes.getString("nome_sessao");
					String Anotaçoes = informaçoes.getString("anotacoes_sessao");
					String Inventario = informaçoes.getString("inventario_sessao");
					CSV.setNome_sessao(Nome);
					CSV.setAnotacoes_sessao(Anotaçoes);
					CSV.setInventario_sessao(Inventario);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		IndiceAtual = 0;
		IndiceAtual2 = 0;

		this.setTitle("Controle de Sessão ★ ");
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
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/jupiter.png")));


		this.lblInventario = new JLabel("Inventário");
		this.lblInventario.setBounds(320, 240, 155, 40);
		this.lblInventario.setForeground(new Color(90, 61, 171));
		this.lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblInventario.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblInventario);
		
		if(CSV.getAnotacoes_sessao() != null) {
			this.txtInventario = new JTextArea(CSV.getInventario_sessao());
		}else {
			this.txtInventario = new JTextArea();
		}
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
		if(CSV.getAnotacoes_sessao() != null) {
			this.txtAnotacao = new JTextArea(CSV.getAnotacoes_sessao());
		}else {
			this.txtAnotacao = new JTextArea();
		}
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
		
		iconVoltar = new ImageIcon(getClass().getResource("/Imagens/voltar1.png"));
		iconVoltar2 = new ImageIcon(getClass().getResource("/Imagens/voltar2.png"));
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
				ASD.EncerraAcessoSessao();
				setVisible(false);
				MenuPrincipalVIEW tela = new MenuPrincipalVIEW();
				tela.setVisible(true);
			}
		});
		this.add(lblvolta);


		this.lblNome = new JLabel("Nome da sessão:");
		this.lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblNome.setBounds(50, 15, 150, 20);
		this.lblNome.setForeground(new Color(90, 61, 171));
		this.add(lblNome);

		
		if(CSV.getNome_sessao() != null) {
			this.tfNome = new JTextField(CSV.getNome_sessao());
		}else {
			this.tfNome = new JTextField();
		}
		this.tfNome.setBounds(50, 40, 160, 25);
		this.tfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.add(tfNome);
		
		this.btnSalva = new JButton("Salvar");
		this.btnSalva.setBounds(80, 72, 100, 25);
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

				nome = tfNome.getText();
				inventario = txtInventario.getText();
				anotacoes = txtAnotacao.getText();
				usuario = user.getNome_Usuario();
				usuario = teste.chamar();
				
				if (teste.chamar() == null) {
					usuario = user.getNome_Usuario();
					System.out.println(usuario);

				}

				controle.setNome_sessao(nome);
				controle.setInventario_sessao(inventario);
				controle.setAnotacoes_sessao(anotacoes);
				controle.setFk_usuario(usuario);

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
		
		JPanel painelprota = new JPanel();
	       painelprota.setBounds(250, 40, 300, 180);
	       painelprota.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
	       painelprota.setBackground(new Color(235, 223, 255));
	       painelprota.setLayout(null);
	       add(painelprota);
	       
	       JButton BTNproximo = new JButton(">");
			BTNproximo.setVisible(true);
			BTNproximo.setBounds(242,80,49,27);
			painelprota.add(BTNproximo);
			
			JButton BTNAbrir = new JButton("abrir");
			BTNAbrir.setVisible(true);
			BTNAbrir.setBounds(110,149,70,27);
			painelprota.add(BTNAbrir);
			JButton BTNanterior = new JButton("<");
			BTNanterior.setVisible(true);
			BTNanterior.setBounds(10,80,49,27);
			painelprota.add(BTNanterior);
			
			
			JPanel rowPanel = new JPanel();
			rowPanel.setBounds(90,20,120,130);
			rowPanel.setBorder(BorderFactory.createLineBorder(new Color(235, 223, 255), 4));
			rowPanel.setBackground(new Color(250, 247, 255));
			rowPanel.setLayout(new GridLayout(5, 1));
			//descriçao da miniFicha - josue
			miniFProtagonista = FPD.informaçoesbaseFP(IndiceAtual);
			JLabel nome = new JLabel("Nome:"+ miniFProtagonista.getNome());
			nome.setHorizontalAlignment(SwingConstants.CENTER);
			rowPanel.add(nome);
			JLabel vida = new JLabel("Vida: "+ miniFProtagonista.getVida());
			vida.setHorizontalAlignment(SwingConstants.CENTER);
			rowPanel.add(vida);
			JLabel def = new JLabel("Defesa: "+ miniFProtagonista.getDefesa());
			def.setHorizontalAlignment(SwingConstants.CENTER);
			rowPanel.add(def);
			JLabel mag = new JLabel("Magia: "+ miniFProtagonista.getMagia());
			mag.setHorizontalAlignment(SwingConstants.CENTER);
			rowPanel.add(mag);
			painelprota.add(rowPanel);
		
		tanto = FPD.retornaTantoFicha();
		//configuraçao dos eventos que ocorrerao ao pressionar os botoes: proximo,anterior,abrir - josue
		BTNanterior.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					IndiceAtual--;
					
					miniFProtagonista = FPD.informaçoesbaseFP(IndiceAtual);
					nome.setText("Nome: " + miniFProtagonista.getNome());
					vida.setText("Vida: " + Integer.toString(miniFProtagonista.getVida()));
					def.setText("Defesa: " + Integer.toString(miniFProtagonista.getDefesa()));
					mag.setText("Magia: " + Integer.toString(miniFProtagonista.getMagia()));
				
				
			}
			
		});
		
		BTNproximo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					IndiceAtual++;
					
				
						miniFProtagonista = FPD.informaçoesbaseFP(IndiceAtual);
						nome.setText("Nome: " + miniFProtagonista.getNome());
						vida.setText("Vida: " + Integer.toString(miniFProtagonista.getVida()));
						def.setText("Defesa: " + Integer.toString(miniFProtagonista.getDefesa()));
						mag.setText("Magia: " + Integer.toString(miniFProtagonista.getMagia()));
					
			
			}
		});

		BTNAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FPD.AtivaprotaOPEN();
				miniFProtagonista = FPD.informaçoesbaseFP(IndiceAtual);
				FPD.retornainfotprota(miniFProtagonista.getNome(), miniFProtagonista.getVida(), miniFProtagonista.getDefesa(),miniFProtagonista.getMagia());
				
				FichaProtagonistaVIEW FPV = new FichaProtagonistaVIEW();
				FPV.setVisible(true);
			}
		});
		
		this.lblNPCs = new JLabel("NPC's");
		this.lblNPCs.setBounds(660, 3, 155, 40);
		this.lblNPCs.setForeground(new Color(90, 61, 171));
		this.lblNPCs.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNPCs.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblNPCs);
		
		JPanel painelNPC = new JPanel();
	       painelNPC.setBounds(590, 40, 300, 180);
	       painelNPC.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
	       painelNPC.setBackground(new Color(235, 223, 255));
	       painelNPC.setLayout(null);
	       add(painelNPC);
	       
	       JButton BTNproximo2 = new JButton(">");
			BTNproximo2.setVisible(true);
			BTNproximo2.setBounds(242,80,49,27);
			painelNPC.add(BTNproximo2);
			
			JButton BTNAbrir2 = new JButton("abrir");
			BTNAbrir2.setVisible(true);
			BTNAbrir2.setBounds(110,149,70,27);
			painelNPC.add(BTNAbrir2);
			JButton BTNanterior2 = new JButton("<");
			BTNanterior2.setVisible(true);
			BTNanterior2.setBounds(10,80,49,27);
			painelNPC.add(BTNanterior2);
			
			
			JPanel rowPanel2 = new JPanel();
			rowPanel2.setBounds(90,20,120,130);
			rowPanel2.setBorder(BorderFactory.createLineBorder(new Color(235, 223, 255), 4));
			rowPanel2.setBackground(new Color(250, 247, 255));
			rowPanel2.setLayout(new GridLayout(5, 1));
			//descriçao da miniFicha - josue
			miniFNPC = FND.RetornaInforBase(IndiceAtual2) ;
			JLabel nomeNPC = new JLabel("Nome:"+ miniFNPC.getNomeNPC());
			nomeNPC.setHorizontalAlignment(SwingConstants.CENTER);
			rowPanel2.add(nomeNPC);
			JLabel vidaNPC = new JLabel("Vida: "+ miniFNPC.getVidaNPC());
			vidaNPC.setHorizontalAlignment(SwingConstants.CENTER);
			rowPanel2.add(vidaNPC);
			JLabel defNPC = new JLabel("Defesa: "+ miniFNPC.getDefNPC());
			defNPC.setHorizontalAlignment(SwingConstants.CENTER);
			rowPanel2.add(defNPC);
			JLabel magNPC = new JLabel("Magia: "+ miniFNPC.getMagNPC());
			magNPC.setHorizontalAlignment(SwingConstants.CENTER);
			rowPanel2.add(magNPC);
			painelNPC.add(rowPanel2);
		
		
		//configuraçao dos eventos que ocorrerao ao pressionar os botoes: proximo,anterior,abrir - josue
		BTNanterior2.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IndiceAtual2--;
					
					miniFNPC = FND.RetornaInforBase(IndiceAtual2);
					nomeNPC.setText("Nome: " + miniFNPC.getNomeNPC());
					vidaNPC.setText("Vida: " + Integer.toString(miniFNPC.getVidaNPC()));
					defNPC.setText("Defesa: " + Integer.toString(miniFNPC.getDefNPC()));
					magNPC.setText("Magia: " + Integer.toString(miniFNPC.getMagNPC()));
			}
			
		});
		BTNproximo2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					IndiceAtual2++;
					
				
					miniFNPC = FND.RetornaInforBase(IndiceAtual2);
					nomeNPC.setText("Nome: " + miniFNPC.getNomeNPC());
					vidaNPC.setText("Vida: " + Integer.toString(miniFNPC.getVidaNPC()));
					defNPC.setText("Defesa: " + Integer.toString(miniFNPC.getDefNPC()));
					magNPC.setText("Magia: " + Integer.toString(miniFNPC.getMagNPC()));
					
			
			}
		});
		
		
		BTNAbrir2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FPD.AtivaprotaOPEN();
				miniFNPC = FND.RetornaInforBase(IndiceAtual2);
				FND.retornaInforNPC(miniFNPC.getNomeNPC(), miniFNPC.getVidaNPC(), miniFNPC.getDefNPC(), miniFNPC.getMagNPC());
				
				FichaNpcVIEW FNV = new FichaNpcVIEW();
				FNV.setVisible(true);
			}
		});

		
		this.jpProtagonistas = new JPanel();
		this.jpProtagonistas.setLayout(null);
		this.jpProtagonistas.setBackground(new Color(235, 223, 255));
		this.jpProtagonistas.setBounds(250, 40, 300, 180);
		this.jpProtagonistas.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.add(jpProtagonistas);

		
	

	
				
		this.iconProtagonista = new ImageIcon(getClass().getResource("/Imagens/Ficha_Protagonista.png"));
		this.lblbtnProtagonista= new JLabel(iconProtagonista);
		this.lblbtnProtagonista.setToolTipText("Adicionar Protagonista");
		this.lblbtnProtagonista.setBounds(-15, 60, 180, 180);
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
			FPD.criarRegistroProta();
			FichaProtagonistaVIEW FPV = new FichaProtagonistaVIEW();
			FPV.setVisible(true);
				
			}
		});
		this.add(lblbtnProtagonista);

		this.lblProtagonista =  new JLabel("Protagonistas");
		this.lblProtagonista.setForeground(new Color(90,61,171));
		this.lblProtagonista.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblProtagonista.setBounds(125,100,190,100);
		this.add(lblProtagonista);
			
		this.iconNPC = new ImageIcon(getClass().getResource("/Imagens/Ficha_NPC.png"));
		this.lblbtnNPC= new JLabel(iconNPC);
		this.lblbtnNPC.setToolTipText("Adicionar NPC");
		this.lblbtnNPC.setBounds(-15, 160, 180, 180);
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
				FichaNPCDAO FND = new FichaNPCDAO();
				FND.criandoRegistroNPC();
				FichaNpcVIEW tela = new FichaNpcVIEW();
				tela.setVisible(true);
				
			}
		});
		this.add(lblbtnNPC);

		this.lblNPC =  new JLabel("NPCs");
		this.lblNPC.setForeground(new Color(90,61,171));
		this.lblNPC.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblNPC.setBounds(150,195,190,100);
		this.add(lblNPC);
			

		this.iconbtnDados = new ImageIcon(getClass().getResource("/Imagens/Botao_Dados.png"));
		this.lblbtnDados = new JLabel(iconbtnDados);
		this.lblbtnDados.setToolTipText("Dados de Jogo");
		this.lblbtnDados.setBounds(-10, 300, 180, 180);
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
				//DadosdeJogoVIEW dadosV = new DadosdeJogoVIEW();
				//dadosV.setVisible(true);
				
			}
		});
		this.add(lblbtnDados);

		
		this.lblDados =  new JLabel("Dados");
		this.lblDados.setForeground(new Color(90,61,171));
		this.lblDados.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblDados.setBounds(55,405,100,100);
		this.lblDados.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {

			lblDados.setForeground(Color.gray);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			lblDados.setForeground(new Color(90,61,171));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			DadosdeJogoVIEW tela = new DadosdeJogoVIEW();
			tela.setVisible(true);
			}
		});
		this.add(lblDados);
		
		
		this.iconbtnCombate = new ImageIcon(getClass().getResource("/Imagens/Combate.png"));
		this.lblbtnCombate = new JLabel(iconbtnCombate);
		this.lblbtnCombate.setToolTipText("Area de Combate");
		this.lblbtnCombate.setBounds(140, 310, 140, 140);
		this.lblbtnCombate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnCombate.setIcon(iconbtnCombate);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnCombate.setIcon(iconbtnCombate);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
				AreaDeCombateVIEW tela = new AreaDeCombateVIEW();
				tela.setVisible(true);
				
			}
		});
		this.add(lblbtnCombate);

		this.lblCombate =  new JLabel("Combate");
		this.lblCombate.setForeground(new Color(90,61,171));
		this.lblCombate.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblCombate.setBounds(180,405,100,100);
		this.lblCombate.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {

			lblCombate.setForeground(Color.gray);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			lblCombate.setForeground(new Color(90,61,171));
		}

		/*@Override
		public void mouseClicked(MouseEvent e) {
			Tela de Combate 
			}*/
		});
		this.add(lblCombate);
		

		
		this.menuWall = new ImageIcon(getClass().getResource("/Imagens/Background.png"));
		this.menuWall = new ImageIcon(menuWall.getImage().getScaledInstance(940, 550, Image.SCALE_DEFAULT));
		this.bckgMenu = new JLabel(menuWall);
		this.bckgMenu.setBounds(-230,-110, 1366, 768);
		this.add(bckgMenu);
		
	}
	
	
}