package br.com.hrom.todolistapi.repository.tarefa;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.hrom.todolistapi.domain.StatusTarefa;
import br.com.hrom.todolistapi.domain.Tarefa;

@Repository
public interface TarefaRepository extends MongoRepository<Tarefa, String>{
	
	List<Tarefa> findByStatus(StatusTarefa status);

}
