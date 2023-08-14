package ANAKIN.CONTROLLER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ANAKIN.MODEL.DAO.TodososdadosDAO;
import ANAKIN.MODEL.VO.Todososdados;
import ANAKIN.VIEW.TelaCadastroVIEW;
import ANAKIN.VIEW.TelaInicialVIEW;
import ANAKIN.VIEW.TelaLoginVIEW;


/**
 * @author Beatriz
 * @see Classe que cria objeto de controle entre a camada Model e View
 *
 */
public class ControllerMain implements ActionListener {
	private TelaInicialVIEW telaInicial;
	private TelaCadastroVIEW telaCadastro;
	private TelaLoginVIEW telaLogin;
	
	
	public ControllerMain(TelaInicialVIEW telaInicial, TelaCadastroVIEW telaCadastro) {
		this.telaInicial = telaInicial;
		this.telaCadastro = telaCadastro;
		//this.telaLogin = telaLogin;
		this.telaInicial.getBtnCadastrar().addActionListener(this);
		this.telaInicial.getBtnLogin().addActionListener(this);
		this.telaCadastro.getBtnVoltar().addActionListener(this);
		this.telaCadastro.getBtnEntrar().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.telaInicial.getBtnCadastrar()) {
			this.telaInicial.setVisible(false);
			telaCadastro = new TelaCadastroVIEW();
			this.telaCadastro.setVisible(true);
			this.telaCadastro.setResizable(false);

		}else if (e.getSource() == this.telaInicial.getBtnLogin()){
			this.telaInicial.setVisible(false);
			telaLogin = new TelaLoginVIEW();
			this.telaLogin.setVisible(true);
			this.telaLogin.setResizable(false);
		}else if(e.getSource() == this.telaCadastro.getBtnVoltar()){
			telaCadastro = new TelaCadastroVIEW();
			this.telaCadastro.setVisible(false);
			telaInicial = new TelaInicialVIEW();
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