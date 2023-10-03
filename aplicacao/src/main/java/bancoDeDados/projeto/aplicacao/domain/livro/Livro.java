package bancoDeDados.projeto.aplicacao.domain.livro;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="livro")
@Entity(name="livro")
public class Livro {
	@Id
	private String id_livro;
	
	private String nome;
	
	private Boolean disponivel;
	
	private String autor;

	public Livro() {}
	
	public Livro(LivroRequest livro) {
		this.id_livro = livro.id_livro();
		this.nome = livro.nome();
		this.disponivel = livro.disponivel();
		this.autor = livro.autor();
	}
	
	public Livro(String id_livro, String nome, Boolean disponivel, String autor) {
		this.id_livro = id_livro;
		this.nome = nome;
		this.disponivel = disponivel;
		this.autor = autor;
	}

	public String getId_livro() {
		return id_livro;
	}

	public void setId_livro(String id_livro) {
		this.id_livro = id_livro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_livro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id_livro, other.id_livro);
	}
	
	
	
}
