public class vetorIDs {
    
    private int[] vetor;
    private boolean permitirRepetidos;
    private int tamanho; 

    public vetorIDs(int comprimento, boolean permitirRepetidos){
        this.vetor = new int[comprimento];
        this.tamanho = 0;
        this.permitirRepetidos = permitirRepetidos;
        limpar();
    }

    //inserindo de forma ordenada
    public boolean inserir(int valor){

        // verificar se o vetor não está cheio
        if(tamanho >= vetor.length){
            return false; // vetor cheio
        }

        // verificar os valores
        if(valor > 999) {
            valor = 999;
        } else if (valor < 100){
            valor = 1000;
        }

        // Verificar se existe valores repetidos, e se a flag está como false;
        if(!permitirRepetidos && localizar(valor) != -1){
            return false;
        }

        int posicao = tamanho;

        // precisa achar a posição que vai ser inserido o valor, e primeiro percorremos todo o array, até achar uma posição vaga (onde o valor é menor que o valor escolhido)
        for(int i = 0; i < tamanho; i++){
            if(vetor[i] > valor){
                posicao = i;
                break;
            }
        }

        //deslocando as posições
        // começa com o tamanho, e equanto for maior que a posição escolhida, ele decrementa
        for(int j = tamanho; j > posicao; j--){
            vetor[j] = vetor[j-1];
        }

        //depois de deslocar coloca o valor na posição
        vetor[posicao] = valor;

        // e incrementa o tamanho
        tamanho++;

        // retorna true pra indicar que deu certo
        return true;
    }

    // remover
    public boolean remover(int valor){
        int pos = localizar(valor);
        if (pos == -1){
            return false;
        }

        // deslocamento para a esquerda
        for(int i = pos; i < tamanho -1; i++){
            vetor[i] = vetor[i+1];
        }

        // na última posição, que antes teria algo, coloca -999, pra indicar que ela é uma posição livre
        vetor[tamanho -1] = -999;

        // remove -1 do tamanho
        tamanho--;

        // retorna true
        return true;
    }

    //ler de uma posição especifica o valor
    public int ler(int pos){
        if (pos < 0 || pos >= tamanho){
            return -999;
        }
        return vetor[pos];
    }

    // Localizar a posicao via busca binária
    public int localizar(int valor){
        int inicio = 0;
        int fim = tamanho - 1;

        while(inicio <= fim){
            int meio = (inicio + fim) / 2;
            if(vetor[meio] == valor){
                return meio;
            } else if (vetor[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio -1;
            }
        }
        return -1;
    }

    public void imprimir(){
        for(int id:vetor){
            if(id != -999){
                System.out.println(id);
            }
        }
    }

    public void limpar(){
        for(int i=0; i < vetor.length; i++){
            vetor[i] = -999;
        }
        tamanho = 0;
    }


}
