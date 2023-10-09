package ANAKIN.MODEL.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class AbrirSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;
	ResultSet rs;
	
	public ArrayList<String> abrirControleSessao(int id) {
		ArrayList<String> registrosControle = new ArrayList<>();
		UsuarioVO user = new UsuarioVO();
		ControleSessaoVO cont = new ControleSessaoVO();
		//select nome_sessao, inventario_sessao, anotacoes_sessao from controle_sessao where id_sessao = 1;
		//String sql = "SELECT nome_sessao, inventario_sessao, anotacoes_sessao from controle_sessao where nome_sessao = ? and id_usuario = 'beabna'";
		String sql = "select nome_sessao from controle_sessao where id_sessao = ?";
		conn = new ConexaoDAO().conectabd();
		
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.setInt(1, id);
			
			rs = PSTM.executeQuery();
			
			while (rs.next()) {
				 String nome = rs.getString(1);
				 registrosControle.add(nome);
				 System.out.println(registrosControle);
			}
			PSTM.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "AbrirSessaoDAO: " + e);
			return null;
		}
		return registrosControle;
	}

}
