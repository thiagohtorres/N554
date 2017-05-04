package br.unifor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turma {
	
	//Disciplina disciplina;
	String semestre;
	@Id
	@GeneratedValue
	Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//public Disciplina getDisciplina() {
		//return disciplina;
	//}
	//public void setDisciplina(Disciplina disciplina) {
		//this.disciplina = disciplina;
	//}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
