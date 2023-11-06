package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ANAKIN.MODEL.DAO.MudarInfoDAO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class EsqueceuSenhaVIEW extends JFrame {
	private Container cont;
	private JLabel lblUser, lblFilme, lblSenha;
	private JTextField txtfUser, txtfFilme, txtfSenha;
	private JButton btnConfirmar;
	private ImageIcon imgIcon;
	private ImageIcon fichaWall;
	private JLabel bckgTela;
	
	public EsqueceuSenhaVIEW() {
		this.setTitle("Alterar informacoes");
		this.setTitle("Mudar a senha");
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(300, 200, 300, 250);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
		
		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/jupiter.png")));

		
		this.lblUser = new JLabel("INFORME SEU NOME DE USUÁRIO:");
		this.lblUser.setBounds(10, 10, 300, 25);
		this.lblUser.setForeground(new Color(90, 61, 171));
		this.lblUser.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblUser);

		this.txtfUser = new JTextField(1);
		this.txtfUser.setBounds(10, 40, 130, 25);
		this.add(txtfUser);

		this.lblFilme = new JLabel("QUAL SEU FILME FAVORITO?");
		this.lblFilme.setBounds(10, 70, 300, 25);
		this.lblFilme.setForeground(new Color(90, 61, 171));
		this.lblFilme.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblFilme);

		this.txtfFilme = new JTextField(1);
		this.txtfFilme.setBounds(10, 100, 130, 25);
		this.add(txtfFilme);

		this.lblSenha = new JLabel("INFORME SUA NOVA SENHA:");
		this.lblSenha.setBounds(10, 130, 300, 25);
		this.lblSenha.setForeground(new Color(90, 61, 171));
		this.lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblSenha);

		this.txtfSenha = new JTextField(14);
		this.txtfSenha.setBounds(10, 150, 130, 25);
		this.add(txtfSenha);

		this.btnConfirmar = new JButton("CONFIRMAR");
		this.btnConfirmar.setBounds(10, 180, 120, 25);
		this.btnConfirmar.setFont(new Font("Arial", Font.BOLD, 13));
		this.btnConfirmar.setBackground(new Color(90, 61, 171));
		this.btnConfirmar.setForeground(Color.white);
		this.btnConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String nome, filme, senha;

				nome = txtfUser.getText();
				filme = txtfFilme.getText();
				senha = txtfSenha.getText();

				UsuarioVO user = new UsuarioVO();
				if (nome == user.getNome_Usuario() && filme == user.getFilme_Usuario()) {
					user.setNome_usuario(nome);
					user.setFilme_usuario(filme);
					user.setSenha_usuario(senha);

					MudarInfoDAO muda = new MudarInfoDAO();
					muda.mudaSenha(user);

					JOptionPane.showMessageDialog(null, "DADOS ALTERADOS");
					setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "DADOS INCORRETOS. TENTE NOVAMENTE");

				}
				if (filme == null || nome == null || senha == null) {
					JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
				}

			}
		});
		this.add(btnConfirmar);
		
		this.fichaWall = new ImageIcon(getClass().getResource("/Imagens/Fichas.png"));
		this.fichaWall = new ImageIcon(fichaWall.getImage().getScaledInstance(580, 500, Image.SCALE_DEFAULT));
		this.bckgTela = new JLabel(fichaWall);
		this.bckgTela.setBounds(-10, -10, 580, 500);
		this.add(bckgTela);

	}
}