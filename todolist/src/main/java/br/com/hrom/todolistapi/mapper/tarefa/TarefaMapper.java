package br.com.hrom.todolistapi.mapper.tarefa;

import br.com.hrom.todolistapi.domain.Tarefa;
import br.com.hrom.todolistapi.dto.TarefaDto;

public interface TarefaMapper {

	Tarefa toTarefa(TarefaDto source);

}