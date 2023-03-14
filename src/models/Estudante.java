package models;

import java.io.File;

//A classe está estendendo Pessoa.
public class Estudante extends Pessoa{
	private String curso;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	//Repare que este toString() reaproveitou a implementação do toString()
	//da classe base por meio do super.toString() e acrescentou ao resultado
	//a informação pertinente a classe atual.
	@Override
	public String toString(){
		return super.toString() + String.format("Curso: %s", this.curso);
	}

	//Por conta do método abstrato definido na classe base, a classe atual
	//que é concreta, foi obrigada a fornecer uma implementação para tal método.
	@Override
	public String getHistorico() {
		//Criar o histórico e retorná-lo
		return "Histórico do Estudante";
	}
}
