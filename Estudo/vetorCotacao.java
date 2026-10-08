public class vetorCotacao {
    
    private double[] vetor;
    private int tamanho;

    public vetorCotacao(int capacidade){
        this.vetor = new double[capacidade];
        this.tamanho = 0;
        limpar();
    }

    
    public boolean inserir(double valor){
        
        if(tamanho >= vetor.length){
            return false;
        }

        if(buscaBinaria(valor) != -1){
            return false;
        }

        int posicao = 0;
        for(int i = 0; i < tamanho; i++){
            if(vetor[i] > valor){
                posicao = i;
                break;
            }
        }

        for(int j=tamanho; j>posicao; j--){
            vetor[j] = vetor[j-1];
        }

        vetor[posicao] = valor;
        tamanho++;
        return true;

    }

    public boolean remover(double valor){
        int pos = buscaBinaria(valor);
        if(pos == -1){
            return false;
        }

        for(int i=pos; i < tamanho -1; i--){
            vetor[i] = vetor[i+1];
        }

        vetor[tamanho-1] = -999;
        tamanho--;
        return true;

    }

    public int buscaBinaria(double valor){
        int inicio = 0;
        int fim = tamanho -1;
        while( inicio <= fim){
            int meio = (inicio + fim) / 2;
            if(valor == meio){
                return meio;
            } else if (valor > meio){
                inicio = meio +1;
            } else {
                fim = meio -1;
            }
        }
        return -1;
    }

    private void limpar(){
        for(int i=0; i < vetor.length; i++){
            vetor[i] = -1;
        }
        tamanho = 0; 
    }
}
