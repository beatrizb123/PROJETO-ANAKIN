package ANAKIN.MODEL.BO;

public class CartasBO {
	int pontos;
	String valores;
	
	public int pontosEsfoco() {
		pontos = 3;
		return pontos;
	}

	public int pontosFascinar() {
		pontos = (int) (Math.random() * 6) + 1;
		if (pontos == 0) {
			pontos = 1;
		}
		return pontos;
	}

	public int pontosEstudo() {
		pontos = 4;
		return pontos;
	}

	public int pontosIntuicao() {
		pontos = (int) (Math.random() * 4) + 1;
		if (pontos == 0) {
			pontos = 1;
		}
		return pontos;
	}

	public int pontosAlgazarra() {
		pontos = (int) (Math.random() * 8) + 1;
		if (pontos == 0) {
			pontos = 1;
		}
		return pontos;
	}

	public int pontosSorte() {
		pontos = 2;
		return pontos;
	}
	

}
