package ANAKIN.MODEL.VO;

/**
 * @author Beatriz
 * @see Métodos de acesso às informações do Controle de Sessão
 *
 */
public class ControleSessaoVO {
	
	//Declaração das variáveis
	private int id_sessao;
	private String nome_sessao, inventario_sessao, anotacoes_sessao;
	
	//get e set - ID da sessão
	public int getId_sessao() {
		return id_sessao;
	}
	public void setId_sessao(int id_sessao) {
		this.id_sessao = id_sessao;
	}
	
	//get e set - Nome da sessão
	public String getNome_sessao() {
		return nome_sessao;
	}
	public void setNome_sessao(String nome_sessao) {
		this.nome_sessao = nome_sessao;
	}
	
	//get e set - Inventário
	public String getInventario_sessao() {
		return inventario_sessao;
	}
	public void setInventario_sessao(String inventario_sessao) {
		this.inventario_sessao = inventario_sessao;
	}
	
	//get e set - Anotações
	public String getAnotacoes_sessao() {
		return anotacoes_sessao;
	}
	public void setAnotacoes_sessao(String anotacoes_sessao) {
		this.anotacoes_sessao = anotacoes_sessao;
	}

	
}
