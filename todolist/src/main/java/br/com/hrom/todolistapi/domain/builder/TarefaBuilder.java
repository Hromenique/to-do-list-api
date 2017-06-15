package br.com.hrom.todolistapi.domain.builder;

import java.time.LocalDateTime;

import br.com.hrom.todolistapi.domain.Duracao;
import br.com.hrom.todolistapi.domain.Lembrete;
import br.com.hrom.todolistapi.domain.StatusTarefa;
import br.com.hrom.todolistapi.domain.Tarefa;

public class TarefaBuilder {

	private String id;
	private String descricao;
	private LocalDateTime dataHoraTarefa;
	private Duracao duracao;
	private Lembrete lembrete;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private LocalDateTime dataUltimaEdicao;
	private LocalDateTime dataRemocao;
	private StatusTarefa status = StatusTarefa.NAO_REALIZADA;

	private TarefaBuilder(){
		
	}
	
	public static TarefaBuilder get(){
		return new TarefaBuilder();
	}
	
	public Tarefa build(){
		Tarefa tarefa = new Tarefa();
		tarefa.setId(id);
		tarefa.setDescricao(descricao);
		tarefa.setDataHoraTarefa(dataHoraTarefa);
		tarefa.setDuracao(duracao);
		tarefa.setLembrete(lembrete);
		tarefa.setDataCriacao(dataCriacao);
		tarefa.setDataUltimaEdicao(dataUltimaEdicao);
		tarefa.setDataRemocao(dataRemocao);
		tarefa.setStatus(status);
		
		return tarefa;
	}
	
	public TarefaBuilder id(String id) {
		this.id = id;
		return this;
	}

	public TarefaBuilder descricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public TarefaBuilder dataHoraTarefa(LocalDateTime dataHoraTarefa) {
		this.dataHoraTarefa = dataHoraTarefa;
		return this;
	}

	public TarefaBuilder duracao(Duracao duracao) {
		this.duracao = duracao;
		return this;
	}

	public TarefaBuilder lembrete(Lembrete lembrete) {
		this.lembrete = lembrete;
		return this;
	}

	public TarefaBuilder dataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
		return this;
	}

	public TarefaBuilder dataUltimaEdicao(LocalDateTime dataUltimaEdicao) {
		this.dataUltimaEdicao = dataUltimaEdicao;
		return this;
	}

	public TarefaBuilder dataRemocao(LocalDateTime dataRemocao) {
		this.dataRemocao = dataRemocao;
		return this;
	}

	public TarefaBuilder status(StatusTarefa status) {
		this.status = status;
		return this;
	}

}
