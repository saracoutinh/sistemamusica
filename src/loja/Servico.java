package loja;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "servicos")
@Inheritance(strategy = InheritanceType.JOINED)

public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id_servico;
	
	protected double valor_orcamento;
	
	@Column(length = 500, nullable = false)
	protected String descricao;
	
	@Column(length = 50, nullable = false)
	protected String tipo_de_servico;
	
	protected int prazo;	
	
	@Temporal(TemporalType.DATE)
	protected Date data_retirada;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	protected Cliente clienteServico;
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "servicos_instrumentos", joinColumns = { @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")},
		inverseJoinColumns = { @JoinColumn(name = "id_instrumentos", referencedColumnName = "id_instrumentos")})
	protected Collection<Instrumento> instrumentos;
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "servicos_instrumentos", joinColumns = { @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")},
		inverseJoinColumns = { @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")})
	protected Collection<Funcionario> funcionarios;
	
	public Servico(double valor_orcamento, String descricao, String tipo_de_servico, int prazo,
			Date data_retirada, Cliente clienteServico, Collection<Instrumento> instrumentos,
			Collection<Funcionario> funcionarios) {
		super();
		this.valor_orcamento = valor_orcamento;
		this.descricao = descricao;
		this.tipo_de_servico = tipo_de_servico;
		this.prazo = prazo;
		this.data_retirada = data_retirada;
		this.clienteServico = clienteServico;
		this.instrumentos = instrumentos;
		this.funcionarios = funcionarios;
	}

	public int getIdServico() {
		return id_servico;
	}

	public void setIdServico(int id_servico) {
		this.id_servico = id_servico;
	}

	public double getValor_orcamento() {
		return valor_orcamento;
	}

	public void setValor_orcamento(double valor_orcamento) {
		this.valor_orcamento = valor_orcamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo_de_servico() {
		return tipo_de_servico;
	}

	public void setTipo_de_servico(String tipo_de_servico) {
		this.tipo_de_servico = tipo_de_servico;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public Date getData_retirada() {
		return data_retirada;
	}

	public void setData_retirada(Date data_retirada) {
		this.data_retirada = data_retirada;
	}

	public Cliente getClienteServico() {
		return clienteServico;
	}

	public void setClienteServico(Cliente clienteServico) {
		this.clienteServico = clienteServico;
	}

	public Collection<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(Collection<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	/* GETTERS AND SETTERS */

	
}
