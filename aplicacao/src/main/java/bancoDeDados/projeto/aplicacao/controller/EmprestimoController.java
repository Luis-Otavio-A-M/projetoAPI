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

import bancoDeDados.projeto.aplicacao.domain.emprestimo.Emprestimo;
import bancoDeDados.projeto.aplicacao.domain.emprestimo.EmprestimoRepository;
import bancoDeDados.projeto.aplicacao.domain.emprestimo.EmprestimoRequest;
import bancoDeDados.projeto.aplicacao.domain.livro.Livro;
import bancoDeDados.projeto.aplicacao.domain.livro.LivroRequest;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
	
	@Autowired
	EmprestimoRepository repository;
	
	@GetMapping
	public ResponseEntity getEmprestimos() {
		var todosEmprestimos = repository.findAll();
		return ResponseEntity.ok(todosEmprestimos);
	}
	
	@PostMapping
	public ResponseEntity registrarEmprestimo(@RequestBody EmprestimoRequest request) {
		Emprestimo novoEmprestimo = new Emprestimo(request);
		repository.save(novoEmprestimo);
		return ResponseEntity.ok(novoEmprestimo);
	}
	
	@PutMapping
	public ResponseEntity atualizarEmprestimo(@RequestBody EmprestimoRequest request) {
		Optional<Emprestimo> emprestimoParaAtualizar = repository.findById(request.id_emprestimo());
		
		if(emprestimoParaAtualizar.isPresent()) {
			Emprestimo emprestimoAtualizado = emprestimoParaAtualizar.get();
			emprestimoAtualizado.setId_livro(request.id_livro());
			emprestimoAtualizado.setMatricula_aluno(request.matricula_aluno());
			emprestimoAtualizado.setData_do_emprestimo(request.data_do_emprestimo());
			emprestimoAtualizado.setData_do_vencimento(request.data_do_vencimento());
			System.out.println(emprestimoAtualizado);
			repository.save(emprestimoAtualizado);
		}
		return ResponseEntity.ok(emprestimoParaAtualizar);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deletarLivro(@PathVariable String id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
