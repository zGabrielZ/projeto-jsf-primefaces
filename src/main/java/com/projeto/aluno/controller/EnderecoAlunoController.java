package com.projeto.aluno.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.projeto.aluno.modelo.entidade.Aluno;
import com.projeto.aluno.modelo.entidade.Cidade;
import com.projeto.aluno.modelo.entidade.Endereco;
import com.projeto.aluno.modelo.service.AlunoService;
import com.projeto.aluno.utils.FacesMessages;

@Named
@ViewScoped
public class EnderecoAlunoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoService alunoService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Aluno> listaAlunos;
	
	private String pesquisaTermo;
	
	private Aluno aluno;
	
	private Endereco endereco;
	
	private Cidade cidade;
	
	public void pesquisarAluno() {
		listaAlunos = alunoService.consultarPorNome(pesquisaTermo);
		
		if (listaAlunos.isEmpty()) {
            messages.info("Sua consulta não retornou registros.");
        }
		
	}
	
	public void todosAlunos() {
		listaAlunos = alunoService.consultarTodos();
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}
	
	public String getPesquisaTermo() {
		return pesquisaTermo;
	}
	
	public void setPesquisaTermo(String pesquisaTermo) {
		this.pesquisaTermo = pesquisaTermo;
	}
	

}
