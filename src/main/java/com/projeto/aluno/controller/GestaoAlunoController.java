
package com.projeto.aluno.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.projeto.aluno.modelo.entidade.Aluno;
import com.projeto.aluno.modelo.entidade.Cidade;
import com.projeto.aluno.modelo.entidade.Endereco;
import com.projeto.aluno.modelo.entidade.Telefone;
import com.projeto.aluno.modelo.entidade.enums.Estado;
import com.projeto.aluno.modelo.entidade.enums.Sexo;
import com.projeto.aluno.modelo.entidade.enums.TipoTelefone;
import com.projeto.aluno.modelo.service.AlunoService;
import com.projeto.aluno.utils.FacesMessages;

@Named
@ViewScoped
public class GestaoAlunoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoService alunoService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Aluno> listaAlunos;
	
	private String pesquisaTermo;
	
	private Aluno aluno;
	
	private Telefone telefone;
	
	private Endereco endereco;
	
	private Cidade cidade;
	
	
	public void prepararNovoAluno() {
		aluno = new Aluno();
		telefone = new Telefone();
		endereco = new Endereco();
		cidade = new Cidade();
		aluno.setTelefone(telefone);
		telefone.setAluno(aluno);
		aluno.setEndereco(endereco);
		endereco.setAluno(aluno);
		endereco.setCidade(cidade);
		cidade.setEndereco(endereco);
	}
	
	public void edicao() {
		 alunoService.consultarPorId(aluno);
		 
		 if(jaHouvePesquisa()) {
				pesquisarAluno();
			} else {
	            todosAlunos();
	        }
		 
	}
	
	public void excluir() {
		alunoService.excluir(aluno);
		
		aluno = null;
		
		if(jaHouvePesquisa()) {
			pesquisarAluno();
		} else {
            todosAlunos();
        }
		
		messages.info("Aluno excluido com sucesso");
		
	}
	
	
	public void salvar() {
		alunoService.inserir(aluno);
		
		if(jaHouvePesquisa()) {
			pesquisarAluno();
		} else {
            todosAlunos();
        }
		
		messages.info("Aluno cadastrado com sucesso");
		
		RequestContext.getCurrentInstance().update(Arrays.asList(
                "frm:alunosDataTable", "frm:messages"));
		
	}
	
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
	
	public Telefone getTelefone() {
		return telefone;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	private boolean jaHouvePesquisa() {
		return pesquisaTermo!=null && "".equals(pesquisaTermo);
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
	
	public Sexo[] getSexo() {
		return Sexo.values();
	}
	
	public TipoTelefone[] getTipo() {
		return TipoTelefone.values();
	}
	
	public Estado[] getEstado() {
		return Estado.values();
	}
	
	public boolean isAlunoSelecionada() {
		return aluno!=null && aluno.getId()!=null;
	}
	


}
