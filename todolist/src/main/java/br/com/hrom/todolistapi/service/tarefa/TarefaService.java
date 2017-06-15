package br.com.hrom.todolistapi.service.tarefa;

import java.util.List;
import java.util.Optional;

import br.com.hrom.todolistapi.domain.StatusTarefa;
import br.com.hrom.todolistapi.domain.Tarefa;
import br.com.hrom.todolistapi.dto.TarefaDto;

public interface TarefaService {
	
	Optional<Tarefa> busca(String id);
	List<Tarefa> lista();
	String salva(TarefaDto tarefa);
	List<Tarefa> lista(StatusTarefa status);	

}
