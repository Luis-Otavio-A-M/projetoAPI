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
import bancoDeDados.projeto.aplicacao.domain.livro.Livro;
import bancoDeDados.projeto.aplicacao.domain.livro.LivroRepository;
import bancoDeDados.projeto.aplicacao.domain.livro.LivroRequest;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroRepository repository;
	
	@GetMapping
	public ResponseEntity getLivros() {
		var todosLivros = repository.findAll();
		return ResponseEntity.ok(todosLivros);
	}
	
	@PostMapping
	public ResponseEntity cadastrarLivro(@RequestBody LivroRequest livro) {
		Livro novoLivro = new Livro(livro);
		repository.save(novoLivro);
		return ResponseEntity.ok(novoLivro);
	}
	
	@PutMapping
	public ResponseEntity atualizarLivro(@RequestBody LivroRequest request) {
		Optional<Livro> livroParaAtualizar = repository.findById(request.id_livro());
		
		if(livroParaAtualizar.isPresent()) {
			System.out.println("teste");
			Livro livroAtualizado = livroParaAtualizar.get();
			livroAtualizado.setNome(request.nome());
			livroAtualizado.setDisponivel(request.disponivel());
			livroAtualizado.setAutor(request.autor());
			
		}
		return ResponseEntity.ok(livroParaAtualizar);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deletarLivro(@PathVariable String id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
