package br.unifor.entity;

import java.io.Serializable;

public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String matricula;
	private String nome;
	private Turma turma;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
	

}
