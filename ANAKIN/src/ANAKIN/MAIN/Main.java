package ANAKIN.MAIN;

import java.sql.ResultSet;

import ANAKIN.MODEL.DAO.ManterSessaoDAO;
import ANAKIN.VIEW.MenuPrincipalVIEW;
import ANAKIN.VIEW.SlpashVIEW;
import ANAKIN.VIEW.TelaInicialVIEW;

public class Main {

	public static void main(String[] args) {
		/*
		 * SlpashVIEW sp = new SlpashVIEW(1500); sp.mostrarSair();
		 */
		TelaInicialVIEW frame = new TelaInicialVIEW();
		frame.setVisible(true);
	}
}