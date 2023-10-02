package ANAKIN.MODEL.BO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class ImagemBO {
	JFileChooser jfArquivo;
	BufferedImage bfimg;
	File file;
	
	public ImagemBO() {
		jfArquivo = new JFileChooser();
		jfArquivo.setCurrentDirectory(new File(System.getProperty("user.downloads")));
	
	}
	
	public ImageIcon abrirImagem (String caminho) {
		java.net.URL imgURL = ImagemBO.class.getResource(caminho);
		
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		}else {
			System.err.println("ImagemBO: "+ caminho);
			return null;
		}
		
		
		
	}
	
	public ImageIcon carregarImagem () {
		jfArquivo.showOpenDialog(null);
		file = jfArquivo.getSelectedFile();
		
		try {
			bfimg = ImageIO.read(file);
			ImageIcon icon = new ImageIcon(bfimg);
			
			return icon;
		} catch (IOException e) {
        	e.printStackTrace();
        	return null;
		}
		
	}
	

	
}
