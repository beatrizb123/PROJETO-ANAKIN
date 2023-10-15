package ANAKIN.MODEL.VO;

public class AuxiliarVO {
	//variaveis auxiliares 
	private static int idusuario;
	private static int idsessao;
	private static int idprotagonista;
	// get and set
	public static int getIdprotagonista() {
		return idprotagonista;
	}

	public static void setIdprotagonista(int idprotagonista) {
		AuxiliarVO.idprotagonista = idprotagonista;
	}

	private static String nomesessaoAUX;
	
	public static String getNomesessaoAUX() {
		return nomesessaoAUX;
	}

	public static void setNomesessaoAUX(String nomesessaoAUX) {
		AuxiliarVO.nomesessaoAUX = nomesessaoAUX;
	}

	public static int getIdsessao() {
		return idsessao;
	}

	public static void setIdsessao(int idsessao) {
		AuxiliarVO.idsessao = idsessao;
	}

	public static int getIdusuario() {
		return idusuario;
	}

	public static void setIdusuario(int idusuario) {
		AuxiliarVO.idusuario = idusuario;
	}

}
