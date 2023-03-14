package models;

import java.io.File;

//A classe está estendendo Pessoa.
public class Professor extends Pessoa{
	private String areaConcurso;

	public String getAreaConcurso() {
		return areaConcurso;
	}

	public void setAreaConcurso(String areaConcurso) {
		this.areaConcurso = areaConcurso;
	}
	
	//Repare que este toString() reaproveitou a implementação do toString()
	//da classe base por meio do super.toString() e acrescentou ao resultado
	//a informação pertinente a classe atual.
	@Override
	public String toString() {
		return super.toString() + "Área do Concurso: " + this.areaConcurso + "\n";
	}

	//Por conta do método abstrato definido na classe base, a classe atual
	//que é concreta, foi obrigada a fornecer uma implementação para tal método.
	@Override
	public String getHistorico() {
		//Criar o histórico e retorná-lo
		return "Histórico do Professor";
	}
}
