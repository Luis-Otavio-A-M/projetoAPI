package bancoDeDados.projeto.aplicacao.domain.emprestimo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="emprestimo")
@Entity(name="emprestimo")
public class Emprestimo {
	@Id
	private String id_emprestimo;
	
	private String matricula_aluno;
	
	private String id_livro;
	
	private LocalDate data_do_emprestimo;
	
	private LocalDate data_do_vencimento;

	public Emprestimo() {}
	
	public Emprestimo(EmprestimoRequest emprestimo) {
		this.id_emprestimo = emprestimo.id_emprestimo();
		this.matricula_aluno = emprestimo.matricula_aluno();
		this.id_livro = emprestimo.id_livro();
		this.data_do_emprestimo = emprestimo.data_do_emprestimo();
		this.data_do_vencimento = emprestimo.data_do_vencimento();
	}
	
	public Emprestimo(String id_emprestimo, String matricula_aluno, String id_livro, LocalDate data_do_emprestimo,
			LocalDate data_do_vencimento) {
		this.id_emprestimo = id_emprestimo;
		this.matricula_aluno = matricula_aluno;
		this.id_livro = id_livro;
		this.data_do_emprestimo = data_do_emprestimo;
		this.data_do_vencimento = data_do_vencimento;
	}

	public String getId_emprestimo() {
		return id_emprestimo;
	}

	public void setId_emprestimo(String id_emprestimo) {
		this.id_emprestimo = id_emprestimo;
	}

	public String getMatricula_aluno() {
		return matricula_aluno;
	}

	public void setMatricula_aluno(String matricula_aluno) {
		this.matricula_aluno = matricula_aluno;
	}

	public String getId_livro() {
		return id_livro;
	}

	public void setId_livro(String id_livro) {
		this.id_livro = id_livro;
	}

	public LocalDate getData_do_emprestimo() {
		return data_do_emprestimo;
	}

	public void setData_do_emprestimo(LocalDate data_do_emprestimo) {
		this.data_do_emprestimo = data_do_emprestimo;
	}

	public LocalDate getData_do_vencimento() {
		return data_do_vencimento;
	}

	public void setData_do_vencimento(LocalDate data_do_vencimento) {
		this.data_do_vencimento = data_do_vencimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_emprestimo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		return Objects.equals(id_emprestimo, other.id_emprestimo);
	}

	@Override
	public String toString() {
		return "Emprestimo [id_emprestimo=" + id_emprestimo + ", matricula_aluno=" + matricula_aluno + ", id_livro="
				+ id_livro + ", data_do_emprestimo=" + data_do_emprestimo + ", data_do_vencimento=" + data_do_vencimento
				+ "]";
	}
	
	
}
