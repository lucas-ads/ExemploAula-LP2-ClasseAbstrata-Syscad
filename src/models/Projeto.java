package models;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	private String nome;
	private String tipo;

	/*
	Repare que a lista abaixo poderá guardar tanto objetos
	da classe Professor quanto objetos da classe Estudante
	por conta da estrutura de herança. A lista aceitará objetos
	de tais classe porque tanto Professor quanto Estudante é 
	Pessoa
	*/
	private List<Pessoa> integrantes;
	
	public Projeto() {
		this.integrantes = new ArrayList<Pessoa>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public List<Pessoa> getIntegrantes() {
		return integrantes;
	}
	
	/*
	 Adiciona uma pessoa na lista de integrantes.
	 O método pode receber no parametro "integrante"
	 tanto um objeto da classe Estudante quanto um
	 objeto da classe Professor, e, caso Pessoa não
	 fosse abstrata, o parametro poderia receber também
	 um objeto que fosse diretamente da classe Pessoa.
	*/
	public void addIntegrante(Pessoa integrante) {
		this.integrantes.add(integrante);
	}
	
}
