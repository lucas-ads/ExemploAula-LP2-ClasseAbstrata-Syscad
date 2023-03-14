package models;

import java.io.File;

//Classe abstrata (não pode ser instanciada, mas serve de
//base para outras classes)
public abstract class Pessoa {

	private String nome;
	private String dataNascimento;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	//Método helper para imprimir um objeto (muito utilizando 
	//em fase de depuração para verificar se tudo está correndo bem)
	public String toString() {
		return String.format("Nome: %s\nNascimento: %s\n", this.nome, this.dataNascimento);
	}
	
	//Método abstrato -> não tem uma implementação, mas forçará as classes
	//filhas (que forem concretas) a implementarem este método. 
	public abstract String getHistorico();
}
