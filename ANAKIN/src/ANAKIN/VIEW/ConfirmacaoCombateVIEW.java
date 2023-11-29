package ANAKIN.VIEW;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import ANAKIN.MODEL.DAO.IniciativaDAO;

public class ConfirmacaoCombateVIEW extends JFrame {
	private JPanel panel, p2;
	private JCheckBox check;
	private JCheckBox selecionaTudo;
	private ImageIcon imgIcon;
	private Border border;
	private JButton btConfirmar, btnCancelar;

	IniciativaDAO iniciDAO;
	ArrayList<String> nomesPerso;
	ArrayList<String> persoSelecionado;

	public ConfirmacaoCombateVIEW() {
		// Instanciação de Objetos
		this.setTitle("Combate");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 280, 250);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		this.setResizable(false);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/Icones/jupiter.png")));

		this.panel = new JPanel(new GridLayout(0, 1));
		this.border = BorderFactory.createTitledBorder("Protagonistas");
		((TitledBorder) this.border).setTitleColor((new Color(90, 61, 171)));
		((TitledBorder) this.border).setTitleFont(new Font("Arial", Font.BOLD, 16));
		((TitledBorder) this.border).setTitleJustification(TitledBorder.CENTER);
		this.panel.setBorder(border);
		this.add(panel);
		
		iniciDAO = new IniciativaDAO();
		nomesPerso = new ArrayList<>();
		nomesPerso.addAll(iniciDAO.listaGeral());
		for (int i = 0; i < nomesPerso.size(); i++) {
			String nome = nomesPerso.get(i);
			this.check = new JCheckBox(nome);
			this.panel.add(check);
			
		}

		this.btConfirmar = new JButton("Confirmar");
		this.btConfirmar.setBackground(new Color(90, 61, 171));
		this.btConfirmar.setForeground(Color.white);
		this.btConfirmar.setFont(new Font("Arial", Font.BOLD, 15));
		this.btConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				AreaDeCombateVIEW tela = new AreaDeCombateVIEW();
				tela.setVisible(true);
				System.out.println(persoSelecionado);
			}
		});
		this.panel.add(btConfirmar);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setForeground(new Color(90, 61, 171));
		this.btnCancelar.setBackground(Color.white);
		this.btnCancelar.setFont(new Font("Arial", Font.BOLD, 15));
		this.btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		this.add(panel, BorderLayout.CENTER);
		this.add(btnCancelar, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		ConfirmacaoCombateVIEW tela = new ConfirmacaoCombateVIEW();
		tela.setVisible(true);
	}

}
