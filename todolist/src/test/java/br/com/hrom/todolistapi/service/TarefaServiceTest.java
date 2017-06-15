package br.com.hrom.todolistapi.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.hrom.todolistapi.domain.Duracao;
import br.com.hrom.todolistapi.domain.Lembrete;
import br.com.hrom.todolistapi.domain.StatusTarefa;
import br.com.hrom.todolistapi.domain.Tarefa;
import br.com.hrom.todolistapi.domain.UnidadeTempo;
import br.com.hrom.todolistapi.domain.builder.TarefaBuilder;
import br.com.hrom.todolistapi.dto.TarefaDto;
import br.com.hrom.todolistapi.repository.tarefa.TarefaRepository;
import br.com.hrom.todolistapi.service.tarefa.TarefaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TarefaServiceTest {
	
	@Autowired
	private TarefaService tarefaService;
	
	@Autowired
	private TarefaRepository repository;
	
	@Before
	public void removeTodasTarefas(){
		repository.deleteAll();
	}	
	
	@Test
	public void buscaTarefaNaoExistente(){
		Optional<Tarefa> tarefa = tarefaService.busca("4545454");
		
		assertFalse(tarefa.isPresent());		
	}
	
	@Test
	public void buscaUmaTarefaExistente(){
		TarefaDto t1 = criaNovaTarefaDto("tarefa 1", 30, 30);		
		
		String id = tarefaService.salva(t1);
		Optional<Tarefa> tarefaEncotrada = tarefaService.busca(id);
		
		assertTrue(tarefaEncotrada.isPresent());		
		Tarefa tarefa = tarefaEncotrada.get();
		saoIguais(t1, tarefa);
	}

	@Test
	public void buscaTodasAsTarefasSemTarefas(){
		List<Tarefa> tarefas = tarefaService.lista();
		assertTrue(tarefas.isEmpty());
	}
	
	@Test
	public void buscaTodasTarefasComTarefas(){
		TarefaDto t1 = criaNovaTarefaDto("tarefa 1", 30, 30);
		TarefaDto t2 = criaNovaTarefaDto("tarefa 2", 60, 60);
		
		tarefaService.salva(t1);
		tarefaService.salva(t2);
		
		List<Tarefa> tarefas = tarefaService.lista();
		
		assertEquals(2, tarefas.size());
		saoIguais(t1, tarefas.get(0));
		saoIguais(t2, tarefas.get(1));
	}
	
	@Test
	public void buscaTarefasRealizadas(){
		Tarefa t1 = TarefaBuilder.get().descricao("t1").status(StatusTarefa.REALIZADA).build();
		Tarefa t2 = TarefaBuilder.get().descricao("t2").status(StatusTarefa.REALIZADA).build();
		Tarefa t3 = TarefaBuilder.get().descricao("t3").status(StatusTarefa.NAO_REALIZADA).build();
		repository.save(Arrays.asList(t1, t2, t3));
		
		List<Tarefa> tarefas = tarefaService.lista(StatusTarefa.REALIZADA);
		assertEquals(2, tarefas.size());
		
		assertThat(Arrays.asList(t1, t2), is(tarefas));
	}
	
	@Test
	public void buscaTarefasNaoRealizadas(){
		Tarefa t1 = TarefaBuilder.get().descricao("t1").status(StatusTarefa.NAO_REALIZADA).build();
		Tarefa t2 = TarefaBuilder.get().descricao("t2").status(StatusTarefa.NAO_REALIZADA).build();
		Tarefa t3 = TarefaBuilder.get().descricao("t3").status(StatusTarefa.REALIZADA).build();
		repository.save(Arrays.asList(t1, t2, t3));
		
		List<Tarefa> tarefas = tarefaService.lista(StatusTarefa.NAO_REALIZADA);
		assertEquals(2, tarefas.size());
		
		assertThat(Arrays.asList(t1, t2), is(tarefas));
	}
	
	private TarefaDto criaNovaTarefaDto(String descricao, int duracao, int lembrete){
		TarefaDto tarefa = new TarefaDto();
		tarefa.setDescricao(descricao);
		tarefa.setDuracao(new Duracao(duracao, UnidadeTempo.MINUTO));
		tarefa.setLembrete(new Lembrete(lembrete, UnidadeTempo.MINUTO));
		
		return tarefa;
	}
	
	

	private void saoIguais(TarefaDto tarefaDto, Tarefa tarefa) {
		assertEquals(tarefaDto.getDescricao(), tarefa.getDescricao());
		assertEquals(tarefaDto.getDuracao(), tarefa.getDuracao());
		assertEquals(tarefaDto.getLembrete(), tarefa.getLembrete());
	}

}
