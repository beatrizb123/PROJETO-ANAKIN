package ANAKIN.MODEL.BO;

import ANAKIN.VIEW.CartasVantagemVIEW;
import ANAKIN.VIEW.DadosdeJogoVIEW;

public class DadosBO {
	int totalD4 = 0;
	int totalD6 = 0;
	int totalD8 = 0;
	int totalD12 = 0;
	int totalD20 = 0;

	String valorBonus;

	public int getTotalD4() {
		return totalD4;
	}

	public void setTotalD4(int totalD4) {
		this.totalD4 = totalD4;
	}

	public int getTotalD6() {
		return totalD6;
	}

	public void setTotalD6(int totalD6) {
		this.totalD6 = totalD6;
	}

	public int getTotalD8() {
		return totalD8;
	}

	public void setTotalD8(int totalD8) {
		this.totalD8 = totalD8;
	}

	public int getTotalD12() {
		return totalD12;
	}

	public void setTotalD12(int totalD12) {
		this.totalD12 = totalD12;
	}

	public int getTotalD20() {
		return totalD20;
	}

	public void setTotalD20(int totalD20) {
		this.totalD20 = totalD20;
	}


	// GERADOR DE D4
	public String geraD4(int d4) {
		int[] vtD4 = new int[d4];

		String stD4 = "";
		String qtdD4 = d4 + "D4 SELECIONADOS";

		for (int i = 0; i < d4; i++) {
			int D4 = (int) (Math.random() * 4) + 1;
			if (D4 == 0) {
				D4 = 1;
			}
			vtD4[i] = D4;

			this.totalD4 = totalD4 + D4;
			stD4 += vtD4[i] + "   ";
		}

		String res = "\n" + qtdD4 + "\nVALORES GERADOS = " + stD4;
		return res;
	}

	public String geraD6(int d6) {
		int[] vtD6 = new int[d6];

		String stD6 = "";
		String qtdD6 = "\n" + d6 + "D6 SELECIONADOS";

		for (int i = 0; i < d6; i++) {
			int D6 = (int) (Math.random() * 6) + 1;
			if (D6 == 0) {
				D6 = 1;
			}
			vtD6[i] = D6;

			this.totalD6 = totalD6 + D6;
			stD6 += vtD6[i] + "   ";
		}

		String res = "\n" + qtdD6 + "\nVALORES GERADOS = " + stD6;
		return res;
	}

	public String geraD8(int d8) {
		int[] vtD8 = new int[d8];

		String stD8 = "";
		String qtdD8 = "\n" + d8 + "D8 SELECIONADOS";

		for (int i = 0; i < d8; i++) {
			int D8 = (int) (Math.random() * 8) + 1;
			if (D8 == 0) {
				D8 = 1;
			}
			vtD8[i] = D8;

			this.totalD8 = totalD8 + D8;
			stD8 += vtD8[i] + "   ";
		}

		String res = "\n" + qtdD8 + "\nVALORES GERADOS = " + stD8;
		return res;
	}

	public String geraD12(int d12) {
		int[] vtD12 = new int[d12];

		String stD12 = "";
		String qtdD12 = "\n" + d12 + "D12 SELECIONADOS";

		for (int i = 0; i < d12; i++) {
			int D12 = (int) (Math.random() * 12) + 1;
			if (D12 == 0) {
				D12 = 1;
			}
			vtD12[i] = D12;

			this.totalD12 = totalD12 + D12;
			stD12 += vtD12[i] + "   ";
		}

		String res = "\n" + qtdD12 + "\nVALORES GERADOS = " + stD12;
		return res;
	}

	public String geraD20(int d20) {
		CartasVantagemVIEW carta = new CartasVantagemVIEW();
		CartasBO valores = new CartasBO();

		int[] vtD20 = new int[d20];
		int segD20;
		int[] segvtD20 = new int [d20];
		String stD20 = "";
		String segstD20 = "";
		String qtdD20 = "\n" + d20 + "D20 SELECIONADOS";

		for (int i = 0; i < d20; i++) {
	

			int D20 = (int) ((Math.random() * 20) + 1) ;
			if (D20 == 0) {
				D20 = 1;
			}
			vtD20[i] = D20;
			
			segD20 = D20 + (int) (Math.random() * 3) + 1;
			if (segD20 == 0) {
				segD20 = 1;
			}
			segvtD20[i] = segD20;
			
			this.totalD20 = totalD20 + D20;
			stD20 += vtD20[i] + "   ";
			segstD20 += segvtD20[i] + "   ";
		}

		String res = "\n" + qtdD20 + "\nVALORES GERADOS = " + stD20 + "\nBONUS APLICADO = " +  segstD20;
		return res;
	}

	public int total(DadosBO total) {
		int somaFinal = (total.getTotalD4()) + (total.getTotalD6()) + (total.getTotalD8()) + (total.getTotalD12())
				+ (total.getTotalD20());

		return somaFinal;

	}

}
