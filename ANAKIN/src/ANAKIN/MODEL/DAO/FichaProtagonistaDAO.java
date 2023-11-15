package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ANAKIN.MODEL.BO.FichaProtagonistaSelecionada;
import ANAKIN.MODEL.BO.MiniFichasProtaBO;
import ANAKIN.MODEL.VO.AuxiliarVO;
import ANAKIN.MODEL.VO.FichaProtagonistaVO;
import ANAKIN.MODEL.VO.UsuarioVO;

public class FichaProtagonistaDAO {
	Connection conn = null;
	PreparedStatement PSTM;
	public boolean VereficaprotaOPEN() {
		conn = new ConexaoDAO().conectabd();
		String sql = "select vereficador from protaopen";
		try {
			PSTM = conn.prepareStatement(sql);
			ResultSet RESP = PSTM.executeQuery();
			if(RESP.next()){
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void AtivaprotaOPEN() {
		conn = new ConexaoDAO().conectabd();
		String sql = "insert into protaOPEN(ID_Porta,vereficador) value (1,'open');";
		
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void DesativaprotaOPEN() {
		conn = new ConexaoDAO().conectabd();
		String sql = "delete protaopen from protaopen where id_Porta = 1 ;";
		
		try {
			PSTM = conn.prepareStatement(sql);
			PSTM.executeUpdate();
			PSTM.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void retornainfotprota(String nome, int vida, int def, int mag) {
	conn = new ConexaoDAO().conectabd();
	AuxiliarVO AV = new AuxiliarVO();
	String SQL = "SELECT nome_protagonista, ocupacao_Protagonista, idade_protagonista, altura_protagonista, vida_protagonista, defesa_protagonista, magia_protagonista, poder, forca, carisma, agilidade, intelecto, id_classe FROM protagonista where nome_Protagonista = ? and vida_Protagonista = ? and defesa_Protagonista = ? and magia_Protagonista = ?;";
			FichaProtagonistaSelecionada FPS ;
	try {
		PSTM = conn.prepareStatement(SQL);
		PSTM.setString(1, nome);
		PSTM.setInt(2, vida);
		PSTM.setInt(3, def);
		PSTM.setInt(4, mag);
		ResultSet infor = PSTM.executeQuery();
		
		if(infor.next()) {
			
			FPS = new FichaProtagonistaSelecionada(infor.getString(1), infor.getString(2), infor.getInt(3), infor.getFloat(4), infor.getInt(5), infor.getInt(6) , infor.getInt(7), infor.getInt(8), infor.getInt(9), infor.getInt(10), infor.getInt(11), infor.getInt(12), infor.getInt(13));
			PSTM.close();
		}else {
		PSTM.close();
		}
		
	} catch (Exception e) {
	 e.printStackTrace();
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
			while (resultado.next()) {
				int idprota = resultado.getInt(1);
				return idprota;
			}
			PSTM.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
			PSTM.setInt(1, AV.getIdsessao());
			ResultSet total = PSTM.executeQuery();
			while (total.next()) {
				INTtotal = total.getInt(1);
			}
			PSTM.close();
			return INTtotal;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public MiniFichasProtaBO informaçoesbaseFP( int posicao) {
	    this.conn = new ConexaoDAO().conectabd();
	    AuxiliarVO AV = new AuxiliarVO();
	    FichaProtagonistaDAO tanto = new FichaProtagonistaDAO();
	    String query = "select nome_Protagonista,vida_Protagonista,defesa_Protagonista,magia_Protagonista from protagonista where id_SESSAO = ? limit 1 OFFSET ? ;";
	    MiniFichasProtaBO registro = null;
	    try {
	        PreparedStatement PSTM = conn.prepareStatement(query);
	        PSTM.setInt(1, AV.getIdsessao());
	        PSTM.setInt(2, posicao);
	        ResultSet resultSet = PSTM.executeQuery();
	        
	        while (resultSet.next()) {
	            String nome = resultSet.getString(1);
	            int vida = resultSet.getInt(2);
	            int defesa = resultSet.getInt(3);
	            int magia = resultSet.getInt(4);
	            
	            registro = new MiniFichasProtaBO(nome, vida, defesa, magia);
	        }
	        
	        PSTM.close();
	        

	        return registro;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
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
			if (i > 0) {
				PSTM = conn.prepareStatement("SELECT LAST_INSERT_ID();");
				ResultSet result = PSTM.executeQuery();
				if (result.next()) {
					int id = result.getInt(1);
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
			PSTM.setString(2, prota.getOcupaçao_Protagonista());
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
		} catch (SQLException erro) {
			System.out.println(erro + "erro em salvar informaçoes do protagonista");
		}
	}

	public int retornaidUsuario(String nome) {
		conn = new ConexaoDAO().conectabd();
		int valor;

		try {
			String sql2 = "select id_sessao from controle_sessao where id_usuario =?";
			PSTM = conn.prepareStatement(sql2);
			PSTM.setString(1, nome);
			ResultSet resultado = PSTM.executeQuery();

			if (resultado.next()) {
				valor = resultado.getInt(1);
				System.out.println(resultado);
				return valor;

			} else {
				System.out.println(" resultado nao encontrado");
			}
			PSTM.close();
			return 0;

		} catch (SQLException erro) {
			System.out.println(erro + " erro ao chamar id do usuario");
			return 0;
		}

	}

	public static void main(String[] args) {
		FichaProtagonistaDAO FPD = new FichaProtagonistaDAO();
		FichaProtagonistaVO FPV = new FichaProtagonistaVO();

		UsuarioVO AV = new UsuarioVO();
		int i = FPV.getFKIdSessao_Protagonista();
		System.out.println(i);

	}
}