package br.com.hrom.todolistapi.dto;

import java.time.LocalDateTime;

import br.com.hrom.todolistapi.domain.Duracao;
import br.com.hrom.todolistapi.domain.Lembrete;

public class TarefaDto {

	private String id;
	private String descricao;
	private LocalDateTime dataHoraTarefa;
	private Duracao duracao;
	private Lembrete lembrete;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
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

}
