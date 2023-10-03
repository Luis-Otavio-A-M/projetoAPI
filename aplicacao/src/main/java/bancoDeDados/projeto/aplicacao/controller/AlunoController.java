package bancoDeDados.projeto.aplicacao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bancoDeDados.projeto.aplicacao.domain.aluno.Aluno;
import bancoDeDados.projeto.aplicacao.domain.aluno.AlunoRepository;
import bancoDeDados.projeto.aplicacao.domain.aluno.RequestAluno;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public ResponseEntity getAlunos() {
		var todosAlunos = repository.findAll();
		return ResponseEntity.ok(todosAlunos);
	}
	
	@PostMapping
	public ResponseEntity cadastrarAluno(@RequestBody RequestAluno request) {
		Aluno novoAluno = new Aluno(request);
		repository.save(novoAluno);
		return ResponseEntity.ok(novoAluno);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizarAluno(@RequestBody RequestAluno request) {
		Optional<Aluno> alunoParaAtualizar = repository.findById(request.matricula());
		if(alunoParaAtualizar.isPresent()) {
			Aluno alunoAtualizado = alunoParaAtualizar.get();
			alunoAtualizado.setNome(request.nome());
			alunoAtualizado.setCurso(request.curso());
			alunoAtualizado.setIdade(request.idade());
		}
		return ResponseEntity.ok(alunoParaAtualizar);
	}
	
	@DeleteMapping("/{matricula}")
	public ResponseEntity deletarAluno(@PathVariable String matricula) {
		repository.deleteById(matricula);
		return ResponseEntity.noContent().build();
	}
}
