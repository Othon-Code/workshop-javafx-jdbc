package model.entidades;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String email;
	private Date aniv;
	private Double salBase;

//aqui fica a associacao com a classe departamento
	private Departamento departamento;

	public Vendedor() {

	}

	public Vendedor(Integer id, String nome, String email, Date aniv, Double salBase, Departamento departamento) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.aniv = aniv;
		this.salBase = salBase;
		this.departamento = departamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAniv() {
		return aniv;
	}

	public void setAniv(Date aniv) {
		this.aniv = aniv;
	}

	public Double getSalBase() {
		return salBase;
	}

	public void setSalBase(Double salBase) {
		this.salBase = salBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", aniv=" + aniv + ", salBase=" + salBase
				+ ", departamento=" + departamento + "]";
	}

}
