package br.com.hrom.todolistapi.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tarefa {

	@Id
	private String id;
	private String descricao;
	private LocalDateTime dataHoraTarefa;
	private Duracao duracao;
	private Lembrete lembrete;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private LocalDateTime dataUltimaEdicao;
	private LocalDateTime dataRemocao;
	private StatusTarefa status = StatusTarefa.NAO_REALIZADA;

	public String getDescricao() {
		return descricao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataHoraTarefa() {
		return dataHoraTarefa;
	}

	public void setDataHoraTarefa(LocalDateTime dataHoraTarefa) {
		this.dataHoraTarefa = dataHoraTarefa;
	}

	public Duracao getDuracao() {
		return duracao;
	}

	public void setDuracao(Duracao duracao) {
		this.duracao = duracao;
	}

	public Lembrete getLembrete() {
		return lembrete;
	}

	public void setLembrete(Lembrete lembrete) {
		this.lembrete = lembrete;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataUltimaEdicao() {
		return dataUltimaEdicao;
	}

	public void setDataUltimaEdicao(LocalDateTime dataUltimaEdicao) {
		this.dataUltimaEdicao = dataUltimaEdicao;
	}

	public LocalDateTime getDataRemocao() {
		return dataRemocao;
	}

	public void setDataRemocao(LocalDateTime dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", descricao=" + descricao + ", dataHoraTarefa=" + dataHoraTarefa + ", duracao="
				+ duracao + ", lembrete=" + lembrete + ", dataCriacao=" + dataCriacao + ", dataUltimaEdicao="
				+ dataUltimaEdicao + ", dataRemocao=" + dataRemocao + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataHoraTarefa == null) ? 0 : dataHoraTarefa.hashCode());
		result = prime * result + ((dataRemocao == null) ? 0 : dataRemocao.hashCode());
		result = prime * result + ((dataUltimaEdicao == null) ? 0 : dataUltimaEdicao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lembrete == null) ? 0 : lembrete.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Tarefa other = (Tarefa) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataHoraTarefa == null) {
			if (other.dataHoraTarefa != null)
				return false;
		} else if (!dataHoraTarefa.equals(other.dataHoraTarefa))
			return false;
		if (dataRemocao == null) {
			if (other.dataRemocao != null)
				return false;
		} else if (!dataRemocao.equals(other.dataRemocao))
			return false;
		if (dataUltimaEdicao == null) {
			if (other.dataUltimaEdicao != null)
				return false;
		} else if (!dataUltimaEdicao.equals(other.dataUltimaEdicao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lembrete == null) {
			if (other.lembrete != null)
				return false;
		} else if (!lembrete.equals(other.lembrete))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
