package main;

public class ListaHistorico {
	
    private No cabeca; // Referencia usada para o primeiro nó da lista
    
    private No cauda;  // Referencia usada para o último nó da lista

    
    
    // Classe inicia o histórico com as urls (mudei algumas)
    public ListaHistorico() {
        
    	// Urls a serem adicionadas ao histórico
        String[] urlsIniciais = {
                "www.google.com",
                "www.github.com",
                "www.op.gg",
                "www.rateyourmusic.com",
                "www.freecodecamp.org",
                "www.scryfall.com",
                "www.fauux.neocities.org",
                "www.pucpr.br",
                "www.frankalcantara.com",
                "www.thepiratebay.org"
        };

        // Adiciona cada URL à lista, utiliza o método "adicionar"
        for (String url : urlsIniciais) {
            adicionar(url);
        }
    }

    // Classe que adiciona uma nova URL no final da lista
    public void adicionar(String url) {
    	
        // Cria um novo nó que armazenará a URL 
        No novoNo = new No(url);

        // Verifica se a lista está vazia (cabeça == null)
        if (cabeca == null) {
            // Se a lista estiver vazia, define o novo nó como cabeça e cauda ao mesmo tempo
            cabeca = cauda = novoNo;
            
        } else {
            // Se já houverem elementos na lista, adiciona o novo nó no final
            cauda.proximo = novoNo; // O próximo do nó atual (cauda) agora aponta para o novo nó
            novoNo.anterior = cauda; // O anterior do novo nó é a cauda atual
            cauda = novoNo; // Atualiza a cauda para referenciar o novo nó
        }
    }

    // Método para remover uma URL  da lista
    public void remover(String url) {
        No atual = cabeca; // Começa a busca pelo primeiro nó

        // Percorre a lista enquanto houver nós disponíveis
        while (atual != null) {
            // Verifica se encontrou a URL que precisa ser removida
            if (atual.url.equals(url)) {
                // Ajusta os ponteiros para remover o nó atual da lista

                if (atual.anterior != null) {        
                    atual.anterior.proximo = atual.proximo; // Ajusta o próximo do nó anterior
                    
                } else {
                    cabeca = atual.proximo; // Atualiza a cabeça se for o primeiro no da lista
                }

                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior; // Ajusta o anterior do próximo nó
                    
                } else {
                    cauda = atual.anterior; // atualiza a cauda se for o ultimo no da lista
                }

                return; // Sai do metodo apos remover o no encontrado
            }

            atual = atual.proximo; // move para o próximo nó na lista
        }
    }

    // Método para listar todas as URLs no histórico
    public void listar() {
    	
        No atual = cabeca; 
        
        // Verifica se a lista está vazia e printa caso a condição for verdadeira
        if (atual == null) {
            System.out.println("Histórico vazio."); 
            return;
        }

        System.out.println("Histórico de navegação:");

        
        // Método para cada URL até o final da lista
        while (atual != null) {
        	
            System.out.println(atual.url); // Imprime URL do no atual no console
            atual = atual.proximo; // Move para o próximo no na lista para continuar a impressão
        }
    }
}