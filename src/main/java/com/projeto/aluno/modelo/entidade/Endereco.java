package com.projeto.aluno.modelo.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tab_endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Rua não pode ser vazio")
	@Column(name = "rua",nullable = false)
	private String rua;
	
	@NotEmpty(message = "Cep não pode ser vazio")
	@Column(name = "cep",nullable = false)
	private String cep;
	
	@NotEmpty(message = "Bairro não pode ser vazio")
	@Column(name = "bairro",nullable = false)
	private String bairro;
	
	@NotEmpty(message = "Número não pode ser vazio")
	@Column(name = "numero",nullable = false)
	private String numero;
	
	@OneToOne(mappedBy = "endereco",cascade = CascadeType.ALL)
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	@OneToOne()
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	public Endereco() {}

	public Endereco(Integer id, String rua, String cep, String bairro,String numero) {
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.bairro = bairro;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
