package bancoDeDados.projeto.aplicacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bancoDeDados.projeto.aplicacao.domain.livro.LivroRepository;

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
}
