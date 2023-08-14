package ANAKIN.VIEW;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SlpashVIEW extends JWindow{
	private JPanel Content = (JPanel)getContentPane();
	private int Duracao;
	private ImageIcon Logo;
	
	public SlpashVIEW(int d) {
		Duracao = d;
	}
	
	public void mostarSplash() {
		setBounds(300, 200, 940, 550);
		setLayout(null);
		
		Logo = new ImageIcon(getClass().getResource("LogoSplash.gif"));
		JLabel label = new JLabel(Logo);
		
		label.setBounds(290, 10, 350, 350);
		Content.add(label);
		
		setVisible(true);
		
		try {
			Thread.sleep(Duracao);
		}catch (Exception e){}
		
		setVisible(false);
	}
	
	public void mostrarSair() {
		mostarSplash();
	}
}
