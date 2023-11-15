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
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ANAKIN.MODEL.BO.FichaProtagonistaSelecionada;
//import ANAKIN.MODEL.BO.FichaProtagonistaSelecionada;
import ANAKIN.MODEL.BO.ImagemBO;
import ANAKIN.MODEL.DAO.FichaProtagonistaDAO;
import ANAKIN.MODEL.DAO.NovoControleDAO;
import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.FichaProtagonistaVO;

public class FichaProtagonistaVIEW extends JFrame {

	// Declaração das Variaveis

	private Container container;
	private JPanel areaFicha;
	private ImageIcon imgIcon, icon;
	private JLabel iconUsuario;
	private JLabel lblImagem, lblAtributos;
	private JLabel lblNome, lblOcupacao, lblIdade, lblAltura;
	private JTextField txtfNome, txtfOcupacao, txtfIdade, txtfAltura;
	private JComboBox ComboClasses;

	private ImageIcon fichaWall, iconbtnSalvar;
	private JLabel bckgFicha, lblbtnSalvar, lblSalvar;

	String Classes[] = { "Classes", "Combatente", "Feiticeiro", "Healer", "Suporte" };
	String Atributo[] = { "", "Luta + Esforço", "Magia + Estudo", "Cura + Estudo", "Auxílio + Esforço" };
	String Imagens[] = { "", "/Imagens/Combatente.png", "/Imagens/Feiticeiro.png", "/Imagens/Healer.png",
			"/Imagens/Suporte.png" };

	private JSlider sldVida, sldDefesa, sldMagia;

	private JLabel Niveis, nivelVida, nivelDefesa, nivelMagia;
	private JLabel pcVida, pcDefesa, pcMagia;

	private JLabel lblHabilidades, lblPoder, lblForca, lblCarisma, lblAgilidade, lblIntelecto;
	private JSpinner spnPoder, spnForca, spnCarisma, spnAgilidade, spnIntelecto;
	private JPanel jpHabilidades;

	private JButton btSalvar;
	private JButton btnApagar;
	private ImageIcon iconbtnCancela, iconbtnAnterior, iconbtnProximo;
	private ImageIcon destaqueCancelar, destaqueSalvar;
	private JLabel lblbtnCancela, lblbtnAnterior, lblbtnProximo;
	private JLabel lblCancela;

	JFileChooser jfArquivo;
	BufferedImage bfimg;
	File file;

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
		FichaProtagonistaVO FPV = new FichaProtagonistaVO();
		FichaProtagonistaDAO FPD = new FichaProtagonistaDAO();
		AuxiliarVO AV = new AuxiliarVO();
		int idprota = AV.getIdprotagonista();
		String nomeperso = AV.getNomeprotagonista();
	

