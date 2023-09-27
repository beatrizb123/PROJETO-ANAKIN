package ANAKIN.VIEW;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FichaProtagonistaVIEW extends JFrame {

	// Declaração das Variaveis

	private Container container;
	private JPanel areaFicha;
	private ImageIcon imgIcon;
	private JLabel lblImagem, lblAtributos;
	private JLabel lblNome, lblOcupacao, lblIdade, lblAltura;
	private JTextField txtfNome, txtfOcupacao, txtfIdade, txtfAltura;
	private JComboBox ComboClasses;

	String Classes[] = { "Classes", "Combatente", "Feiticeiro", "Healer", "Suporte" };
	String Atributo[] = { "", "Luta + Esforço", "Magia + Estudo", "Cura + Estudo", "Auxiliar + Esforço" };

	private JSlider sldVida, sldDefesa, sldMagia;

	private JLabel Niveis, nivelVida, nivelDefesa, nivelMagia;
	private JLabel pcVida, pcDefesa, pcMagia;

	private JLabel lblHabilidades, lblPoder, lblForca, lblCarisma, lblAgilidade, lblIntelecto;
	private JSpinner spnPoder, spnForca, spnCarisma, spnAgilidade, spnIntelecto;
	private JPanel jpHabilidades;

	private JButton btSalvar;
	
	private ImageIcon fichaWall; 
	private JLabel bckgFicha; 


	// get e set

	public JButton getBtSalvar() {
		return btSalvar;

	}

	public JTextField getTxtNome() {
		return txtfNome;
	}

	public JTextField getTxtOcupacao() {
		return txtfOcupacao;
	}

	public JTextField getTxtIdade() {
		return txtfIdade;
	}

	public JTextField getTxtAltura() {
		return txtfAltura;
	}

	public FichaProtagonistaVIEW() {
		// instanciação dos objetos

		this.setTitle("Ficha de Protagonistas");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, 490, 550);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));

		// this.container = getContentPane();

		this.lblNome = new JLabel("Nome:");
		this.lblNome.setForeground(new Color(90, 61, 171));
		this.lblNome.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblNome.setBounds(40, 20, 70, 70);
		this.add(lblNome);

		this.txtfNome = new JTextField(100);
		this.txtfNome.setBounds(90, 45, 200, 20);
		this.add(txtfNome);

		this.lblOcupacao = new JLabel("Ocupacao:");
		this.lblOcupacao.setForeground(new Color(90, 61, 171));
		this.lblOcupacao.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblOcupacao.setBounds(40, 50, 85, 70);
		this.add(lblOcupacao);

		this.txtfOcupacao = new JTextField(100);
		this.txtfOcupacao.setBounds(120, 75, 170, 20);
		this.add(txtfOcupacao);

		this.lblIdade = new JLabel("Idade:");
		this.lblIdade.setForeground(new Color(90, 61, 171));
		this.lblIdade.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblIdade.setBounds(305, 20, 70, 70);
		this.add(lblIdade);

		this.txtfIdade = new JTextField(100);
		this.txtfIdade.setBounds(355, 45, 70, 20);
		this.add(txtfIdade);

		this.lblAltura = new JLabel("Altura:");
		this.lblAltura.setForeground(new Color(90, 61, 171));
		this.lblAltura.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblAltura.setBounds(305, 50, 85, 70);
		this.add(lblAltura);

		this.txtfAltura = new JTextField(100);
		this.txtfAltura.setBounds(355, 75, 70, 20);
		this.add(txtfAltura);

		this.ComboClasses = new JComboBox(Classes);
		this.ComboClasses.setForeground(new Color(90, 61, 171));
		this.ComboClasses.setFont(new Font("Arial", Font.BOLD, 16));
		this.ComboClasses.setBounds(295, 140, 140, 24);
		this.add(ComboClasses);

		this.lblAtributos = new JLabel(Atributo[0]);
		this.lblAtributos.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblAtributos.setBounds(305, 180, 140, 20);
		this.add(lblAtributos);

		this.ComboClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ComboClasses.getSelectedIndex();
				String mostrarAtributos = Atributo[i];

				lblAtributos.setText(mostrarAtributos);

			}
		});

		this.Niveis = new JLabel("Niveis!");
		this.Niveis.setForeground(new Color(90, 61, 171));
		this.Niveis.setFont(new Font("Arial", Font.BOLD, 18));
		this.Niveis.setBounds(120, 118, 65, 20);
		this.add(Niveis);

		this.nivelVida = new JLabel("Vida:");
		this.nivelVida.setForeground(new Color(90, 61, 171));
		this.nivelVida.setFont(new Font("Arial", Font.BOLD, 16));
		this.nivelVida.setBounds(40, 140, 50, 20);
		this.add(nivelVida);

		this.pcVida = new JLabel("100" + "%");
		this.pcVida.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcVida.setBounds(235, 140, 40, 18);
		this.add(pcVida);

		this.sldVida = new JSlider();
		this.sldVida.setBackground(new Color(225, 206, 255));
		this.sldVida.setForeground(new Color(90, 61, 171));
		this.sldVida.setMajorTickSpacing(20);
		this.sldVida.setMinorTickSpacing(5);
		this.sldVida.setPaintTicks(true);
		this.sldVida.setValue(100);
		this.sldVida.setBounds(97, 140, 130, 30);

		this.sldVida.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcVida.setText(String.valueOf(sldVida.getValue()) + "%");

			}

		});
		this.add(sldVida);

		this.nivelDefesa = new JLabel("Defesa:");
		this.nivelDefesa.setForeground(new Color(90, 61, 171));
		this.nivelDefesa.setFont(new Font("Arial", Font.BOLD, 16));
		this.nivelDefesa.setBounds(40, 170, 75, 20);
		this.add(nivelDefesa);

		this.pcDefesa = new JLabel("100" + "%");
		this.pcDefesa.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcDefesa.setBounds(235, 170, 40, 18);
		this.add(pcDefesa);

		this.sldDefesa = new JSlider();
		this.sldDefesa.setBackground(new Color(225, 206, 255));
		this.sldDefesa.setForeground(new Color(90, 61, 171));
		this.sldDefesa.setMajorTickSpacing(20);
		this.sldDefesa.setMinorTickSpacing(5);
		this.sldDefesa.setPaintTicks(true);
		this.sldDefesa.setValue(100);
		this.sldDefesa.setBounds(97, 170, 130, 30);

		this.sldDefesa.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcDefesa.setText(String.valueOf(sldDefesa.getValue()) + "%");

			}

		});
		this.add(sldDefesa);

		this.nivelMagia = new JLabel("Magia:");

		this.nivelMagia.setForeground(new Color(90, 61, 171));
		this.nivelMagia.setFont(new Font("Arial", Font.BOLD, 16));
		this.nivelMagia.setBounds(40, 200, 55, 20);
		this.add(nivelMagia);

		this.pcMagia = new JLabel("100" + "%");
		this.pcMagia.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcMagia.setBounds(235, 200, 40, 18);
		this.add(pcMagia);

		this.sldMagia = new JSlider();
		this.sldMagia.setBackground(new Color(225, 206, 255));
		this.sldMagia.setForeground(new Color(90, 61, 171));
		this.sldMagia.setMajorTickSpacing(20);
		this.sldMagia.setMinorTickSpacing(5);
		this.sldMagia.setPaintTicks(true);
		this.sldMagia.setValue(100);
		this.sldMagia.setBounds(97, 200, 130, 30);

		this.sldMagia.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcMagia.setText(String.valueOf(sldMagia.getValue()) + "%");

			}

		});
		this.add(sldMagia);

		this.lblHabilidades = new JLabel("Habilidades!");
		this.lblHabilidades.setForeground(new Color(90, 61, 171));
		this.lblHabilidades.setFont(new Font("Arial", Font.BOLD, 18));
		this.lblHabilidades.setBounds(100, 250, 110, 20);
		this.add(lblHabilidades);

		this.lblPoder = new JLabel("Poder:");
		this.lblPoder.setForeground(new Color(90, 61, 171));
		this.lblPoder.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblPoder.setBounds(70, 280, 60, 20);
		this.add(lblPoder);

		SpinnerModel valuePoder = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnPoder = new JSpinner(valuePoder);
		this.spnPoder.setEditor(new JSpinner.DefaultEditor(spnPoder));
		this.spnPoder.setBounds(70, 305, 55, 20);
		this.add(spnPoder);

		this.lblForca = new JLabel("Forca:");
		this.lblForca.setForeground(new Color(90, 61, 171));
		this.lblForca.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblForca.setBounds(180, 280, 60, 20);
		this.add(lblForca);

		SpinnerModel valueForca = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnForca = new JSpinner(valueForca);
		this.spnForca.setEditor(new JSpinner.DefaultEditor(spnForca));
		this.spnForca.setBounds(180, 305, 55, 20);
		this.add(spnForca);

		this.lblCarisma = new JLabel("Carisma:");
		this.lblCarisma.setForeground(new Color(90, 61, 171));
		this.lblCarisma.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblCarisma.setBounds(70, 340, 70, 20);
		this.add(lblCarisma);

		SpinnerModel valueCarisma = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnCarisma = new JSpinner(valueCarisma);
		this.spnCarisma.setEditor(new JSpinner.DefaultEditor(spnCarisma));
		this.spnCarisma.setBounds(75, 365, 55, 20);
		this.add(spnCarisma);

		this.lblAgilidade = new JLabel("Agilidade:");
		this.lblAgilidade.setForeground(new Color(90, 61, 171));
		this.lblAgilidade.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblAgilidade.setBounds(180, 340, 80, 20);
		this.add(lblAgilidade);

		SpinnerModel valueAgilidade = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnAgilidade = new JSpinner(valueAgilidade);
		this.spnAgilidade.setEditor(new JSpinner.DefaultEditor(spnAgilidade));
		this.spnAgilidade.setBounds(185, 365, 55, 20);
		this.add(spnAgilidade);

		this.lblIntelecto = new JLabel("Intelecto:");
		this.lblIntelecto.setForeground(new Color(90, 61, 171));
		this.lblIntelecto.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblIntelecto.setBounds(70, 395, 80, 20);
		this.add(lblIntelecto);

		SpinnerModel valueIntelecto = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnIntelecto = new JSpinner(valueIntelecto);
		this.spnIntelecto.setEditor(new JSpinner.DefaultEditor(spnIntelecto));
		this.spnIntelecto.setBounds(75, 420, 55, 20);
		this.add(spnIntelecto);

		this.btSalvar = new JButton("SALVAR");
		this.btSalvar.setBounds(300, 260, 135, 30);
		this.btSalvar.setBackground(new Color(90, 61, 171));
		this.btSalvar.setForeground(Color.white);
		this.add(btSalvar);

		this.jpHabilidades = new JPanel();
		this.jpHabilidades.setLayout(null);
		this.jpHabilidades.setBackground(new Color(225, 206, 255));
		this.jpHabilidades.setBounds(15, 15, 445, 480);
		this.jpHabilidades.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 3));
		this.add(jpHabilidades);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Beatriz\\Downloads\\jupiter.png"));
		
		this.fichaWall = new ImageIcon(getClass().getResource("Fichas.png"));
		this.fichaWall = new ImageIcon(fichaWall.getImage().getScaledInstance(580,500, Image.SCALE_DEFAULT));
		this.bckgFicha = new JLabel(fichaWall);
		this.bckgFicha.setBounds(-10,-10, 580,500);
		this.add(bckgFicha);

	}

	public static void abre() {
		FichaProtagonistaVIEW frame = new FichaProtagonistaVIEW();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);

	}

	public static void main(String[] args) {
		FichaProtagonistaVIEW v = new FichaProtagonistaVIEW();
		v.abre();
	}
}
