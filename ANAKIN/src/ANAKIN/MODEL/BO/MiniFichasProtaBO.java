package ANAKIN.MODEL.BO;

public class MiniFichasProtaBO {
	private static String nome;
	private static int vida;
	private static int defesa;
	private static int magia;

	public MiniFichasProtaBO(String nome,int vida, int defesa,int magia) {
		this.nome = nome;
		this.vida = vida;
		this.defesa = defesa;
		this.magia = magia;
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		MiniFichasProtaBO.nome = nome;
	}

	public static int getVida() {
		return vida;
	}

	public static void setVida(int vida) {
		MiniFichasProtaBO.vida = vida;
	}

	public static int getDefesa() {
		return defesa;
	}

	public static void setDefesa(int defesa) {
		MiniFichasProtaBO.defesa = defesa;
	}

	public static int getMagia() {
		return magia;
	}

	public static void setMagia(int magia) {
		MiniFichasProtaBO.magia = magia;
	}

	
	
	

}