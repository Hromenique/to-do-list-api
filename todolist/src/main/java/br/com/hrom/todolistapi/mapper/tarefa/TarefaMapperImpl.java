package br.com.hrom.todolistapi.mapper.tarefa;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.hrom.todolistapi.domain.Duracao;
import br.com.hrom.todolistapi.domain.Lembrete;
import br.com.hrom.todolistapi.domain.Tarefa;
import br.com.hrom.todolistapi.dto.TarefaDto;

@Component
public class TarefaMapperImpl implements TarefaMapper {
	
	@Override
	public Tarefa toTarefa(TarefaDto source){
		String id = source.getId();
		String descricao = source.getDescricao();
		LocalDateTime dataHoraTarefa = source.getDataHoraTarefa();
		Duracao duracao = source.getDuracao();
		Lembrete lembrete = source.getLembrete();
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(id);
		tarefa.setDescricao(descricao);
		tarefa.setDataHoraTarefa(dataHoraTarefa);
		tarefa.setDuracao(duracao);
		tarefa.setLembrete(lembrete);
		
		return tarefa;
	}
}
