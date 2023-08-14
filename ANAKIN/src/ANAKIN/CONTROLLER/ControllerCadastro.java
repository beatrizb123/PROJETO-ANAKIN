package ANAKIN.CONTROLLER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ANAKIN.MODEL.DAO.TodososdadosDAO;
import ANAKIN.MODEL.VO.Todososdados;
import ANAKIN.VIEW.TelaCadastroVIEW;
import ANAKIN.VIEW.TelaInicialVIEW;


public class ControllerCadastro implements ActionListener {
	private TelaCadastroVIEW telaCadastro;
	private TelaInicialVIEW telaInicial;
	
	public ControllerCadastro(TelaCadastroVIEW telaCadastro) {
		this.telaCadastro = telaCadastro;
		this.telaInicial = telaInicial;
		this.telaCadastro.getBtnVoltar().addActionListener(this);
		this.telaCadastro.getBtnEntrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.telaCadastro.getBtnVoltar()){
			telaCadastro = new TelaCadastroVIEW();
			this.telaCadastro.setVisible(false);
			this.telaInicial.setVisible(true);
			this.telaInicial.setResizable(false);
		}else if (e.getSource() == this.telaCadastro.getBtnEntrar()) {
			telaCadastro = new TelaCadastroVIEW();
			String usuario, senha;
			usuario = this.telaCadastro.getTxtfNomeUser().getText();
			senha = this.telaCadastro.getTxtfSenha().getText();
			Todososdados infor = new Todososdados();
			infor.setNome_usuario(usuario);
			infor.setSenha_usuario(senha);
			TodososdadosDAO TDDAO = new TodososdadosDAO();
			TDDAO.cadastrarUsuario(infor);
		}

		
	}
	

}
