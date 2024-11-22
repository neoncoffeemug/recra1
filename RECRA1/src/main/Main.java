package main;

import java.util.*;


// Classe que executa o programa
public class Main {
	
	public static void main(String[] args) {
		
		ListaHistorico historico = new ListaHistorico(); // Cria uma nova lista 
		Scanner scanner = new Scanner(System.in); 
		String x = "";
		String y ="";
		
		System.out.println("Para ver o histórico, digite 'historico'");
		System.out.println("Para adicionar uma nova url, digite 'adicionar'");
		System.out.println("Para remover uma url, digite 'remover'");
		
		x = scanner.nextLine();
		switch(x.toLowerCase()) {
		
			case "historico" :
				System.out.println();
				historico.listar(); // Lista as URLs iniciais
				System.out.println();
				break;
		
		
			case "adicionar" :
				historico.listar();
				System.out.println("Escreva uma url para adicionar");
				y = scanner.nextLine();
				historico.adicionar(y); //  Adicionar uma nova URL ao histórico
				System.out.println("\nAdicionada nova URL:");
				historico.listar();
				break;
				
			case "remover" :
				historico.listar();
				System.out.println("Escreva uma url para remover");
				y = scanner.nextLine();
				historico.remover(y); // Remover uma URL especifica do histórico
				System.out.println("\nRemovida uma URL:");
				historico.listar(); 
				break;
		}
	
		
	}
}
