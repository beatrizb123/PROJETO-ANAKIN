package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ANAKIN.MODEL.DAO.AbrirSessaoDAO;
import ANAKIN.MODEL.DAO.DadosDAO;
import ANAKIN.MODEL.DAO.NovoControleDAO;
import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.ControleSessaoVO;

public class NovoControleSessaoVIEW extends JFrame{
	private Container cont;
	private ImageIcon imgIcon;
	private JLabel lblMsg;
	private JTextField txtNome;
	private JButton btnContinuar, btnCancelar;
	
	private String nomeSessao;
	
	public NovoControleSessaoVIEW(){
		this.setTitle("Nova Sessão");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 280, 150);
		this.setLayout(null);
		this.setResizable(false);
		
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/jupiter.png")));

		this.lblMsg = new JLabel("Nome do novo controle de sessão:");
		this.lblMsg.setBounds(35, 10, 200, 20);
		this.add(lblMsg);
		
		this.txtNome = new JTextField();
		this.txtNome.setBounds(35, 35, 200, 25);
		this.add(txtNome);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(35, 75, 90, 25);
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
		
		this.btnContinuar = new JButton("Continuar");
		this.btnContinuar.setBounds(145, 75, 90, 25);
		this.btnContinuar.setBackground(new Color(90, 61, 171));
		this.btnContinuar.setForeground(Color.WHITE);
		this.btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				AbrirSessaoDAO ASD = new AbrirSessaoDAO();
				ASD.EncerraAcessoSessao();
				nomeSessao = txtNome.getText();
				
				NovoControleDAO novo = new NovoControleDAO();
				int id = novo.criarNovaSessao(nomeSessao);
				
				AuxiliarVO AV = new AuxiliarVO();
				AV.setIdsessao(id);
				
				ControleSessaoVO dados = new ControleSessaoVO();
				dados.setNome_sessao(nomeSessao);
				
				DadosDAO criarDados = new DadosDAO();
				criarDados.criarRegistro();
				
				ControleSessaoVIEW sessao = new ControleSessaoVIEW();
				sessao.setVisible(true);
				
				MenuPrincipalVIEW tela = new MenuPrincipalVIEW();
				tela.setVisible(false);
			}
		});
		this.add(btnContinuar);
		
		
	}
}
