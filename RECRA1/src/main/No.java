package main;

// Classe cria um n� da lista duplamente encadeada, armazena URL e as refer�ncias do n�s anteriores e pr�ximos

public class No {
 String url; // String da URL da p�gina
 No anterior; // Referencia usada para o n� anterior
 No proximo; // Referencia usada para o pr�ximo n�


 public No(String url) { 
     // Esse n� incia a url fornecida e define os n�s anterior e pr�ximo como nulos
    
     this.url = url;
     this.anterior = null;
     this.proximo = null;
 }
}
