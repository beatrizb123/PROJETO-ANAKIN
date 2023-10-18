package ANAKIN.VIEW;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ANAKIN.MODEL.BO.CartasBO;
import ANAKIN.MODEL.BO.DadosBO;

public class CartasVantagemVIEW extends JFrame {
	private Container container;
	private JPanel jp;

	private JLabel lblEsforco, lblFascinar;
	private JLabel lblEstudo, lblIntuicao;
	private JLabel lblAlgazarra, lblSorte;

	private JLabel lblDescEsforco, lblDescFascinar;
	private JLabel lblDescEstudo, lblDescIntuicao;
	private JLabel lblDescAlgazarra, lblDescSorte;

	private JLabel lblBonusEsforco, lblBonusFascinar;
	private JLabel lblBonusEstudo, lblBonusIntuicao;
	private JLabel lblBonusAlgazarra, lblBonusSorte;

	private JPanel jpEsfoco, jpFascinar;
	private JPanel jpEstudo, jpIntuicao;
	private JPanel jpAlgazarra, jpSorte;

	private JButton btnEsforco, btnFascinar;
	private JButton btnEstudo, btnIntuicao;
	private JButton btnAlgazarra, btnSorte;

	private ImageIcon imgIcon;

	String Alinhamento[] = { "Bom", "Neutro", "Mal" };
	String Talento[] = { "Esforço", "Fascinar", "Estudo", "Intuição", "Algazarra", "Sorte" };
	String Descricao[] = { "<html>Seu instinto altruísta ajuda as pessoas! <br> Isso te enche de determinação.</html>",
			"<html>Você consegue ser positivo as vezes.  <br> Isso cativa todos ao seu redor. </html>",
			"Sua imparcialidade o torna mais sábio.",
			"<html>É mais fácil ler outros... <br> ...quando não se tem inclinações morais…?</html>",
			"<html>Desafie aqueles que são livres das correntes do universo. <br> Imponha sua presença àqueles que estão presos com você.</html>",
			"O universo pode estar ao seu favor." };

	String Bonus[] = { "Ganha +3 em testes de Força e Agilidade", "Ganha 1D6 em testes de Carisma",
			"Ganha +4 em testes de Poder e Intelecto", "Ganha 1D4 em teste de Carisma",
			"Ganha 1D8 em Força e Intelecto", "Ganhe +2 em testes de Agilidade e Poder", };



	public CartasVantagemVIEW() {
		this.setBackground(new Color(250, 247, 255));
		this.setTitle("Cartas de Vantagem");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 400, 510);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.container = getContentPane();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/jupiter.png")));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		scrollPane.setBackground(new Color(235, 223, 255));
		scrollPane.setBounds(10, 10, 370, 450);
		add(scrollPane);

		JPanel borderlaoutpanel = new JPanel();
		scrollPane.setViewportView(borderlaoutpanel);
		borderlaoutpanel.setLayout(new BorderLayout(0, 0));

		JPanel columnpanel = new JPanel();
		borderlaoutpanel.add(columnpanel, BorderLayout.NORTH);
		columnpanel.setLayout(new GridLayout(0, 1, 0, 6));
		columnpanel.setBackground(new Color(235, 223, 255));

