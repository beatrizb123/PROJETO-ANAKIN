package ANAKIN.MODEL.VO;

public class AuxiliarVO {

	// variaveis auxiliares
	private static int idprotagonista;
	private static String nomeprotagonista;
	
	public static String getNomeprotagonista() {
		return nomeprotagonista;
	}

	public static void setNomeprotagonista(String nomeprotagonista) {
		AuxiliarVO.nomeprotagonista = nomeprotagonista;
	}

	public static int getIdprotagonista() {
		return idprotagonista;
	}

	public static void setIdprotagonista(int idprotagonista) {
		AuxiliarVO.idprotagonista = idprotagonista;
	}

	private static int idusuario;
	private static int idsessao;
	private static int idprotagonista;
	private static int idNPC;
	private static int idDados;
		private static String nomeprotagonista;
	
	public static String getNomeprotagonista() {
		return nomeprotagonista;
	}

	public static void setNomeprotagonista(String nomeprotagonista) {
		AuxiliarVO.nomeprotagonista = nomeprotagonista;
	}

	

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

	public static int getIdNPC() {
		return idNPC;
	}

	public static void setIdNPC(int idNPC) {
		AuxiliarVO.idNPC = idNPC;
	}

	public static int getIdDados() {
		return idDados;
	}

	public static void setIdDados(int idDados) {
		AuxiliarVO.idDados = idDados;
	}
	
}