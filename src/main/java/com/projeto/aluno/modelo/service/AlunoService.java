package com.projeto.aluno.modelo.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.projeto.aluno.modelo.entidade.Aluno;
import com.projeto.aluno.modelo.repositorio.AlunoRepositorio;
import com.projeto.aluno.utils.Transacional;

public class AlunoService  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoRepositorio alunoRepositorio;
	
	@Transacional
	public void inserir(Aluno aluno) {
		alunoRepositorio.inserir(aluno);
	}
	
	@Transacional
	public void excluir(Aluno aluno) {
		alunoRepositorio.remover(aluno);
	}
	
	public Aluno consultarPorId(Aluno aluno) {
		return alunoRepositorio.consultarPorId(aluno.getId());
	}
	
	public List<Aluno> consultarPorNome(String nome) {
		return alunoRepositorio.consultarPorNome(nome);
	}
	
	public List<Aluno> consultarTodos() {
		return alunoRepositorio.consultarTodos();
	}
}
