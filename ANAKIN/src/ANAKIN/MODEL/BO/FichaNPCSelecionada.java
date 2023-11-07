package ANAKIN.MODEL.BO;

public class FichaNPCSelecionada {
	private static String NomeNPC;
	private static String OcupaçaoNPC;
	private static int IdadeNPC ;
	private static float AlturaNPC;
	private static String Personalidade;
	private static int VidaNPC;
	private static int DefesaNPC;
	private static int MagiaNPC;
	private static int PoderNPC;
	private static int ForcaNPC;
	private static int CarismaNPC;
	private static int AgilidadeNPC;
	private static int IntelectoNPC;
	private static int FkIdALINHAMENTONPC;
	
	public FichaNPCSelecionada(String nome,String Ocupaçao,int idade,float altura,String personalidade,int vida,int def,int mag,int poder,int forca,int carisma,int agilidade,int intelecto,int alinhamento) {
		this.NomeNPC = nome;
        this.OcupaçaoNPC = Ocupaçao;
        this.IdadeNPC = idade;
        this.AlturaNPC = altura;
        this.Personalidade = personalidade;
        this.VidaNPC = vida;
        this.DefesaNPC = def;
        this.MagiaNPC = mag;
        this.PoderNPC = poder;
        this.ForcaNPC = forca;
        this.CarismaNPC = carisma;
        this.AgilidadeNPC = agilidade;
        this.IntelectoNPC = intelecto;
        this.FkIdALINHAMENTONPC = alinhamento;
	}

	public static String getNomeNPC() {
		return NomeNPC;
	}

	public static void setNomeNPC(String nomeNPC) {
		NomeNPC = nomeNPC;
	}

	public static String getOcupaçaoNPC() {
		return OcupaçaoNPC;
	}

	public static void setOcupaçaoNPC(String ocupaçaoNPC) {
		OcupaçaoNPC = ocupaçaoNPC;
	}

	public static int getIdadeNPC() {
		return IdadeNPC;
	}

	public static void setIdadeNPC(int idadeNPC) {
		IdadeNPC = idadeNPC;
	}

	public static float getAlturaNPC() {
		return AlturaNPC;
	}

	public static void setAlturaNPC(float alturaNPC) {
		AlturaNPC = alturaNPC;
	}

	public static String getPersonalidade() {
		return Personalidade;
	}

	public static void setPersonalidade(String personalidade) {
		Personalidade = personalidade;
	}

	public static int getVidaNPC() {
		return VidaNPC;
	}

	public static void setVidaNPC(int vidaNPC) {
		VidaNPC = vidaNPC;
	}

	public static int getDefesaNPC() {
		return DefesaNPC;
	}

	public static void setDefesaNPC(int defesaNPC) {
		DefesaNPC = defesaNPC;
	}

	public static int getMagiaNPC() {
		return MagiaNPC;
	}

	public static void setMagiaNPC(int magiaNPC) {
		MagiaNPC = magiaNPC;
	}

	public static int getPoderNPC() {
		return PoderNPC;
	}

	public static void setPoderNPC(int poderNPC) {
		PoderNPC = poderNPC;
	}

	public static int getForcaNPC() {
		return ForcaNPC;
	}

	public static void setForcaNPC(int forcaNPC) {
		ForcaNPC = forcaNPC;
	}

	public static int getCarismaNPC() {
		return CarismaNPC;
	}

	public static void setCarismaNPC(int carismaNPC) {
		CarismaNPC = carismaNPC;
	}

	public static int getAgilidadeNPC() {
		return AgilidadeNPC;
	}

	public static void setAgilidadeNPC(int agilidadeNPC) {
		AgilidadeNPC = agilidadeNPC;
	}

	public static int getIntelectoNPC() {
		return IntelectoNPC;
	}

	public static void setIntelectoNPC(int intelectoNPC) {
		IntelectoNPC = intelectoNPC;
	}

	public static int getFkIdALINHAMENTONPC() {
		return FkIdALINHAMENTONPC;
	}

	public static void setFkIdALINHAMENTONPC(int fkIdALINHAMENTONPC) {
		FkIdALINHAMENTONPC = fkIdALINHAMENTONPC;
	}

	
	
}
