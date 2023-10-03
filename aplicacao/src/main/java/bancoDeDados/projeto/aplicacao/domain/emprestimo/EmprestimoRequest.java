package bancoDeDados.projeto.aplicacao.domain.emprestimo;

import java.sql.Date;
import java.time.LocalDate;

public record EmprestimoRequest(String id_emprestimo, String matricula_aluno, String id_livro, LocalDate data_do_emprestimo,
		LocalDate data_do_vencimento) {

}
