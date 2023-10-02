package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.UsuarioVO;

public class ManterSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;

	public void finalizaSessao() {
		conn = new ConexaoDAO().conectabd();
		try {
			String SQL = "update NumeroVereficador set numero = 0 where id = 1;";
			PSTM = conn.prepareStatement(SQL);
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro + "ouve um erro");
		}
	}

	public ResultSet VereficaManterSessao() {
		try {
			conn = new ConexaoDAO().conectabd();
			String SQL = "Select numero from numerovereficador where id = 1";
			PSTM = conn.prepareStatement(SQL);
			ResultSet numero = PSTM.executeQuery();
			return numero;

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro);
			return null;
		}

	}

	public void Sessaomanter(int numerador) {
		conn = new ConexaoDAO().conectabd();
		try {
			String SQL = "update NumeroVereficador set numero = ? where id = 1;";
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, numerador);
			PSTM.executeUpdate();
			PSTM.close();

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro);
		}

	}
	
	public void guardar (int i, UsuarioVO nome) {
		conn = new ConexaoDAO().conectabd();
		String sql = null;
		try {
			if (i == 1) {
				sql = "update NumeroVereficador set usuario = '" + nome.getNome_Usuario() + "' where id = 1";	
			}else if (i == 0) {
				sql = "update NumeroVereficador set usuario = null  where id = 1";	 
			}
			PSTM = conn.prepareStatement(sql);
			PSTM.executeUpdate();
			PSTM.close();
			
		} catch (SQLException erro12) {
			JOptionPane.showMessageDialog(null,"guardar" + erro12);
		}

	}
	
	public String chamar() {
		conn = new ConexaoDAO().conectabd();
		String sql = "select usuario from numerovereficador where id = 1";
		try {
			String nome= null;
			PSTM = conn.prepareStatement(sql);
			ResultSet rs = PSTM.executeQuery();
			if(rs.next()) {
			nome = rs.getString(1);
			}return nome;
		} catch (SQLException erro12) {
			JOptionPane.showMessageDialog(null, "chamar" + erro12);
			return null;
		}
		
	}

}
