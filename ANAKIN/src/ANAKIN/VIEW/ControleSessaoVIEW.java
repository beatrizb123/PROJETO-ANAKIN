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
import java.util.ArrayList;
import java.util.Iterator;

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
	private JButton btnAdd, btnLimpar;
	private ImageIcon imgIcon;
	private DefaultListModel modelo; //
	private JList list;
	private JScrollPane spInventario, spAnotacao;
	private JTextField txtInventario;
	private JTextArea txtAnotacao;

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

		this.modelo = new DefaultListModel(); // eu ñ sei oq modelo é mas é importante
		this.list = new JList(modelo);

		this.btnAdd = new JButton("+");

		// EVENTO DO BOTÃO ADICIONAR (+) aqui pq ñ sei arrumar lá
		// botão que adiciona itens a Jlist

		this.btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itens = txtInventario.getText();

				// itens = coisas do inventario
				// laço que pega a string itens

				if (itens.length() != 0) {
					((DefaultListModel) (list.getModel())).addElement(itens);

					txtInventario.setText("");
					txtInventario.requestFocus();
				}
			}
		});

		this.btnAdd.setBounds(420, 240, 45, 25);
		this.btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnAdd.setBackground(new Color(90, 61, 171));
		this.btnAdd.setForeground(Color.white);
		this.btnAdd.setToolTipText("Adiciona Item");

		this.spInventario = new JScrollPane(list);
		this.spInventario.setBounds(250, 35, 215, 200);
		this.spInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 5));
		// sp.add(list);
		this.container.add(spInventario);

		this.txtInventario = new JTextField(10);
		this.txtInventario.setBounds(250, 240, 170, 25);
		this.add(txtInventario);
		this.add(btnAdd);

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

		this.container.add(spAnotacao);

		// BOTÃO DE LIMPAR APAGA TUDO DO TXTANOTACAO

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

	}
}