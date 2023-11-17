package TelasProjeto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ExcluirContaVIEW extends JFrame {
	
	private JLabel lblUser, lblSenha, lblConfirmar;
	private JTextField txtUser, txtSenha;
	private JButton btnCancelar, btnConfirmar;
	private ImageIcon imgIcon;
	private ImageIcon fichaWall;
	private JLabel bckgTela;
	
	public ExcluirContaVIEW() {
		
		this.setTitle("Excluir Conta");
		this.setResizable(false);
		this.setLayout(null);
		this.setBounds(300, 200, 300, 250);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
		
		//this.imgIcon = new ImageIcon("jupiter.png");
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/jupiter.png")));

		this.lblUser = new JLabel("INFORME SEU NOME DE USUÁRIO:");
		this.lblUser.setBounds(10, 10, 300, 25);
		this.lblUser.setForeground(new Color(90, 61, 171));
		this.lblUser.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblUser);

		this.txtUser = new JTextField(1);
		this.txtUser.setBounds(10, 40, 130, 25);
		this.add(txtUser);

		this.lblSenha = new JLabel("INFORME SUA SENHA:");
		this.lblSenha.setBounds(10, 70, 300, 25);
		this.lblSenha.setForeground(new Color(90, 61, 171));
		this.lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblSenha);

		this.txtSenha = new JTextField(1);
		this.txtSenha.setBounds(10, 100, 130, 25);
		this.add(txtSenha);
		
		this.lblConfirmar = new JLabel("CONFIRMAR EXCLUSÃO:");
		this.lblConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblConfirmar.setBounds(-05, 140, 300, 25);
		this.lblConfirmar.setForeground(new Color(90, 61, 171));
		this.lblConfirmar.setFont(new Font("Arial", Font.BOLD, 14));
		this.add(lblConfirmar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(15, 170, 120, 25);
		this.btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		this.btnCancelar.setBackground(new Color(90, 61, 171));
		this.btnCancelar.setForeground(Color.white);
		this.add(btnCancelar);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBounds(150, 170, 120, 25);
		this.btnConfirmar.setFont(new Font("Arial", Font.BOLD, 13));
		this.btnConfirmar.setBackground(new Color(90, 61, 171));
		this.btnConfirmar.setForeground(Color.white);
		this.add(btnConfirmar);
		
		this.fichaWall = new ImageIcon(getClass().getResource("Fichas.png"));
		this.fichaWall = new ImageIcon(fichaWall.getImage().getScaledInstance(580, 500, Image.SCALE_DEFAULT));
		this.bckgTela = new JLabel(fichaWall);
		this.bckgTela.setBounds(-10, -10, 580, 500);
		this.add(bckgTela);
		
		
	}

	public static void abre() {
		ExcluirContaVIEW frame = new ExcluirContaVIEW();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width)/2,(tela.height - frame.getSize().height)/2);
	}
	
	public static void main(String[] args) {
		ExcluirContaVIEW.abre();
	}
	}