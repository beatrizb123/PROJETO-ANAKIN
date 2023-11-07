package ANAKIN.MODEL.BO;

public class MiniFichasNPCBO {
	private static String NomeNPC ;
	private static int VidaNPC ;
	private static int DefNPC;
	private static int MagNPC;
	public MiniFichasNPCBO(String nome, int vida, int def, int mag) {
		this.NomeNPC = nome;
		this.VidaNPC = vida;
		this.DefNPC = def;
		this.MagNPC = mag;
	}
	public static String getNomeNPC() {
		return NomeNPC;
	}
	public static void setNomeNPC(String nomeNPC) {
		NomeNPC = nomeNPC;
	}
	public static int getVidaNPC() {
		return VidaNPC;
	}
	public static void setVidaNPC(int vidaNPC) {
		VidaNPC = vidaNPC;
	}
	public static int getDefNPC() {
		return DefNPC;
	}
	public static void setDefNPC(int defNPC) {
		DefNPC = defNPC;
	}
	public static int getMagNPC() {
		return MagNPC;
	}
	public static void setMagNPC(int magNPC) {
		MagNPC = magNPC;
	}
	
	
}
