package ANAKIN.VIEW;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import ProjetoAnakin.FichaProtagonistaVIEW;

public class FichaNpcVIEW extends JFrame {
	
	//Declaração de Variaves 
	
	private Container container; 
	private JPanel areaFicha; 
	private ImageIcon imgIcon;
	private JLabel iconUsuario;
	private JLabel lblImagem, lblAtributos;
	private JLabel lblNome, lblOcupacao, lblIdade, lblAltura;
	private JTextField txtfNome, txtfOcupacao, txtfIdade, txtfAltura; 
	private JComboBox ComboAlinhamento;

	private ImageIcon fichaWall;
	private JLabel bckgFicha;

	String Alinhamento[] = {"Alinhamento","Bom","Neutro","Mal"};
	String Talentos[] = {"", "Esforço + Fascinar", "Estudo + Intruição", "Algazarra + Sorte"};

	private JSlider sldVida, sldDefesa, sldMagia;
	private JLabel Niveis, nivelVida, nivelDefesa, nivelMagia;
	private JLabel pcVida, pcDefesa, pcMagia;
	
	private JLabel lblHabilidades, lblPoder, lblForca, lblCarisma, lblAgilidade, lblIntelecto;
	private JSpinner spnPoder,spnForca, spnCarisma, spnAgilidade, spnIntelecto;
	private JPanel jpFicha;
	private JTextArea txtPersonalidade;
	private JScrollPane spPersonalidade;
	private ImageIcon iconbtnSalvar;
	private JLabel lblbtnSalvar;
	private JLabel lblSalvar;


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

