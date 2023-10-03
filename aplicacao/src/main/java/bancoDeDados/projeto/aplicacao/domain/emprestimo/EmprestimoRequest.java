package bancoDeDados.projeto.aplicacao.domain.emprestimo;

import java.sql.Date;

public record EmprestimoRequest(String id_emprestimo, String matricula_aluno, String id_livro, Date data_do_emprestimo,
		Date data_do_vencimento) {

}
