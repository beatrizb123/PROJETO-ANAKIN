package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ANAKIN.MODEL.DAO.AbrirSessaoDAO;
import ANAKIN.MODEL.DAO.BuscarSessaoDAO;
import ANAKIN.MODEL.DAO.CadastroDAO;
import ANAKIN.MODEL.DAO.ConexaoDAO;
import ANAKIN.MODEL.DAO.ControleSessaoDAO;
import ANAKIN.MODEL.DAO.ManterSessaoDAO;
import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class MinhasSessoesVIEW extends JFrame {

	private Container container;
	private ImageIcon imgIcon;
	private JLabel lblMs, lblMens;
	private JTextField tfBusca;

	private JButton btnBusca, btnAbrir, btnCancelar;
	private JLabel label1;
	private JTextField tfSQL;
	private JButton btExecutar;
	private JComboBox cbSessoes;
	private ScrollPane recebelista = new ScrollPane();

	private PreparedStatement statement;
	private ResultSet resultSet;
	JList<String> listasessoes;

	public MinhasSessoesVIEW() {

		this.setTitle("Projeto ANAKIN ★ ");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 300, 350);
		this.setLayout(null);
		this.setResizable(false);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));

		this.lblMs = new JLabel("Minhas Sessões");
		this.lblMs.setBounds(30, 15, 200, 25);
		this.lblMs.setForeground(new Color(90, 61, 171));
		this.lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMs.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(lblMs);

		this.lblMens = new JLabel("Insira o nome da sua sessão:");
		this.lblMens.setBounds(10, 45, 200, 25);
		this.lblMens.setForeground(new Color(90, 61, 171));
		this.lblMens.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblMens.setFont(new Font("Arial", Font.BOLD, 13));
		this.add(lblMens);

		this.tfBusca = new JTextField(20);
		this.tfBusca.setBounds(20, 75, 130, 25);
		this.add(tfBusca);

		this.recebelista.setBounds(20, 120, 240, 110);
		add(recebelista);

		this.btnBusca = new JButton("Buscar");
		this.btnBusca.setBounds(160, 75, 100, 25);
		this.btnBusca.setBackground(new Color(90, 61, 171));
		this.btnBusca.setForeground(Color.WHITE);
		this.btnBusca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String usuarionome = null;
					UsuarioVO user = new UsuarioVO();
					ManterSessaoDAO Msd = new ManterSessaoDAO();
					ControleSessaoDAO nomessessao = new ControleSessaoDAO();
					String recebenome = tfBusca.getText();
					if (Msd.chamar() != null) {
						usuarionome = Msd.chamar();
					} else {
						recebenome = user.getNome_Usuario();
					}
					ArrayList<String> resgistro = nomessessao.chamarinformacoes(recebenome, usuarionome);
					listasessoes = new JList<>(resgistro.toArray(new String[0]));
					listasessoes.setFont(new Font("Arial", Font.BOLD, 15));
					recebelista.add(listasessoes);

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "algo deu errado");
				}

			}
		});
		this.add(btnBusca);

		String[] dados = null;
		BuscarSessaoDAO bs = new BuscarSessaoDAO();

		this.cbSessoes = new JComboBox<Object>(bs.retornaNomes(dados));
		this.cbSessoes.setBounds(20, 250, 240, 30);
		this.cbSessoes.setBackground(Color.white);
		this.cbSessoes.setForeground(Color.black);
		//this.add(cbSessoes);

		this.btnAbrir = new JButton("Abrir");
		this.btnAbrir.setBounds(35, 250, 100, 25);
		this.btnAbrir.setBackground(new Color(90, 61, 171));
		this.btnAbrir.setForeground(Color.WHITE);
		this.btnAbrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			UsuarioVO UV = new UsuarioVO();
			ManterSessaoDAO MSD = new ManterSessaoDAO();
			AbrirSessaoDAO ASD = new AbrirSessaoDAO();
			String nomeusuario;
			String nome =listasessoes.getSelectedValue();
			System.out.println("sessao selecionada :" + nome);
			
			if(MSD.chamar() != null) {
				nomeusuario = MSD.chamar(); 
			}else {	
				nomeusuario = UV.getNome_Usuario();
			}
			AuxiliarVO AV = new AuxiliarVO();
			int id = ASD.RetornaIdSessao(nome, nomeusuario);
			AV.setIdsessao(id);
			ASD.SessaoAcessada(id, nome);
			ControleSessaoVIEW CSV = new ControleSessaoVIEW();
				
				CSV.setVisible(true);
				setVisible(false);
			}
		});
		this.add(btnAbrir);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(145, 250, 100, 25);
		this.btnCancelar.setBackground(new Color(90, 61, 171));
		this.btnCancelar.setForeground(Color.WHITE);
		this.btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuPrincipalVIEW tela = new MenuPrincipalVIEW();
				tela.setVisible(true);

			}
		});
		this.add(btnCancelar);

	}
}
	