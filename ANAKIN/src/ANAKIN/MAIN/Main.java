package ANAKIN.MAIN;

import java.sql.ResultSet;

import javax.swing.JFrame;

import ANAKIN.MODEL.DAO.ManterSessaoDAO;
import ANAKIN.MODEL.VO.UsuarioVO;
import ANAKIN.VIEW.MenuPrincipalVIEW;
import ANAKIN.VIEW.TelaInicialVIEW;

public class Main extends JFrame {

	public static void main(String[] args) {
		// SlpashVIEW sp = new SlpashVIEW(1000);
		// sp.mostrarSair();
		int valor;
		ManterSessaoDAO MSD = new ManterSessaoDAO();
		ResultSet result = MSD.VereficaManterSessao();
		if (result != null) {		
			try {
				if (result.next()) {
					valor = result.getInt("numero");
					if (valor == 1) {
						MenuPrincipalVIEW TPV = new MenuPrincipalVIEW();
						TPV.setVisible(true);
						UsuarioVO user = new UsuarioVO();
					} else if (valor == 0) {
						TelaInicialVIEW frame = new TelaInicialVIEW();
						frame.setVisible(true);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}