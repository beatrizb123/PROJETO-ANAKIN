package ANAKIN.MODEL.VO;

/**
 * @author Josue
 * @see Métodos de acesso às informações do usuário
 *
 */

public class UsuarioVO {
	
	//Declaração das variáveis
	private int id_usuario;
	private String nome_usuario, senha_usuario;
	
	//get e set - ID do usuário
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	//get e set - Nome do usuário
	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	
	//get e set - Senha do usuário
	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}

}
