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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ANAKIN.MODEL.BO.DadosBO;
import ANAKIN.MODEL.DAO.ControleSessaoDAO;
import ANAKIN.MODEL.DAO.DadosDAO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.DadosVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class DadosdeJogoVIEW extends JFrame {

	// declaração das variaveis

	private Container container;
	private JPanel jp;
	private JButton btnMenosD4, btnMenosD6, btnMenosD8, btnMenosD12, btnMenosD20;
	private JButton btnMaisD4, btnMaisD6, btnMaisD8, btnMaisD12, btnMaisD20;
	private JButton btnRolar;
	private JTextField txtD4, txtD6, txtD8, txtD12, txtD20;
	private JLabel lblD4, lblD6, lblD8, lblD12, lblD20;
	private ImageIcon imgD4, imgD6, imgD8, imgD12, imgD20;

	private JScrollPane spResultados;
	private JTextArea txtaResultados;

	public DadosdeJogoVIEW() {

		this.setTitle("Dados de Jogo");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0, 0, 580, 500);
		this.setBackground(new Color(250, 247, 255));
		this.setVisible(true);
		this.setLayout(null);

		this.container = getContentPane();

		this.jp = new JPanel();
		this.jp.setBounds(15, 15, 535, 300);
		this.jp.setLayout(null);
		this.jp.setBackground(new Color(209, 198, 209));
		this.jp.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.add(jp);

		// Imagens dos DADOS
		this.imgD4 = new ImageIcon(getClass().getResource("D4.png"));
		this.lblD4 = new JLabel(imgD4);
		this.lblD4.setBounds(45, 5, 100, 100);
		this.jp.add(lblD4);

		this.imgD6 = new ImageIcon(getClass().getResource("D6.png"));
		this.lblD6 = new JLabel(imgD6);
		this.lblD6.setBounds(215, 5, 100, 100);
		this.jp.add(lblD6);

		this.imgD8 = new ImageIcon(getClass().getResource("D8.png"));
		this.lblD8 = new JLabel(imgD8);
		this.lblD8.setBounds(380, 2, 100, 113);
		this.jp.add(lblD8);

		this.imgD12 = new ImageIcon(getClass().getResource("D12.png"));
		this.lblD12 = new JLabel(imgD12);
		this.lblD12.setBounds(120, 120, 150, 150);
		this.jp.add(lblD12);

		this.imgD20 = new ImageIcon(getClass().getResource("D20.png"));
		this.lblD20 = new JLabel(imgD20);
		this.lblD20.setBounds(280, 120, 150, 150);
		this.jp.add(lblD20);
		// Fim de imagens de Dado

		// Botão incremento e decremento D4

		this.txtD4 = new JTextField(1);
		this.txtD4.setBounds(70, 110, 55, 18);
		this.txtD4.setEditable(false);
		this.txtD4.setHorizontalAlignment(JTextField.CENTER);
		this.txtD4.setText("0");
		this.jp.add(txtD4);

		this.btnMaisD4 = new JButton("+");
		this.btnMaisD4.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMaisD4.setForeground(Color.black);
		this.btnMaisD4.setBounds(125, 110, 39, 18);
		this.btnMaisD4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD4.getText()) + 1;
				txtD4.setText(Integer.toString(i));

			}
		});
		this.jp.add(btnMaisD4);

		this.btnMenosD4 = new JButton("-");
		this.btnMenosD4.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMenosD4.setForeground(Color.black);
		this.btnMenosD4.setBounds(30, 110, 39, 18);
		this.btnMenosD4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD4.getText()) - 1;
				if (i >= 0) {
					txtD4.setText(Integer.toString(i));
				}

			}
		});
		this.jp.add(btnMenosD4);

		// Botão incremento e decremento D6

		this.txtD6 = new JTextField(1);
		this.txtD6.setBounds(239, 110, 55, 18);
		this.txtD6.setEditable(false);
		this.txtD6.setHorizontalAlignment(JTextField.CENTER);
		this.txtD6.setText("0");
		this.jp.add(txtD6);

		this.btnMaisD6 = new JButton("+");
		this.btnMaisD6.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMaisD6.setForeground(Color.black);
		this.btnMaisD6.setBounds(295, 110, 39, 18);
		this.btnMaisD6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD6.getText()) + 1;
				txtD6.setText(Integer.toString(i));

			}
		});
		this.jp.add(btnMaisD6);

		this.btnMenosD6 = new JButton("-");
		this.btnMenosD6.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMenosD6.setForeground(Color.black);
		this.btnMenosD6.setBounds(200, 110, 39, 18);
		this.btnMenosD6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD6.getText()) - 1;
				if (i >= 0) {
					txtD6.setText(Integer.toString(i));
				}

			}
		});
		this.jp.add(btnMenosD6);

		// Botão incremento e decremento D8

		this.txtD8 = new JTextField(1);
		this.txtD8.setBounds(410, 110, 55, 18);
		this.txtD8.setEditable(false);
		this.txtD8.setHorizontalAlignment(JTextField.CENTER);
		this.txtD8.setText("0");
		this.jp.add(txtD8);

		this.btnMaisD8 = new JButton("+");
		this.btnMaisD8.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMaisD8.setForeground(Color.black);
		this.btnMaisD8.setBounds(465, 110, 39, 18);
		this.btnMaisD8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD8.getText()) + 1;
				txtD8.setText(Integer.toString(i));

			}
		});
		this.jp.add(btnMaisD8);

		this.btnMenosD8 = new JButton("-");
		this.btnMenosD8.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMenosD8.setForeground(Color.black);
		this.btnMenosD8.setBounds(370, 110, 39, 18);
		this.btnMenosD8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD8.getText()) - 1;
				if (i >= 0) {
					txtD8.setText(Integer.toString(i));
				}

			}
		});
		this.jp.add(btnMenosD8);

		// Botão incremento e decremento D12

		this.txtD12 = new JTextField(1);
		this.txtD12.setBounds(165, 250, 55, 18);
		this.txtD12.setEditable(false);
		this.txtD12.setHorizontalAlignment(JTextField.CENTER);
		this.txtD12.setText("0");
		this.jp.add(txtD12);

		this.btnMaisD12 = new JButton("+");
		this.btnMaisD12.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMaisD12.setForeground(Color.black);
		this.btnMaisD12.setBounds(220, 250, 39, 18);
		this.btnMaisD12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD12.getText()) + 1;
				txtD12.setText(Integer.toString(i));

			}
		});
		this.jp.add(btnMaisD12);

		this.btnMenosD12 = new JButton("-");
		this.btnMenosD12.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMenosD12.setForeground(Color.black);
		this.btnMenosD12.setBounds(125, 250, 39, 18);
		this.btnMenosD12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD12.getText()) - 1;
				if (i >= 0) {
					txtD12.setText(Integer.toString(i));
				}

			}
		});
		this.jp.add(btnMenosD12);

		// Botão incremento e decremento D20

		this.txtD20 = new JTextField(1);
		this.txtD20.setBounds(330, 250, 55, 18);
		this.txtD20.setEditable(false);
		this.txtD20.setHorizontalAlignment(JTextField.CENTER);
		this.txtD20.setText("0");
		this.jp.add(txtD20);

		this.btnMaisD20 = new JButton("+");
		this.btnMaisD20.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMaisD20.setForeground(Color.black);
		this.btnMaisD20.setBounds(385, 250, 39, 18);
		this.btnMaisD20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD20.getText()) + 1;
				txtD20.setText(Integer.toString(i));

			}
		});
		this.jp.add(btnMaisD20);

		this.btnMenosD20 = new JButton("-");
		this.btnMenosD20.setFont(new Font("Arial", Font.BOLD, 9));
		this.btnMenosD20.setForeground(Color.black);
		this.btnMenosD20.setBounds(290, 250, 39, 18);
		this.btnMenosD20.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(txtD20.getText()) - 1;
				if (i >= 0) {
					txtD20.setText(Integer.toString(i));
				}

			}
		});
		this.jp.add(btnMenosD20);

		this.txtaResultados = new JTextArea();
		this.txtaResultados.setLineWrap(true);
		this.txtaResultados.setWrapStyleWord(true);
		this.txtaResultados.setEditable(false);
		this.txtaResultados.setFont(new Font("Arial", Font.PLAIN, 8));

		this.spResultados = new JScrollPane(txtaResultados);
		this.spResultados.setBounds(280, 335, 270, 115);
		this.container.add(spResultados);

		this.btnRolar = new JButton("ROLAR DADOS");
		this.btnRolar.setBounds(70, 340, 145, 30);
		this.btnRolar.setBackground(new Color(90, 61, 171));
		this.btnRolar.setForeground(Color.white);
		this.btnRolar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DadosBO calcula = new DadosBO();
				int d4 = Integer.parseInt(txtD4.getText());
				int d6 = Integer.parseInt(txtD6.getText());
				int d8 = Integer.parseInt(txtD8.getText());
				int d12 = Integer.parseInt(txtD12.getText());
				int d20 = Integer.parseInt(txtD20.getText());

				String resultados = "";
				String total = "\nTOTAL = " + Integer.toString(calcula.total(calcula));

				if (d4 > 0) {
					resultados += calcula.geraD4(d4);
				}
				if (d6 > 0) {
					resultados += calcula.geraD6(d6);
				}
				if (d8 > 0) {
					resultados += calcula.geraD8(d8);
				}
				if (d12 > 0) {
					resultados += calcula.geraD12(d12);
				}
				if (d20 > 0) {
					resultados += calcula.geraD20(d20);
				}

				txtaResultados.setText(resultados + "" + total);

				DadosVO registro = new DadosVO();
				DadosDAO salvar = new DadosDAO();

				String resgistrar = resultados;

				registro.setRegistro(resgistrar);

				salvar.salvarRegistro(registro);

				JOptionPane.showMessageDialog(null, "INFORMAÇÕES FORAM SALVAS!");

			}
		});

		this.add(btnRolar);
	}

	public JTextField getTxtD4() {
		return txtD4;
	}

	public void setTxtD4(JTextField txtD4) {
		this.txtD4 = txtD4;
	}

	public JTextField getTxtD6() {
		return txtD6;
	}

	public void setTxtD6(JTextField txtD6) {
		this.txtD6 = txtD6;
	}

	public JTextField getTxtD8() {
		return txtD8;
	}

	public void setTxtD8(JTextField txtD8) {
		this.txtD8 = txtD8;
	}

	public JTextField getTxtD12() {
		return txtD12;
	}

	public void setTxtD12(JTextField txtD12) {
		this.txtD12 = txtD12;
	}

	public JTextField getTxtD20() {
		return txtD20;
	}

	public void setTxtD20(JTextField txtD20) {
		this.txtD20 = txtD20;
	}

	public JTextArea getTxtaResultados() {
		return txtaResultados;
	}

	public void setTxtaResultados(JTextArea txtaResultados) {
		this.txtaResultados = txtaResultados;
	}

	public static void abre() {
		DadosdeJogoVIEW frame = new DadosdeJogoVIEW();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);

	}

	
}
