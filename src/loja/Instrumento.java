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
@Table(name = "instrumentos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Instrumento
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id_instrumentos;
	
	@Column(length = 255, nullable = false)
	protected String nome_instrumento;
	
	@Column(length = 100, nullable = false)
	protected String nicho;
	
	@Column(length = 150)
	protected String material;
	
	
	/*@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "servicos_instrumentos", joinColumns = { @JoinColumn(name = "id_instrumentos", referencedColumnName = "id_instrumentos")},
		inverseJoinColumns = { @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")})
	protected Collection<Servico> servicos;*/

	public Instrumento(String nome_instrumento, String nicho, String material) {
		super();
		this.nome_instrumento = nome_instrumento;
		this.nicho = nicho;
		this.material = material;
	}

	/* GETTERS AND SETTERS */

	public int getIdInstrumentos() {
		return id_instrumentos;
	}

	public void setIdInstrumentos(int id_instrumentos) {
		this.id_instrumentos = id_instrumentos;
	}

	public String getNome_instrumento() {
		return nome_instrumento;
	}

	public void setNome_instrumento(String nome_instrumento) {
		this.nome_instrumento = nome_instrumento;
	}

	public String getNicho() {
		return nicho;
	}

	public void setNicho(String nicho) {
		this.nicho = nicho;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	
}
	
