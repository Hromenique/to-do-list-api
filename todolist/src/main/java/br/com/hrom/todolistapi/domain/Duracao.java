package br.com.hrom.todolistapi.domain;

public class Duracao {
	private int valor;
	private UnidadeTempo unidade = UnidadeTempo.MINUTO;

	public Duracao(){
		
	}
	
	public Duracao(int valor) {
		this.valor = valor;
	}

	public Duracao(int valor, UnidadeTempo unidade) {
		super();
		this.valor = valor;
		this.unidade = unidade;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public UnidadeTempo getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeTempo unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return "Duracao [valor=" + valor + ", unidade=" + unidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		result = prime * result + valor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Duracao other = (Duracao) obj;
		if (unidade != other.unidade)
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}
	
}
