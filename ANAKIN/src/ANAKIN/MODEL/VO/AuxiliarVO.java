package ANAKIN.MODEL.VO;

public class AuxiliarVO {
	private static int idusuario;
	private static int idsessao;
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
