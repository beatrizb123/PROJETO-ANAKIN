package ANAKIN.MODEL.BO;

public class FichaProtagonistaSelecionada {
	private static String nome;
	private static String Ocupacao;
	private static int idade;
	private static float altura;
	private static int vida;
	private static int defesa;
	private static int magia;
	private static int poder;
	private static int forca;
	private static int carisma;
	private static int agilidade;
    private	static int intelecto;
	private static int classe;

	public FichaProtagonistaSelecionada(String nome, String Ocupacao, int idade, float altura, int vida, int defesa, int magia, int poder,int forca, int carisma, int agilidade, int intelecto , int classe) {
		this.nome = nome;
		this.Ocupacao = Ocupacao;
		this.idade = idade;
		this.altura = altura;
		this.vida = vida;
		this.defesa = defesa;
		this.magia = magia;
		this.poder = poder;
		this.forca = forca;
		this.carisma = carisma;
		this.agilidade = agilidade;
		this.intelecto = intelecto;
		this.classe = classe;
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		FichaProtagonistaSelecionada.nome = nome;
	}

	public static String getOcupacao() {
		return Ocupacao;
	}

	public static void setOcupacao(String ocupacao) {
		Ocupacao = ocupacao;
	}

	public static int getIdade() {
		return idade;
	}

	public static void setIdade(int idade) {
		FichaProtagonistaSelecionada.idade = idade;
	}

	public static float getAltura() {
		return altura;
	}

	public static void setAltura(float altura) {
		FichaProtagonistaSelecionada.altura = altura;
	}

	public static int getVida() {
		return vida;
	}

	public static void setVida(int vida) {
		FichaProtagonistaSelecionada.vida = vida;
	}

	public static int getDefesa() {
		return defesa;
	}

	public static void setDefesa(int defesa) {
		FichaProtagonistaSelecionada.defesa = defesa;
	}

	public static int getMagia() {
		return magia;
	}

	public static void setMagia(int magia) {
		FichaProtagonistaSelecionada.magia = magia;
	}

	public static int getPoder() {
		return poder;
	}

	public static void setPoder(int poder) {
		FichaProtagonistaSelecionada.poder = poder;
	}

	public static int getForca() {
		return forca;
	}

	public static void setForca(int forca) {
		FichaProtagonistaSelecionada.forca = forca;
	}

	public static int getCarisma() {
		return carisma;
	}

	public static void setCarisma(int carisma) {
		FichaProtagonistaSelecionada.carisma = carisma;
	}

	public static int getAgilidade() {
		return agilidade;
	}

	public static void setAgilidade(int agilidade) {
		FichaProtagonistaSelecionada.agilidade = agilidade;
	}

	public static int getIntelecto() {
		return intelecto;
	}

	public static void setIntelecto(int intelecto) {
		FichaProtagonistaSelecionada.intelecto = intelecto;
	}

	public static int getClasse() {
		return classe;
	}

	public static void setClasse(int classe) {
		FichaProtagonistaSelecionada.classe = classe;
	}
	
	
}
