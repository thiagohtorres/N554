package br.unifor.entity;

import java.io.Serializable;



public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String semestre;
	private Disciplina disciplina;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	

}
