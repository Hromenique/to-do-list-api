package br.com.hrom.todolistapi.dao;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hrom.todolistapi.domain.Tarefa;
import br.com.hrom.todolistapi.repository.tarefa.TarefaRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TarefaRepositoryTest {
	
	@Autowired 
	private TarefaRepository repository;
	
	@Test
	public void salvaTest(){
		
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Compras no mercado");
		tarefa.setDataCriacao(LocalDateTime.now());
		tarefa.setDataHoraTarefa(LocalDateTime.now());
//		tarefa.setDuracao(new Intervalo(10));
//		tarefa.setLembrete(new Intervalo(5));
		
		repository.save(tarefa);
		System.out.println(repository.findAll());
		System.out.println("*******************************************************");
	}

}
