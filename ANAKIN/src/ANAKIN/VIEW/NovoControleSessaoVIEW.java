package ANAKIN.VIEW;

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
		this.setBounds(0, 0, 250, 200);
		this.setLayout(null);
		this.setResizable(false);
		
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/jupiter.png")));

		this.lblMsg = new JLabel("Nome do novo controle de sessão:");
		this.lblMsg.setBounds(20, 10, 200, 20);
		this.add(lblMsg);
		
		this.txtNome = new JTextField();
		this.txtNome.setBounds(25, 40, 180, 20);
		this.add(txtNome);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(25, 65, 80, 25);
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
		this.btnContinuar.setBounds(125, 65, 80, 25);
		this.btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				
				nomeSessao = txtNome.getText();
				
				NovoControleDAO novo = new NovoControleDAO();
				int id = novo.criarNovaSessao(nomeSessao);
				
				AuxiliarVO AV = new AuxiliarVO();
				AV.setIdsessao(id);
				
				ControleSessaoVO dados = new ControleSessaoVO();
				dados.setNome_sessao(nomeSessao);
				
				ControleSessaoVIEW sessao = new ControleSessaoVIEW();
				sessao.setVisible(true);
				
				MenuPrincipalVIEW tela = new MenuPrincipalVIEW();
				tela.setVisible(false);
			}
		});
		this.add(btnContinuar);
		
		
	}
}
