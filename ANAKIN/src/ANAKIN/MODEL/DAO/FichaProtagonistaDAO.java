package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.FichaProtagonistaVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class FichaProtagonistaDAO {
Connection conn = null;
PreparedStatement PSTM;
public int VereficaprotaAcessado() {
	conn = new ConexaoDAO().conectabd();
	String SQL = "SELECT id_protagonista,nomw_protagonista from fprotaacessada;";
	try {
		PSTM = conn.prepareStatement(SQL);
		ResultSet resultado = PSTM.executeQuery();
		if(resultado != null) {
			return 1;
		}else {
			return 0;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return 0;
	}
}
public void AcessaprotaAcessado(String nome) {
	conn = new ConexaoDAO().conectabd();
	AuxiliarVO AV = new AuxiliarVO();
	String SQL = "update fprotaacessada set id_protagonista = ? ,nomw_protagonista = ? where id_porta = 1;";
	try {
		PSTM = conn.prepareStatement(SQL);
		PSTM.setInt(1, AV.getIdprotagonista());
		PSTM.setString(2, nome);
		PSTM.executeUpdate();
		PSTM.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public ResultSet retornainfotprota(int id,String nome) {
	conn = new ConexaoDAO().conectabd();
	AuxiliarVO AV = new AuxiliarVO();
	String SQL = "SELECT nome_protagonista,"
			+ "ocupacao_Protagonista,"
			+ "idade_protagonista,"
			+ "altura_protagonista, "
			+ "vida_protagonista, "
			+ "defesa_protagonista, "
			+ "magia_protagonista,"
			+ "poder,"
			+ "forca,"
			+ "carisma,"
			+ "agilidade,"
			+ "intelecto,"
			+ "id_classe FROM protagonista where id_protagonista = 10 and nome_protagonista = 'tatakae';";
	try {
		PSTM = conn.prepareStatement(SQL);
		//PSTM.setInt(1, id);
		//PSTM.setString(2, nome);
		ResultSet infor = PSTM.executeQuery();
		
		if(infor.next()) {
			return infor;
		}PSTM.close();
		return null;
		
	} catch (Exception e) {
	 e.printStackTrace();
	 return null;
	}

}
public int retornaidprotagonista(String nome) {
	conn = new ConexaoDAO().conectabd();
	AuxiliarVO AV = new AuxiliarVO();
	String SQL = "select distinct id_protagonista from protagonista where nome_protagonista = ? and id_sessao = ?;";
	try {
		PSTM = conn.prepareStatement(SQL);
		PSTM.setString(1, nome);
		PSTM.setInt(2, AV.getIdsessao());
		ResultSet resultado = PSTM.executeQuery();
		while(resultado.next()) {
			int idprota = resultado.getInt(1);
			return idprota;
		}
		PSTM.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
		return 0 ;
	}
	return 0;
}
public int retornaTantoFicha() {
	conn = new ConexaoDAO().conectabd();
	AuxiliarVO AV = new AuxiliarVO();
	String sql = "SELECT COUNT(*) AS total FROM protagonista where id_sessao = ?;";
	int INTtotal = 0;
	try {
		PSTM = conn.prepareStatement(sql);
		PSTM.setInt(1,AV.getIdsessao() );
		ResultSet total = PSTM.executeQuery();
		while(total.next()) {
			INTtotal = total.getInt(1);
		}
		PSTM.close();
		return INTtotal;
	} catch (SQLException e) {
		e.printStackTrace();
		return 0;
	}
}
public ResultSet informaçoesbaseFP() {
	conn = new ConexaoDAO().conectabd();
	AuxiliarVO AV = new AuxiliarVO();
    String query = "SELECT nome_protagonista, vida_protagonista, defesa_protagonista, magia_protagonista FROM protagonista where id_sessao = ?";
    try {
	PreparedStatement PSTM = conn.prepareStatement(query);
    PSTM.setInt(1,AV.getIdsessao());
    ResultSet resultSet = PSTM.executeQuery();
    while (resultSet.next()) {
    	
    	return resultSet;
    }PSTM.close();
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
    return null;
}
public void criarRegistroProta() {
	conn = new ConexaoDAO().conectabd();
	String sql = ("insert into protagonista(id_SESSAO) value (?);");
	AuxiliarVO AV = new AuxiliarVO(); 
	try {
		PSTM = conn.prepareStatement(sql);
		PSTM.setInt(1, AV.getIdsessao());
		int i = PSTM.executeUpdate();
		PSTM.close();
		if(i>0) {
			PSTM = conn.prepareStatement("SELECT LAST_INSERT_ID();");
			ResultSet result = PSTM.executeQuery();
			if(result.next()) {
			int id =result.getInt(1);
			AV.setIdprotagonista(id);
			PSTM.close();
			}
		}
		PSTM.close();
	} catch (SQLException e) {
		System.err.println("erro em criar registro protagonista: " + e);
	}
}
public void SalvarInformaçoes(FichaProtagonistaVO prota) {
	 conn = new ConexaoDAO().conectabd();
	 AuxiliarVO AV = new AuxiliarVO();
	 
	String sql1 = "update protagonista set nome_protagonista = ?, ocupacao_Protagonista = ?, idade_Protagonista = ?, altura_Protagonista = ?, vida_Protagonista = ?, defesa_Protagonista = ?, magia_Protagonista = ?, Poder = ?, Forca = ?, Carisma = ?, Agilidade = ?, Intelecto = ?, id_CLASSE = ? where id_protagonista = ?;";
	try {
		PSTM = conn.prepareStatement(sql1);
		PSTM.setString(1, prota.getNome_Protagonista());
		PSTM.setString(2,prota.getOcupaçao_Protagonista());
		PSTM.setInt(3, prota.getIdade_Protagonista());
		PSTM.setFloat(4, prota.getAltura_Protagonista());
		PSTM.setInt(5, prota.getVida_Protagonista());
		PSTM.setInt(6, prota.getDefesa_Protagonista());
		PSTM.setInt(7, prota.getMagia_Protagonista());
		PSTM.setInt(8, prota.getPoder_Protagonista());
		PSTM.setInt(9, prota.getForca_Protagonista());
		PSTM.setInt(10, prota.getCarisma_Protagonista());
		PSTM.setInt(11, prota.getAgilidade_Protagonista());
		PSTM.setInt(12, prota.getIntelecto_Protagonista());
		PSTM.setInt(13, prota.getFkIdClasse_Protagonista());
		PSTM.setInt(14, AV.getIdprotagonista());
		PSTM.executeUpdate();
		PSTM.close();
	}catch(SQLException erro) {
		System.out.println(erro + "erro em salvar informaçoes do protagonista");
	}
}
	public int retornaidUsuario (String nome) {
		conn = new ConexaoDAO().conectabd();
		int valor;
		
		try {
			String sql2 = "select id_sessao from controle_sessao where id_usuario =?";
			PSTM = conn.prepareStatement(sql2);
			PSTM.setString(1, nome);
			ResultSet resultado = PSTM.executeQuery();
			
			if(resultado.next()) {
				valor = resultado.getInt(1);
				System.out.println(resultado);
				return valor;
				
			}else {
				System.out.println(" resultado nao encontrado");
			}
			PSTM.close();
			return 0 ;
			
		}catch(SQLException erro) {
			System.out.println( erro + " erro ao chamar id do usuario");
			return 0 ;
		}
		
	}
	public static void main(String[]args) {
		FichaProtagonistaDAO FPD = new FichaProtagonistaDAO();
		FichaProtagonistaVO FPV = new FichaProtagonistaVO();
		
		UsuarioVO AV = new UsuarioVO();
		int i =FPV.getFKIdSessao_Protagonista();
		System.out.println(i);
		
		}
}