	public FichaNpcVIEW() {
		//Instanciação dos Objetos
		//Dados Pessoais
	
		this.setTitle("Ficha de Npc's");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0,0,495,550);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));
		
		this.container = getContentPane();

		this.iconUsuario = new JLabel("Icon :D");
		this.iconUsuario.setFont(new Font("Arial", Font.BOLD,13));
		this.iconUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.iconUsuario.setBounds(35, 35, 125,140);
		this.add(iconUsuario);
		
		this.lblNome = new JLabel("Nome:");
		this.lblNome.setForeground(new Color(90,61,171));
		this.lblNome.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblNome.setBounds(185,10,70,70);
		this.add(lblNome);
	
		this.txtfNome = new JTextField(100);
		this.txtfNome.setBounds(235,35,199,20);
		this.add(txtfNome);
		
		
		this.lblOcupacao = new JLabel ("Ocupação:");
		this.lblOcupacao.setForeground(new Color(90,61,171));
		this.lblOcupacao.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblOcupacao.setBounds(185,45,85,70);
		this.add(lblOcupacao);
		
		this.txtfOcupacao = new JTextField(100);
		this.txtfOcupacao.setBounds(265,70,170,20);
		this.add(txtfOcupacao);
		
		
		this.lblIdade = new JLabel("Idade:");
		this.lblIdade.setForeground(new Color(90,61,171));
		this.lblIdade.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblIdade.setBounds(185,78,70,70);
		this.add(lblIdade);
		
		this.txtfIdade = new JTextField(100);
		this.txtfIdade.setBounds(235,108,70,20);
		this.add(txtfIdade);
		
		this.lblAltura = new JLabel ("Altura:");
		this.lblAltura.setForeground(new Color(90,61,171));
		this.lblAltura.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblAltura.setBounds(315,78,85,70);
		this.add(lblAltura);
		
		this.txtfAltura = new JTextField(100);
		this.txtfAltura.setBounds(365,103,70,20);
		this.add(txtfAltura);
		
		//Classes

		this.ComboAlinhamento = new JComboBox(Alinhamento);
		this.ComboAlinhamento.setForeground(new Color(90,61,171));
		this.ComboAlinhamento.setFont(new Font("Arial", Font.BOLD, 15));
		this.ComboAlinhamento.setBounds(185,145,115,20);
		this.add(ComboAlinhamento);
		
		this.lblAtributos = new JLabel(Talentos[0]);
		this.lblAtributos.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblAtributos.setForeground(new Color(82,75,91));
		this.lblAtributos.setBounds(315,145,140,20);
		this.add(lblAtributos);
		
		this.ComboAlinhamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = ComboAlinhamento.getSelectedIndex();
				String mostrarTalentos = Talentos[i];
				
				lblAtributos.setText(mostrarTalentos);

			}
		});
		
		
		//NIVEIS 
		
		this.Niveis = new JLabel("Niveis!");
		this.Niveis.setForeground(new Color(90,61,171));
		this.Niveis.setFont(new Font("Arial", Font.BOLD, 16));
		this.Niveis.setBounds(110,200,65, 20);
		this.add(Niveis);
			
		this.nivelVida = new JLabel("Vida:");
		this.nivelVida.setForeground(new Color(90,61,171));
		this.nivelVida.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelVida.setBounds(35,225,50, 20);
		this.add(nivelVida);
			
		this.pcVida = new JLabel("100"+"%");
		this.pcVida.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcVida.setBounds(198, 225,40, 18);
		this.add(pcVida);
			
		this.sldVida = new JSlider();
		this.sldVida.setBackground(new Color(235,223,255));
		this.sldVida.setForeground(new Color(90, 61, 171));
		this.sldVida.setMajorTickSpacing(20);
		this.sldVida.setMinorTickSpacing(5);
		this.sldVida.setPaintTicks(true);
		this.sldVida.setValue(100);
		this.sldVida.setBounds(87,225,105,30);
		this.sldVida.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pcVida.setText(String.valueOf(sldVida.getValue())+"%");

			}
			
		});
		this.add(sldVida);
		
		this.nivelDefesa = new JLabel("Defesa:");
		this.nivelDefesa.setForeground(new Color(90,61,171));
		this.nivelDefesa.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelDefesa.setBounds(35,260,75,20);
		this.add(nivelDefesa);
		
		this.pcDefesa = new JLabel("100"+"%");
		this.pcDefesa.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcDefesa.setBounds(198, 260,40, 18);
		this.add(pcDefesa);
		
		
		this.sldDefesa = new JSlider();
		this.sldDefesa.setBackground(new Color(235,223,255));
		this.sldDefesa.setForeground(new Color(90, 61, 171));
		this.sldDefesa.setMajorTickSpacing(20);
		this.sldDefesa.setMinorTickSpacing(5);
		this.sldDefesa.setPaintTicks(true);
		this.sldDefesa.setValue(100);
		this.sldDefesa.setBounds(87,260,105,30);
		this.sldDefesa.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
			pcDefesa.setText(String.valueOf(sldDefesa.getValue())+"%");

			}
	
		});
		this.add(sldDefesa);
		
		this.nivelMagia = new JLabel("Magia:");
		
		this.nivelMagia.setForeground(new Color(90,61,171));
		this.nivelMagia.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelMagia.setBounds(35,290,55, 20);
		this.add(nivelMagia);
		
		this.pcMagia = new JLabel("100"+"%");
		this.pcMagia.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcMagia.setBounds(198, 290,40, 18);
		this.add(pcMagia);
		
		
		this.sldMagia = new JSlider();
		this.sldMagia.setBackground(new Color(235,223,255));
		this.sldMagia.setForeground(new Color(90, 61, 171));
		this.sldMagia.setMajorTickSpacing(20);
		this.sldMagia.setMinorTickSpacing(5);
		this.sldMagia.setPaintTicks(true);
		this.sldMagia.setValue(100);
		this.sldMagia.setBounds(87,290,105,30);
		this.sldMagia.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
			pcMagia.setText(String.valueOf(sldMagia.getValue())+"%");

			}
	
		});
		this.add(sldMagia);

		//Habilidades 
		this.lblHabilidades = new JLabel("Habilidades!");
		this.lblHabilidades.setForeground(new Color(90,61,171));
		this.lblHabilidades.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblHabilidades.setBounds(306,200,110, 20);
		this.add(lblHabilidades);
		
		this.lblPoder = new JLabel("Poder:");
		this.lblPoder.setForeground(new Color(90,61,171));
		this.lblPoder.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblPoder.setBounds(258,225,65, 20);
		this.add(lblPoder);
	
		SpinnerModel valuePoder =  new SpinnerNumberModel(1, 0, 5, 1); 
		this.spnPoder = new JSpinner(valuePoder);   
		this.spnPoder.setEditor(new JSpinner.DefaultEditor(spnPoder));
        this.spnPoder.setBounds(258,245,50,20);
        this.add(spnPoder);
        
        
        this.lblForca = new JLabel("Forca:");
		this.lblForca.setForeground(new Color(90,61,171));
		this.lblForca.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblForca.setBounds(328,225,60, 20);
		this.add(lblForca);
		
		SpinnerModel valueForca =  new SpinnerNumberModel(1, 0, 5, 1); 
		this.spnForca = new JSpinner(valueForca);
		this.spnForca.setEditor(new JSpinner.DefaultEditor(spnForca));
        this.spnForca.setBounds(328,245,50,20);
        this.add(spnForca);
		
        this.lblCarisma = new JLabel("Carisma:");
		this.lblCarisma.setForeground(new Color(90,61,171));
		this.lblCarisma.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblCarisma.setBounds(388,225,70, 20);
		this.add(lblCarisma);
		
		SpinnerModel valueCarisma =  new SpinnerNumberModel(1, 0, 5, 1); 
		this.spnCarisma = new JSpinner(valueCarisma);  
		this.spnCarisma.setEditor(new JSpinner.DefaultEditor(spnCarisma));
        this.spnCarisma.setBounds(394,245,50,20);
        this.add(spnCarisma);
        
        this.lblAgilidade = new JLabel("Agilidade:");
		this.lblAgilidade.setForeground(new Color(90,61,171));
		this.lblAgilidade.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblAgilidade.setBounds(280,275,80, 20);
		this.add(lblAgilidade);
		
		SpinnerModel valueAgilidade =  new SpinnerNumberModel(1, 0, 5, 1); 
		this.spnAgilidade = new JSpinner(valueAgilidade);
		this.spnAgilidade.setEditor(new JSpinner.DefaultEditor(spnAgilidade));
        this.spnAgilidade.setBounds(285,295,55,20);
        this.add(spnAgilidade);
        
        this.lblIntelecto = new JLabel("Intelecto:");
		this.lblIntelecto.setForeground(new Color(90,61,171));
		this.lblIntelecto.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblIntelecto.setBounds(360,275,80, 20);
		this.add(lblIntelecto);
		
		SpinnerModel valueIntelecto =  new SpinnerNumberModel(1, 0, 5, 1); 
		this.spnIntelecto = new JSpinner(valueIntelecto); 
		this.spnIntelecto.setEditor(new JSpinner.DefaultEditor(spnIntelecto));
        this.spnIntelecto.setBounds(365,295,50,20);
        this.add(spnIntelecto);
        
        //Personalidade
		
		this.txtPersonalidade = new JTextArea("Personalidade");
		this.txtPersonalidade.setFont(new Font("Helvetica", Font.BOLD, 14));
		this.txtPersonalidade.setLineWrap(true);
		this.txtPersonalidade.setWrapStyleWord(true);

		this.spPersonalidade = new JScrollPane(txtPersonalidade);
		this.spPersonalidade.setBounds(35, 340, 210, 140);
		this.spPersonalidade.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.add(spPersonalidade);
		
		this.iconbtnSalvar = new ImageIcon(getClass().getResource("Icone Salvar.png"));
		this.lblbtnSalvar = new JLabel(iconbtnSalvar);
		this.lblbtnSalvar.setToolTipText("Salvar");
		this.lblbtnSalvar.setBounds(300, 330, 120, 120);
		this.lblbtnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnSalvar.setIcon(iconbtnSalvar);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSalvar.setIcon(iconbtnSalvar);
			}
		});
		this.add(lblbtnSalvar);
		
		this.lblSalvar = new JLabel("Salvar");
		this.lblSalvar.setForeground(new Color(90,61,171));
		this.lblSalvar.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblSalvar.setBounds(330,425,100, 20);
		this.add(lblSalvar);	
        
        this.jpFicha = new JPanel();
		this.jpFicha.setLayout(null);
		this.jpFicha.setBackground(new Color(235,223,255));
		this.jpFicha.setBounds(15,15,450,480);
		this.jpFicha.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 3));
		this.add(jpFicha);
		
		this.fichaWall = new ImageIcon(getClass().getResource("Fichas.png"));
		this.fichaWall = new ImageIcon(fichaWall.getImage().getScaledInstance(495,550, Image.SCALE_DEFAULT));
		this.bckgFicha = new JLabel(fichaWall);
		this.bckgFicha.setBounds(-10,-10, 495,550);
		this.add(bckgFicha);

		
		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/jupiter.png")));

	    }

		

		public static void abre() {
			FichaNpcVIEW frame = new FichaNpcVIEW();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setVisible(true);
			Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setLocation((tela.width - frame.getSize().width)/2,(tela.height - frame.getSize().height)/2);

		}

	}