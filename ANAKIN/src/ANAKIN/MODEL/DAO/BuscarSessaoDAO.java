package ANAKIN.MODEL.DAO;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;
import ANAKIN.VIEW.ControleSessaoVIEW;

public class BuscarSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;
	static int linhas;

	public static int getLinhas() {
		return linhas;
	}

	public String [] retornaSessoes(String [] dados) {
		try {
		UsuarioVO user = new UsuarioVO();
		conn = new ConexaoDAO().conectabd();
		ControleSessaoVO cont = new ControleSessaoVO();
		ControleSessaoVIEW contV = new ControleSessaoVIEW();
		String sql = "select nome_sessao from controle_sessao where id_Usuario = '"
				+ user.getNome_Usuario() + "' and id_sessao = " + cont.getId_sessao();
		PSTM = new ConexaoDAO().conectabd().prepareStatement(sql);
		ResultSet resultSet = PSTM.executeQuery();
		int qtdeColunas = resultSet.getMetaData().getColumnCount();
		ArrayList<String> lista = new ArrayList<String>();

		while (resultSet.next()) {
			lista.add(resultSet.getString(1));
		}
		dados = lista.toArray(new String[lista.size()]);

		resultSet.close();
		PSTM.close();

		return dados;
	} catch (Exception erro) {
		JOptionPane.showMessageDialog(null, erro);
		return null;
	}
	}



	public String[] retornaIds(String[] dados) {
		try {
			UsuarioVO user = new UsuarioVO();

			String id = "select id_sessao from controle_sessao where id_usuario = '" + user.getNome_Usuario() + "'";
			PSTM = new ConexaoDAO().conectabd().prepareStatement(id);
			ResultSet resultSet = PSTM.executeQuery();
			int qtdeColunas = resultSet.getMetaData().getColumnCount();
			ArrayList<String> lista = new ArrayList<String>();

			while (resultSet.next()) {
				lista.add(resultSet.getString(1));
			}
			dados = lista.toArray(new String[lista.size()]);

			resultSet.close();
			PSTM.close();

			return dados;
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
			return null;
		}

	}

	public int qtdColunas() {
		try {
			UsuarioVO user = new UsuarioVO();

			String id = "select id_sessao from controle_sessao where id_usuario = '" + user.getNome_Usuario() + "'";
			PSTM = new ConexaoDAO().conectabd().prepareStatement(id);
			ResultSet resultSet = PSTM.executeQuery();
			int qtd = resultSet.getMetaData().getColumnCount();

			resultSet.close();
			PSTM.close();

			return qtd;

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
			return 0;
		}
	}

	public String[] retornaNomes(String[] dados) {
		try {
			UsuarioVO user = new UsuarioVO();
			String sql = "select nome_sessao from controle_sessao where id_usuario = '" + user.getNome_Usuario() + "'";
			String id = "select id_sessao from controle_sessao where id_usuario = '" + user.getNome_Usuario() + "'";
			PSTM = new ConexaoDAO().conectabd().prepareStatement(sql);
			ResultSet resultSet = PSTM.executeQuery();
			int qtdeColunas = resultSet.getMetaData().getColumnCount();
			ArrayList<String> lista = new ArrayList<String>();

			while (resultSet.next()) {
				lista.add(resultSet.getString(1));
			}
			dados = lista.toArray(new String[lista.size()]);

			resultSet.close();
			PSTM.close();

			return dados;
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
			return null;
		}
	}

}
