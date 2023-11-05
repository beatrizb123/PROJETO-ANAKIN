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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class AreaDeCombateVIEW extends JFrame {
//Declaração de Variaveis 
	private Container container;
	private ImageIcon combateWall;
	private JLabel bckgCombate;
	private JLabel lblIniciativa, lblProtagonistas;
	private JPanel jpIniciativa, jpColumn, jpRow, jpProtagonistas;

	private JTextArea txtaResultados;
	private JScrollPane spResultados;
	private ImageIcon iconbtnCombate, iconbtnAcao, iconbtnSalvar, iconbtnSair;

	private JLabel lblbtnCombate, lblbtnAcao, lblCombate, lblAcao, lblbtnSalvar, lblSalvar, lblbtnSair, lblSair;
	private JScrollPane spIniciativa;
	
	
	public AreaDeCombateVIEW() {
		//Instanciação 
		this.setTitle("Área de Combate");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0,0,580,500);
		this.setBackground(new Color(250,247,255));
		this.setVisible(true);
		this.setLayout(null);

		this.container = getContentPane();
		
		this.lblIniciativa = new JLabel("Iniciativa");
		this.lblIniciativa.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblIniciativa.setForeground(new Color(90,61,171));
		this.lblIniciativa.setBounds(90, 15, 100,20);
		this.add(lblIniciativa);
		
		this.lblProtagonistas = new JLabel("Protagonista Atual");
		this.lblProtagonistas.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblProtagonistas.setForeground(new Color(90,61,171));
		this.lblProtagonistas.setBounds(310, 8, 200,35);
		this.add(lblProtagonistas);
		
		this.spIniciativa = new JScrollPane();
		this.spIniciativa.setBounds(35,40, 190, 190);
		this.spIniciativa.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 3));
		this.container.add(spIniciativa);
		
		this.jpIniciativa = new JPanel();
		this.spIniciativa.setViewportView(jpIniciativa);
		this.jpIniciativa.setLayout(new BorderLayout(0,0));
		
		this.jpColumn = new JPanel();
		this.jpIniciativa.add(jpColumn, BorderLayout.NORTH);
		this.jpColumn.setLayout(new GridLayout(0,1,0,1));
		this.jpColumn.setBackground(new Color(235, 223, 255));
		
		for(int i=0; i<9; i++) {
			
			this.jpRow = new JPanel();
			this.jpRow.setPreferredSize(new Dimension(150,30));
			this.jpColumn.add(jpRow);
			this.jpRow.setLayout(null);
			
			JButton botao = new JButton("Protagonista");
			botao.setBounds(12,5,145,20);
			this.jpRow.add(botao);
			
			if(i%2==0)
            this.jpRow.setBackground(SystemColor.inactiveCaptionBorder);
			
		}
		
		
		
		this.jpProtagonistas = new JPanel(); 
		this.jpProtagonistas.setBounds(260,40, 270, 190);
		this.jpProtagonistas.setBackground(new Color(237,236,237));
		this.jpProtagonistas.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90,61,171), 3));
		this.add(jpProtagonistas);
		
		
		this.iconbtnCombate = new ImageIcon(getClass().getResource("Combate.png"));
		this.lblbtnCombate = new JLabel(iconbtnCombate);
		this.lblbtnCombate.setToolTipText("Dados de Combate");
		this.lblbtnCombate.setBounds(25, 225, 110, 110);
		this.lblbtnCombate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnCombate.setIcon(iconbtnCombate);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnCombate.setIcon(iconbtnCombate);
			}
		});
		this.add(lblbtnCombate);
		
		this.lblCombate = new JLabel("Combate");
		this.lblCombate.setForeground(new Color(90,61,171));
		this.lblCombate.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblCombate.setBounds(50,320,100, 20);
		this.add(lblCombate);
		
		this.iconbtnAcao = new ImageIcon(getClass().getResource("Ação.png"));
		this.lblbtnAcao = new JLabel(iconbtnAcao);
		this.lblbtnAcao.setToolTipText("Dados de Ação");
		this.lblbtnAcao.setBounds(135, 225, 110, 110);
		this.lblbtnAcao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnAcao.setIcon(iconbtnAcao);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnAcao.setIcon(iconbtnAcao);
			}
		});
		this.add(lblbtnAcao);
		
		this.lblAcao = new JLabel("Ação");
		this.lblAcao.setForeground(new Color(90,61,171));
		this.lblAcao.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblAcao.setBounds(175,320,100, 20);
		this.add(lblAcao);
		
		this.iconbtnSalvar = new ImageIcon(getClass().getResource("Icone Salvar2.png"));
		this.lblbtnSalvar = new JLabel(iconbtnSalvar);
		this.lblbtnSalvar.setToolTipText("Salvar");
		this.lblbtnSalvar.setBounds(25, 315, 120, 120);
		this.lblbtnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnSalvar.setIcon(iconbtnSalvar);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSalvar.setIcon(iconbtnSalvar);
			}
		});
		this.add(lblbtnSalvar);
		
		this.lblSalvar = new JLabel("Salvar");
		this.lblSalvar.setForeground(new Color(90,61,171));
		this.lblSalvar.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblSalvar.setBounds(60,405,100, 20);
		this.add(lblSalvar);	
		
		this.iconbtnSair = new ImageIcon(getClass().getResource("icone sair.png"));
		this.lblbtnSair = new JLabel(iconbtnSair);
		this.lblbtnSair.setToolTipText("Salvar");
		this.lblbtnSair.setBounds(125, 320, 120, 120);
		this.lblbtnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnSair.setIcon(iconbtnSair);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSair.setIcon(iconbtnSair);
			}
		});
		this.add(lblbtnSair);
		
		this.lblSair = new JLabel("Sair");
		this.lblSair.setForeground(new Color(90,61,171));
		this.lblSair.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblSair.setBounds(170,405,100, 20);
		this.add(lblSair);
        
		
		
		this.txtaResultados = new JTextArea();
		this.txtaResultados.setLineWrap(true);
		this.txtaResultados.setWrapStyleWord(true);
		this.txtaResultados.setEditable(false);
		this.txtaResultados.setFont(new Font("Arial", Font.PLAIN, 8));

		this.spResultados = new JScrollPane(txtaResultados);
		this.spResultados.setBounds(260, 260, 270, 150);
		this.spResultados.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90,61,171), 3));
		this.add(spResultados);

		this.combateWall = new ImageIcon(getClass().getResource("Dados e Combate.png"));
		this.combateWall = new ImageIcon(combateWall.getImage().getScaledInstance(580,500, Image.SCALE_DEFAULT));
		this.bckgCombate = new JLabel(combateWall);
		this.bckgCombate.setBounds(-10,-10, 580,500);
		this.add(bckgCombate);
		
}

public static void abre() {
	AreaDeCombateVIEW frame = new AreaDeCombateVIEW();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setVisible(true);
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((tela.width - frame.getSize().width)/2,(tela.height - frame.getSize().height)/2);

}
}