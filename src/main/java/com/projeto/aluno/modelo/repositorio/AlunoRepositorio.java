package com.projeto.aluno.modelo.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.projeto.aluno.modelo.entidade.Aluno;

public class AlunoRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public AlunoRepositorio() {}

	public AlunoRepositorio(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Aluno consultarPorId(Integer id) {
		return entityManager.find(Aluno.class,id);
	}
	
	public List<Aluno> consultarTodos(){
		return entityManager.createQuery("from Aluno",Aluno.class).getResultList();
	}
	
	public List<Aluno> consultarPorNome(String nome){
		String jpql = "from Aluno where nome like :nome";
		
		TypedQuery<Aluno> query = entityManager
				.createQuery(jpql, Aluno.class);
		
		query.setParameter("nome", nome + "%");
		
		return query.getResultList();
	}
	
	public Aluno inserir(Aluno aluno) {
		return entityManager.merge(aluno);
	}
	
	public void remover(Aluno aluno) {
		aluno = consultarPorId(aluno.getId());
		entityManager.remove(aluno);
	}
	

}
