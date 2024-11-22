package main;

public class ListaHistorico {
	
    private No cabeca; // Referencia usada para o primeiro n� da lista
    
    private No cauda;  // Referencia usada para o �ltimo n� da lista

    
    
    // Classe inicia o hist�rico com as urls (mudei algumas)
    public ListaHistorico() {
        
    	// Urls a serem adicionadas ao hist�rico
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

        // Adiciona cada URL � lista, utiliza o m�todo "adicionar"
        for (String url : urlsIniciais) {
            adicionar(url);
        }
    }

    // Classe que adiciona uma nova URL no final da lista
    public void adicionar(String url) {
    	
        // Cria um novo n� que armazenar� a URL 
        No novoNo = new No(url);

        // Verifica se a lista est� vazia (cabe�a == null)
        if (cabeca == null) {
            // Se a lista estiver vazia, define o novo n� como cabe�a e cauda ao mesmo tempo
            cabeca = cauda = novoNo;
            
        } else {
            // Se j� houverem elementos na lista, adiciona o novo n� no final
            cauda.proximo = novoNo; // O pr�ximo do n� atual (cauda) agora aponta para o novo n�
            novoNo.anterior = cauda; // O anterior do novo n� � a cauda atual
            cauda = novoNo; // Atualiza a cauda para referenciar o novo n�
        }
    }

    // M�todo para remover uma URL  da lista
    public void remover(String url) {
        No atual = cabeca; // Come�a a busca pelo primeiro n�

        // Percorre a lista enquanto houver n�s dispon�veis
        while (atual != null) {
            // Verifica se encontrou a URL que precisa ser removida
            if (atual.url.equals(url)) {
                // Ajusta os ponteiros para remover o n� atual da lista

                if (atual.anterior != null) {        
                    atual.anterior.proximo = atual.proximo; // Ajusta o pr�ximo do n� anterior
                    
                } else {
                    cabeca = atual.proximo; // Atualiza a cabe�a se for o primeiro no da lista
                }

                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior; // Ajusta o anterior do pr�ximo n�
                    
                } else {
                    cauda = atual.anterior; // atualiza a cauda se for o ultimo no da lista
                }

                return; // Sai do metodo apos remover o no encontrado
            }

            atual = atual.proximo; // move para o pr�ximo n� na lista
        }
    }

    // M�todo para listar todas as URLs no hist�rico
    public void listar() {
    	
        No atual = cabeca; 
        
        // Verifica se a lista est� vazia e printa caso a condi��o for verdadeira
        if (atual == null) {
            System.out.println("Hist�rico vazio."); 
            return;
        }

        System.out.println("Hist�rico de navega��o:");

        
        // M�todo para cada URL at� o final da lista
        while (atual != null) {
        	
            System.out.println(atual.url); // Imprime URL do no atual no console
            atual = atual.proximo; // Move para o pr�ximo no na lista para continuar a impress�o
        }
    }
}