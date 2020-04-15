package com.projeto.aluno.modelo.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import com.projeto.aluno.modelo.entidade.enums.Sexo;

@Entity
@Table(name = "tab_aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotEmpty(message = "Nome não pode ser vazio")
	@Column(name = "nome",nullable = false,length = 80)
	private String nome;
	
	@NotEmpty(message = "Sobrenome não pode ser vazio")
	@Column(name = "sobrenome",nullable = false)
	private String sobrenome;
	
	@NotEmpty(message = "Cpf não pode ser vazio")
	@CPF(message = "Cpf inválido")
	@Column(name = "cpf",nullable = false)
	private String cpf;
	
	@NotEmpty(message = "Email não pode ser vazio")
	@Column(name = "email",nullable = false)
	private String email;
	
	@NotNull(message = "Tem que selecionar o sexo")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@OneToOne(mappedBy = "aluno",cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@OneToOne(mappedBy = "aluno",cascade = CascadeType.ALL)
	@JoinColumn(name = "telefone_id")
	private Telefone telefone;
	
	public Aluno() {}

	public Aluno(Integer id, String nome, String sobrenome, String cpf, String email) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
	
	

	
	
	

	
	
}
