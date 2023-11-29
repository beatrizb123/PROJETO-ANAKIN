package ANAKIN.VIEW;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ANAKIN.MODEL.BO.DadosBO;
import ANAKIN.MODEL.DAO.DadosDAO;
import ANAKIN.MODEL.DAO.IniciativaDAO;
import ANAKIN.MODEL.VO.CombateVO;
import ANAKIN.MODEL.VO.DadosVO;


public class AreaDeCombateVIEW extends JFrame {
//Declaração de Variaveis 
	private Container container;
	private ImageIcon combateWall;
	private JLabel bckgCombate;
	private JLabel lblIniciativa, lblProtagonistas, lblNomes;
	private JPanel jpIniciativa, jpColumn, jpRow, jpProtagonistas;

	private JTextArea txtaResultados;
	private JScrollPane spResultados;
	private ImageIcon iconbtnCombate, iconbtnAcao, iconbtnSalvar, iconbtnSair;
	private ImageIcon destaqueCombate, destaqueAcao, destaqueSalvar, destaqueSair;

	private JLabel lblbtnCombate, lblbtnAcao, lblCombate, lblAcao, lblbtnSalvar, lblSalvar, lblbtnSair, lblSair;
	private JScrollPane spIniciativa;
	
	private JSlider sldVida, sldDefesa, sldMagia;
	private JLabel Niveis, nivelVida, nivelDefesa, nivelMagia;
	private JLabel pcVida, pcDefesa, pcMagia;
	private ImageIcon iconbtnProximo;
	private JLabel lblbtnProximo;
	private JButton btprox;
	
	private JLabel nome, classe, talento;
	
	String resultados;
	
	public AreaDeCombateVIEW() {
		// Instanciação
		this.setTitle("Área de Combate");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 580, 500);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		this.setLayout(null);
		this.container = getContentPane();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
		
		this.lblIniciativa = new JLabel("Iniciativa");
		this.lblIniciativa.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblIniciativa.setForeground(new Color(90, 61, 171));
		this.lblIniciativa.setBounds(90, 15, 100, 20);
		this.add(lblIniciativa);

		this.lblProtagonistas = new JLabel("Protagonista Atual");
		this.lblProtagonistas.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblProtagonistas.setForeground(new Color(90, 61, 171));
		this.lblProtagonistas.setBounds(310, 8, 200, 35);
		this.add(lblProtagonistas);