		// Esforço
		this.jpEsfoco = new JPanel();
		this.jpEsfoco.setPreferredSize(new Dimension(70, 140));
		columnpanel.add(jpEsfoco);
		this.jpEsfoco.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(235, 223, 255), 4));
		this.jpEsfoco.setBackground(new Color(250, 247, 255));
		this.jpEsfoco.setLayout(new GridLayout(4, 1));

		this.lblEsforco = new JLabel(Talento[0]);
		this.lblEsforco.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblEsforco.setForeground(new Color(90, 61, 171));
		this.jpEsfoco.add(lblEsforco);

		this.lblDescEsforco = new JLabel(Descricao[0]);
		this.lblDescEsforco.setFont(new Font("Helvatica", Font.PLAIN, 14));
		this.jpEsfoco.add(lblDescEsforco);

		this.lblBonusEsforco = new JLabel(Bonus[0]);
		this.lblBonusEsforco.setFont(new Font("Helvatica", Font.BOLD, 14));
		this.jpEsfoco.add(lblBonusEsforco);

		this.btnEsforco = new JButton("+");
		this.btnEsforco.setForeground(new Color(90, 61, 171));
		this.btnEsforco.setBackground(Color.WHITE);
		this.btnEsforco.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CartasBO bonus = new CartasBO();
				int valor = bonus.pontosEsfoco();
				
				DadosBO teste = new DadosBO();
				
				setVisible(false);
			}
		});
		this.jpEsfoco.add(btnEsforco);

		// Fascinar
		this.jpFascinar = new JPanel();
		this.jpFascinar.setPreferredSize(new Dimension(70, 140));
		columnpanel.add(jpFascinar);
		this.jpFascinar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(235, 223, 255), 4));
		this.jpFascinar.setBackground(new Color(250, 247, 255));
		this.jpFascinar.setLayout(new GridLayout(4, 1));

		this.lblFascinar = new JLabel(Talento[1]);
		this.lblFascinar.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblFascinar.setForeground(new Color(90, 61, 171));
		this.jpFascinar.add(lblFascinar);

		this.lblDescFascinar = new JLabel(Descricao[1]);
		this.lblDescFascinar.setFont(new Font("Helvatica", Font.PLAIN, 14));
		this.jpFascinar.add(lblDescFascinar);

		this.lblBonusFascinar = new JLabel(Bonus[1]);
		this.lblBonusFascinar.setFont(new Font("Helvatica", Font.BOLD, 14));
		this.jpFascinar.add(lblBonusFascinar);

		this.btnFascinar = new JButton("+");
		this.btnFascinar.setForeground(new Color(90, 61, 171));
		this.btnFascinar.setBackground(Color.WHITE);
		this.btnFascinar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CartasBO bonus = new CartasBO();
				int valor = bonus.pontosFascinar();
			
				setVisible(false);
				
			}
		});
		this.jpFascinar.add(btnFascinar);

		// Estudo
		this.jpEstudo = new JPanel();
		this.jpEstudo.setPreferredSize(new Dimension(70, 140));
		columnpanel.add(jpEstudo);
		this.jpEstudo.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(235, 223, 255), 4));
		this.jpEstudo.setBackground(new Color(250, 247, 255));
		this.jpEstudo.setLayout(new GridLayout(4, 1));

		this.lblEstudo = new JLabel(Talento[2]);
		this.lblEstudo.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblEstudo.setForeground(new Color(90, 61, 171));
		this.jpEstudo.add(lblEstudo);

		this.lblDescEstudo = new JLabel(Descricao[2]);
		this.lblDescEstudo.setFont(new Font("Helvatica", Font.PLAIN, 14));
		this.jpEstudo.add(lblDescEstudo);

		this.lblBonusEstudo = new JLabel(Bonus[2]);
		this.lblBonusEstudo.setFont(new Font("Helvatica", Font.BOLD, 14));
		this.jpEstudo.add(lblBonusEstudo);

		this.btnEstudo = new JButton("+");
		this.btnEstudo.setForeground(new Color(90, 61, 171));
		this.btnEstudo.setBackground(Color.WHITE);
		this.btnEstudo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CartasBO bonus = new CartasBO();
				int valor = bonus.pontosEstudo();
				
				
				setVisible(false);
			}
		});
		this.jpEstudo.add(btnEstudo);

		// Intuição
		this.jpIntuicao = new JPanel();
		this.jpIntuicao.setPreferredSize(new Dimension(70, 140));
		columnpanel.add(jpIntuicao);
		this.jpIntuicao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(235, 223, 255), 4));
		this.jpIntuicao.setBackground(new Color(250, 247, 255));
		this.jpIntuicao.setLayout(new GridLayout(4, 1));

		this.lblIntuicao = new JLabel(Talento[3]);
		this.lblIntuicao.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblIntuicao.setForeground(new Color(90, 61, 171));
		this.jpIntuicao.add(lblIntuicao);

		this.lblDescIntuicao = new JLabel(Descricao[3]);
		this.lblDescIntuicao.setFont(new Font("Helvatica", Font.PLAIN, 14));
		this.jpIntuicao.add(lblDescIntuicao);

		this.lblBonusIntuicao = new JLabel(Bonus[3]);
		this.lblBonusIntuicao.setFont(new Font("Helvatica", Font.BOLD, 14));
		this.jpIntuicao.add(lblBonusIntuicao);

		this.btnIntuicao = new JButton("+");
		this.btnIntuicao.setForeground(new Color(90, 61, 171));
		this.btnIntuicao.setBackground(Color.WHITE);
		this.btnIntuicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CartasBO bonus = new CartasBO();
				int valor = bonus.pontosIntuicao();
			
				
				setVisible(false);
			}
		});
		this.jpIntuicao.add(btnIntuicao);

		// Algazarra
		this.jpAlgazarra = new JPanel();
		this.jpAlgazarra.setPreferredSize(new Dimension(70, 140));
		columnpanel.add(jpAlgazarra);
		this.jpAlgazarra.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(235, 223, 255), 4));
		this.jpAlgazarra.setBackground(new Color(250, 247, 255));
		this.jpAlgazarra.setLayout(new GridLayout(4, 1));

		this.lblAlgazarra = new JLabel(Talento[4]);
		this.lblAlgazarra.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblAlgazarra.setForeground(new Color(90, 61, 171));
		this.jpAlgazarra.add(lblAlgazarra);

		this.lblDescAlgazarra = new JLabel(Descricao[4]);
		this.lblDescAlgazarra.setFont(new Font("Helvatica", Font.PLAIN, 13));
		this.jpAlgazarra.add(lblDescAlgazarra);

		this.lblBonusAlgazarra = new JLabel(Bonus[4]);
		this.lblBonusAlgazarra.setFont(new Font("Helvatica", Font.BOLD, 14));
		this.jpAlgazarra.add(lblBonusAlgazarra);

		this.btnAlgazarra = new JButton("+");
		this.btnAlgazarra.setForeground(new Color(90, 61, 171));
		this.btnAlgazarra.setBackground(Color.WHITE);
		this.btnAlgazarra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CartasBO bonus = new CartasBO();
				int valor = bonus.pontosAlgazarra();
				
				
				setVisible(false);
			}
		});
		this.jpAlgazarra.add(btnAlgazarra);

		// Sorte
		this.jpSorte = new JPanel();
		this.jpSorte.setPreferredSize(new Dimension(70, 140));
		columnpanel.add(jpSorte);
		this.jpSorte.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(235, 223, 255), 4));
		this.jpSorte.setBackground(new Color(250, 247, 255));
		this.jpSorte.setLayout(new GridLayout(4, 1));

		this.lblSorte = new JLabel(Talento[5]);
		this.lblSorte.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblSorte.setForeground(new Color(90, 61, 171));
		this.jpSorte.add(lblSorte);

		this.lblDescSorte = new JLabel(Descricao[5]);
		this.lblDescSorte.setFont(new Font("Helvatica", Font.PLAIN, 14));
		this.jpSorte.add(lblDescSorte);

		this.lblBonusSorte = new JLabel(Bonus[5]);
		this.lblBonusSorte.setFont(new Font("Helvatica", Font.BOLD, 14));
		this.jpSorte.add(lblBonusSorte);

		this.btnSorte = new JButton("+");
		this.btnSorte.setForeground(new Color(90, 61, 171));
		this.btnSorte.setBackground(Color.WHITE);
		this.btnSorte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CartasBO bonus = new CartasBO();
				int valor = bonus.pontosSorte();
			
				
				setVisible(false);
			}
		});
		this.jpSorte.add(btnSorte);

	}

	public static void main(String[] args) {
		CartasVantagemVIEW tela = new CartasVantagemVIEW();
		tela.setVisible(true);
	}

}
