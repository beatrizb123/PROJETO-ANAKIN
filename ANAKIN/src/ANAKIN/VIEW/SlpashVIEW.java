package ANAKIN.VIEW;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SlpashVIEW extends JWindow{
	private JPanel Content = (JPanel)getContentPane();
	private int Duracao;
	private ImageIcon LogoSplash;
	
	public SlpashVIEW(int d) {
		Duracao = d;
	}
	
	public void mostarSplash() {
		this.setBounds(300, 200, 940, 550);
		this.setLayout(null);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((tela.width - getSize().width)/2,(tela.height - getSize().height)/2);

		
		this.LogoSplash = new ImageIcon(getClass().getResource("teste.gif"));
		JLabel label = new JLabel(LogoSplash);
		
		label.setBounds(320, 100, 340, 370);
		Content.add(label);
		
		this.setVisible(true);
		
		try {
			Thread.sleep(Duracao);
		}catch (Exception e){}
		
		setVisible(false);
	}
	
	public void mostrarSair() {
		mostarSplash();
	}
}
