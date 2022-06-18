package loja;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
@Inheritance(strategy = InheritanceType.JOINED)

public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id_funcionario;
	
	@Column(length = 255, nullable = false)
	protected String nome;
	
	@Column(length = 50, nullable = false)
	protected String funcao;
	
	@Column(length = 100)
	protected String nicho;
	
	@Column(length = 100)
	protected String setor;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "servicos_instrumentos", joinColumns = { @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")},
		inverseJoinColumns = { @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")})
	protected Collection<Servico> servicos;
	
	
	public Funcionario(String nome, String funcao, String nicho, String setor) {
		this.nome = nome;
		this.funcao = funcao;
		this.nicho = nicho;
		this.setor = setor;
		this.servicos = new HashSet<Servico>();
		
	}
	
	/* GETTERS AND SETTERS */

	public int getIdFuncionario() {
		return id_funcionario;
	}

	public void setIdFuncionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFuncao() {
		return funcao;
	}

	public void setfuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getNicho() {
		return nicho;
	}

	public void setNicho(String nicho) {
		this.nicho = nicho;
	}
	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}


