package main;

// Classe cria um nó da lista duplamente encadeada, armazena URL e as referências do nós anteriores e próximos

public class No {
 String url; // String da URL da página
 No anterior; // Referencia usada para o nó anterior
 No proximo; // Referencia usada para o próximo nó


 public No(String url) { 
     // Esse nó incia a url fornecida e define os nós anterior e próximo como nulos
    
     this.url = url;
     this.anterior = null;
     this.proximo = null;
 }
}
