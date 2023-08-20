package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ANAKIN.MODEL.DAO.ControleSessaoDAO;
import ANAKIN.MODEL.VO.ControleSessaoVO;

public class ControleSessaoVIEW extends JFrame {

	private Container container;
	private JTextArea areaPersonagem;
	private JLabel lblInventario, lblAnotacoes;
	private JButton btnAdd, btnLimpar, btnSalvar, btnRemove;
	private ImageIcon imgIcon;
	private DefaultListModel modelo;
	private JList list;
	private JScrollPane sp, spAnotacao;
	private JTextField txt;
	private JTextArea txtAnotacao;
	private final static String novaLinha = "\n";

	public ControleSessaoVIEW() {
		// instanciação dos objetos

		this.setTitle("Controle de Sessao ★ ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 940, 550);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		this.container = getContentPane();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

		this.lblInventario = new JLabel("INVENTÁRIO");
		this.lblInventario.setBounds(275, 3, 155, 40);
		this.lblInventario.setForeground(new Color(90, 61, 171));
		this.lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblInventario.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblInventario);

		this.modelo = new DefaultListModel();
		this.list = new JList(modelo);

		this.btnAdd = new JButton("+");
		this.btnAdd.setFont(new Font("Arial", Font.BOLD, 12));
		this.btnAdd.setBounds(380, 240, 43, 25);
		this.btnAdd.setBackground(new Color(90, 61, 171));
		this.btnAdd.setForeground(Color.white);
		this.btnAdd.setToolTipText("Adiciona Item");
		this.btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = txt.getText();
				String [] armazena = {};
				for (int i = 1; i<=20; i++) {
					if (item.length() != 0) {
						((DefaultListModel) (list.getModel())).addElement(item);
						armazena[i] = item;
						
						System.out.println(armazena);
						txt.setText("");
						txt.requestFocus();
					}
					
					if (i == 20) {
						JOptionPane.showMessageDialog(null, "INVENTÁRIO LOTADO, REMOVA ALGUM ITEM!!");
						
					}
				}

			}

		});
		this.add(btnAdd);

		this.btnRemove = new JButton("-");
		this.btnRemove.setFont(new Font("Arial", Font.BOLD, 12));
		this.btnRemove.setBounds(423, 240, 43, 25);
		this.btnRemove.setBackground(new Color(90, 61, 171));
		this.btnRemove.setForeground(Color.white);
		this.btnRemove.setToolTipText("Remover Item");
		this.btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.remove(list.getSelectedIndex());
				list.setModel(modelo);

			}

		});
		this.add(btnRemove);

		ListSelectionModel sm = list.getSelectionModel();
		int index = sm.getMinSelectionIndex();
		if (index >= 0)
			modelo.remove(index);

		this.sp = new JScrollPane(list);

		this.sp.setBounds(250, 35, 216, 200);
		this.sp.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 5));
		this.container.add(sp);

		this.txt = new JTextField(10);
		this.txt.setBounds(250, 240, 130, 25);
		this.add(txt);

		this.lblAnotacoes = new JLabel("ANOTAÇÕES");
		this.lblAnotacoes.setBounds(595, 3, 155, 40);
		this.lblAnotacoes.setForeground(new Color(90, 61, 171));
		this.lblAnotacoes.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAnotacoes.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblAnotacoes);

		this.txtAnotacao = new JTextArea();
		this.spAnotacao = new JScrollPane(txtAnotacao);
		this.spAnotacao.setBounds(500, 35, 360, 200);
		this.spAnotacao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 5));
		// sp.add(list);
		this.container.add(spAnotacao);

		this.btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtAnotacao.setText("");

			}
		});

		this.btnLimpar.setBounds(500, 240, 100, 25);
		this.btnLimpar.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnLimpar.setBackground(new Color(90, 61, 171));
		this.btnLimpar.setForeground(Color.white);
		this.btnLimpar.setToolTipText("Apaga anotações");
		this.add(btnLimpar);

		this.btnSalvar = new JButton("Salva");
		this.btnSalvar.setBounds(50, 35, 100, 25);
		this.btnSalvar.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnSalvar.setBackground(new Color(90, 61, 171));
		this.btnSalvar.setForeground(Color.white);
		this.btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControleSessaoDAO cont = new ControleSessaoDAO();
				ControleSessaoVO infor = new ControleSessaoVO();

				String nome, inventario, anotacoes;
				nome = new MenuPrincipalVIEW().getJP();
				anotacoes = txtAnotacao.getText();

				infor.setNome_sessao(nome);
				infor.setAnotacoes_sessao(anotacoes);

				cont.salvarInformacoes(infor);

			}
		});
		this.add(btnSalvar);
	}
}
