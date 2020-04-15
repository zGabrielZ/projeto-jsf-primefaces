package com.projeto.aluno.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MenuController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String gestaoAluno() {
        return "GestaoAluno?faces-redirect=true";
    }
	
	public String enderecoAluno() {
        return "EnderecoAlunos?faces-redirect=true";
    }

}