		// DADOS PESSOAIS
		this.setTitle("Ficha de Protagonistas");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, 495, 510);
		this.setLayout(null);
		this.setBackground(new Color(250, 247, 255));

		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);

		this.container = getContentPane();

		this.iconUsuario = new JLabel("Adicione um icon :D");
		this.iconUsuario.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		this.iconUsuario.setLayout(null);
		this.iconUsuario.setFont(new Font("Arial", Font.BOLD, 11));
		this.iconUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 2));
		this.iconUsuario.setBounds(40, 35, 125, 140);
		this.iconUsuario.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// image = new ImageIcon("bandeiras/" + fotos[0] + ".jpeg");

				jfArquivo = new JFileChooser();
				jfArquivo.setCurrentDirectory(new File(System.getProperty("user.home")));
				jfArquivo.showOpenDialog(null);
				file = jfArquivo.getSelectedFile();
				// ImageIcon icon = new ImageIcon(getClass().getResource(Imagens[i]));
				// iconUsuario.setIcon(icon);;
				try {

					bfimg = ImageIO.read(file);
					icon = new ImageIcon(bfimg);

					Image img = icon.getImage();
					Image tamanhoImg = img.getScaledInstance(iconUsuario.getWidth(), iconUsuario.getHeight(),Image.SCALE_SMOOTH);
					ImageIcon iconRed = new ImageIcon(tamanhoImg);
					iconUsuario.setIcon(iconRed);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		this.add(iconUsuario);

		this.lblNome = new JLabel("Nome:");
		this.lblNome.setForeground(new Color(90, 61, 171));
		this.lblNome.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblNome.setBounds(185, 10, 70, 70);
		this.add(lblNome);

		this.txtfNome = new JTextField(100);
		if (FPD.VereficaprotaOPEN() != false) {
			this.txtfNome.setText(FichaProtagonistaSelecionada.getNome());
			int idprotagonista = FPD.retornaidprotagonista(FichaProtagonistaSelecionada.getNome());
			AV.setIdprotagonista(idprotagonista);
		}else {
			this.txtfNome.setText("");
		}

		this.txtfNome.setBounds(235, 35, 199, 20);
		this.add(txtfNome);

		this.lblOcupacao = new JLabel("Ocupação:");
		this.lblOcupacao.setForeground(new Color(90, 61, 171));
		this.lblOcupacao.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblOcupacao.setBounds(185, 45, 85, 70);
		this.add(lblOcupacao);

		this.txtfOcupacao = new JTextField(100);

		if (FPD.VereficaprotaOPEN() != false) {
			this.txtfOcupacao.setText(FichaProtagonistaSelecionada.getOcupacao());}

		this.txtfOcupacao.setBounds(265, 70, 170, 20);
		this.add(txtfOcupacao);

		this.lblIdade = new JLabel("Idade:");
		this.lblIdade.setForeground(new Color(90, 61, 171));
		this.lblIdade.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblIdade.setBounds(185, 78, 70, 70);
		this.add(lblIdade);

		this.txtfIdade = new JTextField(100);
		if (FPD.VereficaprotaOPEN() != false) {
			String idade = String.valueOf(FichaProtagonistaSelecionada.getIdade());
			txtfIdade.setText(idade);
		}

		this.txtfIdade.setBounds(235, 108, 70, 20);
		this.add(txtfIdade);

		this.lblAltura = new JLabel("Altura:");
		this.lblAltura.setForeground(new Color(90, 61, 171));
		this.lblAltura.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblAltura.setBounds(315, 78, 85, 70);
		this.add(lblAltura);

		
		this.txtfAltura = new JTextField(100);		
		if (FPD.VereficaprotaOPEN() != false) {

			Float altura = FichaProtagonistaSelecionada.getAltura();
			String alturatxt = String.valueOf(altura);
			txtfAltura.setText(alturatxt);
		}
		this.txtfAltura.setBounds(365, 103, 70, 20);
		this.add(txtfAltura);

		// CLASSES

		this.ComboClasses = new JComboBox(Classes);
		this.ComboClasses.setForeground(new Color(90, 61, 171));
		this.ComboClasses.setFont(new Font("Arial", Font.BOLD, 15));
		this.ComboClasses.setBounds(185, 145, 115, 20);

		if(FPD.VereficaprotaOPEN() != false) {
		
			switch(FichaProtagonistaSelecionada.getClasse()){
			case 1 :

				this.ComboClasses.setSelectedItem("Combatente");
				break;
			case 2:
				this.ComboClasses.setSelectedItem("Feiticeiro");
				break;
			case 3:
				this.ComboClasses.setSelectedItem("Healer");
				break;
			case 4:
				this.ComboClasses.setSelectedItem("Suporte");
				break;
				
				
			}
			
			int i = ComboClasses.getSelectedIndex();

			if (file == null) {

				ImageIcon icon = new ImageIcon(getClass().getResource(Imagens[i]));
				iconUsuario.setText("");
				iconUsuario.setHorizontalAlignment((int) CENTER_ALIGNMENT);
				iconUsuario.setIcon(icon);

			}
		}

		this.add(ComboClasses);

		this.lblAtributos = new JLabel(Atributo[0]);
		this.lblAtributos.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblAtributos.setForeground(new Color(82, 75, 91));
		this.lblAtributos.setBounds(315, 145, 140, 20);
		this.add(lblAtributos);

		this.ComboClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = ComboClasses.getSelectedIndex();
				String mostrarAtributos = Atributo[i];
				lblAtributos.setText(mostrarAtributos);

				if (file == null) {

					ImageIcon icon = new ImageIcon(getClass().getResource(Imagens[i]));
					iconUsuario.setText("");
					iconUsuario.setHorizontalAlignment((int) CENTER_ALIGNMENT);
					iconUsuario.setIcon(icon);

				}
			}
		});

		// NIVEIS

		this.Niveis = new JLabel("Niveis!");
		this.Niveis.setForeground(new Color(90, 61, 171));
		this.Niveis.setFont(new Font("Arial", Font.BOLD, 16));
		this.Niveis.setBounds(110, 190, 65, 20);
		this.add(Niveis);

		this.nivelVida = new JLabel("Vida:");
		this.nivelVida.setForeground(new Color(90, 61, 171));
		this.nivelVida.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelVida.setBounds(35, 215, 50, 20);
		this.add(nivelVida);

		this.pcVida = new JLabel("100" + "%");
		this.pcVida.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcVida.setBounds(198, 215, 40, 18);
		this.add(pcVida);

		this.sldVida = new JSlider();
		this.sldVida.setBackground(new Color(235, 223, 255));
		this.sldVida.setForeground(new Color(90, 61, 171));
		this.sldVida.setMajorTickSpacing(20);
		this.sldVida.setMinorTickSpacing(5);
		this.sldVida.setPaintTicks(true);
		if (FPD.VereficaprotaOPEN() != false) {
			this.sldVida.setValue(FichaProtagonistaSelecionada.getVida());
			String vida = String.valueOf(FichaProtagonistaSelecionada.getVida());
			pcVida.setText(vida + "%");
		} else {
			this.sldVida.setValue(100);
		}
		this.sldVida.setValue(100);
		this.sldVida.setBounds(87, 215, 105, 30);
		this.sldVida.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcVida.setText(String.valueOf(sldVida.getValue()) + "%");

			}

		});
		this.add(sldVida);

		this.nivelDefesa = new JLabel("Defesa:");
		this.nivelDefesa.setForeground(new Color(90, 61, 171));
		this.nivelDefesa.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelDefesa.setBounds(35, 250, 75, 20);
		this.add(nivelDefesa);

		this.pcDefesa = new JLabel("100" + "%");
		this.pcDefesa.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcDefesa.setBounds(198, 250, 40, 18);
		this.add(pcDefesa);

		this.sldDefesa = new JSlider();
		this.sldDefesa.setBackground(new Color(235, 223, 255));
		this.sldDefesa.setForeground(new Color(90, 61, 171));
		this.sldDefesa.setMajorTickSpacing(20);
		this.sldDefesa.setMinorTickSpacing(5);
		this.sldDefesa.setPaintTicks(true);
		if (FPD.VereficaprotaOPEN() != false) {
			this.sldDefesa.setValue(FichaProtagonistaSelecionada.getDefesa());
			String defesa = String.valueOf(FichaProtagonistaSelecionada.getDefesa());
			pcDefesa.setText(defesa + "%");
		} else {
			this.sldDefesa.setValue(100);
		}
		this.sldDefesa.setValue(100);

		this.sldDefesa.setBounds(87, 250, 105, 30);

		this.sldDefesa.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcDefesa.setText(String.valueOf(sldDefesa.getValue()) + "%");

			}

		});
		this.add(sldDefesa);

		this.nivelMagia = new JLabel("Magia:");

		this.nivelMagia.setForeground(new Color(90, 61, 171));
		this.nivelMagia.setFont(new Font("Arial", Font.BOLD, 14));
		this.nivelMagia.setBounds(35, 280, 55, 20);
		this.add(nivelMagia);

		this.pcMagia = new JLabel("100" + "%");
		this.pcMagia.setFont(new Font("Arial", Font.BOLD, 14));
		this.pcMagia.setBounds(198, 280, 40, 18);
		this.add(pcMagia);

		this.sldMagia = new JSlider();
		this.sldMagia.setBackground(new Color(235, 223, 255));
		this.sldMagia.setForeground(new Color(90, 61, 171));
		this.sldMagia.setMajorTickSpacing(20);
		this.sldMagia.setMinorTickSpacing(5);
		this.sldMagia.setPaintTicks(true);

		if(FPD.VereficaprotaOPEN() != false) {

			this.sldMagia.setValue(FichaProtagonistaSelecionada.getMagia());
			String magia = String.valueOf(FichaProtagonistaSelecionada.getMagia());
			pcMagia.setText(magia + "%");
		} else {
			this.sldMagia.setValue(100);
		}
		this.sldMagia.setBounds(87, 280, 105, 30);
		this.sldMagia.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				pcMagia.setText(String.valueOf(sldMagia.getValue()) + "%");

			}

		});
		this.add(sldMagia);

		// HABILIDADES

		this.lblHabilidades = new JLabel("Habilidades!");
		this.lblHabilidades.setForeground(new Color(90, 61, 171));
		this.lblHabilidades.setFont(new Font("Arial", Font.BOLD, 16));
		this.lblHabilidades.setBounds(306, 200, 110, 20);
		this.add(lblHabilidades);

		this.lblPoder = new JLabel("Poder:");
		this.lblPoder.setForeground(new Color(90, 61, 171));
		this.lblPoder.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblPoder.setBounds(258, 215, 65, 20);
		this.add(lblPoder);

		SpinnerModel valuePoder = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnPoder = new JSpinner(valuePoder);

		if(FPD.VereficaprotaOPEN() != false) {

			this.spnPoder.setValue(FichaProtagonistaSelecionada.getPoder());
		}

		this.spnPoder.setEditor(new JSpinner.DefaultEditor(spnPoder));
		this.spnPoder.setBounds(258, 235, 50, 20);
		this.add(spnPoder);

		this.lblForca = new JLabel("Forca:");
		this.lblForca.setForeground(new Color(90, 61, 171));
		this.lblForca.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblForca.setBounds(328, 215, 60, 20);
		this.add(lblForca);

		SpinnerModel valueForca = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnForca = new JSpinner(valueForca);

		if(FPD.VereficaprotaOPEN() != false) {


			this.spnForca.setValue(FichaProtagonistaSelecionada.getForca());
		}

		this.spnForca.setEditor(new JSpinner.DefaultEditor(spnForca));
		this.spnForca.setBounds(328, 235, 50, 20);
		this.add(spnForca);

		this.lblCarisma = new JLabel("Carisma:");
		this.lblCarisma.setForeground(new Color(90, 61, 171));
		this.lblCarisma.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblCarisma.setBounds(388, 215, 70, 20);
		this.add(lblCarisma);

		SpinnerModel valueCarisma = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnCarisma = new JSpinner(valueCarisma);

		if(FPD.VereficaprotaOPEN() != false) {

			this.spnCarisma.setValue(FichaProtagonistaSelecionada.getCarisma());
		}

		this.spnCarisma.setEditor(new JSpinner.DefaultEditor(spnCarisma));
		this.spnCarisma.setBounds(394, 235, 50, 20);
		this.add(spnCarisma);

		this.lblAgilidade = new JLabel("Agilidade:");
		this.lblAgilidade.setForeground(new Color(90, 61, 171));
		this.lblAgilidade.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblAgilidade.setBounds(280, 265, 80, 20);
		this.add(lblAgilidade);

		SpinnerModel valueAgilidade = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnAgilidade = new JSpinner(valueAgilidade);
		if (FPD.VereficaprotaOPEN() != false) {
			spnAgilidade.setValue(FichaProtagonistaSelecionada.getAgilidade());
		}

		this.spnAgilidade.setEditor(new JSpinner.DefaultEditor(spnAgilidade));
		this.spnAgilidade.setBounds(285, 285, 55, 20);
		this.add(spnAgilidade);

		this.lblIntelecto = new JLabel("Intelecto:");
		this.lblIntelecto.setForeground(new Color(90, 61, 171));
		this.lblIntelecto.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblIntelecto.setBounds(360, 265, 80, 20);
		this.add(lblIntelecto);

		SpinnerModel valueIntelecto = new SpinnerNumberModel(1, 0, 5, 1);
		this.spnIntelecto = new JSpinner(valueIntelecto);

		if(FPD.VereficaprotaOPEN() != false) {

			this.spnIntelecto.setValue(FichaProtagonistaSelecionada.getIntelecto());
		}

		this.spnIntelecto.setEditor(new JSpinner.DefaultEditor(spnIntelecto));
		this.spnIntelecto.setBounds(365, 285, 50, 20);
		this.add(spnIntelecto);

		this.destaqueSalvar = new ImageIcon(getClass().getResource("/Imagens/Botões/destaque_salvar.png"));
		this.iconbtnSalvar = new ImageIcon(getClass().getResource("/Imagens/Botões/Salvar.png"));
		this.lblbtnSalvar = new JLabel(iconbtnSalvar);
		this.lblbtnSalvar.setToolTipText("Salvar");
		this.lblbtnSalvar.setBounds(120, 300, 120, 120);
		this.lblbtnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnSalvar.setIcon(destaqueSalvar);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnSalvar.setIcon(iconbtnSalvar);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FichaProtagonistaDAO FPD = new FichaProtagonistaDAO();
					FichaProtagonistaVO FPV = new FichaProtagonistaVO();
					String nome = txtfNome.getText();
					String ocupacao = txtfOcupacao.getText();
					int idade = Integer.parseInt(txtfIdade.getText());
					float altura = Float.parseFloat(txtfAltura.getText());
					int vida = sldVida.getValue();
					int defesa = sldDefesa.getValue();
					int magia = sldMagia.getValue();
					int poder = (int) spnPoder.getValue();
					int forca = (int) spnForca.getValue();
					int Carisma = (int) spnCarisma.getValue();
					int agilidade = (int) spnAgilidade.getValue();
					int intelecto = (int) spnIntelecto.getValue();
					int classe = 0;
					switch ((String) ComboClasses.getSelectedItem()) {
					case "Combatente":
						classe = 1;
						break;
					case "Feiticeiro":
						classe = 2;
						break;
					case "Healer":
						classe = 3;
						break;
					case "Suporte":
						classe = 4;
						break;
					}

					AuxiliarVO AV = new AuxiliarVO();

					ControleSessaoVO CSV = new ControleSessaoVO();
					int sessao = CSV.getId_sessao();

					FPV.setNome_Protagonista(nome);
					FPV.setOcupaçao_Protagonista(ocupacao);
					FPV.setIdade_Protagonista(idade);
					FPV.setAltura_Protagonista(altura);
					FPV.setVida_Protagonista(vida);
					FPV.setDefesa_Protagonista(defesa);
					FPV.setMagia_Protagonista(magia);
					FPV.setPoder_Protagonista(poder);
					FPV.setForca_Protagonista(forca);
					FPV.setCarisma_Protagonista(Carisma);
					FPV.setAgilidade_Protagonista(agilidade);
					FPV.setIntelecto_Protagonista(intelecto);
					FPV.setFkIdClasse_Protagonista(classe);
					FPV.setFKIdSessao_Protagonista(sessao);

					FPD.SalvarInformaçoes(FPV);
					JOptionPane.showMessageDialog(null, "salvo com sucesso");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, erro + "erro ao salvar");
				}
			}
		});
		this.add(lblbtnSalvar);

		this.lblSalvar = new JLabel("Salvar");
		this.lblSalvar.setForeground(new Color(90, 61, 171));
		this.lblSalvar.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblSalvar.setBounds(155, 390, 100, 20);
		this.add(lblSalvar);

		this.destaqueCancelar = new ImageIcon(getClass().getResource("/Imagens/Botões/destaque_cancelar.png"));
		this.iconbtnCancela = new ImageIcon(getClass().getResource("/Imagens/Botões/Cancelar.png"));
		this.lblbtnCancela = new JLabel(iconbtnCancela);
		this.lblbtnCancela.setToolTipText("Cancelar");
		this.lblbtnCancela.setBounds(265, 320, 90, 90);
		this.lblbtnCancela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnCancela.setIcon(destaqueCancelar);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnCancela.setIcon(iconbtnCancela);
			}
		});
		this.add(lblbtnCancela);

		this.lblCancela = new JLabel("Cancelar");
		this.lblCancela.setForeground(new Color(90, 61, 171));
		this.lblCancela.setFont(new Font("Arial", Font.BOLD, 14));
		this.lblCancela.setBounds(280, 390, 100, 20);
		this.add(lblCancela);

		this.btnApagar = new JButton("Apagar");
		this.btnApagar.setBounds(200, 415, 90, 25);
		this.btnApagar.setFont(new Font("Arial", Font.BOLD, 14));
		this.btnApagar.setBackground(new Color(90, 61, 171));
		this.btnApagar.setForeground(Color.white);
		//this.add(btnApagar);

		this.iconbtnAnterior = new ImageIcon(getClass().getResource("/Imagens/Botões/Esquerda.png"));
		this.lblbtnAnterior = new JLabel(iconbtnAnterior);
		this.lblbtnAnterior.setToolTipText("Anterior");
		this.lblbtnAnterior.setBounds(10, 370, 120, 120);
		this.lblbtnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnAnterior.setIcon(iconbtnAnterior);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnAnterior.setIcon(iconbtnAnterior);
			}
		});
		//this.add(lblbtnAnterior);

		this.iconbtnProximo = new ImageIcon(getClass().getResource("/Imagens/Botões/Direita.png"));
		this.lblbtnProximo = new JLabel(iconbtnProximo);
		this.lblbtnProximo.setToolTipText("Proximo");
		this.lblbtnProximo.setBounds(355, 370, 120, 120);
		this.lblbtnProximo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblbtnProximo.setIcon(iconbtnProximo);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblbtnProximo.setIcon(iconbtnProximo);
			}
		});
		//this.add(lblbtnProximo);

		this.jpHabilidades = new JPanel();
		this.jpHabilidades.setLayout(null);
		this.jpHabilidades.setBackground(new Color(235, 223, 235));
		this.jpHabilidades.setBounds(15, 15, 450, 440);
		this.jpHabilidades.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(90, 61, 171), 3));
		this.add(jpHabilidades);

		this.fichaWall = new ImageIcon(getClass().getResource("/Imagens/Background/Fichas.png"));
		this.fichaWall = new ImageIcon(fichaWall.getImage().getScaledInstance(580, 500, Image.SCALE_DEFAULT));
		this.bckgFicha = new JLabel(fichaWall);
		this.bckgFicha.setBounds(-10, -10, 580, 500);
		this.add(bckgFicha);

		this.imgIcon = new ImageIcon("jupiter.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/Icones/jupiter.png")));

		
		
	               
	     FPD.DesativaprotaOPEN();      
	}
		}
