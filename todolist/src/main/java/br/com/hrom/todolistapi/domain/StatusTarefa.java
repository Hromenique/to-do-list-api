package br.com.hrom.todolistapi.domain;

public enum StatusTarefa {

	NAO_REALIZADA(0, "Não Realizada"), REALIZADA(1, "Realizada");

	private Integer id;
	private String descricao;	

	private StatusTarefa(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
