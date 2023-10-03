package bancoDeDados.projeto.aplicacao.domain.aluno;


import jakarta.validation.constraints.NotNull;

public record AlunoRequest(
		@NotNull String matricula, 
		@NotNull String nome, 
		@NotNull String curso, Integer idade) {

}
