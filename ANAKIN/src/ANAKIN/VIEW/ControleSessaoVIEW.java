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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ANAKIN.MODEL.DAO.ControleSessaoDAO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class ControleSessaoVIEW extends JFrame {

	private Container container;
	private JLabel lblNome, lblInventario, lblAnotacoes, lblvolta;
	private JButton btnSalva, btnLimpar, btnRetorna, btnDados;
	private ImageIcon imgIcon;
	private JScrollPane spInventario, spAnotacao;
	private JTextArea txtAnotacao, txtInventario;
	private JTextField tfNome;

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

		this.txtInventario = new JTextArea();
		this.txtInventario.setFont(new Font("Helvetica", Font.BOLD, 14));
		this.txtInventario.setLineWrap(true);
		this.txtInventario.setWrapStyleWord(true);
		
		this.spInventario = new JScrollPane(txtInventario);
		this.spInventario.setBounds(250, 35, 215, 200);
		this.spInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 5));
		this.container.add(spInventario);

		this.lblAnotacoes = new JLabel("ANOTAÇÕES");
		this.lblAnotacoes.setBounds(595, 3, 155, 40);
		this.lblAnotacoes.setForeground(new Color(90, 61, 171));
		this.lblAnotacoes.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblAnotacoes.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblAnotacoes);

		this.lblInventario = new JLabel("INVENTARIO");
		this.lblInventario.setBounds(280, 3, 155, 40);
		this.lblInventario.setForeground(new Color(90, 61, 171));
		this.lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblInventario.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(lblInventario);

		this.txtAnotacao = new JTextArea();
		this.txtAnotacao.setFont(new Font("Helvetica", Font.PLAIN, 13));
		this.txtAnotacao.setLineWrap(true);
		this.txtAnotacao.setWrapStyleWord(true);
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
		this.btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.add(btnLimpar);

		this.lblNome = new JLabel("Nome da sessão:");
		this.lblNome.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblNome.setBounds(30, 35, 150, 25);
		this.lblNome.setForeground(new Color(90, 61, 171));
		this.add(lblNome);

		this.tfNome = new JTextField(20);
		this.tfNome.setBounds(30, 60, 180, 25);
		this.tfNome.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 4));
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
				
				String inventario, anotacoes, nome, usuario;

				nome = tfNome.getText();
				inventario = txtInventario.getText();
				anotacoes = txtAnotacao.getText();
				usuario = user.getNome_usuario();
				
				controle.setNome_sessao(nome);
				controle.setInventario_sessao(inventario);
				controle.setAnotacoes_sessao(anotacoes);
				controle.setFk_usuario(usuario);
				
				salvar.salvarInformacoes(controle);
				
				JOptionPane.showMessageDialog(null, "INFORMAÇÕES FORAM SALVAS!");
				

			}
		});
		this.add(btnSalva);

		this.btnDados = new JButton("DADOS");
		this.btnDados.setBounds(70, 135, 100, 30);
		this.btnDados.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnDados.setBackground(new Color(90, 61, 171));
		this.btnDados.setForeground(Color.white);
		this.btnDados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DadosdeJogoVIEW dados = new DadosdeJogoVIEW();
				dados.setVisible(true);
				
			}
		});
		this.add(btnDados);

		ImageIcon iconVoltar2 = new ImageIcon("voltar1.png");
		ImageIcon iconVoltar = new ImageIcon("voltar2.png");
		    lblvolta = new JLabel(iconVoltar);
		    lblvolta.setBackground(Color.black);
		    lblvolta.setBounds(20, 80, 70, 70);
		    lblvolta.setVisible(true);
		    lblvolta.addMouseListener( new MouseAdapter() {
		        @Override
					public void mouseEntered(MouseEvent e) {

						lblvolta.setIcon(iconVoltar2);;

					}

					@Override
					public void mouseExited(MouseEvent e) {
						lblvolta.setIcon(iconVoltar);
					}
		        
		        @Override
					public void mouseClicked(MouseEvent e) {

						MenuPrincipalVIEW tela = new MenuPrincipalVIEW();
						tela.setVisible(true);
					}
		    });
		    add(lblvolta);

	}
}