	package ANAKIN.MODEL.VO;

import ANAKIN.VIEW.ControleSessaoVIEW;

/**
 * @author Josue
 * @see Métodos de acesso às informações do usuário
 *
 */

public class UsuarioVO {
	
	//Declaração das variáveis
	static String nome_Usuario;
	private String senha_usuario, filme_usuario;
	
	//get e set - Nome do usuário
	public static String getNome_Usuario() {
		return nome_Usuario;
	}

	public static void setNome_usuario(String nomeUsuario) {
		UsuarioVO.nome_Usuario = nomeUsuario;
	}

	
	//get e set - Senha do usuário
	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	
	//get e set - Filme favorito do usuário
	public String getFilme_Usuario() {
		return filme_usuario;
	}
	
	public void setFilme_usuario(String filme_usuario) {
		this.filme_usuario = filme_usuario;
	}

}
