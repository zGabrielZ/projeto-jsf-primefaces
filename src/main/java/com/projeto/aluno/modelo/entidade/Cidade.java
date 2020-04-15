package com.projeto.aluno.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.projeto.aluno.modelo.entidade.enums.Estado;

@Entity
@Table(name = "tab_cidade")
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Nome da cidade não pode ser vazio")
	@Column(name = "descricao_cidade",nullable = false)
	private String descricaoCidade;
	
	@NotNull(message = "Tem que selecionar algum estado")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@OneToOne()
	private Endereco endereco;
	
	public Cidade() {}

	public Cidade(Integer id, String descricaoCidade) {
		this.id = id;
		this.descricaoCidade = descricaoCidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoCidade() {
		return descricaoCidade;
	}

	public void setDescricaoCidade(String descricaoCidade) {
		this.descricaoCidade = descricaoCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
