package TelasProjeto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class InfoUsuarioVIEW extends JFrame {
	
	Container container;
	ImageIcon imgIcon;
	JPanel panel;
	JLabel lblPersonagens, lblNpcs, lblCombate, lblInfo;
	JLabel qtdPersonagens, qtdNpcs, stsCombate;
	private JPanel jpSessoes;
	private JScrollPane spSessoes;
	private JPanel jpColumn;
	private JPanel jpRow;
	private JButton btnProximo;
	private JButton btnAnterior;
	private JLabel lblSessoes;
	private ImageIcon menuWall;
	private JLabel bckgMenu;

	public InfoUsuarioVIEW() {
		this.setTitle("Informações ★ ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 535, 270);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		this.setResizable(false);
		
		this.container = getContentPane();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));
		
		this.lblSessoes = new JLabel("Sessões Criadas");
		this.lblSessoes.setBounds(15, 10, 210, 25);
		this.lblSessoes.setForeground(new Color(90, 61, 171));
		this.lblSessoes.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblSessoes.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(lblSessoes);
		
		this.spSessoes = new JScrollPane();
		this.spSessoes.setBounds(30, 35, 180, 160);
		this.spSessoes.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.container.add(spSessoes);
		
		
		this.jpSessoes = new JPanel();
		this.spSessoes.setViewportView(jpSessoes);
		this.jpSessoes.setLayout(new BorderLayout(0, 0));
		this.add(spSessoes);
		
		this.jpColumn = new JPanel();
		this.jpSessoes.add(jpColumn, BorderLayout.NORTH);
		this.jpColumn.setLayout(new GridLayout(0, 1, 0, 1));
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
			
		//}
		
				
				
				/*int i = 0; i < 9; i++) {
			this.jpRow = new JPanel();
			this.jpRow.setPreferredSize(new Dimension(150, 30));
			this.jpColumn.add(jpRow);
			this.jpRow.setLayout(null);
			JButton botao = new JButton("Protagonista");
			botao.setBounds(12, 5, 145, 20);
			this.jpRow.add(botao);
			if (i % 2 == 0)
				this.jpRow.setBackground(SystemColor.inactiveCaptionBorder);*/
		//}

		
		this.panel = new JPanel();
		this.panel.setBounds(240,35,250,160);
		this.panel.setLayout(null);
		this.panel.setBackground(new Color(235,223,255));
		this.panel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.container.add(panel);
		
		this.lblInfo = new JLabel("Informações");
		this.lblInfo.setBounds(25, 5, 210, 25);
		this.lblInfo.setForeground(new Color(90, 61, 171));
		this.lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblInfo.setFont(new Font("Arial", Font.BOLD, 16));
		this.panel.add(lblInfo);
		
		this.lblPersonagens = new JLabel("Quantidade de personagens:");
		this.lblPersonagens.setBounds(5, 35, 210, 25);
		this.lblPersonagens.setForeground(new Color(90, 61, 171));
		this.lblPersonagens.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblPersonagens.setFont(new Font("Arial", Font.BOLD, 14));
		this.panel.add(lblPersonagens);
		
		this.qtdPersonagens = new JLabel("5");
		this.qtdPersonagens.setBounds(120, 35, 210, 25);
		this.qtdPersonagens.setForeground(new Color(90, 61, 171));
		this.qtdPersonagens.setHorizontalAlignment(SwingConstants.CENTER);
		this.qtdPersonagens.setFont(new Font("Arial", Font.BOLD, 15));
		this.panel.add(qtdPersonagens);
		
		
		this.lblNpcs = new JLabel("Quantidade de NPC's:");
		this.lblNpcs.setBounds(-22, 65, 210, 25);
		this.lblNpcs.setForeground(new Color(90, 61, 171));
		this.lblNpcs.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNpcs.setFont(new Font("Arial", Font.BOLD, 14));
		this.panel.add(lblNpcs);
		
		this.qtdNpcs = new JLabel("5");
		this.qtdNpcs.setBounds(65, 65, 210, 25);
		this.qtdNpcs.setForeground(new Color(90, 61, 171));
		this.qtdNpcs.setHorizontalAlignment(SwingConstants.CENTER);
		this.qtdNpcs.setFont(new Font("Arial", Font.BOLD, 15));
		this.panel.add(qtdNpcs);

		this.lblCombate = new JLabel("Status de Combate:");
		this.lblCombate.setBounds(-18, 95, 190, 25);
		this.lblCombate.setForeground(new Color(90, 61, 171));
		this.lblCombate.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblCombate.setFont(new Font("Arial", Font.BOLD, 14));
		this.panel.add(lblCombate);
		
		this.stsCombate = new JLabel("Ativo");
		this.stsCombate.setBounds(65, 95, 210, 25);
		this.stsCombate.setForeground(new Color(90, 61, 171));
		this.stsCombate.setHorizontalAlignment(SwingConstants.CENTER);
		this.stsCombate.setFont(new Font("Arial", Font.BOLD, 15));
		this.panel.add(stsCombate);

		this.btnProximo = new JButton(">");
		this.btnProximo.setBounds(200, 130, 45, 25);
		this.btnProximo.setBackground(new Color(90, 61, 171));
		this.btnProximo.setFont(new Font("Arial", Font.BOLD,12));
		this.btnProximo.setForeground(Color.WHITE);
		this.panel.add(btnProximo);
		
		this.btnAnterior = new JButton("<");
		this.btnAnterior.setBounds(5, 130, 45, 25);
		this.btnAnterior.setBackground(new Color(90, 61, 171));
		this.btnAnterior.setFont(new Font("Arial", Font.BOLD,12));
		this.btnAnterior.setForeground(Color.WHITE);
		this.panel.add(btnAnterior);
	
		
		this.menuWall = new ImageIcon(getClass().getResource("Dados e Combate.png"));
		this.menuWall = new ImageIcon(menuWall.getImage().getScaledInstance(560, 510, Image.SCALE_DEFAULT));
		this.bckgMenu = new JLabel(menuWall);
		this.bckgMenu.setBounds(0,0, 1366, 768);
		this.add(bckgMenu);
		
		}
	}
	
	public static void abre() {
		InfoUsuarioVIEW frame = new InfoUsuarioVIEW();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width)/2,(tela.height - frame.getSize().height)/2);
	}
}

