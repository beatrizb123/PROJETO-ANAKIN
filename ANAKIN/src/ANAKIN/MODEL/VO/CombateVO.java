package ANAKIN.MODEL.VO;

public class CombateVO {
	private static  String Nome_NPC;
	private static int Vida_NPC;
	private static int Defesa_NPC;
	private static int Magia_NPC;
	private static int idAlinha;
	
	
	private static  String Nome_Protag;
	private static int Vida_Protag;
	private static int Defesa_Protag;
	private static int Magia_Protag;
	private static int idClasse;
	public static String getNome_NPC() {
		return Nome_NPC;
	}
	public static void setNome_NPC(String nome_NPC) {
		Nome_NPC = nome_NPC;
	}
	public static int getVida_NPC() {
		return Vida_NPC;
	}
	public static void setVida_NPC(int vida_NPC) {
		Vida_NPC = vida_NPC;
	}
	public static int getDefesa_NPC() {
		return Defesa_NPC;
	}
	public static void setDefesa_NPC(int defesa_NPC) {
		Defesa_NPC = defesa_NPC;
	}
	public static int getMagia_NPC() {
		return Magia_NPC;
	}
	public static void setMagia_NPC(int magia_NPC) {
		Magia_NPC = magia_NPC;
	}
	public static int getIdAlinha() {
		return idAlinha;
	}
	public static void setIdAlinha(int idAlinha) {
		CombateVO.idAlinha = idAlinha;
	}
	public static String getNome_Protag() {
		return Nome_Protag;
	}
	public static void setNome_Protag(String nome_Protag) {
		Nome_Protag = nome_Protag;
	}
	public static int getVida_Protag() {
		return Vida_Protag;
	}
	public static void setVida_Protag(int vida_Protag) {
		Vida_Protag = vida_Protag;
	}
	public static int getDefesa_Protag() {
		return Defesa_Protag;
	}
	public static void setDefesa_Protag(int defesa_Protag) {
		Defesa_Protag = defesa_Protag;
	}
	public static int getMagia_Protag() {
		return Magia_Protag;
	}
	public static void setMagia_Protag(int magia_Protag) {
		Magia_Protag = magia_Protag;
	}
	public static int getIdClasse() {
		return idClasse;
	}
	public static void setIdClasse(int idClasse) {
		CombateVO.idClasse = idClasse;
	}
	
	private static String dados;
	public static String getDados() {
		return dados;
	}
	public static void setDados(String dados) {
		CombateVO.dados = dados;
	}
	

}
