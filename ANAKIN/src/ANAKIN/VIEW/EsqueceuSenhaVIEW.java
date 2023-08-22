package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ANAKIN.MODEL.DAO.MudarInfoDAO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class EsqueceuSenhaVIEW extends JFrame{
	private Container cont;
	private JLabel lblId, lblUser, lblSenha;
	private JTextField tfId, tfUser, tfSenha;
	private JButton btnConfirmar;
	
	public EsqueceuSenhaVIEW() {
		this.setTitle("Mudar a senha");
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(300, 200, 300, 250);
		this.setBackground(new Color(250, 247, 255));
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.lblId = new JLabel("INFORME O ID DA SUA CONTA:");
		this.lblId.setBounds(10, 10, 300, 25);
		this.lblId.setForeground(new Color(90, 61, 171));
		this.lblId.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblId);
		
		this.tfId = new JTextField(1);
		this.tfId.setBounds(10, 40, 130, 25);
		this.add(tfId);
		
		this.lblUser = new JLabel("INFORME SEU USUARIO:");
		this.lblUser.setBounds(10, 70, 300, 25);
		this.lblUser.setForeground(new Color(90, 61, 171));
		this.lblUser.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblUser);
		
		this.tfUser = new JTextField(1);
		this.tfUser.setBounds(10, 100, 130, 25);
		this.add(tfUser);
		
		this.lblSenha = new JLabel("INFORME SUA NOVA SENHA:");
		this.lblSenha.setBounds(10, 130, 300, 25);
		this.lblSenha.setForeground(new Color(90, 61, 171));
		this.lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblSenha);
		
		this.tfSenha = new JTextField(14);
		this.tfSenha.setBounds(10, 150, 130, 25);
		this.add(tfSenha);
		
		this.btnConfirmar = new JButton("CONFIRMAR");
		this.btnConfirmar.setBounds(10, 180, 120, 25);
		this.btnConfirmar.setFont(new Font("Arial", Font.BOLD, 13));
		this.btnConfirmar.setBackground(new Color(90, 61, 171));
		this.btnConfirmar.setForeground(Color.white);
		this.btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id;
				String nome, senha;
				
				id = Integer.parseInt(tfId.getText());
				nome = tfUser.getText();
				senha = tfSenha.getText();
				
				UsuarioVO user = new UsuarioVO();
				user.setId_usuario(id);
				user.setNome_usuario(nome);
				user.setSenha_usuario(senha);
				
				if (id == 0 || nome == null || senha == null){
					JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
				}
				
				MudarInfoDAO muda = new MudarInfoDAO();
				muda.mudaSenha(user);
				
				JOptionPane.showMessageDialog(null, "DADOS ALTERADOS");
				setVisible(false);
				
				
			}
		});
		this.add(btnConfirmar);

		
		
	}
}
