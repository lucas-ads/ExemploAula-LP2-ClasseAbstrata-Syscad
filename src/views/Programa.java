package views;

import java.util.List;

import models.Estudante;
import models.Pessoa;
import models.Professor;
import models.Projeto;

public class Programa {

	public static void main(String[] args) {
		
		/*
		Declarando um objeto com o tipo "Pessoa" e instanciando
		com o tipo "Professor". 
		 
		Neste caso, a estrutura interna do objeto é a de "Professor",
		mas a interface (conjunto de métodos públicos disponíveis) que
		estará disponível é a que está definida em "Pessoa".
		*/
		Pessoa prof = new Professor();
		
		/*
		Lembre-se:
		- Isso é declaração:
		 	Pessoa prof;
		- Isso é instanciação:
			prof = new Professor();
		- Isso é declaração e instanciação de uma só vez:
			Pessoa prof = new Professor();
		- O tipo usado na instanciação define "O QUE O OBJETO DE FATO É" 
		  enquanto que o tipo usado na declaração define "COMO O OBJETO SERÁ TRATADO"
		*/
		
		prof.setNome("Richard");
		prof.setDataNascimento("1980-07-20");

		
		/*
		Ao tentar acessar o método "prof.setAreaConcurso(String area)"
		teremos um problema pois tal método não está disponível no tipo
		"Pessoa" com o qual foi declarado o objeto "prof", apesar de que
		"prof" tem tal método por ter sido instanciado especificamente 
		com a classe "Professor". Sendo assim, teremos que forçar o Java
		a operar o objeto "prof" como sendo do tipo "Professor" para que 
		o método possa ser acessado. 
		*/
		
		/* Descomente a instrução abaixo para ver que java não reconhecerá que 
		tal método exite em "prof" */
		
		//prof.setAreaConcurso("Engenharia de Software");
		
		//Neste caso, para podemos usar o método, podemos fazer um Cast assim:
		Professor temp = (Professor) prof;
		temp.setAreaConcurso("Astrofísica");
		
		//ou assim:
		((Professor)prof).setAreaConcurso("Astrofísica");
		
		/* 
		Um cast de objeto é utilizado para forçar o java a tratar um objeto 
		de um tipo como sendo de outro tipo, desde que esses tipos estejam 
		ligados por herança ou por implementação de interface. Saiba mais em:
		https://www.baeldung.com/java-type-casting
		*/
		
		System.out.println( prof.toString() );
		
		
		
		/*
		Neste exemplo, estamos declarando e instanciando com a própria
		classe "Estudante". 
		 
		Neste caso, tanto a estrutura interna quanto a interface do
		objeto é a de "Estudante", então teremos acesso a todos os métodos
		de "Estudante" sem nenhum problema.
		*/
		Estudante estudante = new Estudante();
		estudante.setNome("Enzo");
		estudante.setDataNascimento("2006-01-02");
		estudante.setCurso("Técnico em Agropecuária");
		
		System.out.println(estudante.toString());
		
		
		Projeto projeto = new Projeto();
		projeto.setNome("Laboratório de Desenvolvimento de Software");
		projeto.setTipo("Extensão");
		
		/*
		A importância de usar generalização: 
			Como o método "addIntegrante(Pessoa integrante)" de "Projeto"
			está esperando um parametro do tipo "Pessoa" invés de especificar
			como "Professor" ou "Estudante", podemos passar tanto professores
			quanto estudantes para tal método que ele aceitará, afinal, por 
			conta da herança, "Professor" e "Estudante" é "Pessoa".
		*/
		projeto.addIntegrante(prof);
		projeto.addIntegrante(estudante);
		
		//Recuperando a lista de integrantes do projeto
		//Nessa mesma lista poderemos ter tanto estudantes quanto professores.
		List<Pessoa> integrantes = projeto.getIntegrantes();
		
		System.out.println("\n\nIntegrantes do Projeto:\n");
		for(Pessoa pessoa : integrantes) {

			/*
			Como "pessoa" pode ser uma instancia de "Estudante" ou de "Professor",
			só podemos chamar diretamente os métodos que são gerais, ou seja, que
			estão especificados em "Pessoa" (mesmo que "Pessoa" tenha apenas especificado
			um método sem fornecer uma implementação, como é o caso do método
			"Pessoa.getHistorico()".
			*/
			 
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());
			System.out.println("Histórico: " + pessoa.getHistorico());
			
			/*
			Já para podemos acessar métodos especificos, precisaremos verificar de 
			que classe é a instancia, para então fazermos o cast para "Estudante" ou 
			para "Professor", para só então podermos acessar tais métodos específicos.
			Veja abaixo:
			*/
			String classe = pessoa.getClass().getSimpleName();
			if( classe.equals("Professor") ) {
				String areaConcurso = ((Professor)pessoa).getAreaConcurso();
				System.out.println("Área do concurso: " + areaConcurso);
			}else if(classe.equals("Estudante")) {
				String curso = ((Estudante)pessoa).getCurso();
				System.out.println("Curso: " + curso);
			}
			System.out.println();
		}
		
	}

}