		this.spIniciativa = new JScrollPane();
		this.spIniciativa.setBounds(35, 40, 190, 190);
		this.spIniciativa.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 3));
		this.container.add(spIniciativa);

		this.jpIniciativa = new JPanel();
		this.spIniciativa.setViewportView(jpIniciativa);
		this.jpIniciativa.setLayout(new BorderLayout(0, 0));

		this.jpColumn = new JPanel();
		this.jpIniciativa.add(jpColumn, BorderLayout.NORTH);
		this.jpColumn.setLayout(new GridLayout(0, 1, 0, 1));
		this.jpColumn.setBackground(new Color(235, 223, 255));

		IniciativaDAO iniciDAO = new IniciativaDAO();
		iniciDAO = new IniciativaDAO();
		ArrayList<String> nomesPerso = new ArrayList<>();
		nomesPerso.addAll(iniciDAO.listaGeral());
		ArrayList<Integer> idPerso = new ArrayList<>();
		idPerso.addAll(iniciDAO.listaIdGeral());
		int max = idPerso.size();
		
		for (int i = 0; i < max; i++) {

			this.jpRow = new JPanel();
			this.jpRow.setPreferredSize(new Dimension(150, 30));
			this.jpColumn.add(jpRow);
			this.jpRow.setLayout(null);
			this.lblNomes = new JLabel(nomesPerso.get(i));
			this.add(lblNomes);
			if (i % 2 != 0)
				   this.jpRow.setBackground(new Color(250, 247, 255));

		}	


		this.jpProtagonistas = new JPanel();
		this.jpProtagonistas.setBounds(260, 40, 270, 190);
		this.jpProtagonistas.setBackground(new Color(237, 236, 237));
		this.jpProtagonistas.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 3));
		this.add(jpProtagonistas);

		this.destaqueCombate = new ImageIcon(getClass().getResource("/Imagens/Botões/destaque_dados_combate.png"));
		this.iconbtnCombate = new ImageIcon(getClass().getResource("/Imagens/Botões/Dados_Combate.png"));
		this.lblbtnCombate = new JLabel(iconbtnCombate);
		this.lblbtnCombate.setToolTipText("Dados de Combate");
		this.lblbtnCombate.setBounds(25, 225, 110, 110);
		this.lblbtnCombate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnCombate.setIcon(destaqueCombate);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnCombate.setIcon(iconbtnCombate);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				DadosdeJogoVIEW tela = new DadosdeJogoVIEW();
				tela.setVisible(true);
			}
		});
		this.add(lblbtnCombate);

		this.lblCombate = new JLabel("Combate");
		this.lblCombate.setForeground(new Color(90, 61, 171));
		this.lblCombate.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblCombate.setBounds(50, 320, 100, 20);
		this.add(lblCombate);

		this.destaqueAcao = new ImageIcon(getClass().getResource("/Imagens/Botões/destaque_dados_ação.png"));
		this.iconbtnAcao = new ImageIcon(getClass().getResource("/Imagens/Botões/Dados_Ação.png"));
		this.lblbtnAcao = new JLabel(iconbtnAcao);
		this.lblbtnAcao.setToolTipText("Dados de Ação");
		this.lblbtnAcao.setBounds(135, 225, 110, 110);

		this.lblAcao = new JLabel("Ação");
		this.lblAcao.setForeground(new Color(90, 61, 171));
		this.lblAcao.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblAcao.setBounds(175, 320, 100, 20);
		this.add(lblAcao);

		this.destaqueSalvar = new ImageIcon(getClass().getResource("/Imagens/Botões/destaque_salvar.png"));
		this.iconbtnSalvar = new ImageIcon(getClass().getResource("/Imagens/Botões/Salvar.png"));
		this.lblbtnSalvar = new JLabel(iconbtnSalvar);
		this.lblbtnSalvar.setToolTipText("Salvar");
		this.lblbtnSalvar.setBounds(25, 315, 120, 120);
		this.lblbtnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnSalvar.setIcon(destaqueSalvar);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSalvar.setIcon(iconbtnSalvar);
			}
		});
		this.add(lblbtnSalvar);

		this.lblSalvar = new JLabel("Salvar");
		this.lblSalvar.setForeground(new Color(90, 61, 171));
		this.lblSalvar.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblSalvar.setBounds(60, 405, 100, 20);
		this.add(lblSalvar);

		this.destaqueSair = new ImageIcon(getClass().getResource("/Imagens/Botões/destaque_sair.png"));
		this.iconbtnSair = new ImageIcon(getClass().getResource("/Imagens/Botões/icone_sair.png"));
		this.lblbtnSair = new JLabel(iconbtnSair);
		this.lblbtnSair.setToolTipText("Salvar");
		this.lblbtnSair.setBounds(138, 320, 100, 100);
		this.lblbtnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnSair.setIcon(destaqueSair);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSair.setIcon(iconbtnSair);
			}
		});
		this.add(lblbtnSair);

		this.lblSair = new JLabel("Sair");
		this.lblSair.setForeground(new Color(90, 61, 171));
		this.lblSair.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblSair.setBounds(170, 405, 100, 20);
		this.add(lblSair);

		this.txtaResultados = new JTextArea();
		this.txtaResultados.setLineWrap(true);
		this.txtaResultados.setWrapStyleWord(true);
		this.txtaResultados.setEditable(false);
		this.txtaResultados.setFont(new Font("Arial", Font.BOLD, 14));

		this.spResultados = new JScrollPane(txtaResultados);
		this.spResultados.setBounds(260, 260, 270, 150);
		this.spResultados.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 3));
		this.add(spResultados);
		this.lblbtnAcao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblbtnAcao.setIcon(destaqueAcao);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnAcao.setIcon(iconbtnAcao);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				DadosdeJogoVIEW tela = new DadosdeJogoVIEW();
				tela.setVisible(true);
				
				CombateVO consulta = new CombateVO();
				String reg = consulta.getDados();
				
				resultados = "TESTE DE AÇÃO\n";
				txtaResultados.setText(resultados+ "" + reg);
				
			}
		});
		this.add(lblbtnAcao);
		
		
		this.jpProtagonistas = new JPanel();
		this.jpProtagonistas.setBounds(260, 40, 270, 190);
		this.jpProtagonistas.setBackground(new Color(235, 223, 255));
		this.jpProtagonistas.setLayout(null);
		this.jpProtagonistas.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 3));
		this.add(jpProtagonistas);

		this.nivelVida = new JLabel("Vida:");
		this.nivelVida.setForeground(new Color(90, 61, 171));
		this.nivelVida.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelVida.setBounds(15, 80, 50, 20);
		this.jpProtagonistas.add(nivelVida);

		this.pcVida = new JLabel("100" + "%");
		this.pcVida.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcVida.setBounds(210, 80, 40, 18);
		this.jpProtagonistas.add(pcVida);

		this.sldVida = new JSlider();
		this.sldVida.setBackground(new Color(235, 223, 255));
		this.sldVida.setForeground(new Color(90, 61, 171));
		this.sldVida.setMajorTickSpacing(20);
		this.sldVida.setMinorTickSpacing(5);
		this.sldVida.setPaintTicks(true);


		this.sldVida.setValue(100);
		this.sldVida.setBounds(70, 80, 130, 30);
		this.sldVida.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcVida.setText(String.valueOf(sldVida.getValue()) + "%");

			}

		});
		this.jpProtagonistas.add(sldVida);

		this.nivelDefesa = new JLabel("Defesa:");
		this.nivelDefesa.setForeground(new Color(90, 61, 171));
		this.nivelDefesa.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelDefesa.setBounds(15, 110, 75, 20);
		this.jpProtagonistas.add(nivelDefesa);

		this.pcDefesa = new JLabel("100" + "%");
		this.pcDefesa.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcDefesa.setBounds(210, 110, 40, 18);
		this.jpProtagonistas.add(pcDefesa);

		this.sldDefesa = new JSlider();
		this.sldDefesa.setBackground(new Color(235, 223, 255));
		this.sldDefesa.setForeground(new Color(90, 61, 171));
		this.sldDefesa.setMajorTickSpacing(20);
		this.sldDefesa.setMinorTickSpacing(5);
		this.sldDefesa.setPaintTicks(true);

		this.sldDefesa.setValue(100);
		this.sldDefesa.setBounds(70, 110, 130, 30);
		this.sldDefesa.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcDefesa.setText(String.valueOf(sldDefesa.getValue()) + "%");

			}

		});
		this.jpProtagonistas.add(sldDefesa);

		this.nivelMagia = new JLabel("Magia:");
		this.nivelMagia.setForeground(new Color(90, 61, 171));
		this.nivelMagia.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelMagia.setBounds(15, 140, 55, 20);
		this.jpProtagonistas.add(nivelMagia);

		this.pcMagia = new JLabel("100" + "%");
		this.pcMagia.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcMagia.setBounds(210, 140, 40, 18);
		this.jpProtagonistas.add(pcMagia);

		this.sldMagia = new JSlider();
		this.sldMagia.setBackground(new Color(235, 223, 255));
		this.sldMagia.setForeground(new Color(90, 61, 171));
		this.sldMagia.setMajorTickSpacing(20);
		this.sldMagia.setMinorTickSpacing(5);
		this.sldMagia.setPaintTicks(true);
		this.sldMagia.setValue(100);
		this.sldMagia.setBounds(70, 140, 130, 30);
		this.sldMagia.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcMagia.setText(String.valueOf(sldMagia.getValue()) + "%");

			}

		});
		this.jpProtagonistas.add(sldMagia);
		
		this.nome = new JLabel("Nome: ");
		this.nome.setBounds(30, 10, 200, 20);
		this.nome.setFont(new Font("Helvatica", Font.BOLD, 18));
		
		this.classe = new JLabel("Classe: ");
		this.classe.setBounds(40, 45, 120, 20);
		this.classe.setForeground(new Color(90, 61, 171));

		this.talento = new JLabel("Talento: ");
		this.talento.setBounds(125, 45, 120, 20);
		this.talento.setForeground(new Color(90, 61, 171));

		
		this.btprox = new JButton(">");
		this.btprox.setToolTipText("Proximo");
		this.btprox.setBounds(213, 160, 50, 25);

		btprox.setBackground(new Color(90,61,171));
		btprox.setForeground(Color.white);
		this.btprox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sldVida.setValue(100);
				sldDefesa.setValue(100);
				sldMagia.setValue(100);
				
			}
		});
		this.jpProtagonistas.add(btprox);
		this.jpProtagonistas.add(nome);
		this.jpProtagonistas.add(talento);
		this.jpProtagonistas.add(classe);
	
		this.combateWall = new ImageIcon(getClass().getResource("/Imagens/Background/Dados.png"));
		this.combateWall = new ImageIcon(combateWall.getImage().getScaledInstance(580, 500, Image.SCALE_DEFAULT));
		this.bckgCombate = new JLabel(combateWall);
		this.bckgCombate.setBounds(-10, -10, 580, 500);
		this.add(bckgCombate);

	}


	
}
