package br.com.hrom.todolistapi.service.tarefa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrom.todolistapi.domain.StatusTarefa;
import br.com.hrom.todolistapi.domain.Tarefa;
import br.com.hrom.todolistapi.dto.TarefaDto;
import br.com.hrom.todolistapi.mapper.tarefa.TarefaMapper;
import br.com.hrom.todolistapi.repository.tarefa.TarefaRepository;

@Service
public class TarefaServiceImpl implements TarefaService{

	@Autowired
	private TarefaRepository repository;
	
	@Autowired
	private TarefaMapper mapper;

	public Optional<Tarefa> busca(String id) {
		return Optional.ofNullable(repository.findOne(id));
	}
	
	public List<Tarefa> lista(){
		return repository.findAll();
	}
	
	public List<Tarefa> lista(StatusTarefa status){
		return repository.findByStatus(status);
	}

	public String salva(TarefaDto tarefa) {
		return repository.save(mapper.toTarefa(tarefa)).getId();
	}	

}
