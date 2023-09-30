package ANAKIN.MODEL.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.ControleSessaoVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class AbrirSessaoDAO {
	Connection conn;
	PreparedStatement PSTM;
	ResultSet rs;
	
	public void abrirControleSessao() {
		try {
			
			UsuarioVO user = new UsuarioVO();
			ControleSessaoVO cont = new ControleSessaoVO();
			//String sql = "SELECT nome_sessao, inventario_sessao, anotacoes_sessao from controle_sessao where nome_sessao = ? and id_usuario = 'beabna'";
			String sql = "SELECT nome_sessao from controle_sessao where nome_sessao = 'teste' and id_sessao = 3 and id_usuario = '"+ user.getNome_Usuario() +"'";
			conn = new ConexaoDAO().conectabd();
			PSTM = conn.prepareStatement(sql);
			
			rs = PSTM.executeQuery();
			
			while (rs.next()) {
				 //System.out.println(rs.getString("nome_sessao"));
				 cont.setNome_sessao(rs.getString("nome_sessao"));
				 System.out.println(cont.getNome_sessao());
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "AbrirSessaoDAO: " + e);
		}
	}

}
