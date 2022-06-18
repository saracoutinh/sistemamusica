package loja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Table;


@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.JOINED)

public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id_cliente;
	
	@Column(length = 255, nullable = false)
	protected String nome;
	
	@Column(nullable = false)
	private long cpf;
	
	@Column(length = 255)
	protected String endereco;
	
	@Column(length = 19, nullable = false)
	protected String telefone;
	
	@Column(length = 255)
	protected String email;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoCliente", fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servico")
	protected Set<Servico> servicoCliente;
	
	public Cliente() {
		this.servicoCliente = new HashSet<Servico>();
	}*/
	
	public Cliente(String nome, long cpf, String endereco, String telefone, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}
	
	/* GETTERS AND SETTERS */

	public int getIdCliente() {
		return id_cliente;
	}

	public void setIdCliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getCpf()
	{
		return cpf;
	}
	
	public void setCpf(long cpf)
	{
		this.cpf = cpf;
	}
	

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}