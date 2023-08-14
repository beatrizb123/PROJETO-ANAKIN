package ANAKIN.MAIN;

import ANAKIN.CONTROLLER.ControllerMain;
import ANAKIN.VIEW.TelaCadastroVIEW;
import ANAKIN.VIEW.TelaInicialVIEW;

public class Main {

	public static void main(String[] args) {
		TelaInicialVIEW frame = new TelaInicialVIEW();
		TelaCadastroVIEW frame2 = new TelaCadastroVIEW();
		new ControllerMain(frame, frame2);
		frame.setVisible(true);
		
	}

}
