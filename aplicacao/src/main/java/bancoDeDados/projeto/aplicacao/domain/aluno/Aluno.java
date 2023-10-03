package bancoDeDados.projeto.aplicacao.domain.aluno;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="aluno", schema="biblioteca")
@Entity(name="aluno")
public class Aluno {
	@Id
	private String matricula;
	
	private String nome;
	
	private String curso;
	
	private Integer idade;

	public Aluno(String matricula, String nome, String curso, Integer idade) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.idade = idade;
	}

	public Aluno(AlunoRequest aluno) {
		this.matricula = aluno.matricula();
		this.nome = aluno.nome();
		this.curso = aluno.curso();
		this.idade = aluno.idade();
	}
	
	public Aluno() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
	
	
}
